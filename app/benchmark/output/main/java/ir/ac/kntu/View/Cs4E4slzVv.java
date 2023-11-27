package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.TPUHCPyb9x;
import ir.ac.kntu.SKz3xXfGyu;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cs4E4slzVv extends PqGRtHMi7G {
    Pattern SQGDFVBC2W = Pattern.compile("^\\s*Back\\s*$");
    Pattern QnGTCcbFW3 = Pattern.compile("^\\s*Categorize by type (diary|protein|junkFood|sanitary|drink)\\s*$");
    Pattern P3lrH4x8Nv = Pattern.compile("^Sort by price (increasing|decreasing)$");
    Pattern B7KhrXG3Et = Pattern.compile("^Sort by expiration date (increasing|decreasing)$");
    Pattern GngfDJe7mb = Pattern.compile("^\\s*Sort by quantity (increasing|decreasing)\\s*$");
    Pattern QdFqmkS0Ue = Pattern.compile("^\\s*Show out of date goods\\s*$");
    Pattern WtLuMnJez3 = Pattern.compile("^\\s*Show total value\\s*$");
    Pattern TvFemj0yOT = Pattern.compile("^\\s*Show all goods\\s*$");

    @Override
    public void B2gKTSJdCc(Scanner QGEuloQ0EF, SKz3xXfGyu RlFNvFePv6) {
        while (true) {
            System.out.println("Commands list :");
            System.out.println("Back                                            : go to welcome menu");
            System.out
                    .println("Categorize by type <typeOfProduct>              : categorizing all goods by their type");
            System.out.println(
                    "Sort by price <increasing|decreasing>           : sort all goods in increasing or decreasing order");
            System.out.println(
                    "Sort by expiration date <increasing|decreasing> : sort all goods in increasing or decreasing order");
            System.out.println(
                    "Sort by quantity <increasing|decreasing>        : sort all goods based on their quantity");
            System.out.println("Show out of date goods                          : list of all out of date goods");
            System.out.println("Show total value                                : compute total value of receipt");
            System.out.println("Show all goods                                  : show all goods in readable form");
            String SSLXkDXDxG = QGEuloQ0EF.nextLine();
            Matcher HrsIwkElPt;
            if (SQGDFVBC2W.matcher(SSLXkDXDxG).matches())
                return;
            else if ((HrsIwkElPt = QnGTCcbFW3.matcher(SSLXkDXDxG)).matches())
                TPUHCPyb9x.S7ZGMILn28(SSLXkDXDxG.replace("Categorize by type ", ""));
            else if (P3lrH4x8Nv.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.BGDRe3ct4X(SSLXkDXDxG.replace("Sort by price ", ""));
            else if (B7KhrXG3Et.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.Ea8l2HS1Io(SSLXkDXDxG.replace("Sort by expiration date ", ""));
            else if (GngfDJe7mb.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.GPQyz3H3h4(SSLXkDXDxG.replace("Sort by quantity ", ""));
            else if (QdFqmkS0Ue.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.K2OA4lc9Jp();
            else if (WtLuMnJez3.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.XzLVH7zhC3();
            else if (TvFemj0yOT.matcher(SSLXkDXDxG).matches())
                TPUHCPyb9x.Pr75iwaRqR();
            else
                System.out.println("Invalid command !");
        }
    }
}