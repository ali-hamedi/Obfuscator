package ir.ac.kntu.controller;

import ir.ac.kntu.data.db.OuR53JEf1f;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.KJdQ1O5KoW;

import java.util.ArrayList;
import java.util.HashMap;

public class L1hgMhofW3 {
    public static String GhfyP235Ki(LPsHi17T2t VI438Hb1B1) {
        HashMap<YBwVogQr76, ArrayList<String>> BSXSVUTfyF = new HashMap<YBwVogQr76, ArrayList<String>>();
        HashMap<YBwVogQr76, String> XNgQyPoa1k = new HashMap<YBwVogQr76, String>();
        for (YBwVogQr76 HlgDeqxWwK : KJdQ1O5KoW.NVK6b1gNMv.PuZiX7AQI7()) {
            BSXSVUTfyF.put(HlgDeqxWwK, new ArrayList<String>());
            XNgQyPoa1k.put(HlgDeqxWwK, "");
        }
        VI438Hb1B1.QYy4s2C7Ia(BSXSVUTfyF);
        VI438Hb1B1.M7leLhMn5s(XNgQyPoa1k);
        KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().add(VI438Hb1B1);
        return "Question added Successfully";
    }

    public static String ZelsJCpo1g(LPsHi17T2t STgRfz764l) {
        OuR53JEf1f.QuaOknNdMp.add(STgRfz764l);
        return "The question has added to the bank successfully";
    }

    public static String OXRJe2SXBB(LPsHi17T2t ZsgW6WMKeZ) {
        KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().add(ZsgW6WMKeZ);
        return "The question has added to Your exercise successfully";
    }

    public static String Cg88tkXsr2(LPsHi17T2t E4n33S76Zm) {
        if (KJdQ1O5KoW.NVK6b1gNMv.UeHJzpgWJ0().equals(KJdQ1O5KoW.S3a20pSw4e)) {
            int DFPd3kzx4I = -1;
            for (int RExk6lrFGL = 0; RExk6lrFGL < KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().size(); RExk6lrFGL++) {
                if (KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().get(RExk6lrFGL).C7iXK012Jm(E4n33S76Zm)) {
                    DFPd3kzx4I = RExk6lrFGL;
                }
            }
            if (DFPd3kzx4I != -1) {
                KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().remove(DFPd3kzx4I);
                return "Question deleted successfully for every body ";
            }
            return "Question not found.";
        }
        return "You are not the owner";
    }

    public static String HXGFrtERF2(LPsHi17T2t FSXfYHX5q3, LPsHi17T2t JMUc5MMN1X) {
        if (KJdQ1O5KoW.NVK6b1gNMv.UeHJzpgWJ0().equals(KJdQ1O5KoW.S3a20pSw4e)) {
            int DsyaVMQQjz = -1;
            for (int PqjvtbzEPy = 0; PqjvtbzEPy < KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().size(); PqjvtbzEPy++) {
                if (KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().get(PqjvtbzEPy).C7iXK012Jm(FSXfYHX5q3)) {
                    DsyaVMQQjz = PqjvtbzEPy;
                }
            }
            if (DsyaVMQQjz != -1) {
                KJdQ1O5KoW.JdlsgaAs9U.SmkghWXA2l().set(DsyaVMQQjz, JMUc5MMN1X);
                return "Question successfully edited  for every body ";
            }
            return "Question not found";
        }
        return "You are not the owner";
    }

    public static String SLnqIfAuu0(LPsHi17T2t UUxtweutlW, String SKzSqIkzvf) {
        UUxtweutlW.SPBS73HXKV().put(KJdQ1O5KoW.S3a20pSw4e, 0);
        if (UUxtweutlW.BQULXMUH9h() == Qib9SHQbSG.NUVkQKjj3j || UUxtweutlW.BQULXMUH9h() == Qib9SHQbSG.FtLaLqWgKn) {
            if (UUxtweutlW.WhIqwFBScc().equals(SKzSqIkzvf)) {
                UUxtweutlW.SPBS73HXKV().put(KJdQ1O5KoW.S3a20pSw4e, UUxtweutlW.YjWzDxvtNZ());
            }
        }
        ArrayList<String> DSC5Ec9CWJ = UUxtweutlW.EYguyHa83x().get(KJdQ1O5KoW.S3a20pSw4e);
        if (DSC5Ec9CWJ == null) {
            DSC5Ec9CWJ = new ArrayList<String>();
        }
        DSC5Ec9CWJ.add(SKzSqIkzvf);
        UUxtweutlW.QBTv8OPKBy().put(KJdQ1O5KoW.S3a20pSw4e, SKzSqIkzvf);
        GljIj9IcPo.MO2ETj6gsk();
        return "your answer has been submitted succefully";
    }

    public static String QcCbUko4dP(LPsHi17T2t EkmSFpuLXv, YBwVogQr76 QIxWuaGFFC, int Q8oBRYYKAD) {
        EkmSFpuLXv.SPBS73HXKV().put(QIxWuaGFFC, Q8oBRYYKAD);
        GljIj9IcPo.MO2ETj6gsk();
        return "the user points of this question has been submitted";
    }

