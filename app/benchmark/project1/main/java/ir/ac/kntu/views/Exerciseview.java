package app.benchmark.project1.main.java.ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Calendar;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Exercisecontroller;
import ir.ac.kntu.data.models.*;

public class Exerciseview extends View {

    public static void createExercise() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Description:");
        String description = sc.nextLine();
        System.out.print("Start Month:");
        int month = Integer.parseInt(sc.nextLine());
        System.out.print("Start Day:");
        int day = Integer.parseInt(sc.nextLine());
        System.out.print("Deadline length in days:");
        int length = Integer.parseInt(sc.nextLine());
        System.out.print("Deadline length in days after latency:");
        int latencyDuration = Integer.parseInt(sc.nextLine());
        System.out.print("You want the Exercise to be beta:(yes/no)");
        String beta = sc.nextLine();
        boolean isBeta = false;
        if (beta.equals("yes")) {
            isBeta = true;
        }
        System.out.print("Latency Ratio:");
        double lateRatio = Double.parseDouble(sc.nextLine());
        Exercise e = new Exercise(name, description, new Date(Global.currentCourse.getYear(), month, day),
                new Date(Global.currentCourse.getYear(), month, day + length),
                new Date(Global.currentCourse.getYear(), month, day + length + latencyDuration), isBeta,
                lateRatio);
        showResult(Exercisecontroller.createExercise(e));
    }

    public static void deleteExercise() {
        System.out.println("Choose which exercise you wanna delete:");
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Exercisecontroller.deleteExercise(arr.get(n - 1)));
        }
    }

    public static void modifyExercise() {
        System.out.println("Choose which exercise you wanna edit:");
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Modify the exercise:");
            System.out.print("Name"+"(old name was  " + arr.get(n - 1).getName() + ") :");
            String name = sc.nextLine();
            System.out.print("Description:"+"(old name was  " + arr.get(n - 1).getDescription() + ") :");
            String description = sc.nextLine();
            System.out.print("Start Month:");
            System.out.print("(old name was  " + arr.get(n - 1).getStartTime().getMonth() + ") :");
            int month = Integer.parseInt(sc.nextLine());
            System.out.print("Start Day:"+"(old name was  " + arr.get(n - 1).getStartTime().getDay() + ") :");
            int day = Integer.parseInt(sc.nextLine());
            int number1 = arr.get(n - 1).getEndTime().getDay() - arr.get(n - 1).getStartTime().getDay();
            System.out.print("Deadline length in days:"+"(old name was  " + number1 + ") :");
            int length = Integer.parseInt(sc.nextLine());
            int number2 = arr.get(n - 1).getEndTimeAfterLatency().getDay() - arr.get(n - 1).getEndTime().getDay();
            System.out.print("Deadline length in days after latency:"+"(old name was  " + number2 + ") :");
            int latencyDuration = Integer.parseInt(sc.nextLine());
            System.out.print("You want the Exercise to be beta:"+"(old name was  " + arr.get(n - 1).isBeta() + ") :");
            String beta = sc.nextLine();
            boolean isBeta = false;
            if (beta.equals("yes")) {
                isBeta = true;
            }
            System.out.print("Latency Ratio:");
            System.out.print("(old name was  " + arr.get(n - 1).getLateRatio() + ") :");
            double lateRatio = Double.parseDouble(sc.nextLine());
            Exercise newExercise = new Exercise(name, description,
                    new Date(Global.currentCourse.getYear(), month, day),
                    new Date(Global.currentCourse.getYear(), month, day + length),
                    new Date(Global.currentCourse.getYear(), month, day + length + latencyDuration), isBeta,
                    lateRatio);
            showResult(Exercisecontroller.modifyExercise(arr.get(n - 1), newExercise));
        }
    }

    public static void chooseExercise() {
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR);
        today.clear(Calendar.MINUTE);
        today.clear(Calendar.SECOND);
        // java.util.Date todayDate = today.getTime();
        ArrayList<Exercise> arr = new ArrayList<Exercise>();
        for (Exercise e : Global.currentCourse.getExercsies()) {
            if (!Global.currentCourse.getTeacher().equals(Global.currentUser)) {
                // boolean compareDates = (todayDate.getYear() >
                // e.getEndTimeAfterLatency().getYear()
                // | todayDate.getMonth() > e.getEndTimeAfterLatency().getMonth()
                // || todayDate.getDay() > e.getEndTimeAfterLatency().getDay());
                if (!e.isBeta()) {
                    arr.add(e);
                }
            } else {
                arr.add(e);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            showResult(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            Global.currentExercise = arr.get(n - 1);
        }
    }

    public static void getScoreTable() {
        System.out.println("Choose which question:");
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        showResult(Exercisecontroller.getScoreTable(arr.get(n - 1)));

    }
}
