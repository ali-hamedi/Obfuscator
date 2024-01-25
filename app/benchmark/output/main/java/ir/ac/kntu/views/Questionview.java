package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.*;
import ir.ac.kntu.data.db.Questionbank;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Questionview extends View {
    public static void addQuestion() {
        System.out.println(MyCipher.getInstance().decode("b103d2673577d693b2a0c79e299f1332d845d317e7220c96e61673a5f91baa5788"));
        System.out.println(MyCipher.getInstance().decode("b203d0713436d383f7b29386339440204ad727"));
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) == Integer.parseInt(MyCipher.getInstance().decode("b2"))) {
            createQuestion();
        } else if (Integer.parseInt(MyCipher.getInstance().decode(n)) == Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            addQuestionFromBank();
        } else {
            showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
        }
    }

    public static void addQuestionFromBank() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2deffb6d5ef023bcbc85fa7f9318a728f9739255030147acf2dab3a86e66d248bd07e775"));
        ArrayList<Question> arr = Questionbank.quesiton;
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Questioncontroller.addQuestionFromBank(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }

    }

    public static void createQuestion() {
        System.out.print(MyCipher.getInstance().decode("ce4ffe666b"));
        String name = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcddcd"));
        String description = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("d041fa6d25249d"));
        String point = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("d457e3667931d589baf382da249d523ab9350583ab8e20f91b3fc4f753d5e0465c53e94162d30cee69529ca0268544dabf9dca8c"));
        Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "";
        String body = "";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println(MyCipher.getInstance().decode("e241f77a6b"));
            System.out.print(MyCipher.getInstance().decode("ad1fa9"));
            bodyArr[0] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1ca9"));
            bodyArr[1] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1da9"));
            bodyArr[2] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("ad1aa9"));
            bodyArr[3] = sc.nextLine();
            System.out.print(MyCipher.getInstance().decode("f746fa603977c993bab1d6856698407464c4d05518f35ae279606f"));
            answer = MyCipher.getInstance().encode(sc.nextLine());
            body = MyCipher.getInstance().encode(MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b0"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b1"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b2"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b3"))]));
        } else {
            System.out.print(MyCipher.getInstance().decode("e241f77a6b"));
            body = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c140e07434259d"));
            answer = MyCipher.getInstance().encode(sc.nextLine());
        }
        System.out.print(MyCipher.getInstance().decode("c447f5653222cb92aefbd585299c1365f4baad1da0c94c97149da4571f45bc00eabe7e74fd61041ddaefbc31e66e9d8c52ab18"));
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(body), Integer.parseInt(MyCipher.getInstance().decode(point)), diff, typ, MyCipher.getInstance().decode(answer));
        showResult(Questioncontroller.createQuestion(q));
        System.out.print(MyCipher.getInstance().decode("c441b37a3e228791b6bdc7d7329e133513acff4b6c41e2a03d602290c06c7f37ad7e15723f464be413e9e9b65f66143def861cffc9680e71afbcb58a3dbbeb074f9718"));
        String wouldAddToQuestionbank = MyCipher.getInstance().encode(sc.nextLine());
        if (MyCipher.getInstance().decode(wouldAddToQuestionbank).equals(MyCipher.getInstance().decode("f94be0"))) {
            showResult(Questioncontroller.addQuestionToBank(q));
        }
    }

    public static void deleteQuestion() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2deffb6d5ef023bcbc85fa7f931da620bc73985540"));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Questioncontroller.deleteQuestion(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }

    public static void modifyQuestion() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2deffb6d5ef023bcbc85fa7f931ca725ad27c7"));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("cd41f76a372e8792bfb693923e944137f26b693b"));
            System.out.print(MyCipher.getInstance().decode("ce4ffe666b") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getName() + MyCipher.getInstance().decode("a90ea9"));
            String name = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcdd") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getDescription() + MyCipher.getInstance().decode("a90ea9"));
            String description = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d041fa6d25249d") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getPoint() + MyCipher.getInstance().decode("a90ea9"));
            String point = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("d457e3667931d589baf382da249d523ab9350583ab8e20f91b3fc4f753d5e0465c53e94162d30cee69529ca0268544dabf9dca8c") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113")
                    + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getType() + MyCipher.getInstance().decode("a90ea9"));
            Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
            String answer = "";
            String body = "";
            System.out.print(MyCipher.getInstance().decode("e241f77a6b"));
            if (typ == Type.MultiCoice) {
                String[] bodyArr = new String[4];
                System.out.print(MyCipher.getInstance().decode("ad1fa9"));
                bodyArr[0] = sc.nextLine();
                System.out.print(MyCipher.getInstance().decode("ad1ca9"));
                bodyArr[1] = sc.nextLine();
                System.out.print(MyCipher.getInstance().decode("ad1da9"));
                bodyArr[2] = sc.nextLine();
                System.out.print(MyCipher.getInstance().decode("ad1aa9"));
                bodyArr[3] = sc.nextLine();
                System.out.print(MyCipher.getInstance().decode("f746fa603977c993bab1d6856698407464c4d05518f35ae279606f"));
                answer = MyCipher.getInstance().encode(sc.nextLine());
                body = MyCipher.getInstance().encode(MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b0"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b1"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b2"))]) + MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(bodyArr[Integer.parseInt(MyCipher.getInstance().decode("b3"))]));
            } else {
                body = MyCipher.getInstance().encode(sc.nextLine());
                System.out.print(MyCipher.getInstance().decode("c140e07434259d"));
                answer = MyCipher.getInstance().encode(sc.nextLine());
            }
            System.out.print(MyCipher.getInstance().decode("c447f5653222cb92aefbd585299c1365f4baad1da0c94c97149da4571f45bc00eabe7e74fd61041ddaefbc31e66e9d8c52ab18") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113")
                    + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getDifficulty() + MyCipher.getInstance().decode("a90ea9"));
            Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
            showResult(Questioncontroller.modifyQuestion(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))),
                    new Question(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(body), Integer.parseInt(MyCipher.getInstance().decode(point)), diff, typ, MyCipher.getInstance().decode(answer))));
        }
    }

    public static void answerQuestion() {
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {

            Question q = arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")));
            System.out.println(MyCipher.getInstance().decode("d15bf670253ec888edf3"));
            if (q.getType() == Type.MultiCoice) {
                String[] strArr = q.getBody().split(MyCipher.getInstance().decode("ad"));
                for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < strArr.length; i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                    if (Integer.parseInt(MyCipher.getInstance().decode(i)) == Integer.parseInt(MyCipher.getInstance().decode("b0"))) {
                        System.out.println(q.getDescription() + MyCipher.getInstance().decode("bf"));
                    } else {
                        System.out.println(MyCipher.getInstance().decode("ad") + MyCipher.getInstance().decode(strArr[Integer.parseInt(MyCipher.getInstance().decode(i))]));
                    }
                }
            } else {
                System.out.println(q.getBody() + MyCipher.getInstance().decode("bf"));
            }
            System.out.println(MyCipher.getInstance().decode("c540e7662377fe89a2a1939628824431943606"));
            String answer = MyCipher.getInstance().encode(sc.nextLine());
            showResult(Questioncontroller.answerQuestion(q, MyCipher.getInstance().decode(answer)));
        }
    }

    public static void gradeQuestion() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2db6ae"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr1.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr1.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n1 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n1)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr1.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n1)) > arr1.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66844031428a7665"));
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr2.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr2.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n2 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n2)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr2.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n2)) > arr2.size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                showResult(MyCipher.getInstance().decode("d446f6232424c2c6bbb2c083668246360a2b7c407a8cf2f496") + arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getFinalSubmitList().get(arr2.get(Integer.parseInt(MyCipher.getInstance().decode(n2)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
                System.out.println(MyCipher.getInstance().decode("c540e7662377d38eb2f3c3982f9f47749cd3a1f2fef3bc70a8219aa7ed33e815"));
                String points = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
                showResult(Questioncontroller.gradeQuestion(arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))), arr2.get(Integer.parseInt(MyCipher.getInstance().decode(n2)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))), Integer.parseInt(MyCipher.getInstance().decode(points))));
            }
        }
    }

    public static void getSubmitsOfUser() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2db6ae"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr1.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr1.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n1 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n1)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr1.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n1)) > arr1.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66844031428a7665"));
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr2.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr2.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n2 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n2)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr2.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n2)) > arr2.size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                showResult(Questioncontroller.getSubmits(arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))), arr2.get(Integer.parseInt(MyCipher.getInstance().decode(n2)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
            }
        }
    }

    public static void setFinalSubmit() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2db6ae"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr1.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr1.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n1 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n1)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr1.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n1)) > arr1.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f668246363119021372d9817aa6d69dd71abd8d7b43c5fd66")
                    + arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getFinalSubmitList().get(Global.currentUser));
            ArrayList<String> arr2 = arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getSubmitsList().get(Global.currentUser);
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr2.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr2.get(Integer.parseInt(MyCipher.getInstance().decode(i))));
            }
            String n2 = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n2)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr2.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n2)) > arr2.size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                showResult(Questioncontroller.modifyLastSubmit(arr1.get(Integer.parseInt(MyCipher.getInstance().decode(n1)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))), arr2.get(Integer.parseInt(MyCipher.getInstance().decode(n2)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
            }
        }
    }

    public static void getSubmitsAndPoints() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d2deffb6d5ef023bcbc85fa7f931da620bc73985540"));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Questioncontroller.getSubmitsAndPoints(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }
}
