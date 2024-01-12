package ir.ac.kntu.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;

public class Exercisecontroller {

    public static String createExercise(Exercise e) {
        HashMap<User, Integer> scoreTable = new HashMap<User, Integer>();
        for (User u : Global.currentCourse.getAttendence()) {
            scoreTable.put(u, Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
        }
        e.setScoreTable(scoreTable);
        Global.currentCourse.getExercsies().add(e);
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNviI5QeXOt2Kecy2efiGiUkZETp8cWURMR0AhV8sh36uDZW+z2pU6xcSjmgys1w==");
    }

    public static String deleteExercise(Exercise e) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentCourse.getExercsies().size(); i = i + 1) {
                if (Global.currentCourse.getExercsies().get(Integer.parseInt(Main.decode(i))).equals(e)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentCourse.getExercsies().remove(Integer.parseInt(Main.decode(flag)));
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNviI5QeXOt2KNdzLbaTYghvF1G2uV0/ORGT9fOCcMjZcAWJOahCP5ThD2v8geYQ==");
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNviI5QeXOt2KHfSqeezzt3KPUgJ/yE5yb/d/SNIB0");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String modifyExercise(Exercise oldExercise, Exercise newExercise) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < Global.currentCourse.getExercsies().size(); i = i + 1) {
                if (Global.currentCourse.getExercsies().get(Integer.parseInt(Main.decode(i))).equals(oldExercise)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentCourse.getExercsies().set(Integer.parseInt(Main.decode(flag)), newExercise);
                return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNviI5QeXOt2KaZz3deCDHoAjDNeXArTT8BFOB7b5Ms8lY5VG8yKqRMJ8yoqyLNw==");
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNviI5QeXOt2KHfSqeezzt3KPUgJ/yE5yb/d/SNIB0");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String getScoreTable(Exercise e) {
        LinkedHashMap<User, Integer> sortedMap = new LinkedHashMap<User, Integer>();
        e.getScoreTable().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        String str = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        for (User u : sortedMap.keySet()) {
            str = String.valueOf(Main.decode(str) + u.getName()+Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo63lrAIa32EjjGFS0F1k=")+sortedMap.get(u)+Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUqGVHLoCx3k7lHlKyEV8="));
        }
        return Main.decode(str);
    }

    public static void increaseScoreTable(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            HashMap<User, Integer> scoreTable = e.getScoreTable();
            scoreTable.put(u, Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
            e.setScoreTable(scoreTable);
        }
    }

    public static void updateScoreTable() {
        HashMap<User, Integer> scoreTable = new HashMap<User, Integer>();
        for (User u : Global.currentExercise.getScoreTable().keySet()) {
            String userTotalPoints = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
            for (Question q : Global.currentExercise.getQuestions()) {
                userTotalPoints = String.valueOf(Integer.parseInt(Main.decode(userTotalPoints)) + q.getUsersPoint().get(u));
            }
            scoreTable.put(u, Integer.parseInt(Main.decode(userTotalPoints)));
        }
        Global.currentExercise.setScoreTable(scoreTable);
    }

}
