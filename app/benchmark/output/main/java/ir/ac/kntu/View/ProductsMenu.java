package ir.ac.kntu.View;

import ir.ac.kntu.Controllers.ProductController;
import ir.ac.kntu.JsonGenerator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ir.ac.kntu.MyCipher;


public class ProductsMenu extends Menu {

    Pattern backPattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab95abc3463342764baaa"));
    Pattern categorizePattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab95bbc236d0f1465f9f4a11295730b08840c581aec1746d11cf9729fffd223d945f2aa7c955c4378683732dbbe460b6be1e3cee4a4fc5e2347b2cf4574e00e90"));
    Pattern sortByPricePattern = Pattern.compile(MyCipher.getInstance().decode("ee0f86dbe738bf2e2818097ef3ebe41a4043588de54671e123f3cba17de7df44ba80de6681b600"));
    Pattern sortByExpirationDatePattern = Pattern.compile(MyCipher.getInstance().decode("ee0f86dbe738bf2e280d0367f9fca5466fc8bedd6c531ed5a60125a8e0e6b591c712903d297e07b0de9651dca1663fbd5f"));
    Pattern sortByQuantityPattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab94bb2257c48196eb0ffb1531dc586e5cd285b8611e8ec0976d0c54072fe125fe70b362bd9f57e1184e51a00a24a"));
    Pattern sortOutOfDatePattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab94bb5387f481462e4aeab54285b5924d427caa2022d03487883d89b"));
    Pattern showTotalValuePattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab94bb5387f480f78e4efa8129b681f93ee15ff208eed"));
    Pattern showAllGoodsPattern = Pattern.compile(MyCipher.getInstance().decode("ee00b5dab94bb5387f481a7bfcaea35ddc17fbcfcf25a419"));

    @Override
    public void run(Scanner scanner, JsonGenerator jsonGenerator) {
        while (true) {
            System.out.println(MyCipher.getInstance().decode("f33384c4f276b92428041264e4aefe"));
            System.out.println(MyCipher.getInstance().decode("f23d8ac2b338fd7728485b37b0aee4128a8ab95d5097bb4aa6b1d10b73eb391507849817abec538e1ee64740c6a065fd486814120962d4227c90e5fc56e646dade4d5d39"));
            System.out
                    .println(MyCipher.getInstance().decode("f33d9dccf477af3e720d5b75e9aeb04b509d4ad389c28786e2e022e3903271ae02f4d6b6c04bd43b6c62e40294bd4c1147dfaa8c39afcb9dd4f9ec821891fbe81c8a49a6aaf42d77145a2cd9bb7438f065901436f48a"));
            System.out.println(
                    MyCipher.getInstance().decode("e3339bddb37aa477781a1274f5aef85b77ed8e9d6e639f55c047a7e322deec1e5e3e31b41848bbce0028ccb1420da7946beef6dd92229618e4c752d63a1cbefe743d335b1179fc44dad25b20ba3abdebe2c8a443e68345db61eeb4d4aeef2d7b94c8"));
            System.out.println(
                    MyCipher.getInstance().decode("e3339bddb37aa4776d100b7ee2efb05b355dba63c04a0b780b1deca4fb4f61a294c9a7aacd6c0f0dd9682291f117289e518808d9158ce917a873d5e1655e1541f17bf08537dadb55132e639ca4286718f99d85df46ccb1cc9075f70d33eb947a7623"));
            System.out.println(
                    MyCipher.getInstance().decode("e3339bddb37aa477791d1a79e4e7b04b119e7104de19e250f79667f2b57ee0dfd349fdf377502755ca053fca1190d7d7b2ef8d4bc5a04ddaaa36954d57f099bb1b2d29dbb8f0a380d38588bd5157f4d4ebaa8f5552b09d38"));
            System.out.println(MyCipher.getInstance().decode("e33486deb377a82328071d37f4efb05724a83eccad54f1cf8b404b0064f96b549c61f96a92740a623cbf1eb92bb5eff51714afe3707acdc36d31018500fb53af865a38d9b52b2cd923d766dabd5d70"));
            System.out.println(MyCipher.getInstance().decode("e33486deb36cb22369045b61f1e2b157ca2b5317e757df6f35526829c6ce60b45fc4874103a67d8924e691c641f8cdec1b79532e3fd2cd080e098984d28282779034627a7f1271c4a0cc2f3ccefb8e7a"));
            System.out.println(MyCipher.getInstance().decode("e33486deb379b13b280f1478f4fde412a34450312f20ca9aa0820b3b199d74675f69cbba2038d489815b869807ad17b6440fb0976b89475fe1fbe3ba2aac653f369d65ae6142b952f5037640af96596010"));

            String input = MyCipher.getInstance().encode(scanner.nextLine());

            Matcher matcher;

            if (backPattern.matcher(MyCipher.getInstance().decode(input)).matches())
                return;

            else if ((matcher = categorizePattern.matcher(MyCipher.getInstance().decode(input))).matches())
                ProductController.categorizeByType(MyCipher.getInstance().decode(input).replace(MyCipher.getInstance().decode("f33d9dccf477af3e720d5b75e9aeb04b509d4a"), MyCipher.getInstance().decode("")));

            else if (sortByPricePattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.sortByPrice(MyCipher.getInstance().decode(input).replace(MyCipher.getInstance().decode("e3339bddb37aa477781a1274f5ae"), MyCipher.getInstance().decode("")));

            else if (sortByExpirationDatePattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.sortByExpirationDate(MyCipher.getInstance().decode(input).replace(MyCipher.getInstance().decode("e3339bddb37aa4776d100b7ee2efb05b355dba63c04a0b78"), MyCipher.getInstance().decode("")));

            else if (sortByQuantityPattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.sortByQuantity(MyCipher.getInstance().decode(input).replace(MyCipher.getInstance().decode("e3339bddb37aa477791d1a79e4e7b04b11"), MyCipher.getInstance().decode("")));

            else if (sortOutOfDatePattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.showOutOfDateGoods();

            else if (showTotalValuePattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.showTotalValue();

            else if (showAllGoodsPattern.matcher(MyCipher.getInstance().decode(input)).matches())
                ProductController.showAllGoods();

            else
                System.out.println(MyCipher.getInstance().decode("f9329fc8ff71b9776b07167af1e0a0121a"));

        }
    }
}
