package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.YQhMkvD6Jx;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;

public class RWsIaZHWsr {
    public static Scanner sc = new Scanner(System.in);

    public static void OptWS598K8() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String ViqIJ93z72 = "";
        String AlXcxMnpnA = "";
        String OnLFrCHahn = "";
        if (YQhMkvD6Jx.SL6f32rUZU != null) {
            ViqIJ93z72 = YQhMkvD6Jx.SL6f32rUZU.getName();
        }
        if (YQhMkvD6Jx.Cai5b3fR01 != null) {
            AlXcxMnpnA = YQhMkvD6Jx.Cai5b3fR01.getName();
        }
        if (YQhMkvD6Jx.Yp6fyrPT6W != null) {
            OnLFrCHahn = YQhMkvD6Jx.Yp6fyrPT6W.getName();
        }
        System.out.print("Current user: ");
        System.out.print("\u001B[31m");
        System.out.print(ViqIJ93z72);
        System.out.print("\u001B[30m");
        System.out.print("     Current Course: ");
        System.out.print("\u001B[31m");
        System.out.print(AlXcxMnpnA);
        System.out.print("\u001B[30m");
        System.out.print("     Current Exercise: ");
        System.out.print("\u001B[31m");
        System.out.print(OnLFrCHahn);
        System.out.print("\u001B[30m");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[37m");
    }

    public static void IaLlRX14bw(String Yx3UWpAWN9) {
        System.out.print("\u001B[31m");
        System.out.println(Yx3UWpAWN9);
        System.out.print("\u001B[37m");
    }

    public static void N7UKk4QeDO() {
        System.out.print("Search User by email/national code :");
        String VYFMTu2cI9 = OKpO0hToua.nextLine();
        IaLlRX14bw(AChYMxs6Sp.ZD9pGQwjFy(VYFMTu2cI9));
    }

    public static void GyWjHtDFcH() {
        System.out.print("Search Course by course name/teacher's name/institution's name:");
        String M9NgmrVPJZ = OKpO0hToua.nextLine();
        IaLlRX14bw(AChYMxs6Sp.IY33fYIeJT(M9NgmrVPJZ));
    }

    public static void GdEIR1dotA() {
        System.out.print("Name:");
        String MrjjdzxK8V = OKpO0hToua.nextLine();
        System.out.print("Description:");
        String T7OtYHKvnS = OKpO0hToua.nextLine();
        System.out.print("Points:");
        int Jsl2osL0xs = Integer.parseInt(OKpO0hToua.nextLine());
        DBWF9HKpCd CAAOjdutAy = null;
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        DBWF9HKpCd TPGzqUMh3d = FprId0v8JU.KqOSqNH5xj(Integer.parseInt(OKpO0hToua.nextLine()));
        String EoYxwhxKla = "";
        String YQP08CQAIr = "";
        if (CAAOjdutAy == DBWF9HKpCd.MultiCoice) {
            String[] UzrC2XlSEK = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            UzrC2XlSEK[0] = OKpO0hToua.nextLine();
            System.out.print("-2:");
            UzrC2XlSEK[1] = OKpO0hToua.nextLine();
            System.out.print("-3:");
            UzrC2XlSEK[2] = OKpO0hToua.nextLine();
            System.out.print("-4:");
            UzrC2XlSEK[3] = OKpO0hToua.nextLine();
            System.out.print("which number is the Answer:");
            EoYxwhxKla = OKpO0hToua.nextLine();
            YQP08CQAIr = "-" + UzrC2XlSEK[0] + "-" + UzrC2XlSEK[1] + "-" + UzrC2XlSEK[2] + "-" + UzrC2XlSEK[3];
        } else {
            System.out.print("body:");
            YQP08CQAIr = OKpO0hToua.nextLine();
            System.out.print("Answer:");
            EoYxwhxKla = OKpO0hToua.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        HvWli0YqF6 Ok18HRTLaK = FprId0v8JU.K1duajJHWn(Integer.parseInt(OKpO0hToua.nextLine()));
        CWLBfvNLYP DCqu0ZMiL9 = new CWLBfvNLYP(MrjjdzxK8V, T7OtYHKvnS, YQP08CQAIr, Jsl2osL0xs, Ok18HRTLaK, TPGzqUMh3d,
                EoYxwhxKla);
        IaLlRX14bw(FprId0v8JU.AI7Sop68qp(DCqu0ZMiL9));
    }

    public static void U7WTniw19t() {
        ArrayList<CWLBfvNLYP> BVHsoSuC5B = IoZeJsoowW.UvfqA3UOtH;
        for (int TeU87t9iL5 = 0; TeU87t9iL5 < BVHsoSuC5B.size(); TeU87t9iL5++) {
            System.out.println(TeU87t9iL5 + 1 + " " + BVHsoSuC5B.get(TeU87t9iL5).getName() + " -> "
                    + BVHsoSuC5B.get(TeU87t9iL5).getDifficultyString());
        }
    }

    public static void IZlA94atln() {
        if (YQhMkvD6Jx.Yp6fyrPT6W != null) {
            YQhMkvD6Jx.Yp6fyrPT6W = null;
        } else if (YQhMkvD6Jx.Cai5b3fR01 != null) {
            YQhMkvD6Jx.Cai5b3fR01 = null;
        } else if (YQhMkvD6Jx.SL6f32rUZU != null) {
            YQhMkvD6Jx.SL6f32rUZU = null;
        }
    }
}