package ir.ac.kntu.views;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Usercontroller;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Userview extends View {

    public static void register() {
        if (Global.currentUser == null) {
            System.out.print(MyCipher.getInstance().decode("ce4ffe666b"));
            String name = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d55df6717119c68bb2e9"));
            String userName = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c543f26a3d77c682b3a1d6847c"));
            String email = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d04fe0702638d582ed"));
            String password = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d046fc6d3477e993bab1d6857c"));
            String phone = MyCipher.getInstance().encode(Long.parseLong(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("ce4fe76a3e39c68af790dc9323cb"));
            String nationalCode = MyCipher.getInstance().encode(Long.parseLong(sc.nextLine()));
            showResult(Usercontroller.register(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(userName), MyCipher.getInstance().decode(email), MyCipher.getInstance().decode(password),
                    Long.parseLong(MyCipher.getInstance().decode(nationalCode)), Long.parseLong(MyCipher.getInstance().decode(phone))));
        } else {
            showResult(MyCipher.getInstance().decode("d941e623023fc893bbb7939b2996133bfbbd86ba2a79a844"));
        }
    }

    public static void login() {
        if (Global.currentUser == null) {
            System.out.println(MyCipher.getInstance().decode("ce41e4231d38c08fb9f3c39b23904031"));
            System.out.print(MyCipher.getInstance().decode("c543f26a3d77c682b3a1d6847c"));
            String email = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d941e6717107c695a4a4dc8522cb"));
            String password = MyCipher.getInstance().encode(sc.nextLine());
            showResult(Usercontroller.login(MyCipher.getInstance().decode(email), MyCipher.getInstance().decode(password)));
        } else {
            showResult(MyCipher.getInstance().decode("d941e623023fc893bbb7939b2996133bfbbd86ba2a79a844"));
        }
    }

}
