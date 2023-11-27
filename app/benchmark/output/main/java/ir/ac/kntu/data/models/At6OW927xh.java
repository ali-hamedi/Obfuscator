package ir.ac.kntu.data.models;

import java.util.Objects;

public class At6OW927xh {
    public int OYt3xovdB7;
    public int MeJHLVe7RD;
    public int D9XUsdsnNJ;

    public At6OW927xh(int year, int month, int day) {
        while (D9XUsdsnNJ > 30) {
            D9XUsdsnNJ -= 30;
            MeJHLVe7RD++;
        }
        while (D9XUsdsnNJ > 12) {
            MeJHLVe7RD -= 12;
            OYt3xovdB7++;
        }
        this.OYt3xovdB7 = OYt3xovdB7;
        this.MeJHLVe7RD = MeJHLVe7RD;
        this.D9XUsdsnNJ = D9XUsdsnNJ;
    }

    public int UIsqT42349() {
        return D9XUsdsnNJ;
    }

    public int KJTHJuQVwT() {
        return MeJHLVe7RD;
    }

    public int L11dK1gBuF() {
        return OYt3xovdB7;
    }

    public void Fl0lQKvpiC(int HkQrbq0DVE) {
        this.D9XUsdsnNJ = HkQrbq0DVE;
    }

    public void RCcCQ6Wy1a(int IsVDqFghA0) {
        this.MeJHLVe7RD = IsVDqFghA0;
    }

    public void Bvwv29oxPp(int OaoDwKocV3) {
        this.OYt3xovdB7 = OaoDwKocV3;
    }

    @Override
    public boolean GBfluR9neg(Object QpQjPjNfzB) {
        At6OW927xh GYA9TZ8usP = (At6OW927xh) QpQjPjNfzB;
        return (this.OYt3xovdB7 == GYA9TZ8usP.L11dK1gBuF() && this.MeJHLVe7RD == GYA9TZ8usP.KJTHJuQVwT()
                && this.D9XUsdsnNJ == GYA9TZ8usP.UIsqT42349());
    }

    @Override
    public int XyAccMajO1() {
        return Objects.hash(OYt3xovdB7, MeJHLVe7RD, D9XUsdsnNJ);
    }
}