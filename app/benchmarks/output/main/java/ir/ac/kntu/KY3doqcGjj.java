package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Random;
import ir.ac.kntu.MyCipher;


public class KY3doqcGjj {
    private StringBuilder UzJOWAhGbA;
    private Random MVwTcVxTni;
    static final String[] CqSpCweoxg = { "junkFood", "drink", "diary", "sanitary", "protein" };
    static final String[] SnGeH2DTr8 = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    static final String[] LrWqJtkpft = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    static final String[] Htk9vGQmUR = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    static final String[] CfBSz2J8Ml = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash",
            "washingPowder" };
    static final String[] Qn21E0y3RW = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    public KY3doqcGjj() {
        UzJOWAhGbA = new StringBuilder();
        MVwTcVxTni = new Random();
    }

    public String N7earYoAgH() {
        RpvSRXWUQX();
        return UzJOWAhGbA.toString();
    }

    private void RpvSRXWUQX() {
        UzJOWAhGbA.append(MyCipher.getInstance().decode("02"));
        ArrayList<Integer> UltBjhgz8x = ZdZCvYjLOU(5);
        for (Integer CIXEtY2DiO : UltBjhgz8x) {
            Wvqxlczb8K(MyCipher.getInstance().decode(CqSpCweoxg[Integer.parseInt(MyCipher.getInstance().decode(CIXEtY2DiO))]));
        }
        UzJOWAhGbA.append(MyCipher.getInstance().decode("04"));
    }

    private void Wvqxlczb8K(String M6JuAkSCIU) {
        String[] KDLWfTwfeV;
        UzJOWAhGbA.append(MyCipher.getInstance().decode("2546")).append(M6JuAkSCIU).append(MyCipher.getInstance().decode("2546edd8"));
        switch (M6JuAkSCIU) {
            case "junkFood":
                KDLWfTwfeV = Qn21E0y3RW;
                break;
            case "drink":
                KDLWfTwfeV = Htk9vGQmUR;
                break;
            case "diary":
                KDLWfTwfeV = LrWqJtkpft;
                break;
            case "sanitary":
                KDLWfTwfeV = CfBSz2J8Ml;
                break;
            case "protein":
                KDLWfTwfeV = SnGeH2DTr8;
                break;
            default:
                return;
        }
        ArrayList<Integer> PUeuZNOjPH = ZdZCvYjLOU(6);
        for (Integer IH8NVHvJik : PUeuZNOjPH) {
            Hhp1ECFn6B(MyCipher.getInstance().decode(KDLWfTwfeV[Integer.parseInt(MyCipher.getInstance().decode(IH8NVHvJik))]), M6JuAkSCIU);
        }
        UzJOWAhGbA.append(MyCipher.getInstance().decode("2448"));
    }

    private void Hhp1ECFn6B(String VNGq2gEts0, String PEnJUDrpzp) {
        String DNorJ11aPx = MyCipher.getInstance().encode(BQlHrIduHa(PEnJUDrpzp));
        String QKr8iqxReJ = MyCipher.getInstance().encode(CxigeCfVLl());
        String DRFeFryb4R = MyCipher.getInstance().encode(JMmGvFTHLf(MyCipher.getInstance().decode(QKr8iqxReJ), PEnJUDrpzp));
        UzJOWAhGbA.append(MyCipher.getInstance().decode("2546")).append(VNGq2gEts0).append(MyCipher.getInstance().decode("2546edf83ef7e7e43ad4e1b39d35543b")).append(MyCipher.getInstance().decode(DNorJ11aPx)).append(MyCipher.getInstance().decode("2546fbdf40a4e2f73dc3ed9bc6532a230d15"))
                .append(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4851e7"))) + Integer.parseInt(MyCipher.getInstance().decode("4851"))).append(MyCipher.getInstance().decode("2546fbdf40a5e5f937c2e79bd660665ddf085a4d1820537e")).append(MyCipher.getInstance().decode(QKr8iqxReJ))
                .append(MyCipher.getInstance().decode("2546fbdf40b0efe63ac5e59bd660665de79f1951b86c72b5")).append(MyCipher.getInstance().decode(DRFeFryb4R)).append(MyCipher.getInstance().decode("2546aaaf"));
    }

    private String BQlHrIduHa(String Eh92hh2XMC) {
        switch (Eh92hh2XMC) {
            case "junkFood":
                return String.valueOf(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4c51e7b352"))) + Integer.parseInt(MyCipher.getInstance().decode("4b54e7b352")));
            case "drink":
                return String.valueOf(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4d54e7b352"))) + Integer.parseInt(MyCipher.getInstance().decode("4b51e7b352")));
            case "diary":
                return String.valueOf(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4851e7b352e5"))) + Integer.parseInt(MyCipher.getInstance().decode("4c54e7b352")));
            case "sanitary":
                return String.valueOf(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4b54e7b352e5"))) + Integer.parseInt(MyCipher.getInstance().decode("4f54e7b352")));
            case "protein":
                return String.valueOf(MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4a54e7b352e5"))) + Integer.parseInt(MyCipher.getInstance().decode("4854e7b352e5")));
            default:
                return MyCipher.getInstance().decode("1c16a5ec10");
        }
    }

    private String CxigeCfVLl() {
        return MyCipher.getInstance().decode("4b54e5b1") + MyCipher.getInstance().decode("54") + (MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4857"))) + Integer.parseInt(MyCipher.getInstance().decode("48"))) + MyCipher.getInstance().decode("54") + (MVwTcVxTni.nextInt(Integer.parseInt(MyCipher.getInstance().decode("4a55"))) + Integer.parseInt(MyCipher.getInstance().decode("48")));
    }

    private static String JMmGvFTHLf(String TAWZ4W7N5X, String NpL3ZDlTVT) {
        String[] HOhrwmjTdD = TAWZ4W7N5X.split(MyCipher.getInstance().decode("54"));
        String RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(HOhrwmjTdD[Integer.parseInt(MyCipher.getInstance().decode("49"))])));
        String JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(HOhrwmjTdD[Integer.parseInt(MyCipher.getInstance().decode("48"))])));
        String PgFGrxyAZ4 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(HOhrwmjTdD[Integer.parseInt(MyCipher.getInstance().decode("4b"))])));
        switch (NpL3ZDlTVT) {
            case "junkFood":
                JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) + Integer.parseInt(MyCipher.getInstance().decode("4f")));
                if (Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) > Integer.parseInt(MyCipher.getInstance().decode("4856"))) {
                    JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) - Integer.parseInt(MyCipher.getInstance().decode("4856")));
                    RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                }
                break;
            case "drink":
                JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) + Integer.parseInt(MyCipher.getInstance().decode("41")));
                if (Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) > Integer.parseInt(MyCipher.getInstance().decode("4856"))) {
                    JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) - Integer.parseInt(MyCipher.getInstance().decode("4856")));
                    RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                }
                break;
            case "diary":
                PgFGrxyAZ4 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) + Integer.parseInt(MyCipher.getInstance().decode("4851")));
                if (Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) > Integer.parseInt(MyCipher.getInstance().decode("4a54"))) {
                    PgFGrxyAZ4 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) - Integer.parseInt(MyCipher.getInstance().decode("4a54")));
                    JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                    if (Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) > Integer.parseInt(MyCipher.getInstance().decode("4856"))) {
                        JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) - Integer.parseInt(MyCipher.getInstance().decode("4856")));
                        RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                    }
                }
                break;
            case "sanitary":
                RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + Integer.parseInt(MyCipher.getInstance().decode("4b")));
                break;
            case "protein":
                PgFGrxyAZ4 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) + Integer.parseInt(MyCipher.getInstance().decode("4b")));
                if (Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) > Integer.parseInt(MyCipher.getInstance().decode("4a54"))) {
                    PgFGrxyAZ4 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4)) - Integer.parseInt(MyCipher.getInstance().decode("4a54")));
                    JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                    if (Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) > Integer.parseInt(MyCipher.getInstance().decode("4856"))) {
                        JQktgFBpm7 = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) - Integer.parseInt(MyCipher.getInstance().decode("4856")));
                        RjuL3fS3EC = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + Integer.parseInt(MyCipher.getInstance().decode("48")));
                    }
                }
                break;
            default:
                return MyCipher.getInstance().decode("1c16a5ec10");
        }
        return Integer.parseInt(MyCipher.getInstance().decode(RjuL3fS3EC)) + MyCipher.getInstance().decode("54") + Integer.parseInt(MyCipher.getInstance().decode(JQktgFBpm7)) + MyCipher.getInstance().decode("54") + Integer.parseInt(MyCipher.getInstance().decode(PgFGrxyAZ4));
    }

    private ArrayList<Integer> ZdZCvYjLOU(int GQxhyBi6Qh) {
        ArrayList<Integer> UxNKHGYuV8 = new ArrayList<>();
        while (UxNKHGYuV8.size() < MVwTcVxTni.nextInt(GQxhyBi6Qh + Integer.parseInt(MyCipher.getInstance().decode("48"))) + Integer.parseInt(MyCipher.getInstance().decode("48"))) {
            String ZaEk542DrH = MyCipher.getInstance().encode(MVwTcVxTni.nextInt(GQxhyBi6Qh));
            if (!UxNKHGYuV8.contains(Integer.parseInt(MyCipher.getInstance().decode(ZaEk542DrH)))) {
                UxNKHGYuV8.add(Integer.parseInt(MyCipher.getInstance().decode(ZaEk542DrH)));
            }
        }
        return UxNKHGYuV8;
    }
}
