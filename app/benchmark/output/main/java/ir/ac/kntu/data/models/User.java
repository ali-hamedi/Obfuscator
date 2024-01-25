package ir.ac.kntu.data.models;

import java.util.ArrayList;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


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
        this.name = MyCipher.getInstance().encode(name);
        this.userName = MyCipher.getInstance().encode(userName);
        this.email = MyCipher.getInstance().encode(email);
        this.passwrod = MyCipher.getInstance().encode(password);
        this.nationalCode = MyCipher.getInstance().encode(nationalCode);
        this.phone = MyCipher.getInstance().encode(phone);
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
        return MyCipher.getInstance().decode(email);
    }

    public String getName() {
        return MyCipher.getInstance().decode(name);
    }

    public long getNationalCode() {
        return Long.parseLong(MyCipher.getInstance().decode(nationalCode));
    }

    public String getPasswrod() {
        return MyCipher.getInstance().decode(passwrod);
    }

    public long getPhone() {
        return Long.parseLong(MyCipher.getInstance().decode(phone));
    }

    public String getUserName() {
        return MyCipher.getInstance().decode(userName);
    }

    public void setAttendedCourses(ArrayList<Course> attendedCourses) {
        this.attendedCourses = attendedCourses;
    }

    public void setEmail(String email) {
        this.email = MyCipher.getInstance().encode(email);
    }

    public void setName(String name) {
        this.name = MyCipher.getInstance().encode(name);
    }

    public void setNationalCode(long nationalCode) {
        this.nationalCode = MyCipher.getInstance().encode(nationalCode);
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = MyCipher.getInstance().encode(passwrod);
    }

    public void setPhone(long phone) {
        this.phone = MyCipher.getInstance().encode(phone);
    }

    public void setTeachingCourses(ArrayList<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public void setUserName(String userName) {
        this.userName = MyCipher.getInstance().encode(userName);
    }

}
