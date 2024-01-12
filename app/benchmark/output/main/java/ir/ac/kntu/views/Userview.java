package ir.ac.kntu.views;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Usercontroller;
import ir.ac.kntu.Main;

public class Userview extends View {

    public static void register() {
        if (Global.currentUser == null) {
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo="));
            String name = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPdtSI5AsLcvyfTMFq6GVc="));
            String userName = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqyYiTqzctiabdy2EP1I="));
            String email = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYpzQ4VePPtnjLF1u7GFY="));
            String password = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYriglR6zzpy+LdyyEP1I="));
            String phone = String.valueOf(Long.parseLong(sc.nextLine()));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpzMiTeLcvmKqfTrbJ3GL5K7DfwQO7zXZDYIuU4Ck"));
            String nationalCode = String.valueOf(Long.parseLong(sc.nextLine()));
            showResult(Usercontroller.register(Main.decode(name), Main.decode(userName), Main.decode(email),
                    Main.decode(password),
                    Long.parseLong(Main.decode(nationalCode)), Long.parseLong(Main.decode(phone))));
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrceTSpy6NMjLRenMFLtNS2qZuAgD4qvkZvKUO"));
        }
    }

    public static void login() {
        if (Global.currentUser == null) {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGqTBrbuPauyzJYjLbfCC9rihOabAEGZaJDd+tU+n3"));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqyYiTqzctiabdy2EP1I="));
            String email = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTI5AtzcoTGefSzaJ3GcF/EjwFydSaUYGGZXJl8y"));
            String password = String.valueOf(sc.nextLine());
            showResult(Usercontroller.login(Main.decode(email), Main.decode(password)));
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrceTSpy6NMjLRenMFLtNS2qZuAgD4qvkZvKUO"));
        }
    }

}
