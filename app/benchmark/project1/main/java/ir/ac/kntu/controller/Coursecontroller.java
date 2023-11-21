package app.benchmark.project1.main.java.ir.ac.kntu.controller;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;

public class Coursecontroller {

    public static String addTeachingCourses(Course teachingCourse) {
        Global.currentUser.getTeachingCourses().add(teachingCourse);
        Database.courses.add(teachingCourse);
        return "Course was created Successfully";
    }

    public static String addAttendedCourses(Course attendedCourse) {
        attendedCourse.getAttendence().add(Global.currentUser);
        Global.currentUser.getAttendedCourses().add(attendedCourse);
        Exercisecontroller.increaseScoreTable(attendedCourse, Global.currentUser);
        Questioncontroller.increseLists(attendedCourse, Global.currentUser);
        return "Course was added Successfully";
    }

    public static String addUserToCourse(User u, Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            u.getAttendedCourses().add(c);
            c.getAttendence().add(u);
            Exercisecontroller.increaseScoreTable(c, u);
            Questioncontroller.increseLists(c, u);
            return "The user has been added to course successfully";
        }
        return "You are not the owner";
    }

    public static String deleteAttendedCourses(Course c) {
        int flag = -1;
        for (int i = 0; i < Global.currentUser.getAttendedCourses().size(); i++) {
            if (Global.currentUser.getAttendedCourses().get(i).equals(c)) {
                flag = i;
            }
        }
        if (flag == -1) {
            return "Course not found";
        }
        Global.currentUser.getAttendedCourses().remove(flag);
        return "Course was deleted Successfully";
    }

    public static String deleteTeachingCourses(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                int flag = -1;
                for (int i = 0; i < u.getAttendedCourses().size(); i++) {
                    if (u.getAttendedCourses().get(i).equals(c)) {
                        flag = i;
                    }
                }
                if (flag != -1) {
                    u.getAttendedCourses().remove(flag);
                }
            }
            int flag = -1;
            for (int i = 0; i < Global.currentUser.getTeachingCourses().size(); i++) {
                if (Global.currentUser.getTeachingCourses().get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentUser.getTeachingCourses().remove(flag);
            }
            flag = -1;
            for (int i = 0; i < Database.courses.size(); i++) {
                if (Database.courses.get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Database.courses.remove(flag);
            }
            return "Course was deleted Successfully for every body";
        }
        return "You are not the owner";
    }

    public static String modifyCourse(Course newCourse, Course oldCourse) {
        if (Global.currentUser.equals(oldCourse.getTeacher())) {
            for (User u : Database.users) {
                int flag = -1;
                for (int i = 0; i < u.getAttendedCourses().size(); i++) {
                    if (u.getAttendedCourses().get(i).equals(oldCourse)) {
                        flag = i;
                    }
                }
                if (flag != -1) {
                    u.getAttendedCourses().set(flag, newCourse);
                }
            }
            int flag = -1;
            for (int i = 0; i < Global.currentUser.getTeachingCourses().size(); i++) {
                if (Global.currentUser.getTeachingCourses().get(i).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentUser.getTeachingCourses().set(flag, newCourse);
            }
            flag = -1;
            for (int i = 0; i < Database.courses.size(); i++) {
                if (Database.courses.get(i).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Database.courses.set(flag, newCourse);
            }

            return "Course was modyfied Successfully for every body";

        }
        return "You are not the owner";
    }

    public static ArrayList<Course> getAvailbaleCourses() {
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Database.courses) {
            int flag = 0;
            for (Course c2 : Global.currentUser.getAttendedCourses()) {
                if (c.equals(c2)) {
                    flag++;
                }
            }
            for (Course c2 : Global.currentUser.getTeachingCourses()) {
                if (c.equals(c2)) {
                    flag++;
                }
            }
            if (flag == 0 && c.isOpen()) {
                arr.add(c);
            }
        }
        return arr;
    }

    public static String closeCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                int flag = -1;
                for (int i = 0; i < u.getAttendedCourses().size(); i++) {
                    if (u.getAttendedCourses().get(i).equals(c)) {
                        flag = i;
                    }
                }
                if (flag != -1) {
                    u.getAttendedCourses().get(flag).setOpen(false);
                    ;
                }
            }
            int flag = -1;
            for (int i = 0; i < Global.currentUser.getTeachingCourses().size(); i++) {
                if (Global.currentUser.getTeachingCourses().get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentUser.getTeachingCourses().get(flag).setOpen(false);
                ;
            }
            flag = -1;
            for (int i = 0; i < Database.courses.size(); i++) {
                if (Database.courses.get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Database.courses.get(flag).setOpen(false);
                ;
            }
            return "Course hab been closed and only you can add users to it";
        }
        return "You are not the owner";

    }

    public static String openCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                int flag = -1;
                for (int i = 0; i < u.getAttendedCourses().size(); i++) {
                    if (u.getAttendedCourses().get(i).equals(c)) {
                        flag = i;
                    }
                }
                if (flag != -1) {
                    u.getAttendedCourses().get(flag).setOpen(true);
                    ;
                }
            }
            int flag = -1;
            for (int i = 0; i < Global.currentUser.getTeachingCourses().size(); i++) {
                if (Global.currentUser.getTeachingCourses().get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentUser.getTeachingCourses().get(flag).setOpen(true);
                ;
            }
            flag = -1;
            for (int i = 0; i < Database.courses.size(); i++) {
                if (Database.courses.get(i).equals(c)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Database.courses.get(flag).setOpen(true);
                ;
            }
            return "Course hab been opend for every one";
        }
        return "You are not the owner";

    }
}
