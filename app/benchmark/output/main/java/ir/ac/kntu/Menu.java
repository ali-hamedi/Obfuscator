package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.View;
import ir.ac.kntu.MyCipher;


public class Menu extends View {

    public static int shoMenuHandler() {
        System.out.println("\u001B[32m");
        String n = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
        if (Global.currentUser == null) {
            n = MyCipher.getInstance().encode(mainMenu());
        } else {
            System.out.println(MyCipher.getInstance().decode("b003d162323c"));
            if (Global.currentCourse == null) {
                n = MyCipher.getInstance().encode(courseMenu());
            } else if (Global.currentExercise == null) {
                n = MyCipher.getInstance().encode(exerciseMenu());
            } else {
                n = MyCipher.getInstance().encode(questionMenu());
            }
        }
        System.out.println("\u001B[37m");
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) == Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            n = MyCipher.getInstance().encode(userMenu());
        }
        return Integer.parseInt(MyCipher.getInstance().decode(n));
    }

    public static int mainMenu() {
        System.out.println(MyCipher.getInstance().decode("b103c06a3f30878fb9"));
        System.out.println(MyCipher.getInstance().decode("b203c0663025c48ef790dc82348256"));
        System.out.println(MyCipher.getInstance().decode("b303c0663025c48ef786c09234"));
        System.out.println(MyCipher.getInstance().decode("b403d2673577f693b2a0c79e299f132037b6d3f72a71608b9fce49a88631a4"));
        System.out.println(MyCipher.getInstance().decode("b503c06b3e2087b7a2b6c0832f9e5d742fa99d8b"));
        sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int userMenu() {
        System.out.println(MyCipher.getInstance().decode("b103c166363ed492b2a1"));
        System.out.println(MyCipher.getInstance().decode("b203df6c363ec9"));
        return Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b1")) + sc.nextLine());
    }

    public static int courseMenu() {
        System.out.println(MyCipher.getInstance().decode("b103d2673577c6c6b9b6c4d7259e46269866"));
        System.out.println(MyCipher.getInstance().decode("b203d7663d32d383f7b29394298441274f"));
        System.out.println(MyCipher.getInstance().decode("b303de6c3833c19ff7f3d2d7259e4626ee30"));
        System.out.println(MyCipher.getInstance().decode("b403d2673577d295b2a1938329d152743d179d62c923"));
        System.out.println(MyCipher.getInstance().decode("b503d06f3e24c2c6b6f3d09833834031"));
        System.out.println(MyCipher.getInstance().decode("b603dc7334398787f7b0df9835944130554db372a2d471"));
        System.out.println(MyCipher.getInstance().decode("b703d06b3e38d483f7b2939429844127cc"));
        return Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b2")) + sc.nextLine());
    }

    public static int exerciseMenu() {
        String n = "b0";
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println(MyCipher.getInstance().decode("b103d0713436d383f7b2939923861331bc49a1abaa6020"));
            System.out.println(MyCipher.getInstance().decode("b203d7663d32d383f7b2ddd723895626f4519322"));
            System.out.println(MyCipher.getInstance().decode("b303de6c353ec19ff7b2ddd72389562660458d8c"));
            System.out.println(MyCipher.getInstance().decode("b403d06b3e38d483f7b2ddd766b44b3188dc4f745b13"));
            System.out.println(MyCipher.getInstance().decode("b503d4662577d485b8a1d6d73290513837"));
            n = MyCipher.getInstance().encode(Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b3")) + sc.nextLine()));
        } else {
            System.out.println(MyCipher.getInstance().decode("b403d06b3e38d483f7b2ddd766b44b3188dc4f745b13"));
            System.out.println(MyCipher.getInstance().decode("b503d4662577d485b8a1d6d73290513837"));
            n = MyCipher.getInstance().encode(Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b3")) + sc.nextLine()));
        }
        return Integer.parseInt(MyCipher.getInstance().decode(n));
    }

    public static int questionMenu() {
        String n = "b0";
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println(MyCipher.getInstance().decode("b103d2673577c6c6f7a2c69235855a3bdc"));
            System.out.println(MyCipher.getInstance().decode("b203d7663d32d383f7b293863394402045aef2"));
            System.out.println(MyCipher.getInstance().decode("b303de6c353ec19ff7b2938633944020fc15c1"));
            System.out.println(MyCipher.getInstance().decode("b403d4662577c68abbf3dc916690132180161a055f16a559f33d64"));
            System.out.println(MyCipher.getInstance().decode("b503d4713033c2c6b6f3c2822382473d6575"));
            System.out.println(MyCipher.getInstance().decode("b603d4662577d493b5beda8335d1523a83934201fb1c3a82"));
            n = MyCipher.getInstance().encode(Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b4")) + sc.nextLine()));
        } else {
            System.out.println(MyCipher.getInstance().decode("b703d26d2220c294f7b2939666805627d2179ebd"));
            System.out.println(MyCipher.getInstance().decode("b803c0662577de89a2a193912f9f5238e5dc95afc6fe01"));
            n = MyCipher.getInstance().encode(Integer.parseInt(Integer.parseInt(MyCipher.getInstance().decode("b4")) + sc.nextLine()));
        }

        return Integer.parseInt(MyCipher.getInstance().decode(n));
    }

}
