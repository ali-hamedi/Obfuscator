import os
import shutil
import sys

import pytest

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
if ROOT not in sys.path:
    sys.path.insert(0, ROOT)


@pytest.fixture
def app_copy(tmp_path):
    """A disposable copy of the app package so tests never touch tracked files."""
    shutil.copytree(
        os.path.join(ROOT, "app"),
        tmp_path / "app",
        ignore=shutil.ignore_patterns("__pycache__", "*.jar"),
    )
    return tmp_path
