package ir.ac.kntu.Controllers;

import ir.ac.kntu.JsonGenerator;
import ir.ac.kntu.Models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import ir.ac.kntu.MyCipher;


public class JSONReader {

    public static final String[] typeList = { "junkFood", "drink", "diary", "sanitary", "protein" };
    public static final String[] proteinGoodsList = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    public static final String[] diaryGoodsList = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    public static final String[] drinkGoodsList = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    public static final String[] sanitaryGoodsList = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash",
            "washingPowder" };
    public static final String[] junkFoodGoodsList = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    private static final Pattern productPattern = Pattern.compile(
            MyCipher.getInstance().decode("9863d5c7f275b8186e380978f4fba746bbbd95bf48feccdc4f58c302da95e4072e7009b0fcecf8259c91bf5ccf0bcab951b96032f913e01f21c1443ae52398ef7322a349919104099a1d368cc63ef85ab183d81e9b8d754b635b3e7a3216492ecdc7aebda25ac04827219f4df68d3546522c90bf20f9708c63a0a84bc74e87a6a02df61945bd656e89db396f8a547ddf6a083f0534133730cddec4a146f12d0761e3f7010a42de2e2e8e2ad53a19a2b285e78a7f4156dcbf8cb9e8b844ee738e16b89c90210f"));

    public static ArrayList<Product> readAllProducts(String jsonString) {
        jsonString = trimString(jsonString);
        System.out.println(jsonString);
        ArrayList<Product> products = new ArrayList<>();
        Matcher matcher;

        while ((matcher = productPattern.matcher(jsonString)).find()) {
            products.add(handleProduct(matcher));
            jsonString = jsonString.substring(matcher.end());
        }
        return products;
    }

    public static String trimString(String jsonString) {
        String out = MyCipher.getInstance().encode(jsonString.replaceAll(MyCipher.getInstance().decode("eb70b5f5c844810a5434064bccf598108c"), MyCipher.getInstance().decode("90")));
        out = MyCipher.getInstance().encode(MyCipher.getInstance().decode(out).replaceAll(MyCipher.getInstance().decode("ec009a82"), MyCipher.getInstance().decode("90")));
        for (String s : typeList)
            out = MyCipher.getInstance().encode(MyCipher.getInstance().decode(out).replaceAll(MyCipher.getInstance().decode(s) + MyCipher.getInstance().decode("9066c9"), MyCipher.getInstance().decode("")));
        return MyCipher.getInstance().decode(out);
    }

    public static Product handleProduct(Matcher matcher) {
        String typeOfProduct;
        String productName = MyCipher.getInstance().encode(matcher.group(MyCipher.getInstance().decode("de3d84ccdc7e8d25670c0e74e4")));
        String price = MyCipher.getInstance().encode(Integer.parseInt(matcher.group(MyCipher.getInstance().decode("c02e80caf6"))));
        String quantity = MyCipher.getInstance().encode(Integer.parseInt(matcher.group(MyCipher.getInstance().decode("c12988c7e771a92e"))));
        String productionDate = MyCipher.getInstance().encode(matcher.group(MyCipher.getInstance().decode("c02e86cde67ba93e67063f76e4eb")));
        String expirationDate = MyCipher.getInstance().encode(matcher.group(MyCipher.getInstance().decode("d52499c0e179a93e67063f76e4eb")));

        if (Arrays.asList(proteinGoodsList).contains(MyCipher.getInstance().decode(productName)))
            typeOfProduct = "c02e86ddf671b3";
        else if (Arrays.asList(proteinGoodsList).contains(MyCipher.getInstance().decode(productName)))
            typeOfProduct = "d43588dbea";
        else if (Arrays.asList(proteinGoodsList).contains(MyCipher.getInstance().decode(productName)))
            typeOfProduct = "d42e80c7f8";
        else if (Arrays.asList(proteinGoodsList).contains(MyCipher.getInstance().decode(productName)))
            typeOfProduct = "c33d87c0e779af2e";
        else
            typeOfProduct = "da2987c2d577b233";

        return new Product(MyCipher.getInstance().decode(typeOfProduct), MyCipher.getInstance().decode(productName), Integer.parseInt(MyCipher.getInstance().decode(price)), Integer.parseInt(MyCipher.getInstance().decode(quantity)), MyCipher.getInstance().decode(productionDate), MyCipher.getInstance().decode(expirationDate));
    }

}
