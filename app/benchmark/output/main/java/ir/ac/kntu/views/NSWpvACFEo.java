package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.KJdQ1O5KoW;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.data.db.OuR53JEf1f;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;

public class NSWpvACFEo extends HodPiiC1LD {
    public static void PNhvRK6Drk() {
        System.out.println("1-Add question from Question Bank");
        System.out.println("2-Create a question");
        int VuoMM32rpg = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (VuoMM32rpg == 2) {
            TWbDEcSuor();
        } else if (VuoMM32rpg == 1) {
            TlV8auPFYt();
        } else {
            BQaGPSTFNl("Please choose a valid task");
        }
    }

    public static void TlV8auPFYt() {
        System.out.println("Choose which question you want to add to youre exercise :");
        ArrayList<LPsHi17T2t> Sb5r9RYXze = OuR53JEf1f.QuaOknNdMp;
        for (int ZmX6Wb2q73 = 0; ZmX6Wb2q73 < Sb5r9RYXze.size(); ZmX6Wb2q73++) {
            System.out.println(ZmX6Wb2q73 + 1 + " " + Sb5r9RYXze.get(ZmX6Wb2q73).VVLTUogJ97());
        }
        int WCJg7pLDyr = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (WCJg7pLDyr < 1 || Sb5r9RYXze.size() == 0 || WCJg7pLDyr > Sb5r9RYXze.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            BQaGPSTFNl(L1hgMhofW3.OXRJe2SXBB(Sb5r9RYXze.get(WCJg7pLDyr - 1)));
        }

    }

