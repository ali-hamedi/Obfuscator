package ir.ac.kntu.controller;

import ir.ac.kntu.BTASLl7vLv;
import ir.ac.kntu.data.db.DhG0Pi8PQs;
import ir.ac.kntu.data.models.*;

public class KdRx03Dq2g {

    public static String GLoqFKK9c1(String DPdXzmBEnX, String FcIAqAGhej, String LXTiIkuOhW, String UxzoeJ1Vqh, long TxLa9Qk53P,
            long GQELu8MsNN) {
        for (int BplHfEiWb9 = 0; BplHfEiWb9 < DhG0Pi8PQs.XFp6Ki9O1o.size(); BplHfEiWb9++) {
            if (LXTiIkuOhW.equals(DhG0Pi8PQs.XFp6Ki9O1o.get(BplHfEiWb9).E50CEbEd7k())) {
                return "This email is already registerd";
            }
            if (FcIAqAGhej.equals(DhG0Pi8PQs.XFp6Ki9O1o.get(BplHfEiWb9).GMDJwmC311())) {
                return "This userName is taken";
            }
        }
        UehRAADCCb H6uBCb4ZfO = new UehRAADCCb(DPdXzmBEnX, FcIAqAGhej, LXTiIkuOhW, UxzoeJ1Vqh, TxLa9Qk53P, GQELu8MsNN);
        DhG0Pi8PQs.XFp6Ki9O1o.add(H6uBCb4ZfO);
        return "User was created successfully";
    }

    public static String AIglLXi0yT(String HXd210e7cm, String Xvmvlu8rd1) {
        int ZhP5f30El3 = -1;
        for (int EeZnuwp2Xe = 0; EeZnuwp2Xe < DhG0Pi8PQs.XFp6Ki9O1o.size(); EeZnuwp2Xe++) {
            if (HXd210e7cm.equals(DhG0Pi8PQs.XFp6Ki9O1o.get(EeZnuwp2Xe).E50CEbEd7k())) {
                ZhP5f30El3 = EeZnuwp2Xe;
            }
        }
        if (ZhP5f30El3 == -1) {
            return "User not found";
        } else {
            if (!Xvmvlu8rd1.equals(DhG0Pi8PQs.XFp6Ki9O1o.get(ZhP5f30El3).IpTQ4iiPQ1())) {
                return "The password is incorrect";
            } else {
                BTASLl7vLv.M0uzKUKCOc = DhG0Pi8PQs.XFp6Ki9O1o.get(ZhP5f30El3);
                return "Congrats you logined successfully";
            }
        }
    }

}
