package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.KJdQ1O5KoW;
import ir.ac.kntu.controller.FyeNUem8IL;
import ir.ac.kntu.data.db.NLm3phShMD;
import ir.ac.kntu.data.models.*;

public class TMeKLEbma8 extends HodPiiC1LD {

    public static void XbT7GtgqP1() {
        System.out.println("1-Attend a course");
        System.out.println("2-Create a course");
        int NCR8bUTi72 = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (NCR8bUTi72 == 2) {
            OsOd2JHmiK();
        } else if (NCR8bUTi72 == 1) {
            HKUyDBHnza();
        } else {
            BQaGPSTFNl("Please choose a valid task");
        }
    }

    public static void OsOd2JHmiK() {
        System.out.print("Name:");
        String OMw43Lye0q = DBXD6LUQ2U.nextLine();
        System.out.print("Institution:");
        String OCoJCqTyQP = DBXD6LUQ2U.nextLine();
        System.out.print("Description:");
        String XLyP9wnXWQ = DBXD6LUQ2U.nextLine();
        System.out.print("Year:");
        int U7iZdFyICq = Integer.parseInt(DBXD6LUQ2U.nextLine());
        System.out.print("You want the course to be Public: (yes/no)");
        String S2enuMqBtQ = DBXD6LUQ2U.nextLine();
        boolean DyVJtQjVQi = false;
        if (S2enuMqBtQ.equals("yes")) {
            DyVJtQjVQi = true;
        }
        System.out.print("Password:");
        String Ci6jIzWdXt = DBXD6LUQ2U.nextLine();
        SvYdGgGcNf FsdHsaQPW8 = new SvYdGgGcNf(OMw43Lye0q, XLyP9wnXWQ, OCoJCqTyQP, KJdQ1O5KoW.S3a20pSw4e, U7iZdFyICq, true, DyVJtQjVQi,
                Ci6jIzWdXt);
        BQaGPSTFNl(FyeNUem8IL.ThDvZkLIWd(FsdHsaQPW8));
    }

    public static void HKUyDBHnza() {
        ArrayList<SvYdGgGcNf> Xp0NBqZ49u = FyeNUem8IL.LerXx6Ap7O();
        BQaGPSTFNl("Choose which course you want to attend :");
        for (int QWwRl3ev6r = 0; QWwRl3ev6r < Xp0NBqZ49u.size(); QWwRl3ev6r++) {
            System.out.println(QWwRl3ev6r + 1 + Xp0NBqZ49u.get(QWwRl3ev6r).AilU2NMpyF());
        }
        int MrcREk4m4r = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (MrcREk4m4r < 1 || Xp0NBqZ49u.size() == 0 || MrcREk4m4r > Xp0NBqZ49u.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            if (!Xp0NBqZ49u.get(MrcREk4m4r - 1).CHDJA9uDDK()) {
                System.out.print("Enter the course password");
                String ZtZhZAnPO8 = DBXD6LUQ2U.nextLine();
                if (Xp0NBqZ49u.get(MrcREk4m4r - 1).FB2EDqOMAQ().equals(ZtZhZAnPO8)) {

                    BQaGPSTFNl(FyeNUem8IL.CZsaVr5oDA(Xp0NBqZ49u.get(MrcREk4m4r - 1)));
                } else {
                    BQaGPSTFNl("The password is incorrect");
                }
            } else {
                BQaGPSTFNl(FyeNUem8IL.CZsaVr5oDA(Xp0NBqZ49u.get(MrcREk4m4r - 1)));
            }
        }
    }

    public static void JQR0zh0GDa() {
        System.out.println("Choose which course you want to attend :");
        ArrayList<SvYdGgGcNf> GF4upylG1d = KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3();
        for (int Pvc9gIxaao = 0; Pvc9gIxaao < GF4upylG1d.size(); Pvc9gIxaao++) {
            System.out.println(Pvc9gIxaao + 1 + " " + GF4upylG1d.get(Pvc9gIxaao).AilU2NMpyF());
        }
        int EPNlmqsNCH = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (EPNlmqsNCH < 1 || GF4upylG1d.size() == 0 || EPNlmqsNCH > GF4upylG1d.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            System.out.println("Enter the username of the user you wanna add to your course:");
            String OFNj1N6DYh = DBXD6LUQ2U.nextLine();
            int R9dBJukPid = 0;
            for (YBwVogQr76 DRfqISUte6 : NLm3phShMD.Z3bK2EywBt) {
                if (DRfqISUte6.Iv0zPQfviH().equals(OFNj1N6DYh)) {
                    R9dBJukPid++;
                    BQaGPSTFNl(FyeNUem8IL.IpdfqPvkQn(DRfqISUte6, GF4upylG1d.get(EPNlmqsNCH - 1)));
                }
            }
            if (R9dBJukPid == 0) {
                BQaGPSTFNl("User not found");
            }
        }
    }

