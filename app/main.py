import argparse
import os
import re
import sys

from app.data.db import initialize_database
from app.executer import Executer

DEFAULT_PROJECT = "project3"
BENCHMARKS_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "benchmarks")
# a bundled project is a single directory name under app/benchmarks/
_PROJECT_NAME_RE = re.compile(r"^[A-Za-z0-9][A-Za-z0-9_-]*$")
# "output" is where results are written, never an input
_RESERVED_NAMES = {"output"}


def available_projects():
    if not os.path.isdir(BENCHMARKS_DIR):
        return []
    return sorted(
        name
        for name in os.listdir(BENCHMARKS_DIR)
        if name not in _RESERVED_NAMES
        and os.path.isdir(os.path.join(BENCHMARKS_DIR, name, "main"))
    )


def validate_project(name):
    """Return the input directory for a bundled project or raise ValueError."""
    if not _PROJECT_NAME_RE.match(name) or name in _RESERVED_NAMES:
        raise ValueError(f"invalid project name {name!r}")
    project_dir = os.path.join(BENCHMARKS_DIR, name, "main")
    if not os.path.isdir(project_dir):
        raise ValueError(
            f"project {name!r} not found: expected Java sources under {project_dir}. "
            f"Available projects: {', '.join(available_projects()) or 'none'}"
        )
    has_java = any(
        f.endswith(".java") for _, _, files in os.walk(project_dir) for f in files
    )
    if not has_java:
        raise ValueError(f"project {name!r} contains no .java files under {project_dir}")
    return project_dir


def parse_args(argv=None):
    parser = argparse.ArgumentParser(
        prog="python -m app.main",
        description="Obfuscate one of the bundled Java projects under app/benchmarks/. "
        "Output is written to app/benchmarks/output/ and replaces existing files "
        "with the same names.",
    )
    parser.add_argument(
        "--project",
        default=DEFAULT_PROJECT,
        help=f"bundled project directory name (default: {DEFAULT_PROJECT})",
    )
    parser.add_argument(
        "--list", action="store_true", help="list the bundled projects and exit"
    )
    return parser.parse_args(argv)


def main(argv=None):
    args = parse_args(argv)
    if args.list:
        print("\n".join(available_projects()))
        return 0
    try:
        validate_project(args.project)
    except ValueError as e:
        print(f"error: {e}", file=sys.stderr)
        return 2

    initialize_database()
    executer = Executer(args.project)
    executer.execute()
    return 0


if __name__ == "__main__":
    sys.exit(main())
