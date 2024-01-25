package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.Objects;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


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
        this.name = MyCipher.getInstance().encode(name);
        this.description = MyCipher.getInstance().encode(description);
        this.institution = MyCipher.getInstance().encode(institution);
        this.teacher = teacher;
        this.year = MyCipher.getInstance().encode(MyCipher.getInstance().decode(this.name).length());
        this.isOpen = MyCipher.getInstance().encode(isOpen);
        this.isOpen = MyCipher.getInstance().encode(isOpen);
        this.isPublic = MyCipher.getInstance().encode(isPublic);
        this.password = "";
        if (!isPublic && isOpen) {
            this.password = MyCipher.getInstance().encode(password);
        }
        this.exercsies = new ArrayList<Exercise>();
        this.attendence = new ArrayList<User>();
    }

    public ArrayList<Exercise> getExercsies() {
        return exercsies;
    }

    public boolean isPublic() {
        return Boolean.parseBoolean(MyCipher.getInstance().decode(isPublic));
    }

    public boolean isOpen() {
        return Boolean.parseBoolean(MyCipher.getInstance().decode(isOpen));
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = MyCipher.getInstance().encode(isOpen);
    }

    public String getDescription() {
        return MyCipher.getInstance().decode(description);
    }

    public String getName() {
        return MyCipher.getInstance().decode(name);
    }

    public String getInstitution() {
        return MyCipher.getInstance().decode(institution);
    }

    public String getPassword() {
        return MyCipher.getInstance().decode(password);
    }

    public User getTeacher() {
        return teacher;
    }

    public int getYear() {
        return Integer.parseInt(MyCipher.getInstance().decode(year));
    }

    public ArrayList<User> getAttendence() {
        return attendence;
    }

    
    public boolean equals(Object obj) {
        Course c = (Course) obj;
        return (MyCipher.getInstance().decode(this.name).equals(c.getName()) && Integer.parseInt(MyCipher.getInstance().decode(this.year)) == c.getYear() && MyCipher.getInstance().decode(this.password).equals(c.getPassword()));
    }

    
    public int hashCode() {
        return Objects.hash(MyCipher.getInstance().decode(name), Integer.parseInt(MyCipher.getInstance().decode(year)), MyCipher.getInstance().decode(password));
    }

}
