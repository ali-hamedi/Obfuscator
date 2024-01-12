package ir.ac.kntu.controller;

import ir.ac.kntu.data.db.Questionbank;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.Global;

import java.util.ArrayList;
import java.util.HashMap;
import ir.ac.kntu.Main;

public class Questioncontroller {
    public static String createQuestion(Question q) {
        HashMap<User, ArrayList<String>> submitsList = new HashMap<User, ArrayList<String>>();
        HashMap<User, String> finalSubmitList = new HashMap<User, String>();
        for (User u : Global.currentCourse.getAttendence()) {
            submitsList.put(u, new ArrayList<String>());
            finalSubmitList.put(u, Main.decode("YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10="));
        }
        q.setSubmitsList(submitsList);
        q.setFinalSubmitList(finalSubmitList);
        Global.currentExercise.getQuestions().add(q);
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvGKIdjrbeXP00eBeTlRbUB+cAYX9n4vI");
    }

    public static String addQuestionToBank(Question q) {
        Questionbank.quesiton.add(q);
        return Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPcriJrU/nYoTaAfTCedTINlMVwkJwQF5gznlKMy9JqWO1N/pCdy3yx3G2UrjLAKJ852Glzdqgc5Q9HyWD2IUc=");
    }

    public static String addQuestionFromBank(Question q) {
        Global.currentExercise.getQuestions().add(q);
        return Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPcriJrU/nYoTaAfTCedTINlMVwkJwQF5gznn+L24AoGtqr/L4RXMLUeVw1UpfYrK9sfY7QX7ds1bG9q7K6gnw=");
    }

    public static String deleteQuestion(Question q) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = String
                    .valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            System.out.println(Global.currentUser.getPhone());
            System.out.println(Global.currentUser.getName().length());
            System.out.println(Global.currentCourse.getTeacher().getEmail()
                    .equals(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPpqi5pKYe22UniGVW1Flg=")));
            System.out.println(Global.currentExercise.getScoreTable().get(Global.currentUser)
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer
                    .parseInt(Main.decode(i)) < Global.currentExercise.getQuestions().size(); i = i + 1) {
                if (Global.currentExercise.getQuestions().get(Integer.parseInt(Main.decode(i))).equals(q)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer
                    .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentExercise.getQuestions().remove(Integer.parseInt(Main.decode(flag)));
                return Main.decode(
                        "YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvGKNdzLbaTbiO8KmePS+44tAuPgxnjBsRNX9m0zX3C5KEkHUYZr7Dw==");
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvGKHfSqeezy7Klf3RSnLakmfNg/T5/Rq");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String modifyQuestion(Question oldQuestion, Question newQuestion) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = String
                    .valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer
                    .parseInt(Main.decode(i)) < Global.currentExercise.getQuestions().size(); i = i + 1) {
                if (Global.currentExercise.getQuestions().get(Integer.parseInt(Main.decode(i))).equals(oldQuestion)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(Main.decode(flag)) != -Integer
                    .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
                Global.currentExercise.getQuestions().set(Integer.parseInt(Main.decode(flag)), newQuestion);
                return Main.decode(
                        "YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvGKaZz3deCARWp9TOnGxbBFz4bjiGypKimhhLwpwFJn1VbAVc2Qifw==");
            }
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvGKHfSqeezy7Klf7ay7MbU6YMQjU4PNt");
        }
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPRqTJrQ/7Y8iyGZn7KdTYiXH8cf8aYt4rhQyBn85gT");
    }

    public static String answerQuestion(Question q, String answer) {
        q.getUsersPoint().put(Global.currentUser,
                Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
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
        return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPxqTI5Au3ToTWMYH7WfCCqLU3+CGMnfagh7PWGhAq6wzD9V0gZ2CKujfyux9WGcQ==");
    }

    public static String gradeQuestion(Question q, User u, int points) {
        q.getUsersPoint().put(u, points);
        Exercisecontroller.updateScoreTable();
        return Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXP8riJrV//YoGKZfTfQaSAEeS7CseDCwFHQCHrafjwEktFUvARBDJqu1lEsDcdvY9ZHFM3xIf5QCXcfHQQZsHE=");
    }

    public static String modifyLastSubmit(Question q, String lastSubmit) {
        q.getFinalSubmitList().put(Global.currentUser, lastSubmit);
        q.getUsersPoint().put(Global.currentUser,
                Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
        if (q.getType() == Type.MultiCoice || q.getType() == Type.BlankSpace) {
            if (q.getAnswer().equals(lastSubmit)) {
                q.getUsersPoint().put(Global.currentUser, q.getPoint());

            }
        }
        Exercisecontroller.updateScoreTable();
        return Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPxqTJrSu3Lt2KKej/QejZGnzR/CPJgC81gAzJKNAp18PjFUKJFXRgk8D9jPxH4BqzbVgosAgE/OVgSreaZDJY=");
    }

    public static String getSubmits(Question q, User u) {
        String str = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < q
                .getSubmitsList().get(u).size(); i = i + 1) {
            str = String.valueOf(Main.decode(str) + Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOy5EpGL4Gw30/kH1OzEF4=")
                    + q.getSubmitsList().get(u).get(Integer.parseInt(Main.decode(i)))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4="));
        }
        str = String.valueOf(
                Main.decode(str) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOggC4lQ+CdoTeLfzfKPSQq1ws9n/n50wQG+CfBbLtF")
                        + q.getFinalSubmitList().get(u) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo72VHLoCx3k7lHlKyEV8="));
        return Main.decode(str);
    }

    public static String getSubmitsAndPoints(Question q) {
        String str = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        for (User u : q.getUsersPoint().keySet()) {
            str = encode(Main.decode(str) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXP9tSI5GKyf2krhGla2FVs=") + u.getName()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo6isqUfidoTeLfzfKJ3EgWInJtucDCzXSiwBtchHC")
                    + q.getFinalSubmitList().get(u) + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo63lrAIa32EjjGFS0F1k=")
                    + q.getUsersPoint().get(u));
        }
        return Main.decode(str);
    }

    public static void increseLists(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, Main.decode("YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10="));
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
            }
        }
    }

    public static void mmdhos(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, Main.decode("YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10="));
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=")));
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
