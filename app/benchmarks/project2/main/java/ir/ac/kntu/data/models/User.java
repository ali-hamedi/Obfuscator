package ir.ac.kntu.data.models;

import java.util.ArrayList;
import ir.ac.kntu.Main;

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

    public void setAttendedCourses(ArrayList<Course> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setTeachingCourses(ArrayList<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
