package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Jpix49t4ls;
import ir.ac.kntu.controller.Eqoo5rvTv8;
import ir.ac.kntu.data.db.FPOLZQXSZp;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.FRF7GV2ChS;

public class IvCa2Sk5ZL extends VOCIWEKxvJ {

    public static void W5GJDT9ApK() {
        System.out.println("1-Attend a course");
        System.out.println("2-Create a course");
        int EEK4vzj1Zu = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (EEK4vzj1Zu == 2) {
            Ck7JnGWPAk();
        } else if (EEK4vzj1Zu == 1) {
            Bvm13YoGHD();
        } else {
            WcImjHwdqK("Please choose a valid task");
        }
    }

    public static void Ck7JnGWPAk() {
        System.out.print("Name:");
        String SsSG8i165V = A3QLzXPjfR.nextLine();
        System.out.print("Institution:");
        String M8vMspIyBn = A3QLzXPjfR.nextLine();
        System.out.print("Description:");
        String LO7keAENW9 = A3QLzXPjfR.nextLine();
        System.out.print("Year:");
        int G8EMHBQ0VE = Integer.parseInt(A3QLzXPjfR.nextLine());
        System.out.print("You want the course to be Public: (yes/no)");
        String DgHnkWFkM0 = A3QLzXPjfR.nextLine();
        boolean CJJeea7DV2 = false;
        if (DgHnkWFkM0.equals("yes")) {
            CJJeea7DV2 = true;
        }
        System.out.print("Password:");
        String Tp0SvQv8d2 = A3QLzXPjfR.nextLine();
        JplEfN8eke EKhcNFSGBw = new JplEfN8eke(SsSG8i165V, LO7keAENW9, M8vMspIyBn, Jpix49t4ls.R3C1dSUCog, G8EMHBQ0VE, true, CJJeea7DV2,
                Tp0SvQv8d2);
        WcImjHwdqK(Eqoo5rvTv8.PPbupD1zXl(EKhcNFSGBw));
    }

    public static void Bvm13YoGHD() {
        ArrayList<JplEfN8eke> IxEd9Qzk94 = Eqoo5rvTv8.RyWoGyeuPZ();
        WcImjHwdqK("Choose which course you want to attend :");
        for (int VUktBY87cg = 0; VUktBY87cg < IxEd9Qzk94.size(); VUktBY87cg = VUktBY87cg + 1) {
            System.out.println(VUktBY87cg + 1 + IxEd9Qzk94.get(VUktBY87cg).DDxisZqxif());
        }
        int NGTVJLlR8C = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (NGTVJLlR8C < 1 || IxEd9Qzk94.size() == 0 || NGTVJLlR8C > IxEd9Qzk94.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            if (!IxEd9Qzk94.get(NGTVJLlR8C - 1).Y5QvpeSQ6Y()) {
                System.out.print("Enter the course password");
                String IdAK5g1icw = A3QLzXPjfR.nextLine();
                if (IxEd9Qzk94.get(NGTVJLlR8C - 1).VcSrxRs1TG().equals(IdAK5g1icw)) {

                    WcImjHwdqK(Eqoo5rvTv8.EvdXrZkmzk(IxEd9Qzk94.get(NGTVJLlR8C - 1)));
                } else {
                    WcImjHwdqK("The password is incorrect");
                }
            } else {
                WcImjHwdqK(Eqoo5rvTv8.EvdXrZkmzk(IxEd9Qzk94.get(NGTVJLlR8C - 1)));
            }
        }
    }

    public static void MDMUD2m7Nh() {
        System.out.println("Choose which course you want to attend :");
        ArrayList<JplEfN8eke> MW5X59TZe8 = Jpix49t4ls.R3C1dSUCog.DWQOyquJJf();
        for (int RVmal7umsD = 0; RVmal7umsD < MW5X59TZe8.size(); RVmal7umsD = RVmal7umsD + 1) {
            System.out.println(RVmal7umsD + 1 + " " + MW5X59TZe8.get(RVmal7umsD).DDxisZqxif());
        }
        int TKnVEO41SW = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (TKnVEO41SW < 1 || MW5X59TZe8.size() == 0 || TKnVEO41SW > MW5X59TZe8.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            System.out.println("Enter the username of the user you wanna add to your course:");
            String Yq5uu4z6y8 = A3QLzXPjfR.nextLine();
            int XdRF7NxN2R = 0;
            for (PbDqS3MTqS TIIGJsKNHb : FPOLZQXSZp.FpXRk9VTTG) {
                if (TIIGJsKNHb.T8YqWZLQl0().equals(Yq5uu4z6y8)) {
                    XdRF7NxN2R = XdRF7NxN2R + 1;
                    WcImjHwdqK(Eqoo5rvTv8.WxW6H6JD9v(TIIGJsKNHb, MW5X59TZe8.get(TKnVEO41SW - 1)));
                }
            }
            if (XdRF7NxN2R == 0) {
                WcImjHwdqK("User not found");
            }
        }
    }

