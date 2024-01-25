package ir.ac.kntu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Helpercontroller {

    public static String searchUser(String query) {
        String email = "";
        String nationalCode = "b0";
        try {
            nationalCode = MyCipher.getInstance().encode(Long.parseLong(query));
        } catch (Exception e) {
            email = MyCipher.getInstance().encode(query);
        }
        String str = "";
        for (User u : Database.users) {
            if (u.getEmail().equals(MyCipher.getInstance().decode(email)) || u.getNationalCode() == Long.parseLong(MyCipher.getInstance().decode(nationalCode))) {
                str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + MyCipher.getInstance().decode("ee4ffe666b77")+u.getName()+MyCipher.getInstance().decode("a05be0662319c68bb2e993")+u.getUserName()+MyCipher.getInstance().decode("a04bfe62383b9dc6")+u.getEmail()+MyCipher.getInstance().decode("a040f2773838c987bbf3d09822940974")+u.getNationalCode()+MyCipher.getInstance().decode("dc40"));
            }
        }
        if (MyCipher.getInstance().decode(str).length() > Integer.parseInt(MyCipher.getInstance().decode("b0"))) {
            return MyCipher.getInstance().decode(str);
        } else {
            return MyCipher.getInstance().decode("d55df6717139c892f7b5dc822895");
        }
    }

    public static String searchCourse(String query) {
        String str = "";
        for (Course c : Database.courses) {
            if (c.getName().equals(query) || c.getTeacher().getName().equals(query)
                    || c.getInstitution().equals(query)) {
                str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + MyCipher.getInstance().decode("ee4ffe666b77")+c.getName()+MyCipher.getInstance().decode("a04af6703225ce92bebcddcd66")+c.getDescription()+MyCipher.getInstance().decode("a047fd70253ed393a3badc997cd1")+c.getInstitution()+MyCipher.getInstance().decode("a057f662236d87")+c.getYear()+MyCipher.getInstance().decode("dc40"));
            }
        }
        if (MyCipher.getInstance().decode(str).length() > Integer.parseInt(MyCipher.getInstance().decode("b0"))) {
            return MyCipher.getInstance().decode(str);
        } else {
            return MyCipher.getInstance().decode("c341e67122328788b8a7939129845d30");
        }
    }

    public static void sortQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        Collections.sort(arr, Comparator.comparingInt(Question::getDifficultyInt));
        Collections.reverse(arr);
        Questionbank.quesiton = arr;
    }
}
