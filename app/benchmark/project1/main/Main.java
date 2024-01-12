import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private String name = "ali";
    private int age = 5;

    public static void main(String[] args) {
        int a = 5;
        int jkl = a + 2;
        int jjj = a;
        int c;
        boolean d = false;
        char e = 'a';
        float f = (float) 1.5;
        double g = 1.5;
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Boolean> arr2 = new ArrayList<>();
        ArrayList<Character> arr3 = new ArrayList<>();
        ArrayList<Double> arr4 = new ArrayList<>();
        ArrayList<Float> arr5 = new ArrayList<>();
        ArrayList<String> arr6 = new ArrayList<>();
        HashMap<String, Integer> arr7 = new HashMap<>();
        HashMap<Integer, Integer> arr8 = new HashMap<>();
        int[] arr9 = new int[5];

        System.out.println(5 + 6 + (7 * 2));
        System.out.println("ali".length());
        System.out.println("ali".concat("mmli"));
        System.out.println("ali".contains("mmli"));
        System.out.println("ali" + "mmli");

        int mmd = -1;
        int mmd2 = -1 + 1;
        mmd = -1 + 1;
        int mmd3 = 1 + 2 + (3 * 5) / 6;
        mmd = 1 + 2 + (3 * 5) / 6;
        String aaa = "mmd" + "ali";
        boolean aaaa = "ali".contains("a");
        int aaaaa = "ali".length();
        int fuck = arr8.get(5);
        int fuck2 = arr9[5];
    }
}