    public static void TWbDEcSuor() {
        System.out.print("Name:");
        String FQq9Xma97J = DBXD6LUQ2U.nextLine();
        System.out.print("Description:");
        String P7zIPyPFa5 = DBXD6LUQ2U.nextLine();
        System.out.print("Points:");
        int ZOHZvTjBTz = Integer.parseInt(DBXD6LUQ2U.nextLine());
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        Qib9SHQbSG VATYRja5kO = L1hgMhofW3.YC8OLmCnMf(Integer.parseInt(DBXD6LUQ2U.nextLine()));
        String SftWIhjVlD = "";
        String Iy06dXENlb = "";
        if (VATYRja5kO == Qib9SHQbSG.NUVkQKjj3j) {
            String[] SPo0nvGUhQ = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            SPo0nvGUhQ[0] = DBXD6LUQ2U.nextLine();
            System.out.print("-2:");
            SPo0nvGUhQ[1] = DBXD6LUQ2U.nextLine();
            System.out.print("-3:");
            SPo0nvGUhQ[2] = DBXD6LUQ2U.nextLine();
            System.out.print("-4:");
            SPo0nvGUhQ[3] = DBXD6LUQ2U.nextLine();
            System.out.print("which number is the Answer:");
            SftWIhjVlD = DBXD6LUQ2U.nextLine();
            Iy06dXENlb = "-" + SPo0nvGUhQ[0] + "-" + SPo0nvGUhQ[1] + "-" + SPo0nvGUhQ[2] + "-" + SPo0nvGUhQ[3];
        } else {
            System.out.print("body:");
            Iy06dXENlb = DBXD6LUQ2U.nextLine();
            System.out.print("Answer:");
            SftWIhjVlD = DBXD6LUQ2U.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        BPmipLq0ft XP2v3IVhLA = L1hgMhofW3.WRAWvNTPkK(Integer.parseInt(DBXD6LUQ2U.nextLine()));
        LPsHi17T2t HwWuuOnlhi = new LPsHi17T2t(FQq9Xma97J, P7zIPyPFa5, Iy06dXENlb, ZOHZvTjBTz, XP2v3IVhLA, VATYRja5kO, SftWIhjVlD);
        BQaGPSTFNl(L1hgMhofW3.GhfyP235Ki(HwWuuOnlhi));
        System.out.print("Do you want to add this question to the question bank too??(yes/no)");
        String FMEZ0Ts5Mt = DBXD6LUQ2U.nextLine();
        if (FMEZ0Ts5Mt.equals("yes")) {
            BQaGPSTFNl(L1hgMhofW3.ZelsJCpo1g(HwWuuOnlhi));
        }
    }

    public static void FdinmBdyPl() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<LPsHi17T2t> ZgvNcE8Ju0 = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int RooxxELNF0 = 0; RooxxELNF0 < ZgvNcE8Ju0.size(); RooxxELNF0++) {
            System.out.println(RooxxELNF0 + 1 + " " + ZgvNcE8Ju0.get(RooxxELNF0).VVLTUogJ97());
        }
        int PuPky8WIPN = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (PuPky8WIPN < 1 || ZgvNcE8Ju0.size() == 0 || PuPky8WIPN > ZgvNcE8Ju0.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            BQaGPSTFNl(L1hgMhofW3.Cg88tkXsr2(ZgvNcE8Ju0.get(PuPky8WIPN - 1)));
        }
    }

    public static void CEYRPK2Ju5() {
        System.out.println("Choose which question you want to edit :");
        ArrayList<LPsHi17T2t> NRcba5QttY = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int HUvoaD6EdL = 0; HUvoaD6EdL < NRcba5QttY.size(); HUvoaD6EdL++) {
            System.out.println(HUvoaD6EdL + 1 + " " + NRcba5QttY.get(HUvoaD6EdL).VVLTUogJ97());
        }
        int UzJhLiujoo = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (UzJhLiujoo < 1 || NRcba5QttY.size() == 0 || UzJhLiujoo > NRcba5QttY.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            System.out.println("Modify the exercise:");
            System.out.print("Name:" + "(old name was  " + NRcba5QttY.get(UzJhLiujoo - 1).VVLTUogJ97() + ") :");
            String ZJoNwSAUbl = DBXD6LUQ2U.nextLine();
            System.out.print("Description" + "(old name was  " + NRcba5QttY.get(UzJhLiujoo - 1).E0rPym2o9F() + ") :");
            String AJNFAN847H = DBXD6LUQ2U.nextLine();
            System.out.print("Points:" + "(old name was  " + NRcba5QttY.get(UzJhLiujoo - 1).YjWzDxvtNZ() + ") :");
            int A3OhUgOqT1 = Integer.parseInt(DBXD6LUQ2U.nextLine());
            System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):" + "(old name was  "+ NRcba5QttY.get(UzJhLiujoo - 1).BQULXMUH9h() + ") :");
            Qib9SHQbSG BLxZcRiCa8 = L1hgMhofW3.YC8OLmCnMf(Integer.parseInt(DBXD6LUQ2U.nextLine()));
            String Ed1vmSam4E = "";
            String FQXren3NYA = "";
            System.out.print("body:");
            if (BLxZcRiCa8 == Qib9SHQbSG.NUVkQKjj3j) {
                String[] MwxHT4mkEp = new String[4];
                System.out.print("-1:");
                MwxHT4mkEp[0] = DBXD6LUQ2U.nextLine();
                System.out.print("-2:");
                MwxHT4mkEp[1] = DBXD6LUQ2U.nextLine();
                System.out.print("-3:");
                MwxHT4mkEp[2] = DBXD6LUQ2U.nextLine();
                System.out.print("-4:");
                MwxHT4mkEp[3] = DBXD6LUQ2U.nextLine();
                System.out.print("which number is the Answer:");
                Ed1vmSam4E = DBXD6LUQ2U.nextLine();
                FQXren3NYA = "-" + MwxHT4mkEp[0] + "-" + MwxHT4mkEp[1] + "-" + MwxHT4mkEp[2] + "-" + MwxHT4mkEp[3];
            } else {
                FQXren3NYA = DBXD6LUQ2U.nextLine();
                System.out.print("Answer:");
                Ed1vmSam4E = DBXD6LUQ2U.nextLine();
            }
            System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):" + "(old name was  "+ NRcba5QttY.get(UzJhLiujoo - 1).N1JzsGPug7() + ") :");
            BPmipLq0ft Ed6SklBgyD = L1hgMhofW3.WRAWvNTPkK(Integer.parseInt(DBXD6LUQ2U.nextLine()));
            BQaGPSTFNl(L1hgMhofW3.HXGFrtERF2(NRcba5QttY.get(UzJhLiujoo - 1),new LPsHi17T2t(ZJoNwSAUbl, AJNFAN847H, FQXren3NYA, A3OhUgOqT1, Ed6SklBgyD, BLxZcRiCa8, Ed1vmSam4E)));
        }
    }

    public static void SzSQTQKYzm() {
        ArrayList<LPsHi17T2t> ZFWuosgUP4 = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int KfU2ifCDun = 0; KfU2ifCDun < ZFWuosgUP4.size(); KfU2ifCDun++) {
            System.out.println(KfU2ifCDun + 1 + " " + ZFWuosgUP4.get(KfU2ifCDun).VVLTUogJ97());
        }
        int CfnOEEG9Nr = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (CfnOEEG9Nr < 1 || ZFWuosgUP4.size() == 0 || CfnOEEG9Nr > ZFWuosgUP4.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {

            LPsHi17T2t BI1wDwwE7Q = ZFWuosgUP4.get(CfnOEEG9Nr - 1);
            System.out.println("Question: ");
            if (BI1wDwwE7Q.BQULXMUH9h() == Qib9SHQbSG.NUVkQKjj3j) {
                String[] Kmq9eFnaSo = BI1wDwwE7Q.WGPDLR2rMZ().split("-");
                for (int YRnWGUcPu4 = 0; YRnWGUcPu4 < Kmq9eFnaSo.length; YRnWGUcPu4++) {
                    if (YRnWGUcPu4 == 0) {
                        System.out.println(BI1wDwwE7Q.E0rPym2o9F() + "?");
                    } else {
                        System.out.println("-" + Kmq9eFnaSo[YRnWGUcPu4]);
                    }
                }
            } else {
                System.out.println(BI1wDwwE7Q.WGPDLR2rMZ() + "?");
            }
            System.out.println("Enter Your answer: ");
            String KUAdmJ8VGx = DBXD6LUQ2U.nextLine();
            BQaGPSTFNl(L1hgMhofW3.SLnqIfAuu0(BI1wDwwE7Q, KUAdmJ8VGx));
        }
    }

    public static void LCIW8jpXPN() {
        System.out.println("Choose which question  :");
        ArrayList<LPsHi17T2t> Un99W0prT7 = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int MGcyfroYRS = 0; MGcyfroYRS < Un99W0prT7.size(); MGcyfroYRS++) {
            System.out.println(MGcyfroYRS + 1 + " " + Un99W0prT7.get(MGcyfroYRS).VVLTUogJ97());
        }
        int Q0VamTdqfN = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (Q0VamTdqfN < 1 || Un99W0prT7.size() == 0 || Q0VamTdqfN > Un99W0prT7.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<YBwVogQr76> U4E5Yi0rzz = KJdQ1O5KoW.NVK6b1gNMv.PuZiX7AQI7();
            for (int J5ZD11JQjp = 0; J5ZD11JQjp < U4E5Yi0rzz.size(); J5ZD11JQjp++) {
                System.out.println(J5ZD11JQjp + 1 + " " + U4E5Yi0rzz.get(J5ZD11JQjp).C58usGbEqr());
            }
            int AkZyyqc0E7 = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (AkZyyqc0E7 < 1 || U4E5Yi0rzz.size() == 0 || AkZyyqc0E7 > U4E5Yi0rzz.size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                BQaGPSTFNl("The use last submit was: " + Un99W0prT7.get(Q0VamTdqfN - 1).QBTv8OPKBy().get(U4E5Yi0rzz.get(AkZyyqc0E7 - 1)));
                System.out.println("Enter the point you wanna give: ");
                int Mc7L7W31cU = Integer.parseInt(DBXD6LUQ2U.nextLine());
                BQaGPSTFNl(L1hgMhofW3.QcCbUko4dP(Un99W0prT7.get(Q0VamTdqfN - 1), U4E5Yi0rzz.get(AkZyyqc0E7 - 1), Mc7L7W31cU));
            }
        }
    }

    public static void XU5uoGEvyl() {
        System.out.println("Choose which question  :");
        ArrayList<LPsHi17T2t> C6lWD3Xrrg = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int BjALJTpiRW = 0; BjALJTpiRW < C6lWD3Xrrg.size(); BjALJTpiRW++) {
            System.out.println(BjALJTpiRW + 1 + " " + C6lWD3Xrrg.get(BjALJTpiRW).VVLTUogJ97());
        }
        int JVKmIh2YrT = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (JVKmIh2YrT < 1 || C6lWD3Xrrg.size() == 0 || JVKmIh2YrT > C6lWD3Xrrg.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<YBwVogQr76> V4wMcfVVYg = KJdQ1O5KoW.NVK6b1gNMv.PuZiX7AQI7();
            for (int YZUUWT97Q8 = 0; YZUUWT97Q8 < V4wMcfVVYg.size(); YZUUWT97Q8++) {
                System.out.println(YZUUWT97Q8 + 1 + " " + V4wMcfVVYg.get(YZUUWT97Q8).C58usGbEqr());
            }
            int FCedFNfQH0 = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (FCedFNfQH0 < 1 || V4wMcfVVYg.size() == 0 || FCedFNfQH0 > V4wMcfVVYg.size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                BQaGPSTFNl(L1hgMhofW3.KCw6A22wzq(C6lWD3Xrrg.get(JVKmIh2YrT - 1), V4wMcfVVYg.get(FCedFNfQH0 - 1)));
            }
        }
    }

    public static void SzQiUuTp3D() {
        System.out.println("Choose which question  :");
        ArrayList<LPsHi17T2t> F4t56pelJ3 = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int MotaWntUbi = 0; MotaWntUbi < F4t56pelJ3.size(); MotaWntUbi++) {
            System.out.println(MotaWntUbi + 1 + " " + F4t56pelJ3.get(MotaWntUbi).VVLTUogJ97());
        }
        int JrYgL9bIqy = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (JrYgL9bIqy < 1 || F4t56pelJ3.size() == 0 || JrYgL9bIqy > F4t56pelJ3.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            System.out.println("Choose which submits (Last one was):"
                    + F4t56pelJ3.get(JrYgL9bIqy - 1).QBTv8OPKBy().get(KJdQ1O5KoW.S3a20pSw4e));
            ArrayList<String> IqRN5wR1y4 = F4t56pelJ3.get(JrYgL9bIqy - 1).EYguyHa83x().get(KJdQ1O5KoW.S3a20pSw4e);
            for (int MDQdqS2gBs = 0; MDQdqS2gBs < IqRN5wR1y4.size(); MDQdqS2gBs++) {
                System.out.println(MDQdqS2gBs + 1 + " " + IqRN5wR1y4.get(MDQdqS2gBs));
            }
            int QUxnU5tlTx = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (QUxnU5tlTx < 1 || IqRN5wR1y4.size() == 0 || QUxnU5tlTx > IqRN5wR1y4.size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                BQaGPSTFNl(L1hgMhofW3.VU3v2lxO6J(F4t56pelJ3.get(JrYgL9bIqy - 1), IqRN5wR1y4.get(QUxnU5tlTx - 1)));
            }
        }
    }

    public static void ZqIJF8Sxm5() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<LPsHi17T2t> UTqSh88u3X = KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l();
        for (int Ohzkp39t9Q = 0; Ohzkp39t9Q < UTqSh88u3X.size(); Ohzkp39t9Q++) {
            System.out.println(Ohzkp39t9Q + 1 + " " + UTqSh88u3X.get(Ohzkp39t9Q).VVLTUogJ97());
        }
        int GVpZi6Qc8i = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (GVpZi6Qc8i < 1 || UTqSh88u3X.size() == 0 || GVpZi6Qc8i > UTqSh88u3X.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            BQaGPSTFNl(L1hgMhofW3.NHOUY25sWD(UTqSh88u3X.get(GVpZi6Qc8i - 1)));
        }
    }
}
