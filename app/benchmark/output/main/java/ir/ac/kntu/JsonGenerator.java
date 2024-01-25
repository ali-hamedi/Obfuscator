package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Random;
import ir.ac.kntu.MyCipher;


public class JsonGenerator {
    private StringBuilder json;
    private Random rand;
    static final String[] typeList = { "junkFood", "drink", "diary", "sanitary", "protein" };
    static final String[] proteinGoodsList = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    static final String[] diaryGoodsList = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    static final String[] drinkGoodsList = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    static final String[] sanitaryGoodsList = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash",
            "washingPowder" };
    static final String[] junkFoodGoodsList = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    public JsonGenerator() {
        json = new StringBuilder();
        rand = new Random();
    }

    public String generateBuyRecipe() {
        generateRandomTypes();
        return json.toString();
    }

    private void generateRandomTypes() {
        json.append(MyCipher.getInstance().decode("cb"));
        ArrayList<String> typesIndex = generateNonDuplicateRandomNumbers(5);
        for (Integer i : typesIndex) {
            generateRandomGoods(MyCipher.getInstance().decode(typeList[Integer.parseInt(MyCipher.getInstance().decode(i))]));
        }
        json.append(MyCipher.getInstance().decode("cd"));
    }

    private void generateRandomGoods(String type) {
        String[] goodsList;
        json.append(MyCipher.getInstance().decode("ec7e")).append(type).append(MyCipher.getInstance().decode("ec7ed3f2"));
        switch (type) {
            case "junkFood":
                goodsList = junkFoodGoodsList;
                break;
            case "drink":
                goodsList = drinkGoodsList;
                break;
            case "diary":
                goodsList = diaryGoodsList;
                break;
            case "sanitary":
                goodsList = sanitaryGoodsList;
                break;
            case "protein":
                goodsList = proteinGoodsList;
                break;
            default:
                return;
        }
        ArrayList<String> goodsIndex = generateNonDuplicateRandomNumbers(6);
        for (Integer i : goodsIndex) {
            generateRandomGoodsDetails(MyCipher.getInstance().decode(goodsList[Integer.parseInt(MyCipher.getInstance().decode(i))]), type);
        }
        json.append(MyCipher.getInstance().decode("ed70"));
    }

    private void generateRandomGoodsDetails(String item, String type) {
        String price = MyCipher.getInstance().encode(generateRandomPrice(type));
        String pDate = MyCipher.getInstance().encode(generateRandomPDate());
        String eDate = MyCipher.getInstance().encode(generateRandomEDate(MyCipher.getInstance().decode(pDate), type));
        json.append(MyCipher.getInstance().decode("ec7e")).append(item).append(MyCipher.getInstance().decode("ec7ed3d2cf3aad25610b1e4bb2b49810")).append(MyCipher.getInstance().decode(price)).append(MyCipher.getInstance().decode("ec7ec5f5b169a836661c1263e9d2e608e233"))
                .append(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("8169d9"))) + Integer.parseInt(MyCipher.getInstance().decode("8169"))).append(MyCipher.getInstance().decode("ec7ec5f5b168af386c1d1863f9e1aa766183228f3baad989")).append(MyCipher.getInstance().decode(pDate))
                .append(MyCipher.getInstance().decode("ec7ec5f5b17da527611a1a63f9e1aa763dc011521e1be45b")).append(MyCipher.getInstance().decode(eDate)).append(MyCipher.getInstance().decode("ec7e9485"));
    }

    private String generateRandomPrice(String type) {
        switch (type) {
            case "junkFood":
                return String.valueOf(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("8569d999a3"))) + Integer.parseInt(MyCipher.getInstance().decode("826cd999a3")));
            case "drink":
                return String.valueOf(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("846cd999a3"))) + Integer.parseInt(MyCipher.getInstance().decode("8269d999a3")));
            case "diary":
                return String.valueOf(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("8169d999a328"))) + Integer.parseInt(MyCipher.getInstance().decode("856cd999a3")));
            case "sanitary":
                return String.valueOf(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("826cd999a328"))) + Integer.parseInt(MyCipher.getInstance().decode("866cd999a3")));
            case "protein":
                return String.valueOf(rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("836cd999a328"))) + Integer.parseInt(MyCipher.getInstance().decode("816cd999a328")));
            default:
                return MyCipher.getInstance().decode("d52e9bc6e1");
        }
    }

    private String generateRandomPDate() {
        return MyCipher.getInstance().decode("826cdb9b") + MyCipher.getInstance().decode("9d") + (rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("816f"))) + Integer.parseInt(MyCipher.getInstance().decode("81"))) + MyCipher.getInstance().decode("9d") + (rand.nextInt(Integer.parseInt(MyCipher.getInstance().decode("836d"))) + Integer.parseInt(MyCipher.getInstance().decode("81")));
    }

    private static String generateRandomEDate(String pDate, String type) {
        String[] split = pDate.split(MyCipher.getInstance().decode("9d"));
        String year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(split[Integer.parseInt(MyCipher.getInstance().decode("80"))])));
        String month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(split[Integer.parseInt(MyCipher.getInstance().decode("81"))])));
        String day = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(split[Integer.parseInt(MyCipher.getInstance().decode("82"))])));
        switch (type) {
            case "junkFood":
                month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) + Integer.parseInt(MyCipher.getInstance().decode("86")));
                if (Integer.parseInt(MyCipher.getInstance().decode(month)) > Integer.parseInt(MyCipher.getInstance().decode("816e"))) {
                    month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) - Integer.parseInt(MyCipher.getInstance().decode("816e")));
                    year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(year)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                }
                break;
            case "drink":
                month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) + Integer.parseInt(MyCipher.getInstance().decode("88")));
                if (Integer.parseInt(MyCipher.getInstance().decode(month)) > Integer.parseInt(MyCipher.getInstance().decode("816e"))) {
                    month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) - Integer.parseInt(MyCipher.getInstance().decode("816e")));
                    year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(year)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                }
                break;
            case "diary":
                day = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode("8169")));
                if (Integer.parseInt(MyCipher.getInstance().decode(day)) > Integer.parseInt(MyCipher.getInstance().decode("836c"))) {
                    day = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(day)) - Integer.parseInt(MyCipher.getInstance().decode("836c")));
                    month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                    if (Integer.parseInt(MyCipher.getInstance().decode(month)) > Integer.parseInt(MyCipher.getInstance().decode("816e"))) {
                        month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) - Integer.parseInt(MyCipher.getInstance().decode("816e")));
                        year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(year)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                    }
                }
                break;
            case "sanitary":
                year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(year)) + Integer.parseInt(MyCipher.getInstance().decode("82")));
                break;
            case "protein":
                day = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode("82")));
                if (Integer.parseInt(MyCipher.getInstance().decode(day)) > Integer.parseInt(MyCipher.getInstance().decode("836c"))) {
                    day = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(day)) - Integer.parseInt(MyCipher.getInstance().decode("836c")));
                    month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                    if (Integer.parseInt(MyCipher.getInstance().decode(month)) > Integer.parseInt(MyCipher.getInstance().decode("816e"))) {
                        month = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(month)) - Integer.parseInt(MyCipher.getInstance().decode("816e")));
                        year = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(year)) + Integer.parseInt(MyCipher.getInstance().decode("81")));
                    }
                }
                break;
            default:
                return MyCipher.getInstance().decode("d52e9bc6e1");
        }
        return Integer.parseInt(MyCipher.getInstance().decode(year)) + MyCipher.getInstance().decode("9d") + Integer.parseInt(MyCipher.getInstance().decode(month)) + MyCipher.getInstance().decode("9d") + Integer.parseInt(MyCipher.getInstance().decode(day));
    }

    private ArrayList<Integer> generateNonDuplicateRandomNumbers(int max) {
        ArrayList<String> generated = new ArrayList<>();
        while (generated.size() < rand.nextInt(max + Integer.parseInt(MyCipher.getInstance().decode("81"))) + Integer.parseInt(MyCipher.getInstance().decode("81"))) {
            String next = MyCipher.getInstance().encode(rand.nextInt(max));
            if (!generated.contains(Integer.parseInt(MyCipher.getInstance().decode(next)))) {
                generated.add(Integer.parseInt(MyCipher.getInstance().decode(next)));
            }
        }
        return generated;
    }
}
