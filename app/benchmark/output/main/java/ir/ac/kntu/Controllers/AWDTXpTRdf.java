package ir.ac.kntu.Controllers;

import ir.ac.kntu.SKz3xXfGyu;
import ir.ac.kntu.Models.VRc52bkUje;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AWDTXpTRdf {
    public static final String[] WzlnL9MU8O = { "junkFood", "drink", "diary", "sanitary", "protein" };
    public static final String[] GLIfB8sDNH = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    public static final String[] P8CRkL8fmQ = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    public static final String[] EvTbn5D5y4 = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    public static final String[] ABkjHf97Vo = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash",
            "washingPowder" };
    public static final String[] QigY6DMCJH = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };
    private static final Pattern FFGNusNuzP = Pattern.compile(
            "(?<nameOfProduct>\\w+) : price : (?<price>\\d+) quantity : (?<quantity>\\d+) productionDate : (?<productionDate>\\d{4}-\\d{1,2}-\\d{1,2}) expirationDate : (?<expirationDate>\\d{4}-\\d{1,2}-\\d{1,2})");

    public static ArrayList<VRc52bkUje> SjoCxOjLj6(String OLfuElyjuo) {
        OLfuElyjuo = LD7Nck7eIM(OLfuElyjuo);
        System.out.println(OLfuElyjuo);
        ArrayList<VRc52bkUje> KWSTcbXZl0 = new ArrayList<>();
        Matcher F1STtf9qDR;
        while ((F1STtf9qDR = FFGNusNuzP.matcher(OLfuElyjuo)).find()) {
            KWSTcbXZl0.add(CDNFAu9c6j(F1STtf9qDR));
            OLfuElyjuo = OLfuElyjuo.substring(F1STtf9qDR.end());
        }
        return KWSTcbXZl0;
    }

    public static String LD7Nck7eIM(String FQorGlHKaD) {
        String NPIYG7ZojR = FQorGlHKaD.replaceAll("[,\\[\\]\\}\\{\"]", " ");
        NPIYG7ZojR = NPIYG7ZojR.replaceAll("\\s+", " ");
        for (String QOgRS8Vj5m : WzlnL9MU8O)
            NPIYG7ZojR = NPIYG7ZojR.replaceAll(QOgRS8Vj5m + " : ", "");
        return NPIYG7ZojR;
    }

    public static VRc52bkUje CDNFAu9c6j(Matcher IZgvF0Dvjz) {
        String WwzPNsiSaZ;
        String EJKtKXA5L8 = IZgvF0Dvjz.group("nameOfProduct");
        int YLB2WakBa0 = Integer.parseInt(IZgvF0Dvjz.group("price"));
        int XBZS5ktlZ7 = Integer.parseInt(IZgvF0Dvjz.group("quantity"));
        String Dsd7ADtono = IZgvF0Dvjz.group("productionDate");
        String BjrrqCKRMh = IZgvF0Dvjz.group("expirationDate");
        if (List.of(GLIfB8sDNH).contains(EJKtKXA5L8))
            WwzPNsiSaZ = "protein";
        else if (List.of(P8CRkL8fmQ).contains(EJKtKXA5L8))
            WwzPNsiSaZ = "diary";
        else if (List.of(EvTbn5D5y4).contains(EJKtKXA5L8))
            WwzPNsiSaZ = "drink";
        else if (List.of(ABkjHf97Vo).contains(EJKtKXA5L8))
            WwzPNsiSaZ = "sanitary";
        else
            WwzPNsiSaZ = "junkFood";
        return new VRc52bkUje(WwzPNsiSaZ, EJKtKXA5L8, YLB2WakBa0, XBZS5ktlZ7, Dsd7ADtono, BjrrqCKRMh);
    }
}