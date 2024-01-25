package ir.ac.kntu.controller;

import ir.ac.kntu.data.db.Questionbank;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.Global;

import java.util.ArrayList;
import java.util.HashMap;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Questioncontroller {
    public static String createQuestion(Question q) {
        HashMap<User, ArrayList<String>> submitsList = new HashMap<User, ArrayList<String>>();
        HashMap<User, String> finalSubmitList = new HashMap<User, String>();
        for (User u : Global.currentCourse.getAttendence()) {
            submitsList.put(u, new ArrayList<String>());
            finalSubmitList.put(u, MyCipher.getInstance().decode(""));
        }
        q.setSubmitsList(submitsList);
        q.setFinalSubmitList(finalSubmitList);
        Global.currentExercise.getQuestions().add(q);
        return MyCipher.getInstance().decode("d15bf670253ec888f7b2d79323951307f461c78410793a2d0c1537");
    }

    public static String addQuestionToBank(Question q) {
        Questionbank.quesiton.add(q);
        return MyCipher.getInstance().decode("d446f6232022c295a3badc99669952270e3486900d170473aad9cb937f4d32b2dff34216cc8a8338bc5dfc1e4d59fc");
    }

    public static String addQuestionFromBank(Question q) {
        Global.currentExercise.getQuestions().add(q);
        return MyCipher.getInstance().decode("d446f6232022c295a3badc99669952270e3486900d170473aad9e6946f1f70b6e0638a78c4bf4219452f396b3f22e695e72b9c26");
    }

    public static String deleteQuestion(Question q) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            System.out.println(Global.currentUser.getPhone());
            System.out.println(Global.currentUser.getName().length());
            System.out.println(Global.currentCourse.getTeacher().getEmail().equals(MyCipher.getInstance().decode("e142fa")));
            System.out.println(Global.currentExercise.getScoreTable().get(Global.currentUser) + Integer.parseInt(MyCipher.getInstance().decode("b2")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentExercise.getQuestions().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentExercise.getQuestions().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(q)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentExercise.getQuestions().remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
                return MyCipher.getInstance().decode("d15bf670253ec888f7b7d69b23855630fdb5a54769f1150cc48d3ad72b15f3555e2297ef5f78d2531bda2f2a68");
            }
            return MyCipher.getInstance().decode("d15bf670253ec888f7bddc8366975c21d61073");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String modifyQuestion(Question oldQuestion, Question newQuestion) {
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentExercise.getQuestions().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentExercise.getQuestions().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(oldQuestion)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentExercise.getQuestions().set(Integer.parseInt(MyCipher.getInstance().decode(flag)), newQuestion);
                return MyCipher.getInstance().decode("d15bf670253ec888f7a0c6942594402715c054a741eef55300db1a4a12e77fc1e6c9bf3f92eaa0e18573025024");
            }
            return MyCipher.getInstance().decode("d15bf670253ec888f7bddc8366975c21d610");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String answerQuestion(Question q, String answer) {
        q.getUsersPoint().put(Global.currentUser, Integer.parseInt(MyCipher.getInstance().decode("b0")));
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
        return MyCipher.getInstance().decode("f941e6717136c995a0b6c1d72e90407444a8d61b3f0600ab435aaa37c1f3a115900cf7ec6e0ede6e17");
    }

    public static String gradeQuestion(Question q, User u, int points) {
        q.getUsersPoint().put(u, points);
        Exercisecontroller.updateScoreTable();
        return MyCipher.getInstance().decode("f446f6232424c294f7a3dc9e288540740cc6b4a16f80ae98dfd8cf4c08bc121481f3eb5f1bfd531811227474d9350e5243d9e7");
    }

    public static String modifyLastSubmit(Question q, String lastSubmit) {
        q.getFinalSubmitList().put(Global.currentUser, lastSubmit);
        q.getUsersPoint().put(Global.currentUser, Integer.parseInt(MyCipher.getInstance().decode("b0")));
        if (q.getType() == Type.MultiCoice || q.getType() == Type.BlankSpace) {
            if (q.getAnswer().equals(lastSubmit)) {
                q.getUsersPoint().put(Global.currentUser, q.getPoint());

            }
        }
        Exercisecontroller.updateScoreTable();
        return MyCipher.getInstance().decode("f941e6233936d183f7b0db9628965630659c6683a524d0e02291c9797c2e7b04c982bf60935759813f5a22395814");
    }

    public static String getSubmits(Question q, User u) {
        String str = "";
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < q.getSubmitsList().get(u).size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + Integer.parseInt(MyCipher.getInstance().decode(i))+Integer.parseInt(MyCipher.getInstance().decode("b1"))+MyCipher.getInstance().decode("ba")+q.getSubmitsList().get(u).get(Integer.parseInt(MyCipher.getInstance().decode(i)))+MyCipher.getInstance().decode("a0"));
        }
        str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + MyCipher.getInstance().decode("a868fa6d303b8795a2b1de9e32d144352a7a19")+q.getFinalSubmitList().get(u)+MyCipher.getInstance().decode("a007"));
        return MyCipher.getInstance().decode(str);
    }

    public static String getSubmitsAndPoints(Question q) {
        String str = "";
        for (User u : q.getUsersPoint().keySet()) {
            str = MyCipher.getInstance().encode(MyCipher.getInstance().decode(str) + MyCipher.getInstance().decode("f55df6716b77")+u.getName()+MyCipher.getInstance().decode("a002ff6222238795a2b1de9e32cb")+q.getFinalSubmitList().get(u)+MyCipher.getInstance().decode("a003ad23")+q.getUsersPoint().get(u));
        }
        return MyCipher.getInstance().decode(str);
    }

    public static void increseLists(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, MyCipher.getInstance().decode(""));
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, Integer.parseInt(MyCipher.getInstance().decode("b0")));
            }
        }
    }

    public static void mmdhos(Course c, User u) {
        for (Exercise e : c.getExercsies()) {
            for (Question q : e.getQuestions()) {
                HashMap<User, String> finalSubmits = q.getFinalSubmitList();
                HashMap<User, ArrayList<String>> submits = q.getSubmitsList();
                HashMap<User, Integer> userPoints = q.getUsersPoint();
                finalSubmits.put(u, MyCipher.getInstance().decode(""));
                submits.put(u, new ArrayList<String>());
                userPoints.put(u, Integer.parseInt(MyCipher.getInstance().decode("b0")));
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
