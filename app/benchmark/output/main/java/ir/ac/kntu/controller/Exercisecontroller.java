package ir.ac.kntu.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Exercisecontroller {

    public static String createExercise(Exercise e) {
        HashMap<User, Integer> scoreTable = new HashMap<User, Integer>();
        for (User u : Global.currentCourse.getAttendence()) {
            scoreTable.put(u, Integer.parseInt(MyCipher.getInstance().decode("b0")));
        }
        e.setScoreTable(scoreTable);
        Global.currentCourse.getExercsies().add(e);
        return MyCipher.getInstance().decode("c556f671323ed483f7a4d284669241314d59e9886f7fdb71b6e64b9f1ca7e13208");
    }

    public static String deleteExercise(Exercise e) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentCourse.getExercsies().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentCourse.getExercsies().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(e)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentCourse.getExercsies().remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
                return MyCipher.getInstance().decode("c556f671323ed483f7b7d69b2385563001304819dc9dd4aae75e084237304418a0e32f908fcd32006f6da75dd6");
            }
            return MyCipher.getInstance().decode("c556f671323ed483f7bddc8366975c21bc0f");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String modifyExercise(Exercise oldExercise, Exercise newExercise) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentCourse.getExercsies().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentCourse.getExercsies().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(oldExercise)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentCourse.getExercsies().set(Integer.parseInt(MyCipher.getInstance().decode(flag)), newExercise);
                return MyCipher.getInstance().decode("c556f671323ed483f7a0c6942594402749abd93c29e92e2880c7550d03b496fe85fb2524072163d968e0573f27");
            }
            return MyCipher.getInstance().decode("c556f671323ed483f7bddc8366975c21bc0f");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String getScoreTable(Exercise e) {
        LinkedHashMap<User, Integer> sortedMap = new LinkedHashMap<User, Integer>();
        e.getScoreTable().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        String str = "";
        for (User u : sortedMap.keySet()) {
            str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + u.getName()+MyCipher.getInstance().decode("a003ad23")+sortedMap.get(u)+MyCipher.getInstance().decode("dc40"));
        }
        return MyCipher.getInstance().decode(str);
    }

    public static void increaseScoreTable(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            HashMap<User, Integer> scoreTable = e.getScoreTable();
            scoreTable.put(u, Integer.parseInt(MyCipher.getInstance().decode("b0")));
            e.setScoreTable(scoreTable);
        }
    }

    public static void updateScoreTable() {
        HashMap<User, Integer> scoreTable = new HashMap<User, Integer>();
        for (User u : Global.currentExercise.getScoreTable().keySet()) {
            String userTotalPoints = "b0";
            for (Question q : Global.currentExercise.getQuestions()) {
                userTotalPoints = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(userTotalPoints)) + q.getUsersPoint().get(u));
            }
            scoreTable.put(u, Integer.parseInt(MyCipher.getInstance().decode(userTotalPoints)));
        }
        Global.currentExercise.setScoreTable(scoreTable);
    }

}
