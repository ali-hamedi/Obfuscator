package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.data.db.Questionbank;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.Main;

public class Questionview extends View {
    public static void addQuestion() {
        System.out.println("1-Add question from Question Bank");
        System.out.println("2-Create a question");
        int n = Integer.parseInt(sc.nextLine());
        if (n == 2) {
            createQuestion();
        } else if (n == 1) {
            addQuestionFromBank();
        } else {
            showResult("Please choose a valid task");
        }
    }

    public static void addQuestionFromBank() {
        System.out.println("Choose which question you want to add to youre exercise :");
        ArrayList<Question> arr = Questionbank.quesiton;
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Questioncontroller.addQuestionFromBank(arr.get(n - 1)));
        }

    }

    public static void createQuestion() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Description:");
        String description = sc.nextLine();
        System.out.print("Points:");
        int point = Integer.parseInt(sc.nextLine());
        System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):");
        Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "";
        String body = "";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println("body:");
            System.out.print("-1:");
            bodyArr[0] = sc.nextLine();
            System.out.print("-2:");
            bodyArr[1] = sc.nextLine();
            System.out.print("-3:");
            bodyArr[2] = sc.nextLine();
            System.out.print("-4:");
            bodyArr[3] = sc.nextLine();
            System.out.print("which number is the Answer:");
            answer = sc.nextLine();
            body = "-" + bodyArr[0] + "-" + bodyArr[1] + "-" + bodyArr[2] + "-" + bodyArr[3];
        } else {
            System.out.print("body:");
            body = sc.nextLine();
            System.out.print("Answer:");
            answer = sc.nextLine();
        }
        System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):");
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(name, description, body, point, diff, typ, answer);
        showResult(Questioncontroller.createQuestion(q));
        System.out.print("Do you want to add this question to the question bank too??(yes/no)");
        String wouldAddToQuestionbank = sc.nextLine();
        if (wouldAddToQuestionbank.equals("yes")) {
            showResult(Questioncontroller.addQuestionToBank(q));
        }
    }

    public static void deleteQuestion() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Questioncontroller.deleteQuestion(arr.get(n - 1)));
        }
    }

    public static void modifyQuestion() {
        System.out.println("Choose which question you want to edit :");
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Modify the exercise:");
            System.out.print("Name:" + "(old name was  " + arr.get(n - 1).getName() + ") :");
            String name = sc.nextLine();
            System.out.print("Description" + "(old name was  " + arr.get(n - 1).getDescription() + ") :");
            String description = sc.nextLine();
            System.out.print("Points:" + "(old name was  " + arr.get(n - 1).getPoint() + ") :");
            int point = Integer.parseInt(sc.nextLine());
            System.out.print("Type(from 1-blankSpace,2-descriptive,3-multiChoice):" + "(old name was  "
                    + arr.get(n - 1).getType() + ") :");
            Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
            String answer = "";
            String body = "";
            System.out.print("body:");
            if (typ == Type.MultiCoice) {
                String[] bodyArr = new String[4];
                System.out.print("-1:");
                bodyArr[0] = sc.nextLine();
                System.out.print("-2:");
                bodyArr[1] = sc.nextLine();
                System.out.print("-3:");
                bodyArr[2] = sc.nextLine();
                System.out.print("-4:");
                bodyArr[3] = sc.nextLine();
                System.out.print("which number is the Answer:");
                answer = sc.nextLine();
                body = "-" + bodyArr[0] + "-" + bodyArr[1] + "-" + bodyArr[2] + "-" + bodyArr[3];
            } else {
                body = sc.nextLine();
                System.out.print("Answer:");
                answer = sc.nextLine();
            }
            System.out.print("Diffculty(from 1-easy,2-medium,3-hard,4-very hard):" + "(old name was  "
                    + arr.get(n - 1).getDifficulty() + ") :");
            Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
            showResult(Questioncontroller.modifyQuestion(arr.get(n - 1),
                    new Question(name, description, body, point, diff, typ, answer)));
        }
    }

    public static void answerQuestion() {
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {

            Question q = arr.get(n - 1);
            System.out.println("Question: ");
            if (q.getType() == Type.MultiCoice) {
                String[] strArr = q.getBody().split("-");
                for (int i = 0; i < strArr.length; i++) {
                    if (i == 0) {
                        System.out.println(q.getDescription() + "?");
                    } else {
                        System.out.println("-" + strArr[i]);
                    }
                }
            } else {
                System.out.println(q.getBody() + "?");
            }
            System.out.println("Enter Your answer: ");
            String answer = sc.nextLine();
            showResult(Questioncontroller.answerQuestion(q, answer));
        }
    }

    public static void gradeQuestion() {
        System.out.println("Choose which question  :");
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(i + 1 + " " + arr1.get(i).getName());
        }
        int n1 = Integer.parseInt(sc.nextLine());
        if (n1 < 1 || arr1.size() == 0 || n1 > arr1.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (int i = 0; i < arr2.size(); i++) {
                System.out.println(i + 1 + " " + arr2.get(i).getName());
            }
            int n2 = Integer.parseInt(sc.nextLine());
            if (n2 < 1 || arr2.size() == 0 || n2 > arr2.size()) {
                showResult("Enter valid number");
            } else {
                showResult("The use last submit was: " + arr1.get(n1 - 1).getFinalSubmitList().get(arr2.get(n2 - 1)));
                System.out.println("Enter the point you wanna give: ");
                int points = Integer.parseInt(sc.nextLine());
                showResult(Questioncontroller.gradeQuestion(arr1.get(n1 - 1), arr2.get(n2 - 1), points));
            }
        }
    }

    public static void getSubmitsOfUser() {
        System.out.println("Choose which question  :");
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(i + 1 + " " + arr1.get(i).getName());
        }
        int n1 = Integer.parseInt(sc.nextLine());
        if (n1 < 1 || arr1.size() == 0 || n1 > arr1.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Choose which user  :");
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (int i = 0; i < arr2.size(); i++) {
                System.out.println(i + 1 + " " + arr2.get(i).getName());
            }
            int n2 = Integer.parseInt(sc.nextLine());
            if (n2 < 1 || arr2.size() == 0 || n2 > arr2.size()) {
                showResult("Enter valid number");
            } else {
                showResult(Questioncontroller.getSubmits(arr1.get(n1 - 1), arr2.get(n2 - 1)));
            }
        }
    }

    public static void setFinalSubmit() {
        System.out.println("Choose which question  :");
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(i + 1 + " " + arr1.get(i).getName());
        }
        int n1 = Integer.parseInt(sc.nextLine());
        if (n1 < 1 || arr1.size() == 0 || n1 > arr1.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Choose which submits (Last one was):"
                    + arr1.get(n1 - 1).getFinalSubmitList().get(Global.currentUser));
            ArrayList<String> arr2 = arr1.get(n1 - 1).getSubmitsList().get(Global.currentUser);
            for (int i = 0; i < arr2.size(); i++) {
                System.out.println(i + 1 + " " + arr2.get(i));
            }
            int n2 = Integer.parseInt(sc.nextLine());
            if (n2 < 1 || arr2.size() == 0 || n2 > arr2.size()) {
                showResult("Enter valid number");
            } else {
                showResult(Questioncontroller.modifyLastSubmit(arr1.get(n1 - 1), arr2.get(n2 - 1)));
            }
        }
    }

    public static void getSubmitsAndPoints() {
        System.out.println("Choose which question you want to delete :");
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Questioncontroller.getSubmitsAndPoints(arr.get(n - 1)));
        }
    }
}
