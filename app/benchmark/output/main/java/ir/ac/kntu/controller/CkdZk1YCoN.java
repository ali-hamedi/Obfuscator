package ir.ac.kntu.controller;

import ir.ac.kntu.KJdQ1O5KoW;
import ir.ac.kntu.data.db.NLm3phShMD;
import ir.ac.kntu.data.models.*;

public class CkdZk1YCoN {

    public static String E1NPbbtxAE(String HTkqbmOfSt, String HGxTRj6J83, String JNnja8tccu, String CTVW0eOmxF, long V2t1Nz3dq5,
            long VYnetJMrFI) {
        for (int EGWEpuICNR = 0; EGWEpuICNR < NLm3phShMD.Z3bK2EywBt.size(); EGWEpuICNR++) {
            if (JNnja8tccu.equals(NLm3phShMD.Z3bK2EywBt.get(EGWEpuICNR).Uhf1Kt7A9o())) {
                return "This email is already registerd";
            }
            if (HGxTRj6J83.equals(NLm3phShMD.Z3bK2EywBt.get(EGWEpuICNR).Iv0zPQfviH())) {
                return "This userName is taken";
            }
        }
        YBwVogQr76 Oc8feFG224 = new YBwVogQr76(HTkqbmOfSt, HGxTRj6J83, JNnja8tccu, CTVW0eOmxF, V2t1Nz3dq5, VYnetJMrFI);
        NLm3phShMD.Z3bK2EywBt.add(Oc8feFG224);
        return "User was created successfully";
    }

    public static String ULequC7UXb(String JApypjGP7S, String HD1XvxigJi) {
        int IJ4qBXZKFS = -1;
        for (int DtovBqXKAb = 0; DtovBqXKAb < NLm3phShMD.Z3bK2EywBt.size(); DtovBqXKAb++) {
            if (JApypjGP7S.equals(NLm3phShMD.Z3bK2EywBt.get(DtovBqXKAb).Uhf1Kt7A9o())) {
                IJ4qBXZKFS = DtovBqXKAb;
            }
        }
        if (IJ4qBXZKFS == -1) {
            return "User not found";
        } else {
            if (!HD1XvxigJi.equals(NLm3phShMD.Z3bK2EywBt.get(IJ4qBXZKFS).SMu62ivii0())) {
                return "The password is incorrect";
            } else {
                KJdQ1O5KoW.S3a20pSw4e = NLm3phShMD.Z3bK2EywBt.get(IJ4qBXZKFS);
                return "Congrats you logined successfully";
            }
        }
    }

}
