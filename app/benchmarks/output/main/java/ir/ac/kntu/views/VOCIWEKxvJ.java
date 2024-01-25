package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.Jpix49t4ls;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.FRF7GV2ChS;

public class VOCIWEKxvJ {
    public static Scanner A3QLzXPjfR = new Scanner(System.in);

    public static void NjGtQR1KZx() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String MxOFawDJrb = "";
        String FjsYFWvnxd = "";
        String MprbIqRujM = "";
        if (Jpix49t4ls.R3C1dSUCog != null) {
            MxOFawDJrb = Jpix49t4ls.R3C1dSUCog.UJOPUM4cud();
        }
        if (Jpix49t4ls.FuVC6vUvYX != null) {
            FjsYFWvnxd = Jpix49t4ls.FuVC6vUvYX.DDxisZqxif();
        }
        if (Jpix49t4ls.UZ69vWrXEH != null) {
            MprbIqRujM = Jpix49t4ls.UZ69vWrXEH.UzQOUqkNrl();
        }
        System.out.print("Current user: ");
        System.out.print("\u001B[31m");
        System.out.print(MxOFawDJrb);
        System.out.print("\u001B[30m");
        System.out.print("     Current Course: ");
        System.out.print("\u001B[31m");
        System.out.print(FjsYFWvnxd);
        System.out.print("\u001B[30m");
        System.out.print("     Current Exercise: ");
        System.out.print("\u001B[31m");
        System.out.print(MprbIqRujM);
        System.out.print("\u001B[30m");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[37m");
    }

    public static void WcImjHwdqK(String UWJxBgxL6n) {
        System.out.print("\u001B[31m");
        System.out.println(UWJxBgxL6n);
        System.out.print("\u001B[37m");
    }

    public static void Nrz1AZvJDA() {
        System.out.print("Search User by email/national code :");
        String XYH3hBrBZm = A3QLzXPjfR.nextLine();
        WcImjHwdqK(WfXXAEykK4.EHRpS3n6yJ(XYH3hBrBZm));
    }

    public static void KuR2PlQS3L() {
        System.out.print("Search Course by course name/teacher's name/institution's name:");
        String JDnzWIyFzL = A3QLzXPjfR.nextLine();
        WcImjHwdqK(WfXXAEykK4.N41YAvfb60(JDnzWIyFzL));
    }

    public static void ZK2JpMGJem() {
        System.out.print("Name:");
        String PqI3Qg1eSH = A3QLzXPjfR.nextLine();
        System.out.print("Description:");
        String JEY3eSaYsV = A3QLzXPjfR.nextLine();
        System.out.print("Points:");
        int MgFe4xRf15 = Integer.parseInt(A3QLzXPjfR.nextLine());
        ZlNPN6R4tO SEGvb91ubW = null;
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        ZlNPN6R4tO VmPKhrLY3E = QWdfQlwAnQ.G2PRzW8p1U(Integer.parseInt(A3QLzXPjfR.nextLine()));
        String YN115Xa8RV = "";
        String OIA13xvybt = "";
        if (SEGvb91ubW == ZlNPN6R4tO.P0RjkwKKfI) {
            String[] SDVSNNcSZS = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            SDVSNNcSZS[0] = A3QLzXPjfR.nextLine();
            System.out.print("-2:");
            SDVSNNcSZS[1] = A3QLzXPjfR.nextLine();
            System.out.print("-3:");
            SDVSNNcSZS[2] = A3QLzXPjfR.nextLine();
            System.out.print("-4:");
            SDVSNNcSZS[3] = A3QLzXPjfR.nextLine();
            System.out.print("which number is the Answer:");
            YN115Xa8RV = A3QLzXPjfR.nextLine();
            OIA13xvybt = "-" + SDVSNNcSZS[0] + "-" + SDVSNNcSZS[1] + "-" + SDVSNNcSZS[2] + "-" + SDVSNNcSZS[3];
        } else {
            System.out.print("body:");
            OIA13xvybt = A3QLzXPjfR.nextLine();
            System.out.print("Answer:");
            YN115Xa8RV = A3QLzXPjfR.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        HpoOty8Ekh QqFdPhLXUx = QWdfQlwAnQ.CamuErmCVA(Integer.parseInt(A3QLzXPjfR.nextLine()));
        V1vGfZmdTS NLeOPSE2Hj = new V1vGfZmdTS(PqI3Qg1eSH, JEY3eSaYsV, OIA13xvybt, MgFe4xRf15, QqFdPhLXUx, VmPKhrLY3E, YN115Xa8RV);
        WcImjHwdqK(QWdfQlwAnQ.JHmohcVFFQ(NLeOPSE2Hj));
    }

    public static void GeSqFFJyWM() {
        ArrayList<V1vGfZmdTS> CqbDkTpya9 = Ib79daDiYW.Nd4fgj0mfo;
        for (int ZgFd9nJrIa = 0; ZgFd9nJrIa < CqbDkTpya9.size(); ZgFd9nJrIa = ZgFd9nJrIa + 1) {
            System.out.println(ZgFd9nJrIa + 1 + " " + CqbDkTpya9.get(ZgFd9nJrIa).S2jKcOPUI8() + " -> " + CqbDkTpya9.get(ZgFd9nJrIa).X2JoU7YVrw());
        }
    }

    public static void OWdR9a9ClJ() {
        if (Jpix49t4ls.UZ69vWrXEH != null) {
            Jpix49t4ls.UZ69vWrXEH = null;
        } else if (Jpix49t4ls.FuVC6vUvYX != null) {
            Jpix49t4ls.FuVC6vUvYX = null;
        } else if (Jpix49t4ls.R3C1dSUCog != null) {
            Jpix49t4ls.R3C1dSUCog = null;
        }
    }

}