    public static void EtnEVxOuvS() {
        System.out.println("1-Attended course");
        System.out.println("2-Created course");
        int PejNMObJv0 = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (PejNMObJv0 == 2) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<JplEfN8eke> SeprxJvRlg = Jpix49t4ls.R3C1dSUCog.DWQOyquJJf();
            for (int WhYsBm7LYo = 0; WhYsBm7LYo < SeprxJvRlg.size(); WhYsBm7LYo = WhYsBm7LYo + 1) {
                System.out.println(WhYsBm7LYo + 1 + " " + SeprxJvRlg.get(WhYsBm7LYo).DDxisZqxif());
            }
            int LnPmLYs4Gw = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (LnPmLYs4Gw < 1 || SeprxJvRlg.size() == 0 || LnPmLYs4Gw > SeprxJvRlg.size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                WcImjHwdqK(Eqoo5rvTv8.S9tOMPjWWC(SeprxJvRlg.get(LnPmLYs4Gw - 1)));
            }
        } else if (PejNMObJv0 == 1) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<JplEfN8eke> SeXn5Y2CkH = Jpix49t4ls.R3C1dSUCog.GEVwYdAvok();
            for (int IaN0x1faHf = 0; IaN0x1faHf < SeXn5Y2CkH.size(); IaN0x1faHf = IaN0x1faHf + 1) {
                System.out.println(IaN0x1faHf + 1 + " " + SeXn5Y2CkH.get(IaN0x1faHf).DDxisZqxif());
            }
            int Kd1iZOGqDV = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (Kd1iZOGqDV < 1 || SeXn5Y2CkH.size() == 0 || Kd1iZOGqDV > SeXn5Y2CkH.size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                WcImjHwdqK(Eqoo5rvTv8.EQNEswCJxv(SeXn5Y2CkH.get(Kd1iZOGqDV - 1)));
            }
        } else {
            WcImjHwdqK("Please choose a valid task");
        }
    }

    public static void Wm5a09CADE() {
        System.out.println("Choose which course you want to edit :");
        ArrayList<JplEfN8eke> P0VnSJ3BW2 = Jpix49t4ls.R3C1dSUCog.DWQOyquJJf();
        for (int REa7bEBOq0 = 0; REa7bEBOq0 < P0VnSJ3BW2.size(); REa7bEBOq0 = REa7bEBOq0 + 1) {
            System.out.println(REa7bEBOq0 + 1 + " " + P0VnSJ3BW2.get(REa7bEBOq0).DDxisZqxif());
        }
        int GMXEPAAFLx = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (GMXEPAAFLx < 1 || P0VnSJ3BW2.size() == 0 || GMXEPAAFLx > P0VnSJ3BW2.size()) {
            WcImjHwdqK("Enter valid number");
        } else {

            System.out.println("Modify the course");
            System.out.print("Name");
            System.out.print("(old name was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).DDxisZqxif() + ") :");
            String MTZIANYgmP = A3QLzXPjfR.nextLine();
            System.out.print("Institution");
            System.out.print("(old institution was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).FBR6VReyyy() + ") :");
            String R2wHONrXXq = A3QLzXPjfR.nextLine();
            System.out.print("Description");
            System.out.print("(old description was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).HQvV442QoB() + ") :");
            String Af8JvTe71Q = A3QLzXPjfR.nextLine();
            System.out.print("Year");
            System.out.print("(old year was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).HXAUoQBnEN() + ") :");
            int TsYYi8UEcE = Integer.parseInt(A3QLzXPjfR.nextLine());
            System.out.print("You want the course to be Public");
            System.out.print("(old situation was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).Y5QvpeSQ6Y() + ") :");
            boolean TUKvgN8AyW = Boolean.parseBoolean(A3QLzXPjfR.nextLine());
            System.out.print("Password");
            System.out.print("(old password was  " + P0VnSJ3BW2.get(GMXEPAAFLx - 1).VcSrxRs1TG() + ") :");
            String FYlKwrcBma = A3QLzXPjfR.nextLine();
            JplEfN8eke UEoKZZoo2x = new JplEfN8eke(MTZIANYgmP, Af8JvTe71Q, R2wHONrXXq, Jpix49t4ls.R3C1dSUCog, TsYYi8UEcE, true,
                    TUKvgN8AyW,
                    FYlKwrcBma);

            WcImjHwdqK(Eqoo5rvTv8.Xe44V4LjgI(UEoKZZoo2x, P0VnSJ3BW2.get(GMXEPAAFLx - 1)));
        }
    }

    public static void WKuBUx0qXU() {
        System.out.println("1-Attended  course");
        System.out.println("2-Created  course");
        int AV4ov3CjRa = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (AV4ov3CjRa == 1) {
            WcImjHwdqK("Attended Courses:");
            for (int HGY75cafrU = 0; HGY75cafrU < Jpix49t4ls.R3C1dSUCog.GEVwYdAvok().size(); HGY75cafrU = HGY75cafrU + 1) {
                WcImjHwdqK(HGY75cafrU + 1 + " " + Jpix49t4ls.R3C1dSUCog.GEVwYdAvok().get(HGY75cafrU).DDxisZqxif());
            }
            int FwuE5pQKkI = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (FwuE5pQKkI < 1 || Jpix49t4ls.R3C1dSUCog.GEVwYdAvok().size() == 0
                    || FwuE5pQKkI > Jpix49t4ls.R3C1dSUCog.GEVwYdAvok().size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                Jpix49t4ls.FuVC6vUvYX = Jpix49t4ls.R3C1dSUCog.GEVwYdAvok().get(FwuE5pQKkI - 1);
            }
        } else if (AV4ov3CjRa == 2) {
            WcImjHwdqK("Teaching Courses:");
            for (int ICZjBp86ux = 0; ICZjBp86ux < Jpix49t4ls.R3C1dSUCog.DWQOyquJJf().size(); ICZjBp86ux = ICZjBp86ux + 1) {
                WcImjHwdqK(ICZjBp86ux + 1 + " " + Jpix49t4ls.R3C1dSUCog.DWQOyquJJf().get(ICZjBp86ux).DDxisZqxif());
            }
            int PMsOOiLaxx = Integer.parseInt(A3QLzXPjfR.nextLine());
            if (PMsOOiLaxx < 1 || Jpix49t4ls.R3C1dSUCog.DWQOyquJJf().size() == 0
                    || PMsOOiLaxx > Jpix49t4ls.R3C1dSUCog.DWQOyquJJf().size()) {
                WcImjHwdqK("Enter valid number");
            } else {
                Jpix49t4ls.FuVC6vUvYX = Jpix49t4ls.R3C1dSUCog.DWQOyquJJf().get(PMsOOiLaxx - 1);
            }
        } else {
            WcImjHwdqK("Please pick a valid task");
        }
    }

    public static void QIAYP2bE1D() {
        System.out.println("Choose which course you want to close:");
        ArrayList<JplEfN8eke> Uv9O9qY5WZ = new ArrayList<JplEfN8eke>();
        for (JplEfN8eke Z7QI13Hb20 : Jpix49t4ls.R3C1dSUCog.DWQOyquJJf()) {
            if (Z7QI13Hb20.UWgauBE2Pw()) {
                Uv9O9qY5WZ.add(Z7QI13Hb20);
            }
        }
        for (int T9WRvbLjgq = 0; T9WRvbLjgq < Uv9O9qY5WZ.size(); T9WRvbLjgq = T9WRvbLjgq + 1) {
            System.out.println(T9WRvbLjgq + 1 + " " + Uv9O9qY5WZ.get(T9WRvbLjgq).DDxisZqxif());
        }
        int HK204PBsa7 = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (HK204PBsa7 < 1 || Uv9O9qY5WZ.size() == 0 || HK204PBsa7 > Uv9O9qY5WZ.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            WcImjHwdqK(Eqoo5rvTv8.MkUO4dqaOe(Uv9O9qY5WZ.get(HK204PBsa7 - 1)));
        }
    }

    public static void Ni8MXDs23L() {
        System.out.println("Choose which course you want to open to public:");
        ArrayList<JplEfN8eke> DKCZWPQ6Jd = new ArrayList<JplEfN8eke>();
        for (JplEfN8eke Mbxg07LRyI : Jpix49t4ls.R3C1dSUCog.DWQOyquJJf()) {
            if (!Mbxg07LRyI.UWgauBE2Pw()) {
                DKCZWPQ6Jd.add(Mbxg07LRyI);
            }
        }
        for (int UksoCwqait = 0; UksoCwqait < DKCZWPQ6Jd.size(); UksoCwqait = UksoCwqait + 1) {
            System.out.println(UksoCwqait + 1 + " " + DKCZWPQ6Jd.get(UksoCwqait).DDxisZqxif());
        }
        int ART5hT9KUs = Integer.parseInt(A3QLzXPjfR.nextLine());
        if (ART5hT9KUs < 1 || DKCZWPQ6Jd.size() == 0 || ART5hT9KUs > DKCZWPQ6Jd.size()) {
            WcImjHwdqK("Enter valid number");
        } else {
            WcImjHwdqK(Eqoo5rvTv8.CQLIAEdIpN(DKCZWPQ6Jd.get(ART5hT9KUs - 1)));
        }
    }

}
