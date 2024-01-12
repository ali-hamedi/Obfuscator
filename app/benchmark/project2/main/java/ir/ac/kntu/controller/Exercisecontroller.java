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
            scoreTable.put(u, 0);
        }
        e.setScoreTable(scoreTable);
        Global.currentCourse.getExercsies().add(e);
        return "Exercise was created Successfully";
    }

    public static String deleteExercise(Exercise e) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            int flag = -1;
            for (int i = 0; i < Global.currentCourse.getExercsies().size(); i++) {
                if (Global.currentCourse.getExercsies().get(i).equals(e)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentCourse.getExercsies().remove(flag);
                return "Exercise deleted successfully for every body ";
            }
            return "Exercise not found";
        }
        return "You are not the owner";
    }

    public static String modifyExercise(Exercise oldExercise, Exercise newExercise) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            int flag = -1;
            for (int i = 0; i < Global.currentCourse.getExercsies().size(); i++) {
                if (Global.currentCourse.getExercsies().get(i).equals(oldExercise)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentCourse.getExercsies().set(flag, newExercise);
                return "Exercise successfully edited  for every body ";
            }
            return "Exercise not found";
        }
        return "You are not the owner";
    }

    public static String getScoreTable(Exercise e) {
        LinkedHashMap<User, Integer> sortedMap = new LinkedHashMap<User, Integer>();
        e.getScoreTable().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        String str = "";
        for (User u : sortedMap.keySet()) {
            str += u.getName() + " -> " + sortedMap.get(u) + "\n";
        }
        return str;
    }

    public static void increaseScoreTable(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            HashMap<User, Integer> scoreTable = e.getScoreTable();
            scoreTable.put(u, 0);
            e.setScoreTable(scoreTable);
        }
    }

    public static void updateScoreTable() {
        HashMap<User, Integer> scoreTable = new HashMap<User, Integer>();
        for (User u : Global.currentExercise.getScoreTable().keySet()) {
            int userTotalPoints = 0;
            for (Question q : Global.currentExercise.getQuestions()) {
                userTotalPoints += q.getUsersPoint().get(u);
            }
            scoreTable.put(u, userTotalPoints);
        }
        Global.currentExercise.setScoreTable(scoreTable);
    }

}
