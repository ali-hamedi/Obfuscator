package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.BTASLl7vLv;
import ir.ac.kntu.controller.HpcUKU2NH8;
import ir.ac.kntu.data.db.DhG0Pi8PQs;
import ir.ac.kntu.data.models.*;

public class E9Egh3TlsS extends CEh39YQ984 {

    public static void ZN4ia7pJVX() {
        System.out.println("1-Attend a course");
        System.out.println("2-Create a course");
        int HG0g1YGkUV = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (HG0g1YGkUV == 2) {
            LFOUx569ha();
        } else if (HG0g1YGkUV == 1) {
            AhzfRG5XFO();
        } else {
            U34bhODQuD("Please choose a valid task");
        }
    }

    public static void LFOUx569ha() {
        System.out.print("Name:");
        String YD6KrDJpgL = SbU7S9V4Fv.nextLine();
        System.out.print("Institution:");
        String SQwPeH2VOn = SbU7S9V4Fv.nextLine();
        System.out.print("Description:");
        String WQBL2dSFgR = SbU7S9V4Fv.nextLine();
        System.out.print("Year:");
        int NzjjzdToXo = Integer.parseInt(SbU7S9V4Fv.nextLine());
        System.out.print("You want the course to be Public: (yes/no)");
        String KwOqvgdxlK = SbU7S9V4Fv.nextLine();
        boolean NatTjlcUzC = false;
        if (KwOqvgdxlK.equals("yes")) {
            NatTjlcUzC = true;
        }
        System.out.print("Password:");
        String Yy1MbJcYRw = SbU7S9V4Fv.nextLine();
        ASCZIm6zAm GXPSinQmSP = new ASCZIm6zAm(YD6KrDJpgL, WQBL2dSFgR, SQwPeH2VOn, BTASLl7vLv.M0uzKUKCOc, NzjjzdToXo, true, NatTjlcUzC,
                Yy1MbJcYRw);
        U34bhODQuD(HpcUKU2NH8.I8sqiDx2Fb(GXPSinQmSP));
    }

    public static void AhzfRG5XFO() {
        ArrayList<ASCZIm6zAm> GTfrX07t4N = HpcUKU2NH8.ILUMZ53uLf();
        U34bhODQuD("Choose which course you want to attend :");
        for (int Bc4sucne5R = 0; Bc4sucne5R < GTfrX07t4N.size(); Bc4sucne5R++) {
            System.out.println(Bc4sucne5R + 1 + GTfrX07t4N.get(Bc4sucne5R).UoZfKt2HYb());
        }
        int G94HpCit0n = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (G94HpCit0n < 1 || GTfrX07t4N.size() == 0 || G94HpCit0n > GTfrX07t4N.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            if (!GTfrX07t4N.get(G94HpCit0n - 1).GMJUnCCSia()) {
                System.out.print("Enter the course password");
                String FRp7DoxOaO = SbU7S9V4Fv.nextLine();
                if (GTfrX07t4N.get(G94HpCit0n - 1).WrgN5vowCB().equals(FRp7DoxOaO)) {

                    U34bhODQuD(HpcUKU2NH8.Gprw2dPf43(GTfrX07t4N.get(G94HpCit0n - 1)));
                } else {
                    U34bhODQuD("The password is incorrect");
                }
            } else {
                U34bhODQuD(HpcUKU2NH8.Gprw2dPf43(GTfrX07t4N.get(G94HpCit0n - 1)));
            }
        }
    }

    public static void Zpf8AgdxxV() {
        System.out.println("Choose which course you want to attend :");
        ArrayList<ASCZIm6zAm> G7jU7PqB2k = BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8();
        for (int UV9efscAc6 = 0; UV9efscAc6 < G7jU7PqB2k.size(); UV9efscAc6++) {
            System.out.println(UV9efscAc6 + 1 + " " + G7jU7PqB2k.get(UV9efscAc6).UoZfKt2HYb());
        }
        int Xv3gSNJqi0 = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (Xv3gSNJqi0 < 1 || G7jU7PqB2k.size() == 0 || Xv3gSNJqi0 > G7jU7PqB2k.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            System.out.println("Enter the username of the user you wanna add to your course:");
            String Es1eDAckeh = SbU7S9V4Fv.nextLine();
            int YjYoBeSYPU = 0;
            for (UehRAADCCb OO7nUwWo9F : DhG0Pi8PQs.XFp6Ki9O1o) {
                if (OO7nUwWo9F.GMDJwmC311().equals(Es1eDAckeh)) {
                    YjYoBeSYPU++;
                    U34bhODQuD(HpcUKU2NH8.VrAdBX95BU(OO7nUwWo9F, G7jU7PqB2k.get(Xv3gSNJqi0 - 1)));
                }
            }
            if (YjYoBeSYPU == 0) {
                U34bhODQuD("User not found");
            }
        }
    }

