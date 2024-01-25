package ir.ac.kntu;
import ir.ac.kntu.View.Menu;
import java.util.Scanner;
import ir.ac.kntu.MyCipher;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        (new Menu()).run(scanner , new JsonGenerator()) ;
        scanner.close();
    }
 }
