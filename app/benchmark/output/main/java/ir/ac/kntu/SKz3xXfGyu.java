package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Random;

public class SKz3xXfGyu {
    private StringBuilder EdAAaSlB9q;
    private Random Gghk2GLEad;
    static final String[] QLoqIH0aTK = { "junkFood", "drink", "diary", "sanitary", "protein" };
    static final String[] NNrvihf8D4 = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    static final String[] CoxckNTpOQ = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    static final String[] GMaf3klNf3 = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    static final String[] FD0EhVFpYJ = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash", "washingPowder" };
    static final String[] HyLVgkIFyV = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    public SKz3xXfGyu() {
        EdAAaSlB9q = new StringBuilder();
        Gghk2GLEad = new Random();
    }

    public String K7Kyhro2aK() {
        VNSNxAsMG1();
        return EdAAaSlB9q.toString();
    }

    private void VNSNxAsMG1() {
        EdAAaSlB9q.append("{");
        ArrayList<Integer> Z7MD0m4CYa = Y0OVtjWxXc(5);
        for (Integer V5NaU3LnsK : Z7MD0m4CYa) {
            Xuk7nCtYyz(QLoqIH0aTK[V5NaU3LnsK]);
        }
        EdAAaSlB9q.append("}");
    }

    private void Xuk7nCtYyz(String Elu9a2XAOf) {
        String[] GPDEAC7X8f;
        EdAAaSlB9q.append("\"").append(Elu9a2XAOf).append("\":[");
        switch (Elu9a2XAOf) {
            case "junkFood":
                GPDEAC7X8f = HyLVgkIFyV;
                break;
            case "drink":
                GPDEAC7X8f = GMaf3klNf3;
                break;
            case "diary":
                GPDEAC7X8f = CoxckNTpOQ;
                break;
            case "sanitary":
                GPDEAC7X8f = FD0EhVFpYJ;
                break;
            case "protein":
                GPDEAC7X8f = NNrvihf8D4;
                break;
            default:
                return;
        }
        ArrayList<Integer> PRvSD94uWg = Y0OVtjWxXc(6);
        for (Integer RDH5d73Djg : PRvSD94uWg) {
            H476Ki3ZoL(GPDEAC7X8f[RDH5d73Djg], Elu9a2XAOf);
        }
        EdAAaSlB9q.append("],");
    }

    private void H476Ki3ZoL(String JhuWOrTEXM, String Myg13cg723) {
        String QbUHH4A1ih = OPPQ1PYmRZ(Myg13cg723);
        String DKtc2rADuW = UsX2mP2oJO();
        String RgER4L8dQq = Hy2lw3I706(DKtc2rADuW, Myg13cg723);
        EdAAaSlB9q.append("\"").append(JhuWOrTEXM).append("\":{\"price\":\"").append(QbUHH4A1ih)
                .append("\",\"quantity\":\"").append(Gghk2GLEad.nextInt(150) + 15).append("\",\"productionDate\":\"")
                .append(DKtc2rADuW).append("\",\"expirationDate\":\"").append(RgER4L8dQq).append("\"},");
    }

    private String OPPQ1PYmRZ(String I0BwDS9JqT) {
        return switch (I0BwDS9JqT) {
            case "junkFood" -> String.valueOf(Gghk2GLEad.nextInt(55000) + 20000);
            case "drink" -> String.valueOf(Gghk2GLEad.nextInt(40000) + 25000);
            case "diary" -> String.valueOf(Gghk2GLEad.nextInt(150000) + 50000);
            case "sanitary" -> String.valueOf(Gghk2GLEad.nextInt(200000) + 60000);
            case "protein" -> String.valueOf(Gghk2GLEad.nextInt(300000) + 100000);
            default -> "error";
        };
    }

    private String UsX2mP2oJO() {
        return "2022" + "-" + (Gghk2GLEad.nextInt(13) + 1) + "-" + (Gghk2GLEad.nextInt(31) + 1);
    }

    private static String Hy2lw3I706(String ItGtBFpRFT, String P5PTJ8fOFX) {
        String[] PBjZgCnyD0 = ItGtBFpRFT.split("-");
        int W3HTOPDJGS = Integer.parseInt(PBjZgCnyD0[0]);
        int RkPrKjLgBf = Integer.parseInt(PBjZgCnyD0[1]);
        int TSU6NT5YSI = Integer.parseInt(PBjZgCnyD0[2]);
        switch (P5PTJ8fOFX) {
            case "junkFood":
                RkPrKjLgBf += 6;
                if (RkPrKjLgBf > 12) {
                    RkPrKjLgBf -= 12;
                    W3HTOPDJGS += 1;
                }
                break;
            case "drink":
                RkPrKjLgBf += 8;
                if (RkPrKjLgBf > 12) {
                    RkPrKjLgBf -= 12;
                    W3HTOPDJGS += 1;
                }
                break;
            case "diary":
                TSU6NT5YSI += 15;
                if (TSU6NT5YSI > 30) {
                    TSU6NT5YSI -= 30;
                    RkPrKjLgBf += 1;
                    if (RkPrKjLgBf > 12) {
                        RkPrKjLgBf -= 12;
                        W3HTOPDJGS += 1;
                    }
                }
                break;
            case "sanitary":
                W3HTOPDJGS += 2;
                break;
            case "protein":
                TSU6NT5YSI += 2;
                if (TSU6NT5YSI > 30) {
                    TSU6NT5YSI -= 30;
                    RkPrKjLgBf += 1;
                    if (RkPrKjLgBf > 12) {
                        RkPrKjLgBf -= 12;
                        W3HTOPDJGS += 1;
                    }
                }
                break;
            default:
                return "error";
        }
        return W3HTOPDJGS + "-" + RkPrKjLgBf + "-" + TSU6NT5YSI;
    }

    private ArrayList<Integer> Y0OVtjWxXc(int XFgdmucTeA) {
        ArrayList<Integer> H310iL5tV4 = new ArrayList<>();
        while (H310iL5tV4.size() < Gghk2GLEad.nextInt(XFgdmucTeA + 1) + 1) {
            Integer DWr6jX7ux8 = Gghk2GLEad.nextInt(XFgdmucTeA);
            if (!H310iL5tV4.contains(DWr6jX7ux8)) {
                H310iL5tV4.add(DWr6jX7ux8);
            }
        }
        return H310iL5tV4;
    }
}