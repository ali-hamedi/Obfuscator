package app.benchmark.project1.main.java.ir.ac.kntu.data.models;

import java.util.ArrayList;

public class User {

    private String name;

    private String userName;

    private String email;

    private String passwrod;

    private long nationalCode;

    private long phone;

    private ArrayList<Course> attendedCourses;

    private ArrayList<Course> teachingCourses;

    public User(String name, String userName, String email, String password, long nationalCode, long phone) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.passwrod = password;
        this.nationalCode = nationalCode;
        this.phone = phone;
        this.attendedCourses = new ArrayList<Course>();
        this.teachingCourses = new ArrayList<Course>();
    }

    public ArrayList<Course> getAttendedCourses() {
        return attendedCourses;
    }

    public ArrayList<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public long getNationalCode() {
        return nationalCode;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public long getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

}
