"""End-to-end transformation of a bundled project inside a temporary copy.

The bundled key-handling JAR is stubbed out, so no key material is generated;
the test checks extraction, renaming, literal rewriting, output placement and
that the transformed sources still compile with javac.
"""
import os
import shutil
import sqlite3
import subprocess
import sys
import textwrap

import pytest

RUNNER = textwrap.dedent("""
    import sys
    from app.executer import Executer
    calls = []
    Executer.runJavaFile = lambda self, *a: calls.append(a)
    from app import main
    code = main.main(sys.argv[1:])
    print("JAVA_HELPER_CALLS", len(calls))
    sys.exit(code)
""")


def run_pipeline(workdir, *args):
    return subprocess.run([sys.executable, "-c", RUNNER, *args], cwd=str(workdir),
                          capture_output=True, text=True, timeout=300)


def java_files(root):
    return sorted(os.path.relpath(os.path.join(d, f), root)
                  for d, _, fs in os.walk(root) for f in fs if f.endswith(".java"))


def transform(app_copy, project):
    bench = app_copy / "app" / "benchmarks"
    shutil.rmtree(bench / "output")  # start from an empty output tree
    src_before = java_files(bench / project / "main")
    proc = run_pipeline(app_copy, "--project", project)
    assert proc.returncode == 0, proc.stdout[-2000:] + proc.stderr[-2000:]
    assert "JAVA_HELPER_CALLS 1" in proc.stdout
    out = java_files(bench / "output" / "main")
    # input fixtures are untouched
    assert java_files(bench / project / "main") == src_before
    return bench, src_before, out


def compile_output(app_copy, bench, out):
    javac = shutil.which("javac")
    if javac is None:
        pytest.skip("javac not available; compilation check skipped")
    utils = app_copy / "app" / "visitors" / "utils"
    sources = [str(bench / "output" / "main" / p) for p in out] + [
        str(utils / "MyCipher.java"), str(utils / "KeyStoreReader.java")]
    return subprocess.run([javac, "-nowarn", "-d", str(app_copy / "classes"), *sources],
                          capture_output=True, text=True, timeout=300)


def test_project3_transformation(app_copy):
    bench, src, out = transform(app_copy, "project3")

    # entity index is created in the working directory, not in the repository
    db = app_copy / "obfuscator.db"
    assert db.exists()
    with sqlite3.connect(db) as con:
        kinds = {k for (k,) in con.execute("select distinct kind from entity")}
    assert {"class", "method", "localVariable"} <= kinds

    assert len(out) == len(src)
    # files keep their package directory but get new names
    assert {os.path.dirname(p) for p in out} == {os.path.dirname(p) for p in src}
    assert not set(out) & set(src)

    text = "".join((bench / "output" / "main" / p).read_text() for p in out)
    assert "MyCipher.getInstance()" in text
    assert "import ir.ac.kntu.MyCipher;" in text


def test_project2_output_compiles(app_copy):
    bench, src, out = transform(app_copy, "project2")
    assert len(out) == len(src)
    comp = compile_output(app_copy, bench, out)
    assert comp.returncode == 0, comp.stderr[-3000:]


@pytest.mark.xfail(strict=True, reason="known pre-existing renaming defect: some method "
                   "call sites in project3 are not renamed consistently with their declarations")
def test_project3_output_compiles(app_copy):
    bench, _, out = transform(app_copy, "project3")
    comp = compile_output(app_copy, bench, out)
    assert comp.returncode == 0, comp.stderr[-3000:]


def test_unknown_project_fails_without_side_effects(app_copy):
    proc = run_pipeline(app_copy, "--project", "nope")
    assert proc.returncode == 2
    assert "not found" in proc.stderr
    assert not (app_copy / "obfuscator.db").exists()


def test_executer_rejects_missing_project(app_copy):
    code = ("from app.executer import Executer\n"
            "try:\n    Executer('nope').execute()\n"
            "except FileNotFoundError as e:\n    print('FNF', e)\n")
    proc = subprocess.run([sys.executable, "-c", code], cwd=str(app_copy),
                          capture_output=True, text=True, timeout=60)
    assert "FNF Project directory not found" in proc.stdout
