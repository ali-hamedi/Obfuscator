package ir.ac.kntu;

import ir.ac.kntu.views.RWsIaZHWsr;

public class EVXThmBGEX extends RWsIaZHWsr {
    public static int ELRZk3McTM() {
        System.out.println("\u001B[32m");
        int F2oOyFKEu4 = -1;
        if (YQhMkvD6Jx.SL6f32rUZU == null) {
            F2oOyFKEu4 = XUQSsarxAJ();
        } else {
            System.out.println("0-Back");
            if (YQhMkvD6Jx.Cai5b3fR01 == null) {
                F2oOyFKEu4 = EQmrcpfhCf();
            } else if (YQhMkvD6Jx.Yp6fyrPT6W == null) {
                F2oOyFKEu4 = KwSfSXj5sE();
            } else {
                F2oOyFKEu4 = O33z8SvgqM();
            }
        }
        System.out.println("\u001B[37m");
        if (F2oOyFKEu4 == 1) {
            F2oOyFKEu4 = CqaMBzuTl3();
        }
        return F2oOyFKEu4;
    }

    public static int XUQSsarxAJ() {
        System.out.println("1-Sing in");
        System.out.println("2-Search Course");
        System.out.println("3-Search User");
        System.out.println("4-Add Question to Question bank");
        System.out.println("5-Show Question bank");
        return Integer.parseInt(sc.nextLine());
    }

    public static int CqaMBzuTl3() {
        System.out.println("1-Register");
        System.out.println("2-Login");
        return Integer.parseInt(1 + sc.nextLine());
    }

    public static int EQmrcpfhCf() {
        System.out.println("1-Add a new course");
        System.out.println("2-Delete a course");
        System.out.println("3-Moidfy  a course");
        System.out.println("4-Add user to a course");
        System.out.println("5-Close a course");
        System.out.println("6-Open a closerd course");
        System.out.println("7-Choose a course");
        return Integer.parseInt(2 + sc.nextLine());
    }

    public static int KwSfSXj5sE() {
        int M98L3TELH9 = 0;
        if (YQhMkvD6Jx.Cai5b3fR01.getTeacher().equals(YQhMkvD6Jx.SL6f32rUZU)) {
            System.out.println("1-Create a new exercise");
            System.out.println("2-Delete an exercise");
            System.out.println("3-Modify an exercise");
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            M98L3TELH9 = Integer.parseInt(3 + sc.nextLine());
        } else {
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            M98L3TELH9 = Integer.parseInt(3 + sc.nextLine());
        }
        return M98L3TELH9;
    }

    public static int O33z8SvgqM() {
        int VWY2QZtl1v = 0;
        if (YQhMkvD6Jx.Cai5b3fR01.getTeacher().equals(YQhMkvD6Jx.SL6f32rUZU)) {
            System.out.println("1-Add a  question");
            System.out.println("2-Delete a question");
            System.out.println("3-Modify a question");
            System.out.println("4-Get all of a user submits");
            System.out.println("5-Grade a question");
            System.out.println("6-Get submits and points");
            VWY2QZtl1v = Integer.parseInt(4 + sc.nextLine());
        } else {
            System.out.println("7-Answer a a qestion");
            System.out.println("8-Set your final submit");
            VWY2QZtl1v = Integer.parseInt(4 + sc.nextLine());
        }
        return VWY2QZtl1v;
    }
}