    public static void W1ugtDcS1C() {
        System.out.println("1-Attended course");
        System.out.println("2-Created course");
        int BX7jOTmXZU = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (BX7jOTmXZU == 2) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<SvYdGgGcNf> FHwhfTDhZo = KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3();
            for (int ZnwzAJ2TWQ = 0; ZnwzAJ2TWQ < FHwhfTDhZo.size(); ZnwzAJ2TWQ++) {
                System.out.println(ZnwzAJ2TWQ + 1 + " " + FHwhfTDhZo.get(ZnwzAJ2TWQ).AilU2NMpyF());
            }
            int E4XXIGBqUp = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (E4XXIGBqUp < 1 || FHwhfTDhZo.size() == 0 || E4XXIGBqUp > FHwhfTDhZo.size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                BQaGPSTFNl(FyeNUem8IL.QJDmCis8Ja(FHwhfTDhZo.get(E4XXIGBqUp - 1)));
            }
        } else if (BX7jOTmXZU == 1) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<SvYdGgGcNf> GquiqUGD56 = KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM();
            for (int Xakn4IPQg3 = 0; Xakn4IPQg3 < GquiqUGD56.size(); Xakn4IPQg3++) {
                System.out.println(Xakn4IPQg3 + 1 + " " + GquiqUGD56.get(Xakn4IPQg3).AilU2NMpyF());
            }
            int LL7Lotz0pY = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (LL7Lotz0pY < 1 || GquiqUGD56.size() == 0 || LL7Lotz0pY > GquiqUGD56.size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                BQaGPSTFNl(FyeNUem8IL.UO0qP435sH(GquiqUGD56.get(LL7Lotz0pY - 1)));
            }
        } else {
            BQaGPSTFNl("Please choose a valid task");
        }
    }

    public static void ZnmjQjelNo() {
        System.out.println("Choose which course you want to edit :");
        ArrayList<SvYdGgGcNf> AoXfjCm1hA = KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3();
        for (int VYeY8a8JFs = 0; VYeY8a8JFs < AoXfjCm1hA.size(); VYeY8a8JFs++) {
            System.out.println(VYeY8a8JFs + 1 + " " + AoXfjCm1hA.get(VYeY8a8JFs).AilU2NMpyF());
        }
        int AxSEhqiEHd = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (AxSEhqiEHd < 1 || AoXfjCm1hA.size() == 0 || AxSEhqiEHd > AoXfjCm1hA.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {

            System.out.println("Modify the course");
            System.out.print("Name");
            System.out.print("(old name was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).AilU2NMpyF() + ") :");
            String N4YdJW7m6a = DBXD6LUQ2U.nextLine();
            System.out.print("Institution");
            System.out.print("(old institution was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).Caj9jO1yPA() + ") :");
            String YnB0impk7c = DBXD6LUQ2U.nextLine();
            System.out.print("Description");
            System.out.print("(old description was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).GDURhnQaA9() + ") :");
            String DKbzB6Y4qz = DBXD6LUQ2U.nextLine();
            System.out.print("Year");
            System.out.print("(old year was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).P1cPO39LHI() + ") :");
            int DmF41cBoCx = Integer.parseInt(DBXD6LUQ2U.nextLine());
            System.out.print("You want the course to be Public");
            System.out.print("(old situation was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).CHDJA9uDDK() + ") :");
            boolean XZQonjL53b = Boolean.parseBoolean(DBXD6LUQ2U.nextLine());
            System.out.print("Password");
            System.out.print("(old password was  " + AoXfjCm1hA.get(AxSEhqiEHd - 1).FB2EDqOMAQ() + ") :");
            String ZBM8O4mfsC = DBXD6LUQ2U.nextLine();
            SvYdGgGcNf JAGphAUHr6 = new SvYdGgGcNf(N4YdJW7m6a, DKbzB6Y4qz, YnB0impk7c, KJdQ1O5KoW.S3a20pSw4e, DmF41cBoCx, true,
                    XZQonjL53b,
                    ZBM8O4mfsC);

            BQaGPSTFNl(FyeNUem8IL.SVuhrNXAik(JAGphAUHr6, AoXfjCm1hA.get(AxSEhqiEHd - 1)));
        }
    }

    public static void VtByQMIt8c() {
        System.out.println("1-Attended  course");
        System.out.println("2-Created  course");
        int JgalRQuanS = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (JgalRQuanS == 1) {
            BQaGPSTFNl("Attended Courses:");
            for (int HJVJRn1nrJ = 0; HJVJRn1nrJ < KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM().size(); HJVJRn1nrJ++) {
                BQaGPSTFNl(HJVJRn1nrJ + 1 + " " + KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM().get(HJVJRn1nrJ).AilU2NMpyF());
            }
            int GNqaATP1Pq = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (GNqaATP1Pq < 1 || KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM().size() == 0
                    || GNqaATP1Pq > KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM().size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                KJdQ1O5KoW.NVK6b1gNMv = KJdQ1O5KoW.S3a20pSw4e.UtrgqfisnM().get(GNqaATP1Pq - 1);
            }
        } else if (JgalRQuanS == 2) {
            BQaGPSTFNl("Teaching Courses:");
            for (int BDvcdOPabb = 0; BDvcdOPabb < KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3().size(); BDvcdOPabb++) {
                BQaGPSTFNl(BDvcdOPabb + 1 + " " + KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3().get(BDvcdOPabb).AilU2NMpyF());
            }
            int ImzFTQG0wX = Integer.parseInt(DBXD6LUQ2U.nextLine());
            if (ImzFTQG0wX < 1 || KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3().size() == 0
                    || ImzFTQG0wX > KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3().size()) {
                BQaGPSTFNl("Enter valid number");
            } else {
                KJdQ1O5KoW.NVK6b1gNMv = KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3().get(ImzFTQG0wX - 1);
            }
        } else {
            BQaGPSTFNl("Please pick a valid task");
        }
    }

    public static void X88DAE4Sp4() {
        System.out.println("Choose which course you want to close:");
        ArrayList<SvYdGgGcNf> Gqa6HXaOcA = new ArrayList<SvYdGgGcNf>();
        for (SvYdGgGcNf FS8dy9IkWo : KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3()) {
            if (FS8dy9IkWo.OQxKuZCLSj()) {
                Gqa6HXaOcA.add(FS8dy9IkWo);
            }
        }
        for (int J6wCrKM6TR = 0; J6wCrKM6TR < Gqa6HXaOcA.size(); J6wCrKM6TR++) {
            System.out.println(J6wCrKM6TR + 1 + " " + Gqa6HXaOcA.get(J6wCrKM6TR).AilU2NMpyF());
        }
        int B1iUtcS2I8 = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (B1iUtcS2I8 < 1 || Gqa6HXaOcA.size() == 0 || B1iUtcS2I8 > Gqa6HXaOcA.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            BQaGPSTFNl(FyeNUem8IL.TObJPcCxr4(Gqa6HXaOcA.get(B1iUtcS2I8 - 1)));
        }
    }

    public static void WcLM8s0VRg() {
        System.out.println("Choose which course you want to open to public:");
        ArrayList<SvYdGgGcNf> Ei4d1j8vZr = new ArrayList<SvYdGgGcNf>();
        for (SvYdGgGcNf F7E1dYldnG : KJdQ1O5KoW.S3a20pSw4e.MssrQKCTm3()) {
            if (!F7E1dYldnG.OQxKuZCLSj()) {
                Ei4d1j8vZr.add(F7E1dYldnG);
            }
        }
        for (int YuddZKIbqA = 0; YuddZKIbqA < Ei4d1j8vZr.size(); YuddZKIbqA++) {
            System.out.println(YuddZKIbqA + 1 + " " + Ei4d1j8vZr.get(YuddZKIbqA).AilU2NMpyF());
        }
        int CuET2sHhLj = Integer.parseInt(DBXD6LUQ2U.nextLine());
        if (CuET2sHhLj < 1 || Ei4d1j8vZr.size() == 0 || CuET2sHhLj > Ei4d1j8vZr.size()) {
            BQaGPSTFNl("Enter valid number");
        } else {
            BQaGPSTFNl(FyeNUem8IL.BjCmvx1gta(Ei4d1j8vZr.get(CuET2sHhLj - 1)));
        }
    }

}
