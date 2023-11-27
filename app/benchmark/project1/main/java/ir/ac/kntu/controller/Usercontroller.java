package ir.ac.kntu.controller;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;

public class Usercontroller {

    public static String register(String name, String userName, String email, String password, long nationalCode,
            long phone) {
        for (int i = 0; i < Database.users.size(); i++) {
            if (email.equals(Database.users.get(i).getEmail())) {
                return "This email is already registerd";
            }
            if (userName.equals(Database.users.get(i).getUserName())) {
                return "This userName is taken";
            }
        }
        User newUser = new User(name, userName, email, password, nationalCode, phone);
        Database.users.add(newUser);
        return "User was created successfully";
    }

    public static String login(String email, String password) {
        int emailFaound = -1;
        for (int i = 0; i < Database.users.size(); i++) {
            if (email.equals(Database.users.get(i).getEmail())) {
                emailFaound = i;
            }
        }
        if (emailFaound == -1) {
            return "User not found";
        } else {
            if (!password.equals(Database.users.get(emailFaound).getPasswrod())) {
                return "The password is incorrect";
            } else {
                Global.currentUser = Database.users.get(emailFaound);
                return "Congrats you logined successfully";
            }
        }
    }

}
