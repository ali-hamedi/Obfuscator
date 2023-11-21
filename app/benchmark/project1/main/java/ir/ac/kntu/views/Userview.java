package app.benchmark.project1.main.java.ir.ac.kntu.views;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Usercontroller;

public class Userview extends View {

    public static void register() {
        if (Global.currentUser == null) {
            System.out.print("Name:");
            String name = sc.nextLine();
            System.out.print("User Name:");
            String userName = sc.nextLine();
            System.out.print("Email addres:");
            String email = sc.nextLine();
            System.out.print("Password:");
            String password = sc.nextLine();
            System.out.print("Phone Number:");
            long phone = Long.parseLong(sc.nextLine());
            System.out.print("National Code:");
            long nationalCode = Long.parseLong(sc.nextLine());
            showResult(Usercontroller.register(name, userName, email, password,
                    nationalCode, phone));
        } else {
            showResult("You Should log out first");
        }
    }

    public static void login() {
        if (Global.currentUser == null) {
            System.out.println("Now Login please");
            System.out.print("Email addres:");
            String email = sc.nextLine();
            System.out.print("Your Password:");
            String password = sc.nextLine();
            showResult(Usercontroller.login(email, password));
        } else {
            showResult("You Should log out first");
        }
    }

}
