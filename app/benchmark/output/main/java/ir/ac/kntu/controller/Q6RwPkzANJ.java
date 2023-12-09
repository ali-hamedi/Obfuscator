package ir.ac.kntu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ir.ac.kntu.data.db.*;
import ir.ac.kntu.data.models.*;

public class Q6RwPkzANJ {

    public static String VsSSmV4K0K(String A28FwNTCCa) {
        String S3dzmn4FdD = "";
        long LinLEqWjbT = 0;
        try {
            LinLEqWjbT = Long.parseLong(A28FwNTCCa);
        } catch (Exception e) {
            S3dzmn4FdD = A28FwNTCCa;
        }
        String EwiXE6ZFfk = "";
        for (UehRAADCCb NCiWsmHM1Q : DhG0Pi8PQs.XFp6Ki9O1o) {
            if (NCiWsmHM1Q.E50CEbEd7k().equals(S3dzmn4FdD) || NCiWsmHM1Q.PSNy6rprT7() == LinLEqWjbT) {
                EwiXE6ZFfk += "name: " + NCiWsmHM1Q.LOYYZX72It() + " userName: " + NCiWsmHM1Q.GMDJwmC311() + " email: " + NCiWsmHM1Q.E50CEbEd7k()
                        + " national code: " + NCiWsmHM1Q.PSNy6rprT7() + "\n";
            }
        }
        if (EwiXE6ZFfk.length() > 0) {
            return EwiXE6ZFfk;
        } else {
            return "User not found";
        }
    }

    public static String UAxo9vk1oj(String AXeEUsy228) {
        String T1Ff7Q4IPV = "";
        for (ASCZIm6zAm FHKHMoN3hT : DhG0Pi8PQs.LOmIhn3CLt) {
            if (FHKHMoN3hT.UoZfKt2HYb().equals(AXeEUsy228) || FHKHMoN3hT.UHExyXnudX().LOYYZX72It().equals(AXeEUsy228)
                    || FHKHMoN3hT.SqznlYl0RC().equals(AXeEUsy228)) {
                T1Ff7Q4IPV += "name: " + FHKHMoN3hT.UoZfKt2HYb() + " descrition: " + FHKHMoN3hT.BOFjhQjjTQ() + " institution: "
                        + FHKHMoN3hT.SqznlYl0RC()
                        + " year: " + FHKHMoN3hT.TTRqzdyjhD() + "\n";
            }
        }
        if (T1Ff7Q4IPV.length() > 0) {
            return T1Ff7Q4IPV;
        } else {
            return "Course not found";
        }
    }

    public static void HOIWNT4IO3() {
        ArrayList<ECGr4H6bmY> NUGPq5ChUb = OtNKrtrX3r.RA56K9kFkU;
        Collections.sort(NUGPq5ChUb, Comparator.comparingInt(ECGr4H6bmY::KB6H9kVDBx));
        Collections.reverse(NUGPq5ChUb);
        OtNKrtrX3r.RA56K9kFkU = NUGPq5ChUb;
    }
}
