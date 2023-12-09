package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.CEh39YQ984;

public class MzyMemSsoM extends CEh39YQ984 {

    public static int I4EmL7ZKPc() {
        System.out.println("\u001B[32m");
        int VaIxYTyo8Q = -1;
        if (BTASLl7vLv.M0uzKUKCOc == null) {
            VaIxYTyo8Q = P8KeSFO1lx();
        } else {
            System.out.println("0-Back");
            if (BTASLl7vLv.TQGzERtY9b == null) {
                VaIxYTyo8Q = HAyQ1NwAV3();
            } else if (BTASLl7vLv.OPgigAUlqa == null) {
                VaIxYTyo8Q = PPwPb9lM4X();
            } else {
                VaIxYTyo8Q = Rck1a1ayNV();
            }
        }
        System.out.println("\u001B[37m");
        if (VaIxYTyo8Q == 1) {
            VaIxYTyo8Q = YUiASAUWyc();
        }
        return VaIxYTyo8Q;
    }

    public static int P8KeSFO1lx() {
        System.out.println("1-Sing in");
        System.out.println("2-Search Course");
        System.out.println("3-Search User");
        System.out.println("4-Add Question to Question bank");
        System.out.println("5-Show Question bank");
        SbU7S9V4Fv = new Scanner(System.in);
        return Integer.parseInt(SbU7S9V4Fv.nextLine());
    }

    public static int YUiASAUWyc() {
        System.out.println("1-Register");
        System.out.println("2-Login");
        return Integer.parseInt(1 + SbU7S9V4Fv.nextLine());
    }

    public static int HAyQ1NwAV3() {
        System.out.println("1-Add a new course");
        System.out.println("2-Delete a course");
        System.out.println("3-Moidfy  a course");
        System.out.println("4-Add user to a course");
        System.out.println("5-Close a course");
        System.out.println("6-Open a closerd course");
        System.out.println("7-Choose a course");
        return Integer.parseInt(2 + SbU7S9V4Fv.nextLine());
    }

    public static int PPwPb9lM4X() {
        int Zjqy3fRxM9 = 0;
        if (BTASLl7vLv.TQGzERtY9b.UHExyXnudX().equals(BTASLl7vLv.M0uzKUKCOc)) {
            System.out.println("1-Create a new exercise");
            System.out.println("2-Delete an exercise");
            System.out.println("3-Modify an exercise");
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            Zjqy3fRxM9 = Integer.parseInt(3 + SbU7S9V4Fv.nextLine());
        } else {
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            Zjqy3fRxM9 = Integer.parseInt(3 + SbU7S9V4Fv.nextLine());
        }
        return Zjqy3fRxM9;
    }

    public static int Rck1a1ayNV() {
        int QwNMh1Jb4T = 0;
        if (BTASLl7vLv.TQGzERtY9b.UHExyXnudX().equals(BTASLl7vLv.M0uzKUKCOc)) {
            System.out.println("1-Add a  question");
            System.out.println("2-Delete a question");
            System.out.println("3-Modify a question");
            System.out.println("4-Get all of a user submits");
            System.out.println("5-Grade a question");
            System.out.println("6-Get submits and points");
            QwNMh1Jb4T = Integer.parseInt(4 + SbU7S9V4Fv.nextLine());
        } else {
            System.out.println("7-Answer a a qestion");
            System.out.println("8-Set your final submit");
            QwNMh1Jb4T = Integer.parseInt(4 + SbU7S9V4Fv.nextLine());
        }
        return QwNMh1Jb4T;
    }

}
