package ir.ac.kntu.views;

import java.util.ArrayList;
import java.util.Calendar;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Exercisecontroller;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Exerciseview extends View {

    public static void createExercise() {
        System.out.print(MyCipher.getInstance().decode("ce4ffe666b"));
        String name = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcddcd"));
        String description = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("d35af2712577ea89b9a7dbcd"));
        String month = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("d35af2712577e387aee9"));
        String day = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("c44bf2673d3ec983f7bfd69921855b74aa6658b384db01d0"));
        String length = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("c44bf2673d3ec983f7bfd69921855b74aa6658b384db01ca2935045dd858cd1609b6e64393f8"));
        String latencyDuration = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("d941e6232636c992f7a7db9266b44b31b80b4efa8b8bbb625289d62f07802a20a464c8a845bee49d7d"));
        String beta = MyCipher.getInstance().encode(sc.nextLine());
        String isBeta = "e64fff7034";
        if (MyCipher.getInstance().decode(beta).equals(MyCipher.getInstance().decode("f94be0"))) {
            isBeta = "f45ce666";
        }
        System.out.print(MyCipher.getInstance().decode("cc4fe7663f34dec685b2c79e29cb"));
        String lateRatio = MyCipher.getInstance().encode(Double.parseDouble(sc.nextLine()));
        Exercise e = new Exercise(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day))),
                new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode(length))),
                new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode(length)) + Integer.parseInt(MyCipher.getInstance().decode(latencyDuration))), Boolean.parseBoolean(MyCipher.getInstance().decode(isBeta)),
                Double.parseDouble(MyCipher.getInstance().decode(lateRatio)));
        showResult(Exercisecontroller.createExercise(e));
    }

    public static void deleteExercise() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66944b3130209beaef81136e53fdd9a1c16a5aa534ac86a3874d07"));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Exercisecontroller.deleteExercise(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }

    public static void modifyExercise() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66944b3130209beaef81136e53fdd9a1c16a5aa535ad83b2c9"));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("cd41f76a372e8792bfb693923e944137f26b693b"));
            System.out.print(MyCipher.getInstance().decode("ce4ffe66") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getName() + MyCipher.getInstance().decode("a90ea9"));
            String name = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcddcd") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getDescription() + MyCipher.getInstance().decode("a90ea9"));
            String description = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d35af2712577ea89b9a7dbcd"));
            System.out.print(MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getStartTime().getMonth() + MyCipher.getInstance().decode("a90ea9"));
            String month = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("d35af2712577e387aee9") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getStartTime().getDay() + MyCipher.getInstance().decode("a90ea9"));
            String day = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            String number1 = MyCipher.getInstance().encode(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getEndTime().getDay() - arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getStartTime().getDay());
            System.out.print(MyCipher.getInstance().decode("c44bf2673d3ec983f7bfd69921855b74aa6658b384db01d0") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + Integer.parseInt(MyCipher.getInstance().decode(number1)) + MyCipher.getInstance().decode("a90ea9"));
            String length = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            String number2 = MyCipher.getInstance().encode(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getEndTimeAfterLatency().getDay() - arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getEndTime().getDay());
            System.out.print(MyCipher.getInstance().decode("c44bf2673d3ec983f7bfd69921855b74aa6658b384db01ca2935045dd858cd1609b6e64393f8") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + Integer.parseInt(MyCipher.getInstance().decode(number2)) + MyCipher.getInstance().decode("a90ea9"));
            String latencyDuration = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("d941e6232636c992f7a7db9266b44b31b80b4efa8b8bbb625289d62f07802a20a4") + MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).isBeta() + MyCipher.getInstance().decode("a90ea9"));
            String beta = MyCipher.getInstance().encode(sc.nextLine());
            String isBeta = "e64fff7034";
            if (MyCipher.getInstance().decode(beta).equals(MyCipher.getInstance().decode("f94be0"))) {
                isBeta = "f45ce666";
            }
            System.out.print(MyCipher.getInstance().decode("cc4fe7663f34dec685b2c79e29cb"));
            System.out.print(MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getLateRatio() + MyCipher.getInstance().decode("a90ea9"));
            String lateRatio = MyCipher.getInstance().encode(Double.parseDouble(sc.nextLine()));
            Exercise newExercise = new Exercise(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day))),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode(length))),
                    new Date(Global.currentCourse.getYear(), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day)) + Integer.parseInt(MyCipher.getInstance().decode(length)) + Integer.parseInt(MyCipher.getInstance().decode(latencyDuration))), Boolean.parseBoolean(MyCipher.getInstance().decode(isBeta)),
                    Double.parseDouble(MyCipher.getInstance().decode(lateRatio)));
            showResult(Exercisecontroller.modifyExercise(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))), newExercise));
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

        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            showResult(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            Global.currentExercise = arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")));
        }
    }

    public static void getScoreTable() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66804631b45b1e708d37"));
        ArrayList<Exercise> arr = Global.currentCourse.getExercsies();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        showResult(Exercisecontroller.getScoreTable(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));

    }
}
