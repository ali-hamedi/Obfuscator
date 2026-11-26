import os

from antlr4 import CommonTokenStream, InputStream

from app.executer import Executer
from app.gen.JavaLexer import JavaLexer
from app.gen.JavaParser import JavaParser

SNIPPET = """
package demo;
public class Hello {
    private int count = 3;
    public String greet(String name) { String msg = "hi " + name; return msg; }
}
"""


def parse(text):
    parser = JavaParser(CommonTokenStream(JavaLexer(InputStream(text))))
    tree = parser.compilationUnit()
    return parser, tree


def test_parser_loads_and_parses_snippet():
    parser, tree = parse(SNIPPET)
    assert parser.getNumberOfSyntaxErrors() == 0
    assert tree.typeDeclaration(0).classDeclaration().identifier().getText() == "Hello"


def test_bundled_projects_parse_without_syntax_errors():
    ex = Executer("project3")
    paths, names = ex.extractFilePaths(ex.projectPath)
    assert names
    for d, n in zip(paths, names):
        parser, _ = parse(ex.readJavaFile(os.path.join(d, n)))
        assert parser.getNumberOfSyntaxErrors() == 0, n


def test_output_paths_mirror_project_layout():
    ex = Executer("project3")
    src = os.path.join(ex.projectPath, "java", "ir", "ac", "kntu", "Models")
    out = ex.toOutputPath(src)
    assert out == os.path.join(ex.outputPath, "java", "ir", "ac", "kntu", "Models")
    assert os.path.join("benchmarks", "output", "main") in out


def test_missing_input_file_has_clear_error(tmp_path):
    ex = Executer("project3")
    try:
        ex.readJavaFile(str(tmp_path / "Missing.java"))
    except OSError as e:
        assert "Missing.java" in str(e)
    else:
        raise AssertionError("expected OSError")
