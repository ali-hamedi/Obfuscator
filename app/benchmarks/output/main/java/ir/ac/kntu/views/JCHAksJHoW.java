package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Jpix49t4ls;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.data.db.Ib79daDiYW;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.FRF7GV2ChS;

public class JCHAksJHoW extends VOCIWEKxvJ {
    public static void GfxZMWmsBA() {
        System.out.println("1-Add question from Question Bank");
        System.out.println("2-Create a question");
        int PdG2meofOL = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (PdG2meofOL == 2) {
            EnDmyRutCc();
        } else if (PdG2meofOL == 1) {
            Ur1fFkwntV();
        } else {
            WcImjHwdqK("Please choose a valid task");
        }
    }

    public static void Ur1fFkwntV() {
        System.out.println("Choose which question you want to add to youre exercise :");
        ArrayList<V1vGfZmdTS> ChSiAiANmA = Ib79daDiYW.Nd4fgj0mfo;
        for (int LEgKMDOtdF = 0; LEgKMDOtdF < ChSiAiANmA.size(); LEgKMDOtdF = LEgKMDOtdF + 1) {
            System.out.println(LEgKMDOtdF + 1 + " " + ChSiAiANmA.get(LEgKMDOtdF).S2jKcOPUI8());
        }
        int PzFUV4YhUf = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (PzFUV4YhUf < 1 || ChSiAiANmA.size() == 0 || PzFUV4YhUf > ChSiAiANmA.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            WcImjHwdqK(QWdfQlwAnQ.NEehZ6VdJq(ChSiAiANmA.get(PzFUV4YhUf - 1)));
        }

    }

