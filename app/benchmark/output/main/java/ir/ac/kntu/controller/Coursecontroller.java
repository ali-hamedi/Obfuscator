package ir.ac.kntu.controller;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Coursecontroller {

    public static String addTeachingCourses(Course teachingCourse) {
        Global.currentUser.getTeachingCourses().add(teachingCourse);
        Database.courses.add(teachingCourse);
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdpSOaMj3MeDJNWTHjF+7VbL4HK5UZQ5wUFdTGDtK5OTNqS/8z7T/inA==");
    }

    public static String addAttendedCourses(Course attendedCourse) {
        attendedCourse.getAttendence().add(Global.currentUser);
        Global.currentUser.getAttendedCourses().add(attendedCourse);
        Exercisecontroller.increaseScoreTable(attendedCourse, Global.currentUser);
        Questioncontroller.increseLists(attendedCourse, Global.currentUser);
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdpSOaMj/aeTYYTFC8/pawi3I1qhm0x5bJ");
    }

    public static String addUserToCourse(User u, Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            u.getAttendedCourses().add(c);
            c.getAttendence().add(u);
            Exercisecontroller.increaseScoreTable(c, u);
            Questioncontroller.increseLists(c, u);
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcriJrV//YoGKBcy2efzZFNE3Z+6T+2V+s9xL+chHVSM2e5GE2C4eeYdS0fpUbx/kU2e6dhHT/SMSZHm3T75I=");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String deleteAttendedCourses(Course c) {
        String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getAttendedCourses().size(); i = i + 1) {
            if (Global.currentUser.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                flag = i;
            }
        }
        if (Integer.parseInt(Main.decode(flag)) == -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdvC2dMjjRaD1qiHiqWGbl5MvGu6JG/YkP");
        }
        Global.currentUser.getAttendedCourses().remove(Integer.parseInt(Main.decode(flag)));
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdpSOaMjrbcTZViAoGPbCNDZpVVtyF2hhypeNfzql1gj0j08qxn22L1A==");
    }

    public static String deleteTeachingCourses(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
                for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < u.getAttendedCourses().size(); i = i + 1) {
                    if (u.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                    u.getAttendedCourses().remove(Integer.parseInt(Main.decode(flag)));
                }
            }
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getTeachingCourses().size(); i = i + 1) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentUser.getTeachingCourses().remove(Integer.parseInt(Main.decode(flag)));
            }
            flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.courses.size(); i = i + 1) {
                if (Database.courses.get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Database.courses.remove(Integer.parseInt(Main.decode(flag)));
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdpSOaMjrbcTZViAoGPbCNDZpVVtyF2hhyp4o/s4Yf+1depeXc/wb9+VN/k3CtalLaoiXd+kza+b4=");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String modifyCourse(Course newCourse, Course oldCourse) {
        if (Global.currentUser.equals(oldCourse.getTeacher())) {
            for (User u : Database.users) {
                String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
                for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < u.getAttendedCourses().size(); i = i + 1) {
                    if (u.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).equals(oldCourse)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                    u.getAttendedCourses().set(Integer.parseInt(Main.decode(flag)), newCourse);
                }
            }
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getTeachingCourses().size(); i = i + 1) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(i))).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentUser.getTeachingCourses().set(Integer.parseInt(Main.decode(flag)), newCourse);
            }
            flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.courses.size(); i = i + 1) {
                if (Database.courses.get(Integer.parseInt(Main.decode(i))).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Database.courses.set(Integer.parseInt(Main.decode(flag)), newCourse);
            }

            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdpSOaMjPReSq7LfBaMu3yb6JCOb0hEIg3y/82ut3jg4FOMr8iSlU2DFwhz15N63ABpLDCjgiY8PA=");

        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static ArrayList<Course> getAvailbaleCourses() {
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Database.courses) {
            String flag = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
            for (Course c2 : Global.currentUser.getAttendedCourses()) {
                if (c.equals(c2)) {
                    flag = flag + 1;
                }
            }
            for (Course c2 : Global.currentUser.getTeachingCourses()) {
                if (c.equals(c2)) {
                    flag = flag + 1;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) && c.isOpen()) {
                arr.add(c);
            }
        }
        return arr;
    }

    public static String closeCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
                for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < u.getAttendedCourses().size(); i = i + 1) {
                    if (u.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                    u.getAttendedCourses().get(Integer.parseInt(Main.decode(flag))).setOpen(false);
                    ;
                }
            }
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getTeachingCourses().size(); i = i + 1) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(flag))).setOpen(false);
                ;
            }
            flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.courses.size(); i = i + 1) {
                if (Database.courses.get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Database.courses.get(Integer.parseInt(Main.decode(flag))).setOpen(false);
                ;
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemduiOLMjzbeD1W6zeiX0B+NInbECqxLLRjSf4lEqDO6ZlbczX0X/OmR2xWO/Q2bLRX1nvuievwOYQ=");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");

    }

    public static String openCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
                for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < u.getAttendedCourses().size(); i = i + 1) {
                    if (u.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                    u.getAttendedCourses().get(Integer.parseInt(Main.decode(flag))).setOpen(true);
                    ;
                }
            }
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getTeachingCourses().size(); i = i + 1) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(flag))).setOpen(true);
                ;
            }
            flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.courses.size(); i = i + 1) {
                if (Database.courses.get(Integer.parseInt(Main.decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Database.courses.get(Integer.parseInt(Main.decode(flag))).setOpen(true);
                ;
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemduiOLMjzbeD1W5yuoQkE6cofHVG+oJ6pjQd0nYRvW/+lcGCoNAJy4VQ==");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");

    }
}
