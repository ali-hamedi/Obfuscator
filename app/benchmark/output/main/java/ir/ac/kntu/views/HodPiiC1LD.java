package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.KJdQ1O5KoW;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;

public class HodPiiC1LD {
    public static Scanner DBXD6LUQ2U = new Scanner(System.in);

    public static void DQfnBzJeKs() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String G7oFsXCuPC = "";
        String LtyYPmk0Pr = "";
        String ADc8xrILlA = "";
        if (KJdQ1O5KoW.S3a20pSw4e != null) {
            G7oFsXCuPC = KJdQ1O5KoW.S3a20pSw4e.C58usGbEqr();
        }
        if (KJdQ1O5KoW.NVK6b1gNMv != null) {
            LtyYPmk0Pr = KJdQ1O5KoW.NVK6b1gNMv.AilU2NMpyF();
        }
        if (KJdQ1O5KoW.JdlsgaAs9U != null) {
            ADc8xrILlA = KJdQ1O5KoW.JdlsgaAs9U.Z5J4gpEjFy();
        }
        System.out.print("Current user: ");
        System.out.print("\u001B[31m");
        System.out.print(G7oFsXCuPC);
        System.out.print("\u001B[30m");
        System.out.print("     Current Course: ");
        System.out.print("\u001B[31m");
        System.out.print(LtyYPmk0Pr);
        System.out.print("\u001B[30m");
        System.out.print("     Current Exercise: ");
        System.out.print("\u001B[31m");
        System.out.print(ADc8xrILlA);
        System.out.print("\u001B[30m");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[37m");
    }

    public static void BQaGPSTFNl(String HUrXG5bie3) {
        System.out.print("\u001B[31m");
        System.out.println(HUrXG5bie3);
        System.out.print("\u001B[37m");
    }

    public static void BEZZn8rybn() {
        System.out.print("Search User by email/national code :");
        String QRAenhYgC2 = DBXD6LUQ2U.nextLine();
        BQaGPSTFNl(MGd8mjssps.WKc7klJJT5(QRAenhYgC2));
    }

    public static void NdYWpSgINc() {
        System.out.print("Search Course by course name/teacher's name/institution's name:");
        String G1Kb10HeDa = DBXD6LUQ2U.nextLine();
        BQaGPSTFNl(MGd8mjssps.I8XFPe6BgV(G1Kb10HeDa));
    }

    public static void Pw6G7Cydf7() {
        System.out.print("Name:");
        String Td3Vdf4sNP = DBXD6LUQ2U.nextLine();
        System.out.print("Description:");
        String Dcbbw3UT2X = DBXD6LUQ2U.nextLine();
        System.out.print("Points:");
        int WTDjNDKqkM = Integer.parseInt(DBXD6LUQ2U.nextLine());
        Qib9SHQbSG LTJ0EngRR0 = null;
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        Qib9SHQbSG CAMeWZExFV = L1hgMhofW3.YC8OLmCnMf(Integer.parseInt(DBXD6LUQ2U.nextLine()));
        String ERF6KxXQbo = "";
        String GEVp4PYqlX = "";
        if (LTJ0EngRR0 == Qib9SHQbSG.NUVkQKjj3j) {
            String[] V4k23YGUvp = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            V4k23YGUvp[0] = DBXD6LUQ2U.nextLine();
            System.out.print("-2:");
            V4k23YGUvp[1] = DBXD6LUQ2U.nextLine();
            System.out.print("-3:");
            V4k23YGUvp[2] = DBXD6LUQ2U.nextLine();
            System.out.print("-4:");
            V4k23YGUvp[3] = DBXD6LUQ2U.nextLine();
            System.out.print("which number is the Answer:");
            ERF6KxXQbo = DBXD6LUQ2U.nextLine();
            GEVp4PYqlX = "-" + V4k23YGUvp[0] + "-" + V4k23YGUvp[1] + "-" + V4k23YGUvp[2] + "-" + V4k23YGUvp[3];
        } else {
            System.out.print("body:");
            GEVp4PYqlX = DBXD6LUQ2U.nextLine();
            System.out.print("Answer:");
            ERF6KxXQbo = DBXD6LUQ2U.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        BPmipLq0ft HLsqERCeZg = L1hgMhofW3.WRAWvNTPkK(Integer.parseInt(DBXD6LUQ2U.nextLine()));
        LPsHi17T2t VlWvs6yyv6 = new LPsHi17T2t(Td3Vdf4sNP, Dcbbw3UT2X, GEVp4PYqlX, WTDjNDKqkM, HLsqERCeZg, CAMeWZExFV, ERF6KxXQbo);
        BQaGPSTFNl(L1hgMhofW3.ZelsJCpo1g(VlWvs6yyv6));
    }

    public static void VzybfkClbq() {
        ArrayList<LPsHi17T2t> Zs0T6FvzLS = OuR53JEf1f.QuaOknNdMp;
        for (int X923sUfYnf = 0; X923sUfYnf < Zs0T6FvzLS.size(); X923sUfYnf++) {
            System.out.println(X923sUfYnf + 1 + " " + Zs0T6FvzLS.get(X923sUfYnf).VVLTUogJ97() + " -> " + Zs0T6FvzLS.get(X923sUfYnf).RA1unWJerr());
        }
    }

    public static void E1SyP5RsAo() {
        if (KJdQ1O5KoW.JdlsgaAs9U != null) {
            KJdQ1O5KoW.JdlsgaAs9U = null;
        } else if (KJdQ1O5KoW.NVK6b1gNMv != null) {
            KJdQ1O5KoW.NVK6b1gNMv = null;
        } else if (KJdQ1O5KoW.S3a20pSw4e != null) {
            KJdQ1O5KoW.S3a20pSw4e = null;
        }
    }

}
