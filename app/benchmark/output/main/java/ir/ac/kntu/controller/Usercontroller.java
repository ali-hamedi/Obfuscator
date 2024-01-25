package ir.ac.kntu.controller;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Usercontroller {

    public static String register(String name, String userName, String email, String password, long nationalCode,
            long phone) {
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.users.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            if (email.equals(Database.users.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getEmail())) {
                return MyCipher.getInstance().decode("d446fa707132ca87bebf939e35d1523801d5db9a65b0637424071b86f4b928");
            }
            if (userName.equals(Database.users.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getUserName())) {
                return MyCipher.getInstance().decode("d446fa707122d483a59dd29a23d15a27783bf0f1df4e");
            }
        }
        User newUser = new User(name, userName, email, password, nationalCode, phone);
        Database.users.add(newUser);
        return MyCipher.getInstance().decode("d55df6717120c695f7b0c19227855630428d346b44ae6324aca5c2def1");
    }

    public static String login(String email, String password) {
        String emailFaound = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.users.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            if (email.equals(Database.users.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getEmail())) {
                emailFaound = i;
                System.out.println(password);
            }
        }
        if (Integer.parseInt(MyCipher.getInstance().decode(emailFaound)) == -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            return MyCipher.getInstance().decode("d55df6717139c892f7b5dc822895");
        } else {
            if (!password.equals(Database.users.get(Integer.parseInt(MyCipher.getInstance().decode(emailFaound))).getPasswrod())) {
                return MyCipher.getInstance().decode("d446f6232136d495a0bcc193669840742f2b3cb7e2ffa44136");
            } else {
                Global.currentUser = Database.users.get(Integer.parseInt(MyCipher.getInstance().decode(emailFaound)));
                return MyCipher.getInstance().decode("c341fd642336d395f7aadc82669d5c3346ff0237d4de88295d9dddffbc7d9aa21d");
            }
        }
    }

}
