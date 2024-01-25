package ir.ac.kntu.controller;

import ir.ac.kntu.Jpix49t4ls;
import ir.ac.kntu.data.db.FPOLZQXSZp;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.FRF7GV2ChS;

public class PjrZnQhsNh {

    public static String G79NuP6GZF(String LdjZaD775y, String Djv8YGThdO, String LogGBfhVxA, String TitbuNkr09, long Ctm0oIGlQD,
            long ElVIPjyDJX) {
        for (int XOJSauLYc4 = 0; XOJSauLYc4 < FPOLZQXSZp.FpXRk9VTTG.size(); XOJSauLYc4 = XOJSauLYc4 + 1) {
            if (LogGBfhVxA.equals(FPOLZQXSZp.FpXRk9VTTG.get(XOJSauLYc4).KvjvLTNYyZ())) {
                return "This email is already registerd";
            }
            if (Djv8YGThdO.equals(FPOLZQXSZp.FpXRk9VTTG.get(XOJSauLYc4).T8YqWZLQl0())) {
                return "This userName is taken";
            }
        }
        PbDqS3MTqS IcBoB7iCj6 = new PbDqS3MTqS(LdjZaD775y, Djv8YGThdO, LogGBfhVxA, TitbuNkr09, Ctm0oIGlQD, ElVIPjyDJX);
        FPOLZQXSZp.FpXRk9VTTG.add(IcBoB7iCj6);
        return "User was created successfully";
    }

    public static String G6B7dCiSBY(String LTMSBpyq0d, String FfSiB4qG8x) {
        int Tw48sqN35m = -1;
        for (int GHk9iUHu88 = 0; GHk9iUHu88 < FPOLZQXSZp.FpXRk9VTTG.size(); GHk9iUHu88 = GHk9iUHu88 + 1) {
            if (LTMSBpyq0d.equals(FPOLZQXSZp.FpXRk9VTTG.get(GHk9iUHu88).KvjvLTNYyZ())) {
                Tw48sqN35m = GHk9iUHu88;
                System.out.println(FfSiB4qG8x);
            }
        }
        if (Tw48sqN35m == -1) {
            return "User not found";
        } else {
            if (!FfSiB4qG8x.equals(FPOLZQXSZp.FpXRk9VTTG.get(Tw48sqN35m).Tl3tr36C7F())) {
                return "The password is incorrect";
            } else {
                Jpix49t4ls.R3C1dSUCog = FPOLZQXSZp.FpXRk9VTTG.get(Tw48sqN35m);
                return "Congrats you logined successfully";
            }
        }
    }

}
