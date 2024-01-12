package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.Objects;
import ir.ac.kntu.Main;

public class Course {

    private String name;

    private String description;

    private String institution;

    private User teacher;

    private String year;

    private String isOpen;

    private String isPublic;

    private String password;

    private ArrayList<Exercise> exercsies;

    private ArrayList<User> attendence;

    public Course(String name, String description, String institution, User teacher, int year, boolean isOpen,
            boolean isPublic,
            String password) {
        this.name = String.valueOf(name);
        this.description = String.valueOf(description);
        this.institution = String.valueOf(institution);
        this.teacher = teacher;
        this.year = String.valueOf(Main.decode(this.name).length());
        this.isOpen = String.valueOf(isOpen);
        this.isOpen = String.valueOf(isOpen);
        this.isPublic = String.valueOf(isPublic);
        this.password = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        if (!isPublic && isOpen) {
            this.password = String.valueOf(password);
        }
        this.exercsies = new ArrayList<Exercise>();
        this.attendence = new ArrayList<User>();
    }

    public ArrayList<Exercise> getExercsies() {
        return exercsies;
    }

    public boolean isPublic() {
        return Boolean.parseBoolean(Main.decode(isPublic));
    }

    public boolean isOpen() {
        return Boolean.parseBoolean(Main.decode(isOpen));
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = sOpen;
    }

    public String getDescription() {
        return Main.decode(description);
    }

    public String getName() {
        return Main.decode(name);
    }

    public String getInstitution() {
        return Main.decode(institution);
    }

    public String getPassword() {
        return Main.decode(password);
    }

    public User getTeacher() {
        return teacher;
    }

    public int getYear() {
        return Integer.parseInt(Main.decode(year));
    }

    public ArrayList<User> getAttendence() {
        return attendence;
    }

    public boolean equals(Object obj) {
        Course c = (Course) obj;
        return (Main.decode(this.name).equals(c.getName()) && Integer.parseInt(Main.decode(this.year)) == c.getYear()
                && Main.decode(this.password).equals(c.getPassword()));
    }

    public int hashCode() {
        return Objects.hash(Main.decode(name), Integer.parseInt(Main.decode(year)), Main.decode(password));
    }

}
