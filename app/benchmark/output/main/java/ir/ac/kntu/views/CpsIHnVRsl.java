package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.BTASLl7vLv;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.data.db.OtNKrtrX3r;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;

public class CpsIHnVRsl extends CEh39YQ984 {
    public static void Daz31WcQ7P() {
        System.out.println("1-Add question from Question Bank");
        System.out.println("2-Create a question");
        int Ugyw0E9T5I = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (Ugyw0E9T5I == 2) {
            QuasPYV2BS();
        } else if (Ugyw0E9T5I == 1) {
            I0aQ05HAkt();
        } else {
            U34bhODQuD("Please choose a valid task");
        }
    }

    public static void I0aQ05HAkt() {
        System.out.println("Choose which question you want to add to youre exercise :");
        ArrayList<ECGr4H6bmY> QZgKh6fUzW = OtNKrtrX3r.RA56K9kFkU;
        for (int XfgYK4qcWE = 0; XfgYK4qcWE < QZgKh6fUzW.size(); XfgYK4qcWE++) {
            System.out.println(XfgYK4qcWE + 1 + " " + QZgKh6fUzW.get(XfgYK4qcWE).Q8q5TuaylW());
        }
        int Z29v0CY8qL = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (Z29v0CY8qL < 1 || QZgKh6fUzW.size() == 0 || Z29v0CY8qL > QZgKh6fUzW.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            U34bhODQuD(RO4p3QSGvc.RtjtxRASAA(QZgKh6fUzW.get(Z29v0CY8qL - 1)));
        }

    }