    public static void CauCSkzVfN() {
        System.out.println("1-Attended course");
        System.out.println("2-Created course");
        int KMPQQteGQz = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (KMPQQteGQz == 2) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<ASCZIm6zAm> ApL2Locq7S = BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8();
            for (int Ku4q6CID9m = 0; Ku4q6CID9m < ApL2Locq7S.size(); Ku4q6CID9m++) {
                System.out.println(Ku4q6CID9m + 1 + " " + ApL2Locq7S.get(Ku4q6CID9m).UoZfKt2HYb());
            }
            int Mi6vci7qLD = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (Mi6vci7qLD < 1 || ApL2Locq7S.size() == 0 || Mi6vci7qLD > ApL2Locq7S.size()) {
                U34bhODQuD("Enter valid number");
            } else {
                U34bhODQuD(HpcUKU2NH8.G2eW1gEN92(ApL2Locq7S.get(Mi6vci7qLD - 1)));
            }
        } else if (KMPQQteGQz == 1) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<ASCZIm6zAm> Cgc2qZLzLR = BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz();
            for (int XBGF1juBxA = 0; XBGF1juBxA < Cgc2qZLzLR.size(); XBGF1juBxA++) {
                System.out.println(XBGF1juBxA + 1 + " " + Cgc2qZLzLR.get(XBGF1juBxA).UoZfKt2HYb());
            }
            int G9fEci2FPy = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (G9fEci2FPy < 1 || Cgc2qZLzLR.size() == 0 || G9fEci2FPy > Cgc2qZLzLR.size()) {
                U34bhODQuD("Enter valid number");
            } else {
                U34bhODQuD(HpcUKU2NH8.L2mkQMwdAH(Cgc2qZLzLR.get(G9fEci2FPy - 1)));
            }
        } else {
            U34bhODQuD("Please choose a valid task");
        }
    }

    public static void MwyGD9KSSW() {
        System.out.println("Choose which course you want to edit :");
        ArrayList<ASCZIm6zAm> VHyJpNTYHt = BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8();
        for (int GsPQjMHdgm = 0; GsPQjMHdgm < VHyJpNTYHt.size(); GsPQjMHdgm++) {
            System.out.println(GsPQjMHdgm + 1 + " " + VHyJpNTYHt.get(GsPQjMHdgm).UoZfKt2HYb());
        }
        int Y49PiFfYoa = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (Y49PiFfYoa < 1 || VHyJpNTYHt.size() == 0 || Y49PiFfYoa > VHyJpNTYHt.size()) {
            U34bhODQuD("Enter valid number");
        } else {

            System.out.println("Modify the course");
            System.out.print("Name");
            System.out.print("(old name was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).UoZfKt2HYb() + ") :");
            String YSRcWdNs94 = SbU7S9V4Fv.nextLine();
            System.out.print("Institution");
            System.out.print("(old institution was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).SqznlYl0RC() + ") :");
            String I7MJoj7agI = SbU7S9V4Fv.nextLine();
            System.out.print("Description");
            System.out.print("(old description was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).BOFjhQjjTQ() + ") :");
            String DusPZ1x69M = SbU7S9V4Fv.nextLine();
            System.out.print("Year");
            System.out.print("(old year was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).TTRqzdyjhD() + ") :");
            int Fc9jlC1RaA = Integer.parseInt(SbU7S9V4Fv.nextLine());
            System.out.print("You want the course to be Public");
            System.out.print("(old situation was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).GMJUnCCSia() + ") :");
            boolean PO9Td7V3C4 = Boolean.parseBoolean(SbU7S9V4Fv.nextLine());
            System.out.print("Password");
            System.out.print("(old password was  " + VHyJpNTYHt.get(Y49PiFfYoa - 1).WrgN5vowCB() + ") :");
            String ZAEQ74bnFn = SbU7S9V4Fv.nextLine();
            ASCZIm6zAm Qejfuk3woJ = new ASCZIm6zAm(YSRcWdNs94, DusPZ1x69M, I7MJoj7agI, BTASLl7vLv.M0uzKUKCOc, Fc9jlC1RaA, true,
                    PO9Td7V3C4,
                    ZAEQ74bnFn);

            U34bhODQuD(HpcUKU2NH8.DPdHqFwqoo(Qejfuk3woJ, VHyJpNTYHt.get(Y49PiFfYoa - 1)));
        }
    }

    public static void PT9U57kEQ1() {
        System.out.println("1-Attended  course");
        System.out.println("2-Created  course");
        int J2r1PEXJmT = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (J2r1PEXJmT == 1) {
            U34bhODQuD("Attended Courses:");
            for (int Cby5aPn8o3 = 0; Cby5aPn8o3 < BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz().size(); Cby5aPn8o3++) {
                U34bhODQuD(Cby5aPn8o3 + 1 + " " + BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz().get(Cby5aPn8o3).UoZfKt2HYb());
            }
            int OESlUH1Zfu = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (OESlUH1Zfu < 1 || BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz().size() == 0
                    || OESlUH1Zfu > BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz().size()) {
                U34bhODQuD("Enter valid number");
            } else {
                BTASLl7vLv.TQGzERtY9b = BTASLl7vLv.M0uzKUKCOc.LU9C8qukJz().get(OESlUH1Zfu - 1);
            }
        } else if (J2r1PEXJmT == 2) {
            U34bhODQuD("Teaching Courses:");
            for (int N90dCnFIGH = 0; N90dCnFIGH < BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8().size(); N90dCnFIGH++) {
                U34bhODQuD(N90dCnFIGH + 1 + " " + BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8().get(N90dCnFIGH).UoZfKt2HYb());
            }
            int HYEHRTF8DK = Integer.parseInt(SbU7S9V4Fv.nextLine());
            if (HYEHRTF8DK < 1 || BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8().size() == 0
                    || HYEHRTF8DK > BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8().size()) {
                U34bhODQuD("Enter valid number");
            } else {
                BTASLl7vLv.TQGzERtY9b = BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8().get(HYEHRTF8DK - 1);
            }
        } else {
            U34bhODQuD("Please pick a valid task");
        }
    }

    public static void JkpZ3Z2ThR() {
        System.out.println("Choose which course you want to close:");
        ArrayList<ASCZIm6zAm> J7HSmJn5xA = new ArrayList<ASCZIm6zAm>();
        for (ASCZIm6zAm CjDYCjAPKm : BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8()) {
            if (CjDYCjAPKm.FjU4TtvTEt()) {
                J7HSmJn5xA.add(CjDYCjAPKm);
            }
        }
        for (int Zwrf17g3fE = 0; Zwrf17g3fE < J7HSmJn5xA.size(); Zwrf17g3fE++) {
            System.out.println(Zwrf17g3fE + 1 + " " + J7HSmJn5xA.get(Zwrf17g3fE).UoZfKt2HYb());
        }
        int IlJcmXkl4B = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (IlJcmXkl4B < 1 || J7HSmJn5xA.size() == 0 || IlJcmXkl4B > J7HSmJn5xA.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            U34bhODQuD(HpcUKU2NH8.C4o3fbIqzi(J7HSmJn5xA.get(IlJcmXkl4B - 1)));
        }
    }

    public static void DXOhjDXy8Z() {
        System.out.println("Choose which course you want to open to public:");
        ArrayList<ASCZIm6zAm> T0BqLaXoxy = new ArrayList<ASCZIm6zAm>();
        for (ASCZIm6zAm M2jDW9rkPC : BTASLl7vLv.M0uzKUKCOc.N5gzj0VMY8()) {
            if (!M2jDW9rkPC.FjU4TtvTEt()) {
                T0BqLaXoxy.add(M2jDW9rkPC);
            }
        }
        for (int PuufWOBVtC = 0; PuufWOBVtC < T0BqLaXoxy.size(); PuufWOBVtC++) {
            System.out.println(PuufWOBVtC + 1 + " " + T0BqLaXoxy.get(PuufWOBVtC).UoZfKt2HYb());
        }
        int GeaZQ38uwq = Integer.parseInt(SbU7S9V4Fv.nextLine());
        if (GeaZQ38uwq < 1 || T0BqLaXoxy.size() == 0 || GeaZQ38uwq > T0BqLaXoxy.size()) {
            U34bhODQuD("Enter valid number");
        } else {
            U34bhODQuD(HpcUKU2NH8.GXbDj9YSzF(T0BqLaXoxy.get(GeaZQ38uwq - 1)));
        }
    }

}
