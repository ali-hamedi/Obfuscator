package ir.ac.kntu.controller;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Usercontroller {

    public static String register(String name, String userName, String email, String password, long nationalCode,
            long phone) {
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.users.size(); i = i + 1) {
            if (Main.decode(email).equals(Database.users.get(Integer.parseInt(Main.decode(i))).getEmail())) {
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcri44AunQsyuFMjfNPTKq10B/lj9lWq3cVGHeoVd5Cw3kpW9HDPFL3xrEcJ1o2A==");
            }
            if (Main.decode(userName).equals(Database.users.get(Integer.parseInt(Main.decode(i))).getUserName())) {
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcri44AvnOtzCnczPbPToz/NWjgZTgIo2PUtgaQOxm");
            }
        }
        User newUser = new User(name, userName, email, password, nationalCode, phone);
        Database.users.add(newUser);
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPdtSI5AvvcoWKKYDvfaTaOkHgbXwD7WpL80kjLOVA7");
    }

    public static String login(String email, String password) {
        String emailFaound = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Database.users.size(); i = i + 1) {
            if (Main.decode(email).equals(Database.users.get(Integer.parseInt(Main.decode(i))).getEmail())) {
                emailFaound = i;
            }
        }
        if (Integer.parseInt(Main.decode(emailFaound)) == -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPdtSI5AuLSpmKPfSvQeXGk6JFcjMJsMeFEgQmW3BCt");
        } else {
            if (!Main.decode(password).equals(Database.users.get(Integer.parseInt(Main.decode(emailFaound))).getPasswrod())) {
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcriJrUu3OoTWGYDqedCChhT+JDt4s3PVruZ2pOPqZ");
            } else {
                Global.currentUser = Database.users.get(Integer.parseInt(Main.decode(emailFaound)));
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLqSksUO3JoWKQfSuecTyZf+MFZ2Sh0Rcr5fbikLqdbg6vqi7cT6pcOZVeHDp7Qw==");
            }
        }
    }

}