    public static void QuasPYV2BS() {
        System.out.print("Name:");
        String TY9DNNp74C = SbU7S9V4Fv.nextLine();
        System.out.print("Description:");
        String HG8u8YrsOO = SbU7S9V4Fv.nextLine();
        System.out.print("Points:");
        int QKeoPmQzmv = Integer.parseInt(SbU7S9V4Fv.nextLine());
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        LBiSlwW4Ii CXp73Hs2Tx = RO4p3QSGvc.H62sEZjXUO(Integer.parseInt(SbU7S9V4Fv.nextLine()));
        String UTDvytIrzH = "";
        String SNhCkXHDJ7 = "";
        if (CXp73Hs2Tx == LBiSlwW4Ii.Hn8nn7YCVK) {
            String[] Uw1LB72AeU = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            Uw1LB72AeU[0] = SbU7S9V4Fv.nextLine();
            System.out.print("-2:");
            Uw1LB72AeU[1] = SbU7S9V4Fv.nextLine();
            System.out.print("-3:");
            Uw1LB72AeU[2] = SbU7S9V4Fv.nextLine();
            System.out.print("-4:");
            Uw1LB72AeU[3] = SbU7S9V4Fv.nextLine();
            System.out.print("which number is the Answer:");
            UTDvytIrzH = SbU7S9V4Fv.nextLine();
            SNhCkXHDJ7 = "-" + Uw1LB72AeU[0] + "-" + Uw1LB72AeU[1] + "-" + Uw1LB72AeU[2] + "-" + Uw1LB72AeU[3];
        } else {
            System.out.print("body:");
            SNhCkXHDJ7 = SbU7S9V4Fv.nextLine();
            System.out.print("Answer:");
            UTDvytIrzH = SbU7S9V4Fv.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        VjW7fp0JeE EHP3NHAveM = RO4p3QSGvc.B54lj4DY3J(Integer.parseInt(SbU7S9V4Fv.nextLine()));
        ECGr4H6bmY K8wN9QjW9K = new ECGr4H6bmY(TY9DNNp74C, HG8u8YrsOO, SNhCkXHDJ7, QKeoPmQzmv, EHP3NHAveM, CXp73Hs2Tx, UTDvytIrzH);
        U34bhODQuD(RO4p3QSGvc.Rcq74V7eIH(K8wN9QjW9K));
        System.out.print("Do you want to add this question to the question bank too??(yes/no)");
        String YMEAmjjAWh = SbU7S9V4Fv.nextLine();
        if (YMEAmjjAWh.equals("yes")) {
            U34bhODQuD(RO4p3QSGvc.GEqUQvFP6b(K8wN9QjW9K));
        }
    }

    public static void QLKCAjZGXY() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<ECGr4H6bmY> TAQmLUBhAi = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int UlfBLy2k4c = 0; UlfBLy2k4c < TAQmLUBhAi.size(); UlfBLy2k4c++) {
            System.out.println(UlfBLy2k4c + 1 + " " + TAQmLUBhAi.get(UlfBLy2k4c).Q8q5TuaylW());
        }
        int YLWYboqpGe = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (YLWYboqpGe < 1 || TAQmLUBhAi.size() == 0 || YLWYboqpGe > TAQmLUBhAi.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            U34bhODQuD(RO4p3QSGvc.HZwqLFRpRt(TAQmLUBhAi.get(YLWYboqpGe - 1)));
        }
    }

    public static void EvOw9biek6() {
        System.out.println("Choose which question you want to edit :");
        ArrayList<ECGr4H6bmY> Gs3Gv2emoH = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int JEgGNOxbLA = 0; JEgGNOxbLA < Gs3Gv2emoH.size(); JEgGNOxbLA++) {
            System.out.println(JEgGNOxbLA + 1 + " " + Gs3Gv2emoH.get(JEgGNOxbLA).Q8q5TuaylW());
        }
        int QiXsdpPibC = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (QiXsdpPibC < 1 || Gs3Gv2emoH.size() == 0 || QiXsdpPibC > Gs3Gv2emoH.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            System.out.println("Modify the exercise:");
            System.out.print("Name:" + "(old name was  " + Gs3Gv2emoH.get(QiXsdpPibC - 1).Q8q5TuaylW() + ") :");
            String YYXVHgzU7u = SbU7S9V4Fv.nextLine();
            System.out.print("Description" + "(old name was  " + Gs3Gv2emoH.get(QiXsdpPibC - 1).J8Gq2Yr0zG() + ") :");
            String Ad8mcEXUeK = SbU7S9V4Fv.nextLine();
            System.out.print("Points:" + "(old name was  " + Gs3Gv2emoH.get(QiXsdpPibC - 1).CKgenPEsyU() + ") :");
            int UpPB9hkVQl = Integer.parseInt(SbU7S9V4Fv.nextLine());
            System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):" + "(old name was  "+ Gs3Gv2emoH.get(QiXsdpPibC - 1).JKdW1uZ5uU() + ") :");
            LBiSlwW4Ii HPLy5bgqYH = RO4p3QSGvc.H62sEZjXUO(Integer.parseInt(SbU7S9V4Fv.nextLine()));
            String VGGa3iqGSM = "";
            String RoFqrKoDYU = "";
            System.out.print("body:");
            if (HPLy5bgqYH == LBiSlwW4Ii.Hn8nn7YCVK) {
                String[] Pi4bqAdsan = new String[4];
                System.out.print("-1:");
                Pi4bqAdsan[0] = SbU7S9V4Fv.nextLine();
                System.out.print("-2:");
                Pi4bqAdsan[1] = SbU7S9V4Fv.nextLine();
                System.out.print("-3:");
                Pi4bqAdsan[2] = SbU7S9V4Fv.nextLine();
                System.out.print("-4:");
                Pi4bqAdsan[3] = SbU7S9V4Fv.nextLine();
                System.out.print("which number is the Answer:");
                VGGa3iqGSM = SbU7S9V4Fv.nextLine();
                RoFqrKoDYU = "-" + Pi4bqAdsan[0] + "-" + Pi4bqAdsan[1] + "-" + Pi4bqAdsan[2] + "-" + Pi4bqAdsan[3];
            } else {
                RoFqrKoDYU = SbU7S9V4Fv.nextLine();
                System.out.print("Answer:");
                VGGa3iqGSM = SbU7S9V4Fv.nextLine();
            }
            System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):" + "(old name was  "+ Gs3Gv2emoH.get(QiXsdpPibC - 1).CcPIBERDJe() + ") :");
            VjW7fp0JeE G2BfGlhEBI = RO4p3QSGvc.B54lj4DY3J(Integer.parseInt(SbU7S9V4Fv.nextLine()));
            U34bhODQuD(RO4p3QSGvc.FfCLhBCImX(Gs3Gv2emoH.get(QiXsdpPibC - 1),new ECGr4H6bmY(YYXVHgzU7u, Ad8mcEXUeK, RoFqrKoDYU, UpPB9hkVQl, G2BfGlhEBI, HPLy5bgqYH, VGGa3iqGSM)));
        }
    }

    public static void DOkd3a2y6z() {
        ArrayList<ECGr4H6bmY> KRfUvPbsUT = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int GVa44YfqLp = 0; GVa44YfqLp < KRfUvPbsUT.size(); GVa44YfqLp++) {
            System.out.println(GVa44YfqLp + 1 + " " + KRfUvPbsUT.get(GVa44YfqLp).Q8q5TuaylW());
        }
        int OV9ZX7x1CH = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (OV9ZX7x1CH < 1 || KRfUvPbsUT.size() == 0 || OV9ZX7x1CH > KRfUvPbsUT.size()) {
            U34bhODQuD("Enter valid number");
        } else {

            ECGr4H6bmY MeHHxNbJ1V = KRfUvPbsUT.get(OV9ZX7x1CH - 1);
            System.out.println("Question: ");
            if (MeHHxNbJ1V.JKdW1uZ5uU() == LBiSlwW4Ii.Hn8nn7YCVK) {
                String[] K6nW65gVhx = MeHHxNbJ1V.I3cMRAgARY().split("-");
                for (int ArGz8PB2V6 = 0; ArGz8PB2V6 < K6nW65gVhx.length; ArGz8PB2V6++) {
                    if (ArGz8PB2V6 == 0) {
                        System.out.println(MeHHxNbJ1V.J8Gq2Yr0zG() + "?");
                    } else {
                        System.out.println("-" + K6nW65gVhx[ArGz8PB2V6]);
                    }
                }
            } else {
                System.out.println(MeHHxNbJ1V.I3cMRAgARY() + "?");
            }
            System.out.println("Enter Your answer: ");
            String WJ4JiJiDNV = SbU7S9V4Fv.nextLine();
            U34bhODQuD(RO4p3QSGvc.XySnu8iMJq(MeHHxNbJ1V, WJ4JiJiDNV));
        }
    }

    public static void SlNk8JKsvD() {
        System.out.println("Choose which question  :");
        ArrayList<ECGr4H6bmY> VR7ROXlgd3 = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int Ta8hvqFnfI = 0; Ta8hvqFnfI < VR7ROXlgd3.size(); Ta8hvqFnfI++) {
            System.out.println(Ta8hvqFnfI + 1 + " " + VR7ROXlgd3.get(Ta8hvqFnfI).Q8q5TuaylW());
        }
        int CQ8tgYGAVq = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (CQ8tgYGAVq < 1 || VR7ROXlgd3.size() == 0 || CQ8tgYGAVq > VR7ROXlgd3.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<UehRAADCCb> BerbW8l9vV = BTASLl7vLv.TQGzERtY9b.McqiEUfIon();
            for (int GTywe3w7tY = 0; GTywe3w7tY < BerbW8l9vV.size(); GTywe3w7tY++) {
                System.out.println(GTywe3w7tY + 1 + " " + BerbW8l9vV.get(GTywe3w7tY).LOYYZX72It());
            }
            int FJ9OraTiAR = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (FJ9OraTiAR < 1 || BerbW8l9vV.size() == 0 || FJ9OraTiAR > BerbW8l9vV.size()) {
                U34bhODQuD("Enter valid number");
            } else {
                U34bhODQuD("The use last submit was: " + VR7ROXlgd3.get(CQ8tgYGAVq - 1).Zrb7kjT2Kl().get(BerbW8l9vV.get(FJ9OraTiAR - 1)));
                System.out.println("Enter the point you wanna give: ");
                int XxrkzJn4AC = Integer.parseInt(SbU7S9V4Fv.nextLine());
                U34bhODQuD(RO4p3QSGvc.ZcJAK7HMnx(VR7ROXlgd3.get(CQ8tgYGAVq - 1), BerbW8l9vV.get(FJ9OraTiAR - 1), XxrkzJn4AC));
            }
        }
    }

    public static void R2SHDlGNBz() {
        System.out.println("Choose which question  :");
        ArrayList<ECGr4H6bmY> Yp4dRHxmTi = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int BDruKDhSHb = 0; BDruKDhSHb < Yp4dRHxmTi.size(); BDruKDhSHb++) {
            System.out.println(BDruKDhSHb + 1 + " " + Yp4dRHxmTi.get(BDruKDhSHb).Q8q5TuaylW());
        }
        int GiFK4jddMd = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (GiFK4jddMd < 1 || Yp4dRHxmTi.size() == 0 || GiFK4jddMd > Yp4dRHxmTi.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<UehRAADCCb> FHLFl9yiik = BTASLl7vLv.TQGzERtY9b.McqiEUfIon();
            for (int Kq1HrlmICG = 0; Kq1HrlmICG < FHLFl9yiik.size(); Kq1HrlmICG++) {
                System.out.println(Kq1HrlmICG + 1 + " " + FHLFl9yiik.get(Kq1HrlmICG).LOYYZX72It());
            }
            int FFmJWhwzXY = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (FFmJWhwzXY < 1 || FHLFl9yiik.size() == 0 || FFmJWhwzXY > FHLFl9yiik.size()) {
                U34bhODQuD("Enter valid number");
            } else {
                U34bhODQuD(RO4p3QSGvc.ZaM6S5YXZM(Yp4dRHxmTi.get(GiFK4jddMd - 1), FHLFl9yiik.get(FFmJWhwzXY - 1)));
            }
        }
    }

    public static void VoUlrRyUAa() {
        System.out.println("Choose which question  :");
        ArrayList<ECGr4H6bmY> Hu0erBFrKE = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int XsJjE7R4gS = 0; XsJjE7R4gS < Hu0erBFrKE.size(); XsJjE7R4gS++) {
            System.out.println(XsJjE7R4gS + 1 + " " + Hu0erBFrKE.get(XsJjE7R4gS).Q8q5TuaylW());
        }
        int Sm5SkobOdR = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (Sm5SkobOdR < 1 || Hu0erBFrKE.size() == 0 || Sm5SkobOdR > Hu0erBFrKE.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            System.out.println("Choose which submits (Last one was):"
                    + Hu0erBFrKE.get(Sm5SkobOdR - 1).Zrb7kjT2Kl().get(BTASLl7vLv.M0uzKUKCOc));
            ArrayList<String> NkI4TnUexk = Hu0erBFrKE.get(Sm5SkobOdR - 1).R33CzGEfAv().get(BTASLl7vLv.M0uzKUKCOc);
            for (int S5XsZEKJMj = 0; S5XsZEKJMj < NkI4TnUexk.size(); S5XsZEKJMj++) {
                System.out.println(S5XsZEKJMj + 1 + " " + NkI4TnUexk.get(S5XsZEKJMj));
            }
            int JoJwMZkItw = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (JoJwMZkItw < 1 || NkI4TnUexk.size() == 0 || JoJwMZkItw > NkI4TnUexk.size()) {
                U34bhODQuD("Enter valid number");
            } else {
                U34bhODQuD(RO4p3QSGvc.UlFJFgKFNe(Hu0erBFrKE.get(Sm5SkobOdR - 1), NkI4TnUexk.get(JoJwMZkItw - 1)));
            }
        }
    }

    public static void GFGv4IZ5oK() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<ECGr4H6bmY> FUV3I6vC0G = BTASLl7vLv.OPgigAUlqa.UUA7sPQo6q();
        for (int NhMca1CCGa = 0; NhMca1CCGa < FUV3I6vC0G.size(); NhMca1CCGa++) {
            System.out.println(NhMca1CCGa + 1 + " " + FUV3I6vC0G.get(NhMca1CCGa).Q8q5TuaylW());
        }
        int C08rTxSoKp = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (C08rTxSoKp < 1 || FUV3I6vC0G.size() == 0 || C08rTxSoKp > FUV3I6vC0G.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            U34bhODQuD(RO4p3QSGvc.DUNv4rXj9W(FUV3I6vC0G.get(C08rTxSoKp - 1)));
        }
    }
}