    public static void EnDmyRutCc() {
        System.out.print("Name:");
        String KdmyaIyHNp = A3QLzXPjfR.nextLine();
        System.out.print("Description:");
        String B3KMWvOCag = A3QLzXPjfR.nextLine();
        System.out.print("Points:");
        int I1I79iSynd = Integer.parseInt(A3QLzXPjfR.nextLine());
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        ZlNPN6R4tO X3YTIGKPkO = QWdfQlwAnQ.G2PRzW8p1U(Integer.parseInt(A3QLzXPjfR.nextLine()));
        String UJBhK1HGbd = "";
        String KwMFoCmnS1 = "";
        if (X3YTIGKPkO == ZlNPN6R4tO.P0RjkwKKfI) {
            String[] QjyOnsDnXg = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            QjyOnsDnXg[0] = A3QLzXPjfR.nextLine();
            System.out.print("-2:");
            QjyOnsDnXg[1] = A3QLzXPjfR.nextLine();
            System.out.print("-3:");
            QjyOnsDnXg[2] = A3QLzXPjfR.nextLine();
            System.out.print("-4:");
            QjyOnsDnXg[3] = A3QLzXPjfR.nextLine();
            System.out.print("which number is the Answer:");
            UJBhK1HGbd = A3QLzXPjfR.nextLine();
            KwMFoCmnS1 = "-" + QjyOnsDnXg[0] + "-" + QjyOnsDnXg[1] + "-" + QjyOnsDnXg[2] + "-" + QjyOnsDnXg[3];
        } else {
            System.out.print("body:");
            KwMFoCmnS1 = A3QLzXPjfR.nextLine();
            System.out.print("Answer:");
            UJBhK1HGbd = A3QLzXPjfR.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        HpoOty8Ekh CzJzUVO1Mi = QWdfQlwAnQ.CamuErmCVA(Integer.parseInt(A3QLzXPjfR.nextLine()));
        V1vGfZmdTS DFJmx7WogP = new V1vGfZmdTS(KdmyaIyHNp, B3KMWvOCag, KwMFoCmnS1, I1I79iSynd, CzJzUVO1Mi, X3YTIGKPkO, UJBhK1HGbd);
        WcImjHwdqK(QWdfQlwAnQ.VVs7Tt851N(DFJmx7WogP));
        System.out.print("Do you want to add this question to the question bank too??(yes/no)");
        String TPRfSfb442 = A3QLzXPjfR.nextLine();
        if (TPRfSfb442.equals("yes")) {
            WcImjHwdqK(QWdfQlwAnQ.JHmohcVFFQ(DFJmx7WogP));
        }
    }

    public static void O2W8QOSwAw() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<V1vGfZmdTS> KL0iaNpQ66 = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int X0ygi8W0r8 = 0; X0ygi8W0r8 < KL0iaNpQ66.size(); X0ygi8W0r8 = X0ygi8W0r8 + 1) {
            System.out.println(X0ygi8W0r8 + 1 + " " + KL0iaNpQ66.get(X0ygi8W0r8).S2jKcOPUI8());
        }
        int T6v77zrITU = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (T6v77zrITU < 1 || KL0iaNpQ66.size() == 0 || T6v77zrITU > KL0iaNpQ66.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            WcImjHwdqK(QWdfQlwAnQ.FytdVcgkvR(KL0iaNpQ66.get(T6v77zrITU - 1)));
        }
    }

    public static void HX6dnsuhZZ() {
        System.out.println("Choose which question you want to edit :");
        ArrayList<V1vGfZmdTS> H8l5RBUGcU = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int R1Z6g6Szhl = 0; R1Z6g6Szhl < H8l5RBUGcU.size(); R1Z6g6Szhl = R1Z6g6Szhl + 1) {
            System.out.println(R1Z6g6Szhl + 1 + " " + H8l5RBUGcU.get(R1Z6g6Szhl).S2jKcOPUI8());
        }
        int CVS2UhiTfr = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (CVS2UhiTfr < 1 || H8l5RBUGcU.size() == 0 || CVS2UhiTfr > H8l5RBUGcU.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            System.out.println("Modify the exercise:");
            System.out.print("Name:" + "(old name was  " + H8l5RBUGcU.get(CVS2UhiTfr - 1).S2jKcOPUI8() + ") :");
            String HmKzkd6cp9 = A3QLzXPjfR.nextLine();
            System.out.print("Description" + "(old name was  " + H8l5RBUGcU.get(CVS2UhiTfr - 1).No1XvNhLLK() + ") :");
            String DlVblTacbc = A3QLzXPjfR.nextLine();
            System.out.print("Points:" + "(old name was  " + H8l5RBUGcU.get(CVS2UhiTfr - 1).DUgXvqVznT() + ") :");
            int IoB073xTZB = Integer.parseInt(A3QLzXPjfR.nextLine());
            System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):" + "(old name was  "
                    + H8l5RBUGcU.get(CVS2UhiTfr - 1).BSzkjtMYzW() + ") :");
            ZlNPN6R4tO Y5FOBDX1aj = QWdfQlwAnQ.G2PRzW8p1U(Integer.parseInt(A3QLzXPjfR.nextLine()));
            String P9eAiSGELm = "";
            String VoqaAecJ7o = "";
            System.out.print("body:");
            if (Y5FOBDX1aj == ZlNPN6R4tO.P0RjkwKKfI) {
                String[] L3kfX9Ukkd = new String[4];
                System.out.print("-1:");
                L3kfX9Ukkd[0] = A3QLzXPjfR.nextLine();
                System.out.print("-2:");
                L3kfX9Ukkd[1] = A3QLzXPjfR.nextLine();
                System.out.print("-3:");
                L3kfX9Ukkd[2] = A3QLzXPjfR.nextLine();
                System.out.print("-4:");
                L3kfX9Ukkd[3] = A3QLzXPjfR.nextLine();
                System.out.print("which number is the Answer:");
                P9eAiSGELm = A3QLzXPjfR.nextLine();
                VoqaAecJ7o = "-" + L3kfX9Ukkd[0] + "-" + L3kfX9Ukkd[1] + "-" + L3kfX9Ukkd[2] + "-" + L3kfX9Ukkd[3];
            } else {
                VoqaAecJ7o = A3QLzXPjfR.nextLine();
                System.out.print("Answer:");
                P9eAiSGELm = A3QLzXPjfR.nextLine();
            }
            System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):" + "(old name was  "
                    + H8l5RBUGcU.get(CVS2UhiTfr - 1).JsKEKGR1Zo() + ") :");
            HpoOty8Ekh Jzuo32CODd = QWdfQlwAnQ.CamuErmCVA(Integer.parseInt(A3QLzXPjfR.nextLine()));
            WcImjHwdqK(QWdfQlwAnQ.DJbUbdy8in(H8l5RBUGcU.get(CVS2UhiTfr - 1),
                    new V1vGfZmdTS(HmKzkd6cp9, DlVblTacbc, VoqaAecJ7o, IoB073xTZB, Jzuo32CODd, Y5FOBDX1aj, P9eAiSGELm)));
        }
    }

    public static void LtJlTuay5s() {
        ArrayList<V1vGfZmdTS> Z1hAnHPjB8 = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int UDhKagYhns = 0; UDhKagYhns < Z1hAnHPjB8.size(); UDhKagYhns = UDhKagYhns + 1) {
            System.out.println(UDhKagYhns + 1 + " " + Z1hAnHPjB8.get(UDhKagYhns).S2jKcOPUI8());
        }
        int BHjjEAniOD = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (BHjjEAniOD < 1 || Z1hAnHPjB8.size() == 0 || BHjjEAniOD > Z1hAnHPjB8.size()) {
            WcImjHwdqK("Enter valid number");
        } else {

            V1vGfZmdTS IOW81cJxOJ = Z1hAnHPjB8.get(BHjjEAniOD - 1);
            System.out.println("Question: ");
            if (IOW81cJxOJ.BSzkjtMYzW() == ZlNPN6R4tO.P0RjkwKKfI) {
                String[] XOVpeMIecn = IOW81cJxOJ.LufC7jTCkb().split("-");
                for (int BbkDq1ZvUN = 0; BbkDq1ZvUN < XOVpeMIecn.length; BbkDq1ZvUN = BbkDq1ZvUN + 1) {
                    if (BbkDq1ZvUN == 0) {
                        System.out.println(IOW81cJxOJ.No1XvNhLLK() + "?");
                    } else {
                        System.out.println("-" + XOVpeMIecn[BbkDq1ZvUN]);
                    }
                }
            } else {
                System.out.println(IOW81cJxOJ.LufC7jTCkb() + "?");
            }
            System.out.println("Enter Your answer: ");
            String KfbvVuVPoM = A3QLzXPjfR.nextLine();
            WcImjHwdqK(QWdfQlwAnQ.C3QHB4eQU9(IOW81cJxOJ, KfbvVuVPoM));
        }
    }

    public static void BuFUkmUxWF() {
        System.out.println("Choose which question  :");
        ArrayList<V1vGfZmdTS> YQxnfJD9jc = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int Js1l3UtYxS = 0; Js1l3UtYxS < YQxnfJD9jc.size(); Js1l3UtYxS = Js1l3UtYxS + 1) {
            System.out.println(Js1l3UtYxS + 1 + " " + YQxnfJD9jc.get(Js1l3UtYxS).S2jKcOPUI8());
        }
        int O9llHZhzIw = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (O9llHZhzIw < 1 || YQxnfJD9jc.size() == 0 || O9llHZhzIw > YQxnfJD9jc.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<PbDqS3MTqS> F1q3M2Tsvo = Jpix49t4ls.FuVC6vUvYX.J5Rw597uIV();
            for (int Bh72HUbNhj = 0; Bh72HUbNhj < F1q3M2Tsvo.size(); Bh72HUbNhj = Bh72HUbNhj + 1) {
                System.out.println(Bh72HUbNhj + 1 + " " + F1q3M2Tsvo.get(Bh72HUbNhj).UJOPUM4cud());
            }
            int ELG2m6Kbry = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (ELG2m6Kbry < 1 || F1q3M2Tsvo.size() == 0 || ELG2m6Kbry > F1q3M2Tsvo.size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                WcImjHwdqK("The use last submit was: " + YQxnfJD9jc.get(O9llHZhzIw - 1).CuWcP7HdZC().get(F1q3M2Tsvo.get(ELG2m6Kbry - 1)));
                System.out.println("Enter the point you wanna give: ");
                int GrRIW3sG3l = Integer.parseInt(A3QLzXPjfR.nextLine());
                WcImjHwdqK(QWdfQlwAnQ.BJcPQM7K7b(YQxnfJD9jc.get(O9llHZhzIw - 1), F1q3M2Tsvo.get(ELG2m6Kbry - 1), GrRIW3sG3l));
            }
        }
    }

    public static void R64cBPEa87() {
        System.out.println("Choose which question  :");
        ArrayList<V1vGfZmdTS> YW3q0eSXZO = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int X5ptMvt6WG = 0; X5ptMvt6WG < YW3q0eSXZO.size(); X5ptMvt6WG = X5ptMvt6WG + 1) {
            System.out.println(X5ptMvt6WG + 1 + " " + YW3q0eSXZO.get(X5ptMvt6WG).S2jKcOPUI8());
        }
        int ZKivoo7y50 = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (ZKivoo7y50 < 1 || YW3q0eSXZO.size() == 0 || ZKivoo7y50 > YW3q0eSXZO.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<PbDqS3MTqS> TySJMq6cNr = Jpix49t4ls.FuVC6vUvYX.J5Rw597uIV();
            for (int JDVyYPaTDz = 0; JDVyYPaTDz < TySJMq6cNr.size(); JDVyYPaTDz = JDVyYPaTDz + 1) {
                System.out.println(JDVyYPaTDz + 1 + " " + TySJMq6cNr.get(JDVyYPaTDz).UJOPUM4cud());
            }
            int YYpMty1Z5j = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (YYpMty1Z5j < 1 || TySJMq6cNr.size() == 0 || YYpMty1Z5j > TySJMq6cNr.size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                WcImjHwdqK(QWdfQlwAnQ.BfLKVt7btB(YW3q0eSXZO.get(ZKivoo7y50 - 1), TySJMq6cNr.get(YYpMty1Z5j - 1)));
            }
        }
    }

    public static void SG1UX816ar() {
        System.out.println("Choose which question  :");
        ArrayList<V1vGfZmdTS> RRh2vL3QGn = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int Y2Cb5MwjLr = 0; Y2Cb5MwjLr < RRh2vL3QGn.size(); Y2Cb5MwjLr = Y2Cb5MwjLr + 1) {
            System.out.println(Y2Cb5MwjLr + 1 + " " + RRh2vL3QGn.get(Y2Cb5MwjLr).S2jKcOPUI8());
        }
        int BwHkb8jakT = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (BwHkb8jakT < 1 || RRh2vL3QGn.size() == 0 || BwHkb8jakT > RRh2vL3QGn.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            System.out.println("Choose which submits (Last one was):"
                    + RRh2vL3QGn.get(BwHkb8jakT - 1).CuWcP7HdZC().get(Jpix49t4ls.R3C1dSUCog));
            ArrayList<String> KzQ3tAWzR3 = RRh2vL3QGn.get(BwHkb8jakT - 1).ErmW5k5dhg().get(Jpix49t4ls.R3C1dSUCog);
            for (int ErpjF7FZST = 0; ErpjF7FZST < KzQ3tAWzR3.size(); ErpjF7FZST = ErpjF7FZST + 1) {
                System.out.println(ErpjF7FZST + 1 + " " + KzQ3tAWzR3.get(ErpjF7FZST));
            }
            int R4tqfaq9Vq = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (R4tqfaq9Vq < 1 || KzQ3tAWzR3.size() == 0 || R4tqfaq9Vq > KzQ3tAWzR3.size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                WcImjHwdqK(QWdfQlwAnQ.NYGELNh3I7(RRh2vL3QGn.get(BwHkb8jakT - 1), KzQ3tAWzR3.get(R4tqfaq9Vq - 1)));
            }
        }
    }

    public static void A3vWTaiWIc() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<V1vGfZmdTS> LrEt11uebe = Jpix49t4ls.UZ69vWrXEH.Wi1x3x4Cvb();
        for (int LSALwR7jlj = 0; LSALwR7jlj < LrEt11uebe.size(); LSALwR7jlj = LSALwR7jlj + 1) {
            System.out.println(LSALwR7jlj + 1 + " " + LrEt11uebe.get(LSALwR7jlj).S2jKcOPUI8());
        }
        int PA96Qefyby = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (PA96Qefyby < 1 || LrEt11uebe.size() == 0 || PA96Qefyby > LrEt11uebe.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            WcImjHwdqK(QWdfQlwAnQ.NyuVnuwbGx(LrEt11uebe.get(PA96Qefyby - 1)));
        }
    }
}
