package ir.ac.kntu.controller;

import ir.ac.kntu.data.db.Questionbank;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.Global;

import java.util.ArrayList;
import java.util.HashMap;

public class Questioncontroller {
    public static String createQuestion(Question q) {
        HashMap<User, ArrayList<String>> submitsList = new HashMap<User, ArrayList<String>>();
        HashMap<User, String> finalSubmitList = new HashMap<User, String>();
        for (User u : Global.currentCourse.getAttendence()) {
            submitsList.put(u, new ArrayList<String>());
            finalSubmitList.put(u, "");
        }
        q.setSubmitsList(submitsList);
        q.setFinalSubmitList(finalSubmitList);
        Global.currentExercise.getQuestions().add(q);
        return "Question added Successfully";
    }

    public static String addQuestionToBank(Question q) {
        Questionbank.quesiton.add(q);
        return "The question has added to the bank successfully";
    }

    public static String addQuestionFromBank(Question q) {
        Global.currentExercise.getQuestions().add(q);
        return "The question has added to Your exercise successfully";
    }

    public static String deleteQuestion(Question q) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            int flag = -1;
            for (int i = 0; i < Global.currentExercise.getQuestions().size(); i++) {
                if (Global.currentExercise.getQuestions().get(i).equals(q)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentExercise.getQuestions().remove(flag);
                return "Question deleted successfully for every body ";
            }
            return "Question not found.";
        }
        return "You are not the owner";
    }

    public static String modifyQuestion(Question oldQuestion, Question newQuestion) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            int flag = -1;
            for (int i = 0; i < Global.currentExercise.getQuestions().size(); i++) {
                if (Global.currentExercise.getQuestions().get(i).equals(oldQuestion)) {
                    flag = i;
                }
            }
            if (flag != -1) {
                Global.currentExercise.getQuestions().set(flag, newQuestion);
                return "Question successfully edited  for every body ";
            }
            return "Question not found";
        }
        return "You are not the owner";
    }

    public static String answerQuestion(Question q, String answer) {
        q.getUsersPoint().put(Global.currentUser, 0);
        if (q.getType() == Type.MultiCoice || q.getType() == Type.BlankSpace) {
            if (q.getAnswer().equals(answer)) {
                q.getUsersPoint().put(Global.currentUser, q.getPoint());
            }
        }
        ArrayList<String> arr = q.getSubmitsList().get(Global.currentUser);
        if (arr == null) {
            arr = new ArrayList<String>();
        }
        arr.add(answer);
        q.getFinalSubmitList().put(Global.currentUser, answer);
        Exercisecontroller.updateScoreTable();
        return "your answer has been submitted succefully";
    }

    public static String gradeQuestion(Question q, User u, int points) {
        q.getUsersPoint().put(u, points);
        Exercisecontroller.updateScoreTable();
        return "the user points of this question has been submitted";
    }

    public static String modifyLastSubmit(Question q, String lastSubmit) {
        q.getFinalSubmitList().put(Global.currentUser, lastSubmit);
        q.getUsersPoint().put(Global.currentUser, 0);
        if (q.getType() == Type.MultiCoice || q.getType() == Type.BlankSpace) {
            if (q.getAnswer().equals(lastSubmit)) {
                q.getUsersPoint().put(Global.currentUser, q.getPoint());

            }
        }
        Exercisecontroller.updateScoreTable();
        return "you have changed your last submit successfully";
    }

    public static String getSubmits(Question q, User u) {
        String str = "";
        for (int i = 0; i < q.getSubmitsList().get(u).size(); i++) {
            str += i + 1 + ":" + q.getSubmitsList().get(u).get(i) + " ";
        }
        str += "(Final submit was: " + q.getFinalSubmitList().get(u) + " )";
        return str;
    }

    public static String getSubmitsAndPoints(Question q) {
        String str = "";
        for (User u : q.getUsersPoint().keySet()) {
            str += "user: " + u.getName() + " ,last submit:" + q.getFinalSubmitList().get(u) + " -> "
                    + q.getUsersPoint().get(u);
        }
        return str;
    }

    public static void increseLists(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, "");
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, 0);
            }
        }
    }
    public static void mmdhos(Course c,User u,Question q){
                for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, "");
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, 0);
            }
        }
    }

    public static Type getQuestionTypeByInt(int type) {
        Type typ;
        switch (type) {
            case 1:
                typ = Type.BlankSpace;
                break;
            case 2:
                typ = Type.Descriptive;
                break;
            default:
                typ = Type.MultiCoice;
                break;
        }
        return typ;
    }

    public static Difficulty getQuestionDifficultyByInt(int difficulty) {
        Difficulty diff;
        switch (difficulty) {
            case 1:
                diff = Difficulty.Easy;
                break;
            case 2:
                diff = Difficulty.Medium;
                break;
            case 3:
                diff = Difficulty.Hard;
                break;
            default:
                diff = Difficulty.VeryHard;
                break;
        }
        return diff;
    }

}
