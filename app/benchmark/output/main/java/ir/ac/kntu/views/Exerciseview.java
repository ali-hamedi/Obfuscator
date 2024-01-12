package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Calendar;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Exercisecontroller;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Exerciseview extends View {

    public static void createExercise() {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo="));
        String name = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfGScH1E="));
        String description = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPbsiY5VqzwvSydemScH1E="));
        String month = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPbsiY5Vqz5szvTMFq6GVc="));
        String day = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMoyYvTuXTt2KFdzDZaTutpdwBTuudozRm1tYdF/cV"));
        String length = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMoyYvTuXTt2KFdzDZaTutpdwBTuudoy4ltqR+Y9F/pR76BU4PNYs50v3TaWNjBw=="));
        String latencyDuration = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrVe3TpmKdejueWCttHNlzxvmG2onNGzpmZVv3osOLn56lSj6qgxgqvxhyuA=="));
        String beta = String.valueOf(sc.nextLine());
        String isBeta = "YWFhYWFhYWFhYWFhYWFhYTfpqjQuKYe22UniGVW1Flg=";
        if (Main.decode(beta).equals(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPxozRpKYe22UniGVW1Flg="))) {
            isBeta = "YWFhYWFhYWFhYWFhYWFhYSX6syJHLoCx3k7lHlKyEV8=";
        }
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPEpzMuTO/E8hCIZjfRJ3Ha1/5fM9u0r9eKEidy8Nq+"));
        String lateRatio = String.valueOf(Double.parseDouble(sc.nextLine()));
        Exercise e = new Exercise(Main.decode(name), Main.decode(description), new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day))),
                new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day)) + Integer.parseInt(Main.decode(length))),
                new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day)) + Integer.parseInt(Main.decode(length)) + Integer.parseInt(Main.decode(latencyDuration))), Boolean.parseBoolean(Main.decode(isBeta)),
                Double.parseDouble(Main.decode(lateRatio)));
        showResult(Exercisecontroller.createExercise(e));
    }

    public static void deleteExercise() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaeeCuAmWNuR4l6mpTkdBiu7/Je7VZzgOKLk/2MpMOFRNti/Q=="));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Exercisecontroller.deleteExercise(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }

    public static void modifyExercise() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaeeCuAmWNuR4l6mpTkdBiu7/Je7VdyhfPF1M6nqs2LStVs8w=="));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPFqSMiRPWdpiqMMjvGeCHLQw3v6aYjqMVD6thA7fA3"));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouAIa32EjjGFS0F1k=") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getName() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String name = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfGScH1E=") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getDescription() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String description = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPbsiY5VqzwvSydemScH1E="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getStartTime().getMonth() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String month = String.valueOf(Integer.parseInt(sc.nextLine()));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPbsiY5Vqz5szvTMFq6GVc=") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getStartTime().getDay() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String day = String.valueOf(Integer.parseInt(sc.nextLine()));
            String number1 = String.valueOf(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getEndTime().getDay() - arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getStartTime().getDay());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMoyYvTuXTt2KFdzDZaTutpdwBTuudozRm1tYdF/cV") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + Integer.parseInt(Main.decode(number1)) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String length = String.valueOf(Integer.parseInt(sc.nextLine()));
            String number2 = String.valueOf(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getEndTimeAfterLatency().getDay() - arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getEndTime().getDay());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMoyYvTuXTt2KFdzDZaTutpdwBTuudoy4ltqR+Y9F/pR76BU4PNYs50v3TaWNjBw==") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + Integer.parseInt(Main.decode(number2)) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String latencyDuration = String.valueOf(Integer.parseInt(sc.nextLine()));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrVe3TpmKdejueWCttHNlzxvmG2onNGzpmZVv3osOB6/bbaF3IpzcitxB6sA==") + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).isBeta() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String beta = String.valueOf(sc.nextLine());
            String isBeta = "YWFhYWFhYWFhYWFhYWFhYTfpqjQuKYe22UniGVW1Flg=";
            if (Main.decode(beta).equals(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPxozRpKYe22UniGVW1Flg="))) {
                isBeta = "YWFhYWFhYWFhYWFhYWFhYSX6syJHLoCx3k7lHlKyEV8=";
            }
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPEpzMuTO/E8hCIZjfRJ3Ha1/5fM9u0r9eKEidy8Nq+"));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn") + arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getLateRatio() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String lateRatio = String.valueOf(Double.parseDouble(sc.nextLine()));
            Exercise newExercise = new Exercise(Main.decode(name), Main.decode(description),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day))),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day)) + Integer.parseInt(Main.decode(length))),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(Main.decode(month)), Integer.parseInt(Main.decode(day)) + Integer.parseInt(Main.decode(length)) + Integer.parseInt(Main.decode(latencyDuration))), Boolean.parseBoolean(Main.decode(isBeta)),
                    Double.parseDouble(Main.decode(lateRatio)));
            showResult(Exercisecontroller.modifyExercise(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))), newExercise));
        }
    }

    public static void chooseExercise() {
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR);
        today.clear(Calendar.MINUTE);
        today.clear(Calendar.SECOND);
        // java.util.Date todayDate = today.getTime();
        ArrayList<Exercise> arr = new ArrayList<Exercise>();
        for (Exercise e : Global.currentCourse.getExercsies()) {
            if (!Global.currentCourse.getTeacher().equals(Global.currentUser)) {
                // boolean compareDates = (todayDate.getYear() >
                // e.getEndTimeAfterLatency().getYear()
                // | todayDate.getMonth() > e.getEndTimeAfterLatency().getMonth()
                // || todayDate.getDay() > e.getEndTimeAfterLatency().getDay());
                if (!e.isBeta()) {
                    arr.add(e);
                }
            } else {
                arr.add(e);
            }
        }

        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            showResult(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")) || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            Global.currentExercise = arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
        }
    }

    public static void getScoreTable() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kblWaikA5Yum7RM"));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr.size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i)) + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=") + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        showResult(Exercisecontroller.getScoreTable(arr.get(Integer.parseInt(Main.decode(n)) - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));

    }
}
