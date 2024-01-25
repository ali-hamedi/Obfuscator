package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.VOCIWEKxvJ;

public class OYWnAjgbSO extends VOCIWEKxvJ {

    public static int WSLoT4IuS4() {
        System.out.println("\u001B[32m");
        int Bt2MWzvqhf = -1;
        if (Jpix49t4ls.R3C1dSUCog == null) {
            Bt2MWzvqhf = WYQqJOb85o();
        } else {
            System.out.println("0-Back");
            if (Jpix49t4ls.FuVC6vUvYX == null) {
                Bt2MWzvqhf = UIocmuIC5K();
            } else if (Jpix49t4ls.UZ69vWrXEH == null) {
                Bt2MWzvqhf = XMY4gFg4N2();
            } else {
                Bt2MWzvqhf = TA57LWcEfi();
            }
        }
        System.out.println("\u001B[37m");
        if (Bt2MWzvqhf == 1) {
            Bt2MWzvqhf = EkGa0uybS0();
        }
        return Bt2MWzvqhf;
    }

    public static int WYQqJOb85o() {
        System.out.println("1-Sing in");
        System.out.println("2-Search Course");
        System.out.println("3-Search User");
        System.out.println("4-Add Question to Question bank");
        System.out.println("5-Show Question bank");
        A3QLzXPjfR = new Scanner(System.in);
        return Integer.parseInt(A3QLzXPjfR.nextLine());
    }

    public static int EkGa0uybS0() {
        System.out.println("1-Register");
        System.out.println("2-Login");
        return Integer.parseInt(1 + A3QLzXPjfR.nextLine());
    }

    public static int UIocmuIC5K() {
        System.out.println("1-Add a new course");
        System.out.println("2-Delete a course");
        System.out.println("3-Moidfy  a course");
        System.out.println("4-Add user to a course");
        System.out.println("5-Close a course");
        System.out.println("6-Open a closerd course");
        System.out.println("7-Choose a course");
        return Integer.parseInt(2 + A3QLzXPjfR.nextLine());
    }

    public static int XMY4gFg4N2() {
        int Y4pj01KKe4 = 0;
        if (Jpix49t4ls.FuVC6vUvYX.WcoIXJfG0B().equals(Jpix49t4ls.R3C1dSUCog)) {
            System.out.println("1-Create a new exercise");
            System.out.println("2-Delete an exercise");
            System.out.println("3-Modify an exercise");
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            Y4pj01KKe4 = Integer.parseInt(3 + A3QLzXPjfR.nextLine());
        } else {
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            Y4pj01KKe4 = Integer.parseInt(3 + A3QLzXPjfR.nextLine());
        }
        return Y4pj01KKe4;
    }

    public static int TA57LWcEfi() {
        int LwpamNdd6f = 0;
        if (Jpix49t4ls.FuVC6vUvYX.WcoIXJfG0B().equals(Jpix49t4ls.R3C1dSUCog)) {
            System.out.println("1-Add a  question");
            System.out.println("2-Delete a question");
            System.out.println("3-Modify a question");
            System.out.println("4-Get all of a user submits");
            System.out.println("5-Grade a question");
            System.out.println("6-Get submits and points");
            LwpamNdd6f = Integer.parseInt(4 + A3QLzXPjfR.nextLine());
        } else {
            System.out.println("7-Answer a a qestion");
            System.out.println("8-Set your final submit");
            LwpamNdd6f = Integer.parseInt(4 + A3QLzXPjfR.nextLine());
        }

        return LwpamNdd6f;
    }

}
