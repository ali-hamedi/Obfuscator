package ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Coursecontroller;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Courseview extends View {

    public static void addCourse() {
        System.out.println(MyCipher.getInstance().decode("b103d2772532c982f7b293942984412791"));
        System.out.println(MyCipher.getInstance().decode("b203d0713436d383f7b29394298441270c"));
        String attendOrTeach = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b2"))) {
            createCourse();
        } else if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            attendCourse();
        } else {
            showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
        }
    }

    public static void createCourse() {
        System.out.print(MyCipher.getInstance().decode("ce4ffe666b"));
        String name = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("c940e0773823d292bebcddcd"));
        String institution = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcddcd"));
        String description = MyCipher.getInstance().encode(sc.nextLine());
        System.out.print(MyCipher.getInstance().decode("d94bf2716b"));
        String year = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        System.out.print(MyCipher.getInstance().decode("d941e6232636c992f7a7db9266925c21ab50324d475a55896baf41ebc3a5f22457974ecc0e2b9e91c62d"));
        String privacy = MyCipher.getInstance().encode(sc.nextLine());
        String isPublic = "e64fff7034";
        if (MyCipher.getInstance().decode(privacy).equals(MyCipher.getInstance().decode("f94be0"))) {
            isPublic = "f45ce666";
        }
        System.out.print(MyCipher.getInstance().decode("d04fe0702638d582ed"));
        String password = MyCipher.getInstance().encode(sc.nextLine());
        Course newCourse = new Course(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(institution), Global.currentUser, Integer.parseInt(MyCipher.getInstance().decode(year)), true, Boolean.parseBoolean(MyCipher.getInstance().decode(isPublic)),
                MyCipher.getInstance().decode(password));
        showResult(Coursecontroller.addTeachingCourses(newCourse));
    }

    public static void attendCourse() {
        ArrayList<Course> arr = Coursecontroller.getAvailbaleCourses();
        showResult(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcbdf1a4a70b3d9656"));
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            if (!arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).isPublic()) {
                System.out.print(MyCipher.getInstance().decode("c540e7662377d38eb2f3d09833834031b04f9ee3e7eff64e72"));
                String pass = MyCipher.getInstance().encode(sc.nextLine());
                if (arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getPassword().equals(MyCipher.getInstance().decode(pass))) {

                    showResult(Coursecontroller.addAttendedCourses(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
                } else {
                    showResult(MyCipher.getInstance().decode("d446f6232136d495a0bcc193669840742f2b3cb7e2ffa44136"));
                }
            } else {
                showResult(Coursecontroller.addAttendedCourses(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
            }
        }
    }

    public static void addUser() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcbdf1a4a70b3d9656"));
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            System.out.println(MyCipher.getInstance().decode("c540e7662377d38eb2f3c68423835d35863fdeffb99b76caddb9d6f154b20968aa48c0928cd726179b3971faf09330735443b61855443f0f5a2bdba0"));
            String userName = MyCipher.getInstance().encode(sc.nextLine());
            String flag = "b0";
            for (User u : Database.users) {
                if (u.getUserName().equals(MyCipher.getInstance().decode(userName))) {
                    flag = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(flag)) + Integer.parseInt(MyCipher.getInstance().decode("b1")));
                    showResult(Coursecontroller.addUserToCourse(u, arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) == Integer.parseInt(MyCipher.getInstance().decode("b0"))) {
                showResult(MyCipher.getInstance().decode("d55df6717139c892f7b5dc822895"));
            }
        }
    }

    public static void deleteCourse() {
        System.out.println(MyCipher.getInstance().decode("b103d2772532c982b2b793942984412714"));
        System.out.println(MyCipher.getInstance().decode("b203d0713436d383b3f3d09833834031"));
        String attendOrTeach = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b2"))) {
            System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcbdf1a4a70b3d9656"));
            ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                showResult(Coursecontroller.deleteTeachingCourses(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
            }
        } else if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcbdf1a4a70b3d9656"));
            ArrayList<Course> arr = Global.currentUser.getAttendedCourses();
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                showResult(Coursecontroller.deleteAttendedCourses(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
            }
        } else {
            showResult(MyCipher.getInstance().decode("d042f66222328785bfbcdc8423d1527444e6afcbdac06e107270"));
        }
    }

    public static void modifyCourse() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcb9e1b9b64563"));
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {

            System.out.println(MyCipher.getInstance().decode("cd41f76a372e8792bfb69394298441276b"));
            System.out.print(MyCipher.getInstance().decode("ce4ffe66"));
            System.out.print(MyCipher.getInstance().decode("a841ff677139c68bb2f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getName() + MyCipher.getInstance().decode("a90ea9"));
            String name = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c940e0773823d292bebcdd"));
            System.out.print(MyCipher.getInstance().decode("a841ff67713ec995a3bac78232985c3a11ecf7425025") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getInstitution() + MyCipher.getInstance().decode("a90ea9"));
            String institution = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("c44be060233ed792bebcdd"));
            System.out.print(MyCipher.getInstance().decode("a841ff677133c295b4a1da8732985c3ae52bc25fd3fa") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getDescription() + MyCipher.getInstance().decode("a90ea9"));
            String description = MyCipher.getInstance().encode(sc.nextLine());
            System.out.print(MyCipher.getInstance().decode("d94bf271"));
            System.out.print(MyCipher.getInstance().decode("a841ff67712ec287a5f3c49635d113") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getYear() + MyCipher.getInstance().decode("a90ea9"));
            String year = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("d941e6232636c992f7a7db9266925c21ab50324d475a55896baf41ebc3a5f224"));
            System.out.print(MyCipher.getInstance().decode("a841ff677124ce92a2b2c79e299f132342c9f496") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).isPublic() + MyCipher.getInstance().decode("a90ea9"));
            String isPublic = MyCipher.getInstance().encode(Boolean.parseBoolean(sc.nextLine()));
            System.out.print(MyCipher.getInstance().decode("d04fe0702638d582"));
            System.out.print(MyCipher.getInstance().decode("a841ff677127c695a4a4dc8522d1443588fbe9") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1"))).getPassword() + MyCipher.getInstance().decode("a90ea9"));
            String password = MyCipher.getInstance().encode(sc.nextLine());
            Course newCourse = new Course(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(institution), Global.currentUser, Integer.parseInt(MyCipher.getInstance().decode(year)), true,
                    Boolean.parseBoolean(MyCipher.getInstance().decode(isPublic)),
                    MyCipher.getInstance().decode(password));

            showResult(Coursecontroller.modifyCourse(newCourse, arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }

    public static void chooseCourse() {
        System.out.println(MyCipher.getInstance().decode("b103d2772532c982b2b793d7259e4626b049"));
        System.out.println(MyCipher.getInstance().decode("b203d0713436d383b3f39394298441275f"));
        String attendOrTeach = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            showResult(MyCipher.getInstance().decode("c15ae7663f33c282f790dc823482562799"));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                showResult(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + Global.currentUser.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || Global.currentUser.getAttendedCourses().size() == Integer.parseInt(MyCipher.getInstance().decode("b0"))
                    || Integer.parseInt(MyCipher.getInstance().decode(n)) > Global.currentUser.getAttendedCourses().size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                Global.currentCourse = Global.currentUser.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")));
            }
        } else if (Integer.parseInt(MyCipher.getInstance().decode(attendOrTeach)) == Integer.parseInt(MyCipher.getInstance().decode("b2"))) {
            showResult(MyCipher.getInstance().decode("d44bf260393ec981f790dc8234825627e4"));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getTeachingCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                showResult(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
            }
            String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
            if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || Global.currentUser.getTeachingCourses().size() == Integer.parseInt(MyCipher.getInstance().decode("b0"))
                    || Integer.parseInt(MyCipher.getInstance().decode(n)) > Global.currentUser.getTeachingCourses().size()) {
                showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
            } else {
                Global.currentCourse = Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")));
            }
        } else {
            showResult(MyCipher.getInstance().decode("d042f66222328796beb0d8d727d14535043ea40f2cf1cb37"));
        }
    }

    public static void closeCourse() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcbfe9bfb10063"));
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (c.isOpen()) {
                arr.add(c);
            }
        }
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Coursecontroller.closeCourse(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }

    public static void opeanCourse() {
        System.out.println(MyCipher.getInstance().decode("c346fc6c22328791bfbad09f66925c21a09882c2498956c32de01e9000192cfcb3f5b5ac452dd94ca8cbdf1b5516c6"));
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (!c.isOpen()) {
                arr.add(c);
            }
        }
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < arr.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            System.out.println(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")) + MyCipher.getInstance().decode("a0") + arr.get(Integer.parseInt(MyCipher.getInstance().decode(i))).getName());
        }
        String n = MyCipher.getInstance().encode(Integer.parseInt(sc.nextLine()));
        if (Integer.parseInt(MyCipher.getInstance().decode(n)) < Integer.parseInt(MyCipher.getInstance().decode("b1")) || arr.size() == Integer.parseInt(MyCipher.getInstance().decode("b0")) || Integer.parseInt(MyCipher.getInstance().decode(n)) > arr.size()) {
            showResult(MyCipher.getInstance().decode("c540e7662377d187bbbad7d728845e368ea3"));
        } else {
            showResult(Coursecontroller.openCourse(arr.get(Integer.parseInt(MyCipher.getInstance().decode(n)) - Integer.parseInt(MyCipher.getInstance().decode("b1")))));
        }
    }

}
