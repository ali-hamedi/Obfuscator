package app.benchmark.project1.main.java.ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;

public class View {
    public static Scanner sc = new Scanner(System.in);

    public static void showStatus() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String userStr = "";
        String courseStr = "";
        String exerciseStr = "";
        if (Global.currentUser != null) {
            userStr = Global.currentUser.getName();
        }
        if (Global.currentCourse != null) {
            courseStr = Global.currentCourse.getName();
        }
        if (Global.currentExercise != null) {
            exerciseStr = Global.currentExercise.getName();
        }
        System.out.print("Current user: ");
        System.out.print("\u001B[31m");
        System.out.print(userStr);
        System.out.print("\u001B[30m");
        System.out.print("     Current Course: ");
        System.out.print("\u001B[31m");
        System.out.print(courseStr);
        System.out.print("\u001B[30m");
        System.out.print("     Current Exercise: ");
        System.out.print("\u001B[31m");
        System.out.print(exerciseStr);
        System.out.print("\u001B[30m");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[37m");
    }

    public static void showResult(String s) {
        System.out.print("\u001B[31m");
        System.out.println(s);
        System.out.print("\u001B[37m");
    }

    public static void searchUser() {
        System.out.print("Search User by email/national code :");
        String query = sc.nextLine();
        showResult(Helpercontroller.searchUser(query));
    }

    public static void searchCourse() {
        System.out.print("Search Course by course name/teacher's name/institution's name:");
        String query = sc.nextLine();
        showResult(Helpercontroller.searchCourse(query));
    }

    public static void addQuestionToBank() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Description:");
        String description = sc.nextLine();
        System.out.print("Points:");
        int point = Integer.parseInt(sc.nextLine());
        Type typ = null;
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        Type type = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "";
        String body = "";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            bodyArr[0] = sc.nextLine();
            System.out.print("-2:");
            bodyArr[1] = sc.nextLine();
            System.out.print("-3:");
            bodyArr[2] = sc.nextLine();
            System.out.print("-4:");
            bodyArr[3] = sc.nextLine();
            System.out.print("which number is the Answer:");
            answer = sc.nextLine();
            body = "-" + bodyArr[0] + "-" + bodyArr[1] + "-" + bodyArr[2] + "-" + bodyArr[3];
        } else {
            System.out.print("body:");
            body = sc.nextLine();
            System.out.print("Answer:");
            answer = sc.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(name, description, body, point, diff, type, answer);
        showResult(Questioncontroller.addQuestionToBank(q));
    }

    public static void showQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName() + " -> " + arr.get(i).getDifficultyString());
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
