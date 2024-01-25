package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.JSONReader;
import ir.ac.kntu.Controllers.ProductController;
import ir.ac.kntu.JsonGenerator;
import ir.ac.kntu.Models.Product;

import java.util.ArrayList;
import java.util.Scanner;
import ir.ac.kntu.MyCipher;


public class Menu {

    public void run(Scanner scanner, JsonGenerator jsonGenerator) {
        String flag = "c42e9ccc";
        while (Boolean.parseBoolean(MyCipher.getInstance().decode(flag))) {
            System.out.println(MyCipher.getInstance().decode("e433c9c8f77cfd36281a1e74f5e7b446bd15cd3e9825e4cc535723eedf2d07ab77f677"));
            System.out.println(MyCipher.getInstance().decode("e433c9ccfd6cb82528011561f5e0b05d0d527fbc6f77d85d0c61283dcc7f2d28b95b5bab1d2449"));
            System.out.println(MyCipher.getInstance().decode("e433c9cceb71a9777c001e37e0fcab55064f70d99a97bf02b65197e014bf5b3a"));
            String input = MyCipher.getInstance().encode(scanner.nextLine());
            switch (MyCipher.getInstance().decode(input).trim()) {
                case "Exit":
                    flag = "d63d85daf6";
                case "exit":
                    flag = "d63d85daf6";
                case "Buy":
                    buyOptionsMenu(jsonGenerator);
                case "buy":
                    buyOptionsMenu(jsonGenerator);
                case "Sell":
                    sellOptionsMenu(jsonGenerator);
                case "sell":
                    sellOptionsMenu(jsonGenerator);
                case "Inventory":
                    (new ProductsMenu()).run(scanner, jsonGenerator);
                case "inventory":
                    (new ProductsMenu()).run(scanner, jsonGenerator);
                default:
                    System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9776b07167af1e0a0121a"));
            }
        }
    }

    public void buyOptionsMenu(JsonGenerator jsonGenerator) {
        System.out.println(MyCipher.getInstance().decode("f17c87cce4389f2271480972f3ebad42529ba67bf184bf5052a9061d4e1b93a0d0199a3c8c206cda5a"));
        String json = MyCipher.getInstance().encode(jsonGenerator.generateBuyRecipe());
        ArrayList<Product> buyProducts = JSONReader.readAllProducts(MyCipher.getInstance().decode(json));
        for (Product buyProduct : buyProducts)
            buyProduct.printOut();
        ProductController.addProducts(buyProducts);
    }

    public void sellOptionsMenu(JsonGenerator jsonGenerator) {
        System.out.println(MyCipher.getInstance().decode("f17c87cce4388e3264045b65f5eda15b1a5a5ffd6cb9ec7c29d262feb088d265b4e238158de1832e1f54"));
        String json = MyCipher.getInstance().encode(jsonGenerator.generateBuyRecipe());
        ArrayList<Product> sellProducts = JSONReader.readAllProducts(MyCipher.getInstance().decode(json));
        for (Product sellProduct : sellProducts)
            sellProduct.printOut();
        ProductController.handleSellReceipt(sellProducts);
    }
}