    public static String VU3v2lxO6J(LPsHi17T2t SN1MaDo0Ow, String AwAhzoxqjr) {
        SN1MaDo0Ow.QBTv8OPKBy().put(KJdQ1O5KoW.S3a20pSw4e, AwAhzoxqjr);
        SN1MaDo0Ow.SPBS73HXKV().put(KJdQ1O5KoW.S3a20pSw4e, 0);
        if (SN1MaDo0Ow.BQULXMUH9h() == Qib9SHQbSG.NUVkQKjj3j || SN1MaDo0Ow.BQULXMUH9h() == Qib9SHQbSG.FtLaLqWgKn) {
            if (SN1MaDo0Ow.WhIqwFBScc().equals(AwAhzoxqjr)) {
                SN1MaDo0Ow.SPBS73HXKV().put(KJdQ1O5KoW.S3a20pSw4e, SN1MaDo0Ow.YjWzDxvtNZ());

            }
        }
        GljIj9IcPo.MO2ETj6gsk();
        return "you have changed your last submit successfully";
    }

    public static String KCw6A22wzq(LPsHi17T2t Ip1dbGgkQF, YBwVogQr76 GByAKY7gNM) {
        String Dn2i4wvshJ = "";
        for (int EbgrAzLTTQ = 0; EbgrAzLTTQ < Ip1dbGgkQF.EYguyHa83x().get(GByAKY7gNM).size(); EbgrAzLTTQ++) {
            Dn2i4wvshJ += EbgrAzLTTQ + 1 + ":" + Ip1dbGgkQF.EYguyHa83x().get(GByAKY7gNM).get(EbgrAzLTTQ) + " ";
        }
        Dn2i4wvshJ += "(Final submit was: " + Ip1dbGgkQF.QBTv8OPKBy().get(GByAKY7gNM) + " )";
        return Dn2i4wvshJ;
    }

    public static String NHOUY25sWD(LPsHi17T2t SllWzw2CTi) {
        String Gbho6ZH7f9 = "";
        for (YBwVogQr76 UQrHnyiFzE : SllWzw2CTi.SPBS73HXKV().keySet()) {
            Gbho6ZH7f9 += "user: " + UQrHnyiFzE.C58usGbEqr() + " ,last submit:" + SllWzw2CTi.QBTv8OPKBy().get(UQrHnyiFzE) + " -> "
                    + SllWzw2CTi.SPBS73HXKV().get(UQrHnyiFzE);
        }
        return Gbho6ZH7f9;
    }

    public static void XWVcSHNVVX(SvYdGgGcNf HF4OBw7kh3, YBwVogQr76 VOcoRxRi6h) {
        for (KKwDH1DIQV EMfGNHUyE6 : HF4OBw7kh3.TBt57FkegP()) {
            for (LPsHi17T2t JlGKxkawBE : EMfGNHUyE6.SmkghWXA2l()) {
                HashMap<YBwVogQr76, String> ErE4zkcefx = JlGKxkawBE.QBTv8OPKBy();
                HashMap<YBwVogQr76, ArrayList<String>> I8ybk9FkZR = JlGKxkawBE.EYguyHa83x();
                HashMap<YBwVogQr76, Integer> Xnuw7ej65c = JlGKxkawBE.SPBS73HXKV();
                ErE4zkcefx.put(VOcoRxRi6h, "");
                I8ybk9FkZR.put(VOcoRxRi6h, new ArrayList<String>());
                Xnuw7ej65c.put(VOcoRxRi6h, 0);
            }
        }
    }
    public static void GfeOR2rEA6(SvYdGgGcNf I829IdXBWr,YBwVogQr76 RvTnFFuLJv,LPsHi17T2t RgCTIs1KYd){
                for (KKwDH1DIQV MzIneZiHUl : I829IdXBWr.TBt57FkegP()) {
            for (LPsHi17T2t NqcZIX03mM : MzIneZiHUl.SmkghWXA2l()) {
                HashMap<YBwVogQr76, String> ETT1uBw1bR = NqcZIX03mM.QBTv8OPKBy();
                HashMap<YBwVogQr76, ArrayList<String>> DTGAB6EdsF = NqcZIX03mM.EYguyHa83x();
                HashMap<YBwVogQr76, Integer> CMkiMiNABW = NqcZIX03mM.SPBS73HXKV();
                ETT1uBw1bR.put(RvTnFFuLJv, "");
                DTGAB6EdsF.put(RvTnFFuLJv, new ArrayList<String>());
                CMkiMiNABW.put(RvTnFFuLJv, 0);
            }
        }
    }

    public static Qib9SHQbSG YC8OLmCnMf(int T7zGekTnYc) {
        Qib9SHQbSG Ba8j7dKPjX;
        switch (T7zGekTnYc) {
            case 1:
                Ba8j7dKPjX = Qib9SHQbSG.FtLaLqWgKn;
                break;
            case 2:
                Ba8j7dKPjX = Qib9SHQbSG.HVlAHsosJQ;
                break;
            default:
                Ba8j7dKPjX = Qib9SHQbSG.NUVkQKjj3j;
                break;
        }
        return Ba8j7dKPjX;
    }

    public static BPmipLq0ft WRAWvNTPkK(int Yh7fAljhrN) {
        BPmipLq0ft UrIkmskX9i;
        switch (Yh7fAljhrN) {
            case 1:
                UrIkmskX9i = BPmipLq0ft.FElx2cP3lz;
                break;
            case 2:
                UrIkmskX9i = BPmipLq0ft.U6NAZxVVzI;
                break;
            case 3:
                UrIkmskX9i = BPmipLq0ft.ThoW6XW4j3;
                break;
            default:
                UrIkmskX9i = BPmipLq0ft.J6xP0u2FHX;
                break;
        }
        return UrIkmskX9i;
    }

}
