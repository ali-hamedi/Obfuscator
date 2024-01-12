package ir.ac.kntu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Helpercontroller {

    public static String searchUser(String query) {
        String email = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        String nationalCode = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
        try {
            nationalCode = String.valueOf(Long.parseLong(query));
        } catch (Exception e) {
            email = query;
        }
        String str = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        for (User u : Database.users) {
            if (u.getEmail().equals(Main.decode(email)) || u.getNationalCode() == Long.parseLong(Main.decode(nationalCode))) {
                str = String.valueOf(Main.decode(str) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXPmpyouGKyf2krhGla2FVs=")+u.getName()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOoszQuUMLcvyfTMny9HlA=")+u.getUserName()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOooyoqS+CH8mDvFFi4G1U=")+u.getEmail()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOoqCY/S+PTsy7JcTHaeGmIYXCm4I9eB02QrMedX1EZ")+u.getNationalCode()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUqGVHLoCx3k7lHlKyEV8="));
            }
        }
        if (Main.decode(str).length() > Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))) {
            return Main.decode(str);
        } else {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPdtSI5AuLSpmKPfSvQeXGk6JFcjMJsMeFEgQmW3BCt");
        }
    }

    public static String searchCourse(String query) {
        String str = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        for (Course c : Database.courses) {
            if (c.getName().equals(query) || c.getTeacher().getName().equals(query)
                    || c.getInstitution().equals(query)) {
                str = String.valueOf(Main.decode(str) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXPmpyouGKyf2krhGla2FVs=")+c.getName()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOooiI4Qf7UpiuGfGSeP1I=")+c.getDescription()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOoryk4VuXJpzaAfTCEPXFm3UsABO8SJJQXzfUHMx/m")+c.getInstitution()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOovyIqULad8EXuFVm5GlQ=")+c.getYear()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUqGVHLoCx3k7lHlKyEV8="));
            }
        }
        if (Main.decode(str).length() > Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))) {
            return Main.decode(str);
        } else {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqTI5UemdvC2dMjjRaD1qiHiqWGbl5MvGu6JG/YkP");
        }
    }

    public static void sortQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        Collections.sort(arr, Comparator.comparingInt(Question::getDifficultyInt));
        Collections.reverse(arr);
        Questionbank.quesiton = arr;
    }
}
