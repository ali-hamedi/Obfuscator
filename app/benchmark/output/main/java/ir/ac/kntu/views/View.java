package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.Main;

public class View {
    public static Scanner sc = new Scanner(System.in);

    public static void showStatus() {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m5nWEMFq6GVc="));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XKEMFq6GVc="));
        String userStr = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        String courseStr = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        String exerciseStr = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        if (Global.currentUser != null) {
            userStr = String.valueOf(Global.currentUser.getName());
        }
        if (Global.currentCourse != null) {
            courseStr = String.valueOf(Global.currentCourse.getName());
        }
        if (Global.currentExercise != null) {
            exerciseStr = String.valueOf(Global.currentExercise.getName());
        }
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLszU5R+LJ8jeadyyEPXGpV5eKMzt1IAPzuolHhoMq"));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XOEMFq6GVc="));
        System.out.print(Main.decode(userStr));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XKEMFq6GVc="));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5mdrAs/IoDCMfCqeXjy7vYdUmpoT2ZvwDZIqjwIE"));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XOEMFq6GVc="));
        System.out.print(Main.decode(courseStr));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XKEMFq6GVc="));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5mdrAs/IoDCMfCqeWCt9vmV6t/IKiwt3oWkCJyOO"));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XOEMFq6GVc="));
        System.out.print(Main.decode(exerciseStr));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XKEMFq6GVc="));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4i/LF1u7GFY="));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XWEMFq6GVc="));
    }

    public static void showResult(String s) {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XOEMFq6GVc="));
        System.out.println(s);
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XWEMFq6GVc="));
    }

    public static void searchUser() {
        System.out.print(Main
                .decode("YWFhYWFhYWFhYWFhYWFhYXPboyY5QeSdhzGMYH7cZHNe+7/8Fz5usHYYicBsRy/H0wa/3q7AC0cHIxb8R//cVw=="));
        String query = String.valueOf(sc.nextLine());
        showResult(Helpercontroller.searchUser(Main.decode(query)));
    }

    public static void searchCourse() {
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPboyY5QeSdkS2cYC3bPTHJ1Ensj/GQ8wq0xIMbGCvJokuXvUsV8lSxq8g7rJ3wFid+FtNJs/O2TMAerPs0O1BBFh3PFesXP5LiRKQL/XjS"));
        String query = String.valueOf(sc.nextLine());
        showResult(Helpercontroller.searchCourse(Main.decode(query)));
    }

    public static void addQuestionToBank() {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo="));
        String name = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfGScH1E="));
        String description = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqS4lVv+H8EXuFVm5GlQ="));
        String point = String.valueOf(Integer.parseInt(sc.nextLine()));
        Type typ = null;
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPcvzcuCurPvS/JI3PccTKFs+51Aur/aZ1uVPC8Nu9FLi9ckGtKY22ip6xCvqCs9MIRjkl04tjSlKryIGWCBTg="));
        Type type = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        String body = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPqqSMyGK6020vgG1e3FFo="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl931pKYe22UniGVW1Flg="));
            bodyArr[0] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9H1pKYe22UniGVW1Flg="));
            bodyArr[1] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9X1pKYe22UniGVW1Flg="));
            bodyArr[2] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl8n1pKYe22UniGVW1Flg="));
            bodyArr[3] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXP/ri4oSqzTpy+LdyyedCB3X/KD9D3FrmP5FmCU7lvv"));
            answer = String.valueOf(sc.nextLine());
            body = String.valueOf(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(
                            bodyArr[Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=") + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw="))]));
        } else {
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPqqSMyGK6020vgG1e3FFo="));
            body = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPJqDQ8R/6H8EXuFVm5GlQ="));
            answer = String.valueOf(sc.nextLine());
        }
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPMryEtQfnRpjvBdCzRcHM+3r5+Xe9fMHr3LMxYmLvYnOuI3qp9xok9gBQlsEBHhE3aerP9ZJOON3IWPV/VTk4="));
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(Main.decode(name), Main.decode(description), Main.decode(body),
                Integer.parseInt(Main.decode(point)), diff, type, Main.decode(answer));
        showResult(Questioncontroller.addQuestionToBank(q));
    }

    public static void showQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo63lrAIa32EjjGFS0F1k=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getDifficultyString());
        }
    }

    public static void back() {
        if (Global.currentExercise != null) {
            Global.currentExercise = null;
        } else if (Global.currentCourse != null) {
            Global.currentCourse = null;
        } else if (Global.currentUser != null) {
            Global.currentUser = null;
        }
    }

}
