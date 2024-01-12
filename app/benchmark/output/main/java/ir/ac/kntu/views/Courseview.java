package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Coursecontroller;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Courseview extends View {

    public static void addCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wY/VunTtmKIMj3RaCGtdAEyQg4lwWQPSwpzNR16"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wQ5R+3Jt2KIMj3RaCGFj+JWFddwtSlZOan+y2dM"));
        String attendOrTeach = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))) {
            createCourse();
        } else if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            attendCourse();
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqiIqUemdsSqGfS3bPTKi4qMI9wtWegSYO+sVf6EP"));
        }
    }

    public static void createCourse() {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo="));
        String name = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPBqDQ/S/jIpiuGfGScH1E="));
        String institution = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfGScH1E="));
        String description = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRoyY5GK6020vgG1e3FFo="));
        String year = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrVe3TpmKdejuefjxLt2cIdUkV+MdU+uRrLpRFk90dLuUCM9sLRXJXp+zuzg=="));
        String privacy = String.valueOf(sc.nextLine());
        String isPublic = "YWFhYWFhYWFhYWFhYWFhYTfpqjQuKYe22UniGVW1Flg=";
        if (Main.decode(privacy).equals(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPxozRpKYe22UniGVW1Flg="))) {
            isPublic = "YWFhYWFhYWFhYWFhYWFhYSX6syJHLoCx3k7lHlKyEV8=";
        }
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYpzQ4VePPtnjLF1u7GFY="));
        String password = String.valueOf(sc.nextLine());
        Course newCourse = new Course(Main.decode(name), Main.decode(description), Main.decode(institution), Global.currentUser, Integer.parseInt(Main.decode(year)), true, Boolean.parseBoolean(Main.decode(isPublic)),
                Main.decode(password));
        showResult(Coursecontroller.addTeachingCourses(newCourse));
    }

    public static void attendCourse() {
        ArrayList<Course> arr = Coursecontroller.getAvailbaleCourses();
        showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cnoEB/56C15LSwTYSjZXg=="));
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            if (!arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).isPublic()) {
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzJuifJcTHLbyBuDX7oOGyAzE+oe7BkGIEb"));
                String pass = String.valueOf(sc.nextLine());
                if (arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getPassword().equals(Main.decode(pass))) {

                    showResult(Coursecontroller.addAttendedCourses(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
                } else {
                    showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcriJrUu3OoTWGYDqedCChhT+JDt4s3PVruZ2pOPqZ"));
                }
            } else {
                showResult(Coursecontroller.addAttendedCourses(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
            }
        }
    }

    public static void addUser() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cnoEB/56C15LSwTYSjZXg=="));
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzJuifJZy3bbz1NWIuXsSKCAVHOErk29714Ak+DbQl2x/1tiRLrSKNDEC/RhAX8t111mCUwqGc3XbA="));
            String userName = String.valueOf(sc.nextLine());
            String flag = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
            for (User u : Database.users) {
                if (u.getUserName().equals(Main.decode(userName))) {
                    flag = flag + 1;
                    showResult(Coursecontroller.addUserToCourse(u, arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
                }
            }
            if (Integer.parseInt(Main.decode(flag)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPdtSI5AuLSpmKPfSvQeXGk6JFcjMJsMeFEgQmW3BCt"));
            }
        }
    }

    public static void deleteCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wY/VunTtieNMj3RaCE/4mmFvyJF2NCy4Ffao21U"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wQ5R+3JtybJcTHLbyCuRGOYxSSwkDwxgj+vi0k3"));
        String attendOrTeach = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))) {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cnoEB/56C15LSwTYSjZXg=="));
            ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
                System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                showResult(Coursecontroller.deleteTeachingCourses(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
            }
        } else if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cnoEB/56C15LSwTYSjZXg=="));
            ArrayList<Course> arr = Global.currentUser.getAttendedCourses();
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
                System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                showResult(Coursecontroller.deleteAttendedCourses(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
            }
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqiIqUemdsSqGfS3bPTKi4qMI9wtWegSYO+sVf6EP"));
        }
    }

    public static void modifyCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0c34DQ63ti9LByIdbybXUA=="));
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {

            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPFqSMiRPWdpiqMMj3RaCHijaFvKoHPiPbjgVckEdL2"));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouAIa32EjjGFS0F1k="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getName() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String name = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPBqDQ/S/jIpiuGfHy9HlA="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuXToTaAZivKdDxJUlcnZXlu99480EdjFLOs") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getInstitution() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String institution = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfHy9HlA="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAujYoSGbey7KdDwrahpWrZLMG1MuCvth9ZRp") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getDescription() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String description = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRoyY5AIa32EjjGFS0F1k="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAvXYszDJZT/NPXO5YAMqmP7ePe73xnFLrAdq") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getYear() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String year = String.valueOf(Integer.parseInt(sc.nextLine()));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrVe3TpmKdejuefjxLt2cIdUkV+MdU+uRrLpRFk8UzCJJpTvprJFV7rebkxA=="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAv/UpjeIZjfRc3PMUwoLRERkoBqgJlX1tzcT") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).isPublic() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String isPublic = String.valueOf(Boolean.parseBoolean(sc.nextLine()));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYpzQ4VePPtmDvFFi4G1U="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAvzcoTGefSzaPSRfl5+7aRt1KGSZFKDbU5yZ") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getPassword() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String password = String.valueOf(sc.nextLine());
            Course newCourse = new Course(Main.decode(name), Main.decode(description), Main.decode(institution), Global.currentUser, Integer.parseInt(Main.decode(year)), true,
                    Boolean.parseBoolean(Main.decode(isPublic)),
                    Main.decode(password));

            showResult(Coursecontroller.modifyCourse(newCourse, arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }

    public static void chooseCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wY/VunTtieNMn7dciZVZF6EXNl60Nv3+XFZSXW8"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wQ5R+3JtybJMj3RaCHoQCY3AzHKuZArsfaquIR8"));
        String attendOrTeach = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPJsjMuTOjYtmKqfSvMbjaNLFq+uhjx+VDygMOTH+0l"));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getAttendedCourses().size(); i = i + 1) {
                showResult(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + Global.currentUser.getAttendedCourses().get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || Global.currentUser.getAttendedCourses().size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                    || Integer.parseInt(Main.decode(n)) > Global.currentUser.getAttendedCourses().size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                Global.currentCourse = Global.currentUser.getAttendedCourses().get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            }
        } else if (Integer.parseInt(Main.decode(attendOrTeach)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcoyYoSuXTtWKqfSvMbjYUdAg6/cwpgVjBSjTepLPf"));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentUser.getTeachingCourses().size(); i = i + 1) {
                showResult(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || Global.currentUser.getTeachingCourses().size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                    || Integer.parseInt(Main.decode(n)) > Global.currentUser.getTeachingCourses().size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                Global.currentCourse = Global.currentUser.getTeachingCourses().get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            }
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqiIqUemdoiuKeX7fPSXyckZrNxOhmEgQUHZ3tgbX"));
        }
    }

    public static void closeCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cvwCwnyti9LByIdbybXUA=="));
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (c.isOpen()) {
                arr.add(c);
            }
        }
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Coursecontroller.closeCourse(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }

    public static void opeanCourse() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaefjxfbueJjQF7VTA2kHTfq3tR0cfsARS3+GJjf193C0e8YqVz/HRzu+d+n7ZUf9PC8f4="));
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (!c.isOpen()) {
                arr.add(c);
            }
        }
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Coursecontroller.openCourse(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }

}
