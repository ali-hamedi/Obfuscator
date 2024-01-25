package ir.ac.kntu.Controllers;

import ir.ac.kntu.Models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import ir.ac.kntu.MyCipher;


public class ProductController {

    public static ArrayList<Product> inventory = new ArrayList<>();

    public static void categorizeByType(String typeOfProduct) {
        if (Arrays.asList(JSONReader.typeList).contains(typeOfProduct)) {
            System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9777c110b72b0e1a2121a1a74ea5ad20fc888"));
            return;
        }
        System.out.println(MyCipher.getInstance().decode("f33d9dccf477af2e28") + typeOfProduct + MyCipher.getInstance().decode("9066"));
        for (Product receiptProduct : inventory) {
            if (receiptProduct.getTypeOfProduct().equals(typeOfProduct.trim()))
                receiptProduct.printOut();
        }
    }

    public static void sortByPrice(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains(MyCipher.getInstance().decode("d9328adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getPrice));
        } else if (sortType.contains(MyCipher.getInstance().decode("d4398adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getPrice).reversed());
        } else {
            System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9776b07167af1e0a0121a"));
            return;
        }
        showAllGoods();
    }

    public static void sortByExpirationDate(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains(MyCipher.getInstance().decode("d9328adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getExpirationDate));
        } else if (sortType.contains(MyCipher.getInstance().decode("d4398adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getExpirationDate).reversed());
        } else {
            System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9776b07167af1e0a0121a"));
            return;
        }
        showAllGoods();
    }

    public static void sortByQuantity(String sortType) {
        sortType = sortType.trim();
        if (sortType.contains(MyCipher.getInstance().decode("d9328adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getQuantity));
        } else if (sortType.contains(MyCipher.getInstance().decode("d4398adbf679ae3e660f"))) {
            inventory.sort(Comparator.comparing(Product::getQuantity).reversed());
        } else {
            System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9776b07167af1e0a0121a"));
            return;
        }
        showAllGoods();
    }

    public static void showOutOfDateGoods() {
        String currentTime = MyCipher.getInstance().encode((DateTimeFormatter.ofPattern(MyCipher.getInstance().decode("c92590d0be55907a6c0c"))).format(LocalDateTime.now()));
        System.out.println(MyCipher.getInstance().decode("f3299bdbf676a9776c090f72b0e7b712bf53") + MyCipher.getInstance().decode(currentTime));
        for (Product product : inventory)
            if (product.getExpirationDate().compareTo(MyCipher.getInstance().decode(currentTime)) < Integer.parseInt(MyCipher.getInstance().decode("80")))
                System.out.printf(MyCipher.getInstance().decode("952fc993b33dae0b66"), product.getProductName(), product.getExpirationDate());
    }

    public static void showTotalValue() {
        String total = "80";
        for (Product product : inventory)
            total = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(total)) + product.getPrice());
        System.out.println(Integer.parseInt(MyCipher.getInstance().decode(total)));
    }

    public static void showAllGoods() {
        if (inventory.isEmpty())
            System.out.println(MyCipher.getInstance().decode("f9329fccfd6cb22571481264b0eba94246fd5fe3"));
        else
            for (Product product : inventory)
                product.printOut();
    }

    public static void addProducts(ArrayList<Product> products) {
        for (Product product : products) {
            Product byName = getProductByName(product.getProductName());
            if (byName == null)
                inventory.add(product);
            else {
                byName.setPrice(byName.getPrice() + product.getPrice());
                byName.setQuantity(byName.getQuantity() + product.getQuantity());
            }
        }
    }

    public static Product getProductByName(String name) {
        for (Product product : inventory) {
            if (product.getProductName().equals(name))
                return product;
        }
        return null;
    }

    public static void handleSellReceipt(ArrayList<Product> sellProducts) {
        for (Product sellProduct : sellProducts)
            handleSellAction(sellProduct);
    }

    public static void handleSellAction(Product product) {
        Product byName = getProductByName(product.getProductName());
        if (byName == null)
            System.out.println(MyCipher.getInstance().decode("e02e86cde67ba977") + product.getProductName()
                    + MyCipher.getInstance().decode("902987c8e579b43b690a1772b0e7aa122cf688b976916ebb6fb74ab41ede110cd21a5fe7054304c6cac588571782719a17f81701555713ec1c"));
        else if (byName.getQuantity() < product.getQuantity())
            System.out.println(MyCipher.getInstance().decode("e02e86cde67ba977") + product.getProductName()
                    + MyCipher.getInstance().decode("90359a89f26ebc3e6409197bf5aea64757c939cdd710b56c02c5af22f914ea2d476257146c86b1f7c2223e661c13af69c9c9c44c84158d973ee9be43"));
        else if (byName.getQuantity() >= product.getQuantity()) {
            byName.setQuantity(byName.getQuantity() - product.getQuantity());
            System.out.println(MyCipher.getInstance().decode("e02e86cde67ba977") + product.getProductName() + MyCipher.getInstance().decode("902c9bc6f07dae246d0c5b76feeae45b15fd5d794884fed3a266747d45a6ac21ea5a439be5becab76b81"));
        }
    }
}
