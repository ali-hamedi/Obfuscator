import pytest

from app import main as cli


def test_default_project_is_project3():
    assert cli.parse_args([]).project == "project3"


def test_project_argument():
    assert cli.parse_args(["--project", "project1"]).project == "project1"


def test_help_exits_cleanly(capsys):
    with pytest.raises(SystemExit) as exc:
        cli.parse_args(["--help"])
    assert exc.value.code == 0
    assert "--project" in capsys.readouterr().out


def test_bundled_projects_are_listed():
    projects = cli.available_projects()
    assert {"project1", "project2", "project3", "project4"} <= set(projects)
    assert "output" not in projects


@pytest.mark.parametrize("name", ["../project3", "project3/../x", "/etc", "", ".hidden",
                                  "output", "a b", "project3;rm"])
def test_unsafe_or_reserved_names_rejected(name):
    with pytest.raises(ValueError, match="invalid project name"):
        cli.validate_project(name)


def test_missing_project_rejected():
    with pytest.raises(ValueError, match="not found"):
        cli.validate_project("project999")


def test_main_rejects_invalid_project_before_processing(monkeypatch, capsys):
    called = []
    monkeypatch.setattr(cli, "initialize_database", lambda: called.append("db"))
    assert cli.main(["--project", "../../etc"]) == 2
    assert called == []
    assert "invalid project name" in capsys.readouterr().err
