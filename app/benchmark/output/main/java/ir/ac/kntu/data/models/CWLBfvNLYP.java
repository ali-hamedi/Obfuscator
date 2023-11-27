package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import ir.ac.kntu.data.models.enums.*;

public class CWLBfvNLYP {
    private String IPL4weSBdH;
    private String EveQlMvCfc;
    private String LtYqyGbE7r;
    private int RZaDi25gQd;
    private HvWli0YqF6 N2PxZr4Ugk;
    private DBWF9HKpCd PkhRG0rp2v;
    private String IIFrZER9V9;
    private HashMap<QQmEi2u0yA, ArrayList<String>> Fy8C33T6Jw;
    private HashMap<QQmEi2u0yA, String> RVehxBK6d3;
    private HashMap<QQmEi2u0yA, Integer> M7FoqTa5Bg;

    public CWLBfvNLYP(String name, String description, String body, int point, HvWli0YqF6 difficulty, DBWF9HKpCd type,
            String answer) {
        this.IPL4weSBdH = IPL4weSBdH;
        this.EveQlMvCfc = EveQlMvCfc;
        this.LtYqyGbE7r = LtYqyGbE7r;
        this.RZaDi25gQd = RZaDi25gQd;
        this.N2PxZr4Ugk = N2PxZr4Ugk;
        this.PkhRG0rp2v = PkhRG0rp2v;
        this.IIFrZER9V9 = IIFrZER9V9;
        this.Fy8C33T6Jw = new HashMap<QQmEi2u0yA, ArrayList<String>>();
        this.M7FoqTa5Bg = new HashMap<QQmEi2u0yA, Integer>();
        this.RVehxBK6d3 = new HashMap<QQmEi2u0yA, String>();
    }

    public String PCOCh0sOa1() {
        return IIFrZER9V9;
    }

    public String Vwb6UH5EZP() {
        return EveQlMvCfc;
    }

    public String T0meWLm5Zx() {
        return LtYqyGbE7r;
    }

    public HvWli0YqF6 V5OLESGu8j() {
        return N2PxZr4Ugk;
    }

    public String PWJj7nM1LG() {
        return IPL4weSBdH;
    }

    public int HNgWUbtSXu() {
        return RZaDi25gQd;
    }

    public DBWF9HKpCd S4aquEh37c() {
        return PkhRG0rp2v;
    }

    public HashMap<QQmEi2u0yA, ArrayList<String>> VykBGXC4Fk() {
        return Fy8C33T6Jw;
    }

    public HashMap<QQmEi2u0yA, Integer> Xxjbj8TjZ0() {
        return M7FoqTa5Bg;
    }

    public HashMap<QQmEi2u0yA, String> UuYkX20mXn() {
        return RVehxBK6d3;
    }

    public void H0QpJymOsw(HashMap<QQmEi2u0yA, ArrayList<String>> JcXT9Ucj4V) {
        this.Fy8C33T6Jw = JcXT9Ucj4V;
    }

    public void BBsjKMFGBk(HashMap<QQmEi2u0yA, String> H6vwsakpif) {
        this.RVehxBK6d3 = H6vwsakpif;
    }

    public int SFXbqhOjbM() {
        if (this.N2PxZr4Ugk == HvWli0YqF6.Easy) {
            return 1;
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.Medium) {
            return 2;
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.Hard) {
            return 3;
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.VeryHard) {
            return 4;
        } else {
            return -1;
        }
    }

    public String XxJN3ZGNCz() {
        if (this.N2PxZr4Ugk == HvWli0YqF6.Easy) {
            return "easy";
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.Medium) {
            return "medium";
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.Hard) {
            return "hard";
        } else if (this.N2PxZr4Ugk == HvWli0YqF6.VeryHard) {
            return "very hard";
        } else {
            return "";
        }
    }

    @Override
    public boolean YXltR2ujLO(Object APDNazcRgh) {
        CWLBfvNLYP PF6svlNVWG = (CWLBfvNLYP) APDNazcRgh;
        return (this.IPL4weSBdH.equals(PF6svlNVWG.PWJj7nM1LG()) && this.EveQlMvCfc == PF6svlNVWG.Vwb6UH5EZP()
                && this.LtYqyGbE7r == PF6svlNVWG.T0meWLm5Zx() && this.RZaDi25gQd == PF6svlNVWG.HNgWUbtSXu());
    }

    @Override
    public int F5xVfqkrbj() {
        return Objects.hash(IPL4weSBdH, EveQlMvCfc, LtYqyGbE7r, RZaDi25gQd);
    }
}