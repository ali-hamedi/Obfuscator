package app.benchmark.project2.main;

public class Main{
    public static String name = "ali";
    public int age = 19;
    private int height  = 190;
    public static void main(String[] args) {
        int temp=0;
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                temp++;
            }
        }
        System.out.println(temp);
        String str = "The wheels on the bus go round and round";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        for (int i = 0; i < str.toUpperCase().length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}