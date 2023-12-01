package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.HodPiiC1LD;

public class Kv1T6gfsif extends HodPiiC1LD {

    public static int Waq5zo6rZR() {
        System.out.println("\u001B[32m");
        int KR0BR6US9H = -1;
        if (KJdQ1O5KoW.S3a20pSw4e == null) {
            KR0BR6US9H = QIagFlqTvL();
        } else {
            System.out.println("0-Back");
            if (KJdQ1O5KoW.NVK6b1gNMv == null) {
                KR0BR6US9H = KG5WZAi997();
            } else if (KJdQ1O5KoW.JdlsgaAs9U == null) {
                KR0BR6US9H = FWl7m7DMmt();
            } else {
                KR0BR6US9H = SNgUVZB1EI();
            }
        }
        System.out.println("\u001B[37m");
        if (KR0BR6US9H == 1) {
            KR0BR6US9H = UqPSJ2XOKE();
        }
        return KR0BR6US9H;
    }

    public static int QIagFlqTvL() {
        System.out.println("1-Sing in");
        System.out.println("2-Search Course");
        System.out.println("3-Search User");
        System.out.println("4-Add Question to Question bank");
        System.out.println("5-Show Question bank");
        DBXD6LUQ2U = new Scanner(System.in);
        return Integer.parseInt(DBXD6LUQ2U.nextLine());
    }

    public static int UqPSJ2XOKE() {
        System.out.println("1-Register");
        System.out.println("2-Login");
        return Integer.parseInt(1 + DBXD6LUQ2U.nextLine());
    }

    public static int KG5WZAi997() {
        System.out.println("1-Add a new course");
        System.out.println("2-Delete a course");
        System.out.println("3-Moidfy  a course");
        System.out.println("4-Add user to a course");
        System.out.println("5-Close a course");
        System.out.println("6-Open a closerd course");
        System.out.println("7-Choose a course");
        return Integer.parseInt(2 + DBXD6LUQ2U.nextLine());
    }

    public static int FWl7m7DMmt() {
        int C0O1bIXXJu = 0;
        if (KJdQ1O5KoW.NVK6b1gNMv.UeHJzpgWJ0().equals(KJdQ1O5KoW.S3a20pSw4e)) {
            System.out.println("1-Create a new exercise");
            System.out.println("2-Delete an exercise");
            System.out.println("3-Modify an exercise");
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            C0O1bIXXJu = Integer.parseInt(3 + DBXD6LUQ2U.nextLine());
        } else {
            System.out.println("4-Choose an  Exercises");
            System.out.println("5-Get score table");
            C0O1bIXXJu = Integer.parseInt(3 + DBXD6LUQ2U.nextLine());
        }
        return C0O1bIXXJu;
    }

    public static int SNgUVZB1EI() {
        int UFss93SuYz = 0;
        if (KJdQ1O5KoW.NVK6b1gNMv.UeHJzpgWJ0().equals(KJdQ1O5KoW.S3a20pSw4e)) {
            System.out.println("1-Add a  question");
            System.out.println("2-Delete a question");
            System.out.println("3-Modify a question");
            System.out.println("4-Get all of a user submits");
            System.out.println("5-Grade a question");
            System.out.println("6-Get submits and points");
            UFss93SuYz = Integer.parseInt(4 + DBXD6LUQ2U.nextLine());
        } else {
            System.out.println("7-Answer a a qestion");
            System.out.println("8-Set your final submit");
            UFss93SuYz = Integer.parseInt(4 + DBXD6LUQ2U.nextLine());
        }
        return UFss93SuYz;
    }

}
