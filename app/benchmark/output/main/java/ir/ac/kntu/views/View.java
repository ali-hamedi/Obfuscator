package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class View {
    public static Scanner sc = new Scanner(System.in);

    public static void showStatus() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String userStr = "";
        String courseStr = "";
        String exerciseStr = "";
        if (Global.currentUser != null) {
            userStr = MyCipher.getInstance().encode(Global.currentUser.getName());
        }
        if (Global.currentCourse != null) {
            courseStr = MyCipher.getInstance().encode(Global.currentCourse.getName());
        }
        if (Global.currentExercise != null) {
            exerciseStr = MyCipher.getInstance().encode(Global.currentExercise.getName());
        }
        System.out.print(MyCipher.getInstance().decode("c35be1713439d3c6a2a0d6857cd1"));
        System.out.print("\u001B[31m");
        System.out.print(MyCipher.getInstance().decode(userStr));
        System.out.print("\u001B[30m");
        System.out.print(MyCipher.getInstance().decode("a00eb3237114d294a5b6dd8366b25c219cc91a9bde"));
        System.out.print("\u001B[31m");
        System.out.print(MyCipher.getInstance().decode(courseStr));
        System.out.print("\u001B[30m");
        System.out.print(MyCipher.getInstance().decode("a00eb3237114d294a5b6dd8366b44b313f13ea56727b21"));
        System.out.print("\u001B[31m");
        System.out.print(MyCipher.getInstance().decode(exerciseStr));
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
        System.out.print(MyCipher.getInstance().decode("d34bf271323f87b3a4b6c1d7248813311508001d3e538dfd30647c11ee43efcea1ab986c"));
        String query = MyCipher.getInstance().encode(sc.nextLine());
        showResult(Helpercontroller.searchUser(MyCipher.getInstance().decode(query)));
    }

    public static void searchCourse() {
        System.out.print(MyCipher.getInstance().decode("d34bf271323f87a5b8a6c18423d1512d3a1201372e118f395decbdcabd89fac770b67193f2235363c41efdb625e805911930738e60c87682cb7aed482604c8"));
        String query = MyCipher.getInstance().encode(sc.nextLine());
        showResult(Helpercontroller.searchCourse(MyCipher.getInstance().decode(query)));
    }

    public static void addQuestionToBank() {
        System.out.print(MyCipher.getInstance().decode("ce4ffe666b"));
        String name = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcddcd"));
        String description = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("d041fa6d25249d"));
        String point = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        Type typ = null;
        System.out.print(MyCipher.getInstance().decode("d457e3667931d589baf382da249d523ab9350583ab8e20f91b3fc4f753d5e0465c53e94162d30cee69529ca0268544dabf9dca8c"));
        Type type = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "";
        String body = "";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println(MyCipher.getInstance().decode("e241f77a6b"));
            System.out.print(MyCipher.getInstance().decode("ad1fa9"));
            bodyArr[0] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1ca9"));
            bodyArr[1] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1da9"));
            bodyArr[2] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1aa9"));
            bodyArr[3] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("f746fa603977c993bab1d6856698407464c4d05518f35ae279606f"));
            answer = MyCipher.getInstance().encode(sc.nextLine());
            body = MyCipher.getInstance().encode(MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b0"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b1"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b2"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b3"))]));
        } else {
            System.out.print(MyCipher.getInstance().decode("e241f77a6b"));
            body = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c140e07434259d"));
            answer = MyCipher.getInstance().encode(sc.nextLine());
        }
        System.out.print(MyCipher.getInstance().decode("c447f5653222cb92aefbd585299c1365f4baad1da0c94c97149da4571f45bc00eabe7e74fd61041ddaefbc31e66e9d8c52ab18"));
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(body), Integer.parseInt(MyCipher.getInstance().decode(point)), diff, type, MyCipher.getInstance().decode(answer));
        showResult(Questioncontroller.addQuestionToBank(q));
    }

    public static void showQuestionbank() {
        ArrayList<Question> arr = Questionbank.quesiton;
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName() + MyCipher.getInstance().decode("a003ad23") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getDifficultyString());
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
