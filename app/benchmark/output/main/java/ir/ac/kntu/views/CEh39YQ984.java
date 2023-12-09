package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.BTASLl7vLv;
import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.controller.*;

public class CEh39YQ984 {
    public static Scanner SbU7S9V4Fv = new Scanner(System.in);

    public static void ZSLpKqk7y6() {
        System.out.print("\u001B[47m");
        System.out.print("\u001B[30m");
        String DGaAueKzVf = "";
        String QD7UGhn2HL = "";
        String XgeGZnQwcM = "";
        if (BTASLl7vLv.M0uzKUKCOc != null) {
            DGaAueKzVf = BTASLl7vLv.M0uzKUKCOc.LOYYZX72It();
        }
        if (BTASLl7vLv.TQGzERtY9b != null) {
            QD7UGhn2HL = BTASLl7vLv.TQGzERtY9b.UoZfKt2HYb();
        }
        if (BTASLl7vLv.OPgigAUlqa != null) {
            XgeGZnQwcM = BTASLl7vLv.OPgigAUlqa.KSA3YgnYqc();
        }
        System.out.print("Current user: ");
        System.out.print("\u001B[31m");
        System.out.print(DGaAueKzVf);
        System.out.print("\u001B[30m");
        System.out.print("     Current Course: ");
        System.out.print("\u001B[31m");
        System.out.print(QD7UGhn2HL);
        System.out.print("\u001B[30m");
        System.out.print("     Current Exercise: ");
        System.out.print("\u001B[31m");
        System.out.print(XgeGZnQwcM);
        System.out.print("\u001B[30m");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[37m");
    }

    public static void U34bhODQuD(String SJbs7H36DF) {
        System.out.print("\u001B[31m");
        System.out.println(SJbs7H36DF);
        System.out.print("\u001B[37m");
    }

    public static void ZQjqPguoI1() {
        System.out.print("Search User by email/national code :");
        String NI0eKWcHhi = SbU7S9V4Fv.nextLine();
        U34bhODQuD(Q6RwPkzANJ.VsSSmV4K0K(NI0eKWcHhi));
    }

    public static void Mcryi2oXlE() {
        System.out.print("Search Course by course name/teacher's name/institution's name:");
        String IOA8yOsvJU = SbU7S9V4Fv.nextLine();
        U34bhODQuD(Q6RwPkzANJ.UAxo9vk1oj(IOA8yOsvJU));
    }

    public static void EwSQTQRoTM() {
        System.out.print("Name:");
        String YZSo0v3Bco = SbU7S9V4Fv.nextLine();
        System.out.print("Description:");
        String Zd8JQEP2Bg = SbU7S9V4Fv.nextLine();
        System.out.print("Points:");
        int G42CijWfvE = Integer.parseInt(SbU7S9V4Fv.nextLine());
        LBiSlwW4Ii Bm69cHkhE4 = null;
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        LBiSlwW4Ii G12XtTMcML = RO4p3QSGvc.H62sEZjXUO(Integer.parseInt(SbU7S9V4Fv.nextLine()));
        String BgK01SqN8v = "";
        String I9eH5gaa1A = "";
        if (Bm69cHkhE4 == LBiSlwW4Ii.Hn8nn7YCVK) {
            String[] HvOpgqOuEV = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            HvOpgqOuEV[0] = SbU7S9V4Fv.nextLine();
            System.out.print("-2:");
            HvOpgqOuEV[1] = SbU7S9V4Fv.nextLine();
            System.out.print("-3:");
            HvOpgqOuEV[2] = SbU7S9V4Fv.nextLine();
            System.out.print("-4:");
            HvOpgqOuEV[3] = SbU7S9V4Fv.nextLine();
            System.out.print("which number is the Answer:");
            BgK01SqN8v = SbU7S9V4Fv.nextLine();
            I9eH5gaa1A = "-" + HvOpgqOuEV[0] + "-" + HvOpgqOuEV[1] + "-" + HvOpgqOuEV[2] + "-" + HvOpgqOuEV[3];
        } else {
            System.out.print("body:");
            I9eH5gaa1A = SbU7S9V4Fv.nextLine();
            System.out.print("Answer:");
            BgK01SqN8v = SbU7S9V4Fv.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        VjW7fp0JeE YQfKyVzKU0 = RO4p3QSGvc.B54lj4DY3J(Integer.parseInt(SbU7S9V4Fv.nextLine()));
        ECGr4H6bmY JLSVhojLvq = new ECGr4H6bmY(YZSo0v3Bco, Zd8JQEP2Bg, I9eH5gaa1A, G42CijWfvE, YQfKyVzKU0, G12XtTMcML, BgK01SqN8v);
        U34bhODQuD(RO4p3QSGvc.GEqUQvFP6b(JLSVhojLvq));
    }

    public static void YHk9WOpke3() {
        ArrayList<ECGr4H6bmY> TV3QR2ecxa = OtNKrtrX3r.RA56K9kFkU;
        for (int DkpXnfeUoE = 0; DkpXnfeUoE < TV3QR2ecxa.size(); DkpXnfeUoE++) {
            System.out.println(DkpXnfeUoE + 1 + " " + TV3QR2ecxa.get(DkpXnfeUoE).Q8q5TuaylW() + " -> " + TV3QR2ecxa.get(DkpXnfeUoE).EhPYqNMcyi());
        }
    }

    public static void F5sEKeNdMQ() {
        if (BTASLl7vLv.OPgigAUlqa != null) {
            BTASLl7vLv.OPgigAUlqa = null;
        } else if (BTASLl7vLv.TQGzERtY9b != null) {
            BTASLl7vLv.TQGzERtY9b = null;
        } else if (BTASLl7vLv.M0uzKUKCOc != null) {
            BTASLl7vLv.M0uzKUKCOc = null;
        }
    }

}
