package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.Exerciseview;
import ir.ac.kntu.views.Questionview;
import ir.ac.kntu.views.Userview;
import ir.ac.kntu.controller.Usercontroller;
import ir.ac.kntu.views.Courseview;
import ir.ac.kntu.views.View;
import ir.ac.kntu.MyCipher;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Usercontroller.register(MyCipher.getInstance().decode("e142fa"), MyCipher.getInstance().decode("e142fa"),
                MyCipher.getInstance().decode("e142fa43363ac68fbbfdd0982b"), MyCipher.getInstance().decode("b11ca0"),
                Integer.parseInt(MyCipher.getInstance().decode("b11ca0")),
                Integer.parseInt(MyCipher.getInstance().decode("b11ca0")));
        Usercontroller.register(MyCipher.getInstance().decode("ed43f7"), MyCipher.getInstance().decode("ed43f7"),
                MyCipher.getInstance().decode("ed43f743363ac68fbbfdd0982b"), MyCipher.getInstance().decode("b11ca0"),
                Integer.parseInt(MyCipher.getInstance().decode("b41ba5")),
                Integer.parseInt(MyCipher.getInstance().decode("b41ba5")));
        Usercontroller.register(MyCipher.getInstance().decode("ed4be76a"), MyCipher.getInstance().decode("ed4be76a"),
                MyCipher.getInstance().decode("ed4be76a1130ca87bebf9d94299c"), MyCipher.getInstance().decode("b11ca0"),
                Integer.parseInt(MyCipher.getInstance().decode("b41ba5")),
                Integer.parseInt(MyCipher.getInstance().decode("b41ba5")));
        while (true) {
            mainFunc();
        }
    }

    public static void mainFunc() {
        View.showStatus();
        String choice = MyCipher.getInstance().encode(Menu.shoMenuHandler());
        choiceHandler(Integer.parseInt(MyCipher.getInstance().decode(choice)));
    }

    public static void choiceHandler(int choice) {
        if (choice > Integer.parseInt(MyCipher.getInstance().decode("b0"))
                && choice < Integer.parseInt(MyCipher.getInstance().decode("b11e"))) {
            mainChoiceHandler(choice);
        } else if (choice > Integer.parseInt(MyCipher.getInstance().decode("b11e"))
                && choice < Integer.parseInt(MyCipher.getInstance().decode("b21e"))) {
            userChoiceHandler(choice);
        } else if (choice > Integer.parseInt(MyCipher.getInstance().decode("b21e"))
                && choice < Integer.parseInt(MyCipher.getInstance().decode("b31e"))) {
            courseChoiceHandler(choice);
        } else if (choice > Integer.parseInt(MyCipher.getInstance().decode("b31e"))
                && choice < Integer.parseInt(MyCipher.getInstance().decode("b41e"))) {
            exerciseChoiceHandler(choice);
        } else if (choice > Integer.parseInt(MyCipher.getInstance().decode("b41e"))
                && choice < Integer.parseInt(MyCipher.getInstance().decode("b51e"))) {
            questionChoiceHandler(choice);
        } else if (choice == Integer.parseInt(MyCipher.getInstance().decode("b11e"))
                || choice == Integer.parseInt(MyCipher.getInstance().decode("b0"))
                || choice == Integer.parseInt(MyCipher.getInstance().decode("b21e"))
                || choice == Integer.parseInt(MyCipher.getInstance().decode("b31e"))
                || choice == Integer.parseInt(MyCipher.getInstance().decode("b41e"))) {
            View.back();
        } else {
            View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
        }
    }

    private static void mainChoiceHandler(int choice) {
        switch (choice) {
            case 2:
                View.searchCourse();
                break;
            case 3:
                View.searchUser();
                break;
            case 4:
                View.addQuestionToBank();
                break;
            case 5:
                View.showQuestionbank();
                break;
            default:
                View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
                break;
        }
    }

    private static void userChoiceHandler(int choice) {
        switch (choice) {
            case 11:
                Userview.register();
                break;
            case 12:
                Userview.login();
                break;
            default:
                View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
                break;
        }
    }

    private static void courseChoiceHandler(int choice) {
        switch (choice) {
            case 21:
                Courseview.addCourse();
                break;
            case 22:
                Courseview.deleteCourse();
                break;
            case 23:
                Courseview.modifyCourse();
                break;
            case 24:
                Courseview.addUser();
                break;
            case 25:
                Courseview.closeCourse();
                break;
            case 26:
                Courseview.opeanCourse();
                break;
            case 27:
                Courseview.chooseCourse();
                break;
            default:
                View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
                break;
        }
    }

    private static void exerciseChoiceHandler(int choice) {
        switch (choice) {
            case 31:
                Exerciseview.createExercise();
                break;
            case 32:
                Exerciseview.deleteExercise();
                break;
            case 33:
                Exerciseview.modifyExercise();
                break;
            case 34:
                Exerciseview.chooseExercise();
                break;
            case 35:
                Exerciseview.getScoreTable();
                break;
            default:
                View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
                break;
        }
    }

    private static void questionChoiceHandler(int choice) {
        switch (choice) {
            case 41:
                Questionview.addQuestion();
                break;
            case 42:
                Questionview.deleteQuestion();
                break;
            case 43:
                Questionview.modifyQuestion();
                break;
            case 44:
                Questionview.getSubmitsOfUser();
                break;
            case 45:
                Questionview.gradeQuestion();
                break;
            case 46:
                Questionview.getSubmitsAndPoints();
                break;
            case 47:
                Questionview.answerQuestion();
                break;
            case 48:
                Questionview.setFinalSubmit();
                break;
            default:
                View.showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
                break;
        }

    }

}