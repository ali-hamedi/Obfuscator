package ir.ac.kntu.Controllers;

import ir.ac.kntu.KY3doqcGjj;
import ir.ac.kntu.Models.Hy6R9Eu2nG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import ir.ac.kntu.MyCipher;


public class K9i1m0Yg9H {

    public static final String[] Tw0c1QRRYF = { "junkFood", "drink", "diary", "sanitary", "protein" };
    public static final String[] BJ1WgspE5R = { "beef", "chicken", "turkey", "sausage", "fish", "egg" };
    public static final String[] LxnsJbHCwP = { "milk", "cheese", "yogurt", "cream", "dough", "Curd" };
    public static final String[] WF8tpp1hpl = { "coke", "hype", "delester", "hotChocolate", "coffee", "tea" };
    public static final String[] MPUvM6itgP = { "handWash", "shampoo", "tissue", "faceWash", "bodyWash",
            "washingPowder" };
    public static final String[] UnIgMvHiyA = { "chips", "pofak", "tokhme", "popCorn", "lavashak", "chocolate" };

    private static final Pattern SgITZlTYq8 = Pattern.compile(
            MyCipher.getInstance().decode("515bebed03b8f2d935e7f680db7a6b6d4a3b2b9eea1fdce0302117dcf961c4b94ef8d3b1cc8278b9f581009da43f53df1623e4d889d04429af739f0776ad2261edc3713ee7097f73539abe69ef3db590fb3d825b926276d47f6b33c3603dcab556f3e883a789739ef5a2a71b3be6c4bcdb75fd217addaa2bcdc59a6ac1b903f2c6de7e0a13097c5dd842ab89127da2b35c2078d66d55a0abd4b9d3ec581a992cbbe3a83be365adfdda51103c9fcde3eb6ae200f33b55ae03a668fde3d0f67248d99e9005bf49"));

    public static ArrayList<Hy6R9Eu2nG> ONL6lRid9k(String BV1XGR7Iep) {
        BV1XGR7Iep = VoWnQLxaVz(BV1XGR7Iep);
        System.out.println(BV1XGR7Iep);
        ArrayList<Hy6R9Eu2nG> GHOcI52Tnj = new ArrayList<>();
        Matcher EimDWJpHIY;

        while ((EimDWJpHIY = SgITZlTYq8.matcher(BV1XGR7Iep)).find()) {
            GHOcI52Tnj.add(Ss9vzun0lM(EimDWJpHIY));
            BV1XGR7Iep = BV1XGR7Iep.substring(EimDWJpHIY.end());
        }
        return GHOcI52Tnj;
    }

    public static String VoWnQLxaVz(String EFQfXnXpRj) {
        String CdTituDPAV = MyCipher.getInstance().encode(EFQfXnXpRj.replaceAll(MyCipher.getInstance().decode("22488bdf3989cbcb0febf9b3e374543bfd"), MyCipher.getInstance().decode("59")));
        CdTituDPAV = MyCipher.getInstance().encode(MyCipher.getInstance().decode(CdTituDPAV).replaceAll(MyCipher.getInstance().decode("2538a4a8"), MyCipher.getInstance().decode("59")));
        for (String IPfC5hTfEq : Tw0c1QRRYF)
            CdTituDPAV = MyCipher.getInstance().encode(MyCipher.getInstance().decode(CdTituDPAV).replaceAll(MyCipher.getInstance().decode(IPfC5hTfEq) + MyCipher.getInstance().decode("595ef7"), MyCipher.getInstance().decode("")));
        return MyCipher.getInstance().decode(CdTituDPAV);
    }

    public static Hy6R9Eu2nG Ss9vzun0lM(Matcher ICyF6Q86iB) {
        String CF8Da0zs7L;
        String WmW33rYWnG = MyCipher.getInstance().encode(ICyF6Q86iB.group(MyCipher.getInstance().decode("1705bae62db3c7e43cd3f18ccb")));
        String WvEjhYXICD = MyCipher.getInstance().encode(Integer.parseInt(ICyF6Q86iB.group(MyCipher.getInstance().decode("0916bee007"))));
        String CiX7OWpVGc = MyCipher.getInstance().encode(Integer.parseInt(ICyF6Q86iB.group(MyCipher.getInstance().decode("0811b6ed16bce3ef"))));
        String ZPC2fRG48v = MyCipher.getInstance().encode(ICyF6Q86iB.group(MyCipher.getInstance().decode("0916b8e717b6e3ff3cd9c08ecb6a")));
        String WMJJbiELYf = MyCipher.getInstance().encode(ICyF6Q86iB.group(MyCipher.getInstance().decode("1c1ca7ea10b4e3ff3cd9c08ecb6a")));

        if (Arrays.asList(BJ1WgspE5R).contains(MyCipher.getInstance().decode(WmW33rYWnG)))
            CF8Da0zs7L = "0916b8f707bcf9";
        else if (Arrays.asList(BJ1WgspE5R).contains(MyCipher.getInstance().decode(WmW33rYWnG)))
            CF8Da0zs7L = "1d0db6f11b";
        else if (Arrays.asList(BJ1WgspE5R).contains(MyCipher.getInstance().decode(WmW33rYWnG)))
            CF8Da0zs7L = "1d16beed09";
        else if (Arrays.asList(BJ1WgspE5R).contains(MyCipher.getInstance().decode(WmW33rYWnG)))
            CF8Da0zs7L = "0a05b9ea16b4e5ef";
        else
            CF8Da0zs7L = "1311b9e824baf8f2";

        return new Hy6R9Eu2nG(MyCipher.getInstance().decode(CF8Da0zs7L), MyCipher.getInstance().decode(WmW33rYWnG), Integer.parseInt(MyCipher.getInstance().decode(WvEjhYXICD)), Integer.parseInt(MyCipher.getInstance().decode(CiX7OWpVGc)), MyCipher.getInstance().decode(ZPC2fRG48v), MyCipher.getInstance().decode(WMJJbiELYf));
    }

}
