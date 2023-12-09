package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.View;

public class Menu extends View {

    public static int shoMenuHandler() {
        System.out.println("\u001B[32m");
        int n = -1;
        if (Global.currentUser == null) {
            n = mainMenu();
        } else {
            System.out.println("0-Back");
            if (Global.currentCourse == null) {
                n = courseMenu();
            } else if (Global.currentExercise == null) {
                n = exerciseMenu();
            } else {
                n = questionMenu();
            }
        }
        System.out.println("\u001B[37m");
        if (n == 1) {
            n = userMenu();
        }
        return n;
    }

    public static int mainMenu() {
        System.out.println("1-Sing in");
        System.out.println("2-Search Course");
        System.out.println("3-Search User");
        System.out.println("4-Add Question to Question bank");
        System.out.println("5-Show Question bank");
        sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int userMenu() {
        System.out.println("1-Register");
        System.out.println("2-Login");
        return Integer.parseInt(1 + sc.nextLine());
    }

    public static int courseMenu() {
        System.out.println("1-Add a new course");
        System.out.println("2-Delete a course");
        System.out.println("3-Moidfy  a course");
        System.out.println("4-Add user to a course");
        System.out.println("5-Close a course");
        System.out.println("6-Open a closerd course");
        System.out.println("7-Choose a course");
        return Integer.parseInt(2 + sc.nextLine());
    }

    public static int exerciseMenu() {
        int n = 0;
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println("1-Create a new exercise");
            System.out.println("2-Delete an exercise");
            System.out.println("3-Modify an exercise");
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            n = Integer.parseInt(3 + sc.nextLine());
        } else {
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            n = Integer.parseInt(3 + sc.nextLine());
        }
        return n;
    }

    public static int questionMenu() {
        int n = 0;
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println("1-Add a  question");
            System.out.println("2-Delete a question");
            System.out.println("3-Modify a question");
            System.out.println("4-Get all of a user submits");
            System.out.println("5-Grade a question");
            System.out.println("6-Get submits and points");
            n = Integer.parseInt(4 + sc.nextLine());
        } else {
            System.out.println("7-Answer a a qestion");
            System.out.println("8-Set your final submit");
            n = Integer.parseInt(4 + sc.nextLine());
        }
        return n;
    }

}
