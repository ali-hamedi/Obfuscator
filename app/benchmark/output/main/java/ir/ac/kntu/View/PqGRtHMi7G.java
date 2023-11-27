package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.AWDTXpTRdf;
import ir.ac.kntu.Controllers.TPUHCPyb9x;
import ir.ac.kntu.SKz3xXfGyu;
import ir.ac.kntu.Models.VRc52bkUje;
import java.util.ArrayList;
import java.util.Scanner;

public class PqGRtHMi7G {
    public void B2gKTSJdCc(Scanner MW6Wavzjyo, SKz3xXfGyu Ps5GLqoegl) {
        boolean VfIhZFabwe = true;
        while (VfIhZFabwe) {
            System.out.println("To add a receipt choose Buy or Sell");
            System.out.println("To enter inventory menu enter Inventory");
            System.out.println("To exit the program , enter Exit");
            String UmJFJQlxAB = MW6Wavzjyo.nextLine();
            switch (UmJFJQlxAB.trim()) {
                case "Exit", "exit" -> VfIhZFabwe = false;
                case "Buy", "buy" -> S8frWZLpyV(Ps5GLqoegl);
                case "Sell", "sell" -> EGFabk4ZxA(Ps5GLqoegl);
                case "Inventory", "inventory" -> (new Cs4E4slzVv()).run(MW6Wavzjyo, Ps5GLqoegl);
                default -> System.out.println("Invalid command !");
            }
        }
    }

    public void S8frWZLpyV(SKz3xXfGyu HSAi2ivvD1) {
        System.out.println("A new Buy receipt is created as follows :");
        String Mnk5HgpXg8 = HSAi2ivvD1.K7Kyhro2aK();
        ArrayList<VRc52bkUje> NOJ7eBcPcQ = AWDTXpTRdf.SjoCxOjLj6(Mnk5HgpXg8);
        for (VRc52bkUje J4Y4knz7A2 : NOJ7eBcPcQ)
            J4Y4knz7A2.KORTnhtSU4();
        TPUHCPyb9x.R9m6AK4TFw(NOJ7eBcPcQ);
    }

    public void EGFabk4ZxA(SKz3xXfGyu YvE2fBTokQ) {
        System.out.println("A new Sell receipt is created as follows :");
        String Bndctq1fin = YvE2fBTokQ.K7Kyhro2aK();
        ArrayList<VRc52bkUje> DXJXzGWlNK = AWDTXpTRdf.SjoCxOjLj6(Bndctq1fin);
        for (VRc52bkUje JMFgeCqH56 : DXJXzGWlNK)
            JMFgeCqH56.KORTnhtSU4();
        TPUHCPyb9x.N2fZ861idP(DXJXzGWlNK);
    }
}