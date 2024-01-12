package ir.ac.kntu.data.models;

import java.util.ArrayList;
import ir.ac.kntu.Main;

public class User {

    private String name;

    private String userName;

    private String email;

    private String passwrod;

    private String nationalCode;

    private String phone;

    private ArrayList<Course> attendedCourses;

    private ArrayList<Course> teachingCourses;

    public User(String name, String userName, String email, String password, long nationalCode, long phone) {
        this.name = String.valueOf(name);
        this.userName = String.valueOf(userName);
        this.email = String.valueOf(email);
        this.passwrod = String.valueOf(password);
        this.nationalCode = String.valueOf(nationalCode);
        this.phone = String.valueOf(phone);
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
        return Main.decode(email);
    }

    public String getName() {
        return Main.decode(name);
    }

    public long getNationalCode() {
        return Long.parseLong(Main.decode(nationalCode));
    }

    public String getPasswrod() {
        return Main.decode(passwrod);
    }

    public long getPhone() {
        return Long.parseLong(Main.decode(phone));
    }

    public String getUserName() {
        return Main.decode(userName);
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
        this.nationalCode = String.valueOf(nationalCode);
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public void setPhone(long phone) {
        this.phone = String.valueOf(phone);
    }

    public void setTeachingCourses(ArrayList<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
