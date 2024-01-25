package ir.ac.kntu.controller;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Coursecontroller {

    public static String addTeachingCourses(Course teachingCourse) {
        Global.currentUser.getTeachingCourses().add(teachingCourse);
        Database.courses.add(teachingCourse);
        return MyCipher.getInstance().decode("c341e67122328791b6a09394349452204149b666b347ed4a84f70f47a99ac8");
    }

    public static String addAttendedCourses(Course attendedCourse) {
        attendedCourse.getAttendence().add(Global.currentUser);
        Global.currentUser.getAttendedCourses().add(attendedCourse);
        Exercisecontroller.increaseScoreTable(attendedCourse, Global.currentUser);
        Questioncontroller.increseLists(attendedCourse, Global.currentUser);
        return MyCipher.getInstance().decode("c341e67122328791b6a09396229556307087e5bc2e3d6eb46397ae40d6");
    }

    public static String addUserToCourse(User u, Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            u.getAttendedCourses().add(c);
            c.getAttendence().add(u);
            Exercisecontroller.increaseScoreTable(c, u);
            Questioncontroller.increseLists(c, u);
            return MyCipher.getInstance().decode("d446f6232424c294f7bbd28466935631415351145b7bb28326ab61d41f387de688947bd879d12d6d3608a47c437e");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String deleteAttendedCourses(Course c) {
        String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
        for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
            if (Global.currentUser.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                flag = i;
            }
        }
        if (Integer.parseInt(MyCipher.getInstance().decode(flag)) == -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
            return MyCipher.getInstance().decode("c341e67122328788b8a7939129845d30");
        }
        Global.currentUser.getAttendedCourses().remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
        return MyCipher.getInstance().decode("c341e67122328791b6a09393239d5620deb3af742ed1747fa8783490e03125");
    }

    public static String deleteTeachingCourses(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
                for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < u.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                    if (u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                    u.getAttendedCourses().remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
                }
            }
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getTeachingCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentUser.getTeachingCourses().remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
            }
            flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.courses.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Database.courses.remove(Integer.parseInt(MyCipher.getInstance().decode(flag)));
            }
            return MyCipher.getInstance().decode("c341e67122328791b6a09393239d5620deb3af742ed1747fa8783490e03125dce3cdd5755eb311e3970f51a43b92");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static String modifyCourse(Course newCourse, Course oldCourse) {
        if (Global.currentUser.equals(oldCourse.getTeacher())) {
            for (User u : Database.users) {
                String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
                for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < u.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                    if (u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(oldCourse)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                    u.getAttendedCourses().set(Integer.parseInt(MyCipher.getInstance().decode(flag)), newCourse);
                }
            }
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getTeachingCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentUser.getTeachingCourses().set(Integer.parseInt(MyCipher.getInstance().decode(flag)), newCourse);
            }
            flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.courses.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(oldCourse)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Database.courses.set(Integer.parseInt(MyCipher.getInstance().decode(flag)), newCourse);
            }

            return MyCipher.getInstance().decode("c341e67122328791b6a0939a29954a325725a4579c0bd16584d73c8554660f21aeb67a2947e752602366ca22f11f93");

        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");
    }

    public static ArrayList<Course> getAvailbaleCourses() {
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Database.courses) {
            String flag = "b0";
            for (Course c2 : Global.currentUser.getAttendedCourses()) {
                if (c.equals(c2)) {
                    flag = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(flag)) + Integer.parseInt(MyCipher.getInstance().decode("b1")));
                }
            }
            for (Course c2 : Global.currentUser.getTeachingCourses()) {
                if (c.equals(c2)) {
                    flag = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(flag)) + Integer.parseInt(MyCipher.getInstance().decode("b1")));
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) == Integer.parseInt(MyCipher.getInstance().decode("b0")) && c.isOpen()) {
                arr.add(c);
            }
        }
        return arr;
    }

    public static String closeCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
                for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < u.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                    if (u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                    u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(false);
                    ;
                }
            }
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getTeachingCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(false);
                ;
            }
            flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.courses.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(false);
                ;
            }
            return MyCipher.getInstance().decode("c341e6712232878eb6b1939523945d7449ea8fa21710713ca4caa72fa5c9e3630a165071ae412546565d0a886f804c6d1fbd82d946fd7a");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");

    }

    public static String openCourse(Course c) {
        if (Global.currentUser.equals(c.getTeacher())) {
            for (User u : Database.users) {
                String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
                for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < u.getAttendedCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                    if (u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                        flag = i;
                    }
                }
                if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                    u.getAttendedCourses().get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(true);
                    ;
                }
            }
            String flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Global.currentUser.getTeachingCourses().size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Global.currentUser.getTeachingCourses().get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(true);
                ;
            }
            flag = MyCipher.getInstance().encode(-Integer.parseInt(MyCipher.getInstance().decode("b1")));
            for (String i = "b0"; Integer.parseInt(MyCipher.getInstance().decode(i)) < Database.courses.size(); i = MyCipher.getInstance().encode(Integer.parseInt(MyCipher.getInstance().decode(i)) + Integer.parseInt(MyCipher.getInstance().decode("b1")))) {
                if (Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(i))).equals(c)) {
                    flag = i;
                }
            }
            if (Integer.parseInt(MyCipher.getInstance().decode(flag)) != -Integer.parseInt(MyCipher.getInstance().decode("b1"))) {
                Database.courses.get(Integer.parseInt(MyCipher.getInstance().decode(flag))).setOpen(true);
                ;
            }
            return MyCipher.getInstance().decode("c341e6712232878eb6b1939523945d7445f685bf16543732b88ee236aed7e3632b50eb");
        }
        return MyCipher.getInstance().decode("d941e6233025c2c6b9bcc7d732995674b7f3b3831a");

    }
}
