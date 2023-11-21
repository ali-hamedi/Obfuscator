package app.benchmark.project1.main.java.ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.Objects;

public class Course {

    private String name;

    private String description;

    private String institution;

    private User teacher;

    private int year;

    private boolean isOpen;

    private boolean isPublic;

    private String password;

    private ArrayList<Exercise> exercsies;

    private ArrayList<User> attendence;

    public Course(String name, String description, String institution, User teacher, int year, boolean isOpen,
            boolean isPublic,
            String password) {
        this.name = name;
        this.description = description;
        this.institution = institution;
        this.teacher = teacher;
        this.year = year;
        this.isOpen = isOpen;
        this.isOpen = isOpen;
        this.isPublic = isPublic;
        this.password = "";
        if (!isPublic && isOpen) {
            this.password = password;
        }
        this.exercsies = new ArrayList<Exercise>();
        this.attendence = new ArrayList<User>();
    }

    public ArrayList<Exercise> getExercsies() {
        return exercsies;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public String getPassword() {
        return password;
    }

    public User getTeacher() {
        return teacher;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<User> getAttendence() {
        return attendence;
    }

    @Override
    public boolean equals(Object obj) {
        Course c = (Course) obj;
        return (this.name.equals(c.getName()) && this.year == c.getYear() && this.password.equals(c.getPassword()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, password);
    }

}
