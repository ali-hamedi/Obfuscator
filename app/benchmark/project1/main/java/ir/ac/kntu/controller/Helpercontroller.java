package app.benchmark.project1.main.java.ir.ac.kntu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;

public class Helpercontroller {

    public static String searchUser(String query) {
        String email = "";
        long nationalCode = 0;
        try {
            nationalCode = Long.parseLong(query);
        } catch (Exception e) {
            email = query;
        }
        String str = "";
        for (User u : Database.users) {
            if (u.getEmail().equals(email) || u.getNationalCode() == nationalCode) {
                str += "name: " + u.getName() + " userName: " + u.getUserName() + " email: " + u.getEmail()
                        + " national code: " + u.getNationalCode() + "\n";
            }
        }
        if (str.length() > 0) {
            return str;
        } else {
            return "User not found";
        }
    }

    public static String searchCourse(String query) {
        String str = "";
        for (Course c : Database.courses) {
            if (c.getName().equals(query) || c.getTeacher().getName().equals(query)
                    || c.getInstitution().equals(query)) {
                str += "name: " + c.getName() + " descrition: " + c.getDescription() + " institution: "
                        + c.getInstitution()
                        + " year: " + c.getYear() + "\n";
            }
        }
        if (str.length() > 0) {
            return str;
        } else {
            return "Course not found";
        }
    }

    public static void sortQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        Collections.sort(arr, Comparator.comparingInt(Question::getDifficultyInt));
        Collections.reverse(arr);
        Questionbank.quesiton = arr;
    }
}
