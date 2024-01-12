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
        System.out.println(Main
                .decode("YWFhYWFhYWFhYWFhYWFhYXO56wYvRqzMpyeaZjfRc3O5Q3yGQazxvU3UJSk+VjqwlmvGUauMfAxuLq9C+VYvpg=="));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wQ5R+3Jt2KIMi/LeCDH+shy6TvB+CX6+VkFU1PN"));
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) == Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))) {
            createQuestion();
        } else if (Integer.parseInt(Main.decode(n)) == Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            addQuestionFromBank();
        } else {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqiIqUemdsSqGfS3bPTKi4qMI9wtWegSYO+sVf6EP"));
        }
    }

    public static void addQuestionFromBank() {
        System.out.println(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/As/ZK+lH/chksb0JjufTpors1KUnok1r4XKnkAr8qhrxCeL0fJz+77I="));
        ArrayList<Question> arr = Questionbank.quesiton;
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Questioncontroller.addQuestionFromBank(arr.get(Integer.parseInt(Main.decode(n))
                    - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }

    }

    public static void createQuestion() {
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo="));
        String name = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfGScH1E="));
        String description = String.valueOf(sc.nextLine());
        System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqS4lVv+H8EXuFVm5GlQ="));
        String point = String.valueOf(Integer.parseInt(sc.nextLine()));
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPcvzcuCurPvS/JI3PccTKFs+51Aur/aZ1uVPC8Nu9FLi9ckGtKY22ip6xCvqCs9MIRjkl04tjSlKryIGWCBTg="));
        Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
        String answer = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        String body = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
        if (typ == Type.MultiCoice) {
            String[] bodyArr = new String[4];
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPqqSMyGK6020vgG1e3FFo="));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl931pKYe22UniGVW1Flg="));
            bodyArr[0] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9H1pKYe22UniGVW1Flg="));
            bodyArr[1] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9X1pKYe22UniGVW1Flg="));
            bodyArr[2] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl8n1pKYe22UniGVW1Flg="));
            bodyArr[3] = sc.nextLine();
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXP/ri4oSqzTpy+LdyyedCB3X/KD9D3FrmP5FmCU7lvv"));
            answer = String.valueOf(sc.nextLine());
            body = String.valueOf(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                    + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))])
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=") + Main.decode(bodyArr[Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw="))]));
        } else {
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPqqSMyGK6020vgG1e3FFo="));
            body = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPJqDQ8R/6H8EXuFVm5GlQ="));
            answer = String.valueOf(sc.nextLine());
        }
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPMryEtQfnRpjvBdCzRcHM+3r5+Xe9fMHr3LMxYmLvYnOuI3qp9xok9gBQlsEBHhE3aerP9ZJOON3IWPV/VTk4="));
        Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
        Question q = new Question(Main.decode(name), Main.decode(description), Main.decode(body),
                Integer.parseInt(Main.decode(point)), diff, typ, Main.decode(answer));
        showResult(Questioncontroller.createQuestion(q));
        System.out.print(Main.decode(
                "YWFhYWFhYWFhYWFhYWFhYXPMqWcyTfmdpSOHZn7KcnNji7jmLzpAhCSJB8b/ILTHVlf2Lqj0IkOhtjE82C7NKk/kVpnLgv27IdSwX53i3Az3MDMyYkfAOZ8taaIM/eBY"));
        String wouldAddToQuestionbank = String.valueOf(sc.nextLine());
        if (Main.decode(wouldAddToQuestionbank).equals(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPxozRpKYe22UniGVW1Flg="))) {
            showResult(Questioncontroller.addQuestionToBank(q));
        }
    }

    public static void deleteQuestion() {
        System.out.println(Main
                .decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/As/ZK+lH/chksb0Ji+bb44rm1OZq0zsKxQ=="));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Questioncontroller.deleteQuestion(arr.get(Integer.parseInt(Main.decode(n))
                    - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }

    public static void modifyQuestion() {
        System.out.println(Main
                .decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/As/ZK+lH/chksb0Jiufe8t651tpO0TkIxw=="));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPFqSMiRPWdpiqMMjvGeCHLQw3v6aYjqMVD6thA7fA3"));
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPGpyouGK6020vgG1e3FFo=")
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn")
                    + arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getName()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String name = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPMozQoUOXNpiuGfHy9HlA=")
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn")
                    + arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))
                            .getDescription()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String description = String.valueOf(sc.nextLine());
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPYqS4lVv+H8EXuFVm5GlQ=")
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn")
                    + arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getPoint()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            String point = String.valueOf(Integer.parseInt(sc.nextLine()));
            System.out.print(Main.decode(
                    "YWFhYWFhYWFhYWFhYWFhYXPcvzcuCurPvS/JI3PccTKFs+51Aur/aZ1uVPC8Nu9FLi9ckGtKY22ip6xCvqCs9MIRjkl04tjSlKryIGWCBTg=")
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn")
                    + arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))).getType()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            Type typ = Questioncontroller.getQuestionTypeByInt(Integer.parseInt(sc.nextLine()));
            String answer = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
            String body = "YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=";
            System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPqqSMyGK6020vgG1e3FFo="));
            if (typ == Type.MultiCoice) {
                String[] bodyArr = new String[4];
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl931pKYe22UniGVW1Flg="));
                bodyArr[0] = sc.nextLine();
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9H1pKYe22UniGVW1Flg="));
                bodyArr[1] = sc.nextLine();
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl9X1pKYe22UniGVW1Flg="));
                bodyArr[2] = sc.nextLine();
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl8n1pKYe22UniGVW1Flg="));
                bodyArr[3] = sc.nextLine();
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXP/ri4oSqzTpy+LdyyedCB3X/KD9D3FrmP5FmCU7lvv"));
                answer = String.valueOf(sc.nextLine());
                body = String.valueOf(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                        + Main.decode(bodyArr[Integer
                                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))])
                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                        + Main.decode(bodyArr[Integer
                                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))])
                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                        + Main.decode(
                                bodyArr[Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="))]
                                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                                        + Main.decode(bodyArr[Integer.parseInt(
                                                Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw="))])));
            } else {
                body = String.valueOf(sc.nextLine());
                System.out.print(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPJqDQ8R/6H8EXuFVm5GlQ="));
                answer = String.valueOf(sc.nextLine());
            }
            System.out.print(Main.decode(
                    "YWFhYWFhYWFhYWFhYWFhYXPMryEtQfnRpjvBdCzRcHM+3r5+Xe9fMHr3LMxYmLvYnOuI3qp9xok9gBQlsEBHhE3aerP9ZJOON3IWPV/VTk4=")
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOgqSsvAuLcvyfJZT/NPXPCj1OyfDwhwasOq5Cb4XAn")
                    + arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))
                            .getDifficulty()
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOh5n1pKYe22UniGVW1Flg="));
            Difficulty diff = Questioncontroller.getQuestionDifficultyByInt(Integer.parseInt(sc.nextLine()));
            showResult(Questioncontroller.modifyQuestion(
                    arr.get(Integer.parseInt(Main.decode(n))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))),
                    new Question(Main.decode(name), Main.decode(description), Main.decode(body),
                            Integer.parseInt(Main.decode(point)), diff, typ, Main.decode(answer))));
        }
    }

    public static void answerQuestion() {
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {

            Question q = arr.get(Integer.parseInt(Main.decode(n))
                    - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPZsyI4VuXSvHjJMFq6GVc="));
            if (q.getType() == Type.MultiCoice) {
                String[] strArr = q.getBody().split(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4="));
                for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer
                        .parseInt(Main.decode(i)) < strArr.length; i = i + 1) {
                    if (Integer.parseInt(Main.decode(i)) == Integer
                            .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))) {
                        System.out.println(
                                q.getDescription() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXO35EpGL4Gw30/kH1OzEF4="));
                    } else {
                        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOl5EpGL4Gw30/kH1OzEF4=")
                                + Main.decode(strArr[Integer.parseInt(Main.decode(i))]));
                    }
                }
            } else {
                System.out.println(q.getBody() + Main.decode("YWFhYWFhYWFhYWFhYWFhYXO35EpGL4Gw30/kH1OzEF4="));
            }
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzkvTebMj/QbiSW6GGLzGuGKA1hwcIMnEty"));
            String answer = String.valueOf(sc.nextLine());
            showResult(Questioncontroller.answerQuestion(q, Main.decode(answer)));
        }
    }

    public static void gradeQuestion() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/W5qODZgglbpC"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr1
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr1.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n1 = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n1)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr1.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n1)) > arr1.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaeaCBEEKjB8C+aCc9HwdzC0gFv"));
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr2
                    .size(); i = i + 1) {
                System.out.println(Integer.parseInt(Main.decode(i))
                        + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                        + arr2.get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n2 = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n2)) < Integer
                    .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    || arr2.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                    || Integer.parseInt(Main.decode(n2)) > arr2.size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPcriJrV//Y8i6IYSqebia08NQv/7QZtxdIye9c2rB9") + arr1
                        .get(Integer.parseInt(Main.decode(n1))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))
                        .getFinalSubmitList().get(arr2.get(Integer.parseInt(Main.decode(n2))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
                System.out.println(Main.decode(
                        "YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzJuifJYjHXcydcUYMSSfnF1ehWU2agWLeL7DvYSYjdwYIHQguUGBVx8g=="));
                String points = String.valueOf(Integer.parseInt(sc.nextLine()));
                showResult(Questioncontroller.gradeQuestion(
                        arr1.get(Integer.parseInt(Main.decode(n1))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))),
                        arr2.get(Integer.parseInt(Main.decode(n2))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))),
                        Integer.parseInt(Main.decode(points))));
            }
        }
    }

    public static void getSubmitsOfUser() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/W5qODZgglbpC"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr1
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr1.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n1 = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n1)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr1.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n1)) > arr1.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaeaCBEEKjB8C+aCc9HwdzC0gFv"));
            ArrayList<User> arr2 = Global.currentCourse.getAttendence();
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr2
                    .size(); i = i + 1) {
                System.out.println(Integer.parseInt(Main.decode(i))
                        + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                        + arr2.get(Integer.parseInt(Main.decode(i))).getName());
            }
            String n2 = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n2)) < Integer
                    .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    || arr2.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                    || Integer.parseInt(Main.decode(n2)) > arr2.size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                showResult(Questioncontroller.getSubmits(
                        arr1.get(Integer.parseInt(Main.decode(n1))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))),
                        arr2.get(Integer.parseInt(Main.decode(n2))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
            }
        }
    }

    public static void setFinalSubmit() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/W5qODZgglbpC"));
        ArrayList<Question> arr1 = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr1
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr1.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n1 = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n1)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr1.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n1)) > arr1.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            System.out.println(Main
                    .decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebiZdzgMmrNiAgPgffcNerNuEmE1FdqFZ631IDy9TbWBn7A==")
                    + arr1.get(Integer.parseInt(Main.decode(n1))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))
                            .getFinalSubmitList().get(Global.currentUser));
            ArrayList<String> arr2 = arr1
                    .get(Integer.parseInt(Main.decode(n1))
                            - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))
                    .getSubmitsList().get(Global.currentUser);
            for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr2
                    .size(); i = i + 1) {
                System.out.println(Integer.parseInt(Main.decode(i))
                        + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                        + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                        + arr2.get(Integer.parseInt(Main.decode(i))));
            }
            String n2 = String.valueOf(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(Main.decode(n2)) < Integer
                    .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    || arr2.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                    || Integer.parseInt(Main.decode(n2)) > arr2.size()) {
                showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
            } else {
                showResult(Questioncontroller.modifyLastSubmit(
                        arr1.get(Integer.parseInt(Main.decode(n1))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))),
                        arr2.get(Integer.parseInt(Main.decode(n2))
                                - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
            }
        }
    }

    public static void getSubmitsAndPoints() {
        System.out.println(Main
                .decode("YWFhYWFhYWFhYWFhYWFhYXPLrigkUemdpSqAcTaebCb7izmm0kb/As/ZK+lH/chksb0Ji+bb44rm1OZq0zsKxQ=="));
        ArrayList<Question> arr = Global.currentExercise.getQuestions();
        for (String i = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="; Integer.parseInt(Main.decode(i)) < arr
                .size(); i = i + 1) {
            System.out.println(Integer.parseInt(Main.decode(i))
                    + Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                    + Main.decode("YWFhYWFhYWFhYWFhYWFhYXOo5EpGL4Gw30/kH1OzEF4=")
                    + arr.get(Integer.parseInt(Main.decode(i))).getName());
        }
        String n = String.valueOf(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(Main.decode(n)) < Integer
                .parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))
                || arr.size() == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw="))
                || Integer.parseInt(Main.decode(n)) > arr.size()) {
            showResult(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPNqDMuUKzLsy6Adn7QaD5eY/xRolWSdi9/xHwL32cP"));
        } else {
            showResult(Questioncontroller.getSubmitsAndPoints(arr.get(Integer.parseInt(Main.decode(n))
                    - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")))));
        }
    }
}
