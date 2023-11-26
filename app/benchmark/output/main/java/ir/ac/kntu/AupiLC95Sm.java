package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Random;

public class AupiLC95Sm {
    private StringBuilder WWmVTZYKQ0;
    private Random WX2ZlNiZbN;
    static final String[] RL8v89e7bh = { "junkFood", "drink", "diary", "sanitary", "protein" };
    static final String[] SneMK8KAg9 = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    static final String[] LwZKMJeCcp = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    static final String[] Ne4CEpAQTW = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    static final String[] Vq7Tb5tvrg = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash", "washingPowder" };
    static final String[] GFrtfwkd5q = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    public JsonGenerator ( ) { WWmVTZYKQ0 = new StringBuilder ( ) ; WX2ZlNiZbN = new Random ( ) ; }

    public String HZDQZdg4mb() {
        generateRandomTypes();
        return WWmVTZYKQ0.toString();
    }

    private void GDO1osNSzc() {
        WWmVTZYKQ0.append("{");
        ArrayList<Integer> D4yS54tlw7 = generateNonDuplicateRandomNumbers(5);
        for (Integer YXN9KdHGRr : D4yS54tlw7) {
            generateRandomGoods(RL8v89e7bh[YXN9KdHGRr]);
        }
        WWmVTZYKQ0.append("}");
    }

    private void MQIIj1RE0x(String ETkNNK0sgE) {
        String[] MtSdfDtLL8;
        WWmVTZYKQ0.append("\"").append(ETkNNK0sgE).append("\":[");
        switch (ETkNNK0sgE) {
            case "junkFood":
                MtSdfDtLL8 = GFrtfwkd5q;
                break;
            case "drink":
                MtSdfDtLL8 = Ne4CEpAQTW;
                break;
            case "diary":
                MtSdfDtLL8 = LwZKMJeCcp;
                break;
            case "sanitary":
                MtSdfDtLL8 = Vq7Tb5tvrg;
                break;
            case "protein":
                MtSdfDtLL8 = SneMK8KAg9;
                break;
            default:
                return;
        }
        ArrayList<Integer> MZjjRm8U4X = generateNonDuplicateRandomNumbers(6);
        for (Integer Gsa6oLvnq9 : MZjjRm8U4X) {
            generateRandomGoodsDetails(MtSdfDtLL8[Gsa6oLvnq9], ETkNNK0sgE);
        }
        WWmVTZYKQ0.append("],");
    }

    private void XqygLcxwUo(String QbNrD04U5c, String Swk9GHeARa) {
        String UlEkZ311xs = generateRandomPrice(Swk9GHeARa);
        String NGiZep4hDM = generateRandomPDate();
        String WhrEJU9AS2 = generateRandomEDate(NGiZep4hDM, Swk9GHeARa);
        WWmVTZYKQ0.append("\"").append(QbNrD04U5c).append("\":{\"price\":\"").append(UlEkZ311xs)
                .append("\",\"quantity\":\"").append(WX2ZlNiZbN.nextInt(150) + 15).append("\",\"productionDate\":\"")
                .append(NGiZep4hDM).append("\",\"expirationDate\":\"").append(WhrEJU9AS2).append("\"},");
    }

    private String AhYhwBbeuB(String R9w0UcUOMq) {
        return switch (R9w0UcUOMq) {
            case "junkFood" -> String.valueOf(WX2ZlNiZbN.nextInt(55000) + 20000);
            case "drink" -> String.valueOf(WX2ZlNiZbN.nextInt(40000) + 25000);
            case "diary" -> String.valueOf(WX2ZlNiZbN.nextInt(150000) + 50000);
            case "sanitary" -> String.valueOf(WX2ZlNiZbN.nextInt(200000) + 60000);
            case "protein" -> String.valueOf(WX2ZlNiZbN.nextInt(300000) + 100000);
            default -> "error";
        };
    }

    private String IUO6g7P7PO() {
        return "2022" + "-" + (WX2ZlNiZbN.nextInt(13) + 1) + "-" + (WX2ZlNiZbN.nextInt(31) + 1);
    }

    private static String HkCCfsDXC4(String Qn9OF83LxS, String SbJHiMgi4c) {
        String[] I1dpAzVRUI = NGiZep4hDM.split("-");
        int WABTL2Buke = Integer.parseInt(I1dpAzVRUI[0]);
        int UgXGkZLwnJ = Integer.parseInt(I1dpAzVRUI[1]);
        int ZHvTAJch8p = Integer.parseInt(I1dpAzVRUI[2]);
        switch (SbJHiMgi4c) {
            case "junkFood":
                UgXGkZLwnJ += 6;
                if (UgXGkZLwnJ > 12) {
                    UgXGkZLwnJ -= 12;
                    WABTL2Buke += 1;
                }
                break;
            case "drink":
                UgXGkZLwnJ += 8;
                if (UgXGkZLwnJ > 12) {
                    UgXGkZLwnJ -= 12;
                    WABTL2Buke += 1;
                }
                break;
            case "diary":
                ZHvTAJch8p += 15;
                if (ZHvTAJch8p > 30) {
                    ZHvTAJch8p -= 30;
                    UgXGkZLwnJ += 1;
                    if (UgXGkZLwnJ > 12) {
                        UgXGkZLwnJ -= 12;
                        WABTL2Buke += 1;
                    }
                }
                break;
            case "sanitary":
                WABTL2Buke += 2;
                break;
            case "protein":
                ZHvTAJch8p += 2;
                if (ZHvTAJch8p > 30) {
                    ZHvTAJch8p -= 30;
                    UgXGkZLwnJ += 1;
                    if (UgXGkZLwnJ > 12) {
                        UgXGkZLwnJ -= 12;
                        WABTL2Buke += 1;
                    }
                }
                break;
            default:
                return "error";
        }
        return WABTL2Buke + "-" + UgXGkZLwnJ + "-" + ZHvTAJch8p;
    }

    private ArrayList<Integer> KyvAmP1Plj(int EqkdmJIj4o) {
        ArrayList<Integer> KFhhIbwYXg = new ArrayList<>();
        while (KFhhIbwYXg.size() < WX2ZlNiZbN.nextInt(EqkdmJIj4o + 1) + 1) {
            Integer EFmgtIIYzw = WX2ZlNiZbN.nextInt(EqkdmJIj4o);
            if (!KFhhIbwYXg.contains(EFmgtIIYzw)) {
                KFhhIbwYXg.add(EFmgtIIYzw);
            }
        }
        return KFhhIbwYXg;
    }
}