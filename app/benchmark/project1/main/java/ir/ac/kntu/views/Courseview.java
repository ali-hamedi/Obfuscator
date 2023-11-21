package app.benchmark.project1.main.java.ir.ac.kntu.views;

import java.util.ArrayList;

import ir.ac.kntu.Global;
import ir.ac.kntu.controller.Coursecontroller;
import ir.ac.kntu.data.db.Database;
import ir.ac.kntu.data.models.*;

public class Courseview extends View {

    public static void addCourse() {
        System.out.println("1-Attend a course");
        System.out.println("2-Create a course");
        int attendOrTeach = Integer.parseInt(sc.nextLine());
        if (attendOrTeach == 2) {
            createCourse();
        } else if (attendOrTeach == 1) {
            attendCourse();
        } else {
            showResult("Please choose a valid task");
        }
    }

    public static void createCourse() {
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Institution:");
        String institution = sc.nextLine();
        System.out.print("Description:");
        String description = sc.nextLine();
        System.out.print("Year:");
        int year = Integer.parseInt(sc.nextLine());
        System.out.print("You want the course to be Public: (yes/no)");
        String privacy = sc.nextLine();
        boolean isPublic = false;
        if (privacy.equals("yes")) {
            isPublic = true;
        }
        System.out.print("Password:");
        String password = sc.nextLine();
        Course newCourse = new Course(name, description, institution, Global.currentUser, year, true, isPublic,
                password);
        showResult(Coursecontroller.addTeachingCourses(newCourse));
    }

    public static void attendCourse() {
        ArrayList<Course> arr = Coursecontroller.getAvailbaleCourses();
        showResult("Choose which course you want to attend :");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            if (!arr.get(n - 1).isPublic()) {
                System.out.print("Enter the course password");
                String pass = sc.nextLine();
                if (arr.get(n - 1).getPassword().equals(pass)) {

                    showResult(Coursecontroller.addAttendedCourses(arr.get(n - 1)));
                } else {
                    showResult("The password is incorrect");
                }
            } else {
                showResult(Coursecontroller.addAttendedCourses(arr.get(n - 1)));
            }
        }
    }

    public static void addUser() {
        System.out.println("Choose which course you want to attend :");
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            System.out.println("Enter the username of the user you wanna add to your course:");
            String userName = sc.nextLine();
            int flag = 0;
            for (User u : Database.users) {
                if (u.getUserName().equals(userName)) {
                    flag++;
                    showResult(Coursecontroller.addUserToCourse(u, arr.get(n - 1)));
                }
            }
            if (flag == 0) {
                showResult("User not found");
            }
        }
    }

    public static void deleteCourse() {
        System.out.println("1-Attended course");
        System.out.println("2-Created course");
        int attendOrTeach = Integer.parseInt(sc.nextLine());
        if (attendOrTeach == 2) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(i + 1 + " " + arr.get(i).getName());
            }
            int n = Integer.parseInt(sc.nextLine());
            if (n < 1 || arr.size() == 0 || n > arr.size()) {
                showResult("Enter valid number");
            } else {
                showResult(Coursecontroller.deleteTeachingCourses(arr.get(n - 1)));
            }
        } else if (attendOrTeach == 1) {
            System.out.println("Choose which course you want to attend :");
            ArrayList<Course> arr = Global.currentUser.getAttendedCourses();
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(i + 1 + " " + arr.get(i).getName());
            }
            int n = Integer.parseInt(sc.nextLine());
            if (n < 1 || arr.size() == 0 || n > arr.size()) {
                showResult("Enter valid number");
            } else {
                showResult(Coursecontroller.deleteAttendedCourses(arr.get(n - 1)));
            }
        } else {
            showResult("Please choose a valid task");
        }
    }

    public static void modifyCourse() {
        System.out.println("Choose which course you want to edit :");
        ArrayList<Course> arr = Global.currentUser.getTeachingCourses();
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {

            System.out.println("Modify the course");
            System.out.print("Name");
            System.out.print("(old name was  " + arr.get(n - 1).getName() + ") :");
            String name = sc.nextLine();
            System.out.print("Institution");
            System.out.print("(old institution was  " + arr.get(n - 1).getInstitution() + ") :");
            String institution = sc.nextLine();
            System.out.print("Description");
            System.out.print("(old description was  " + arr.get(n - 1).getDescription() + ") :");
            String description = sc.nextLine();
            System.out.print("Year");
            System.out.print("(old year was  " + arr.get(n - 1).getYear() + ") :");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("You want the course to be Public");
            System.out.print("(old situation was  " + arr.get(n - 1).isPublic() + ") :");
            boolean isPublic = Boolean.parseBoolean(sc.nextLine());
            System.out.print("Password");
            System.out.print("(old password was  " + arr.get(n - 1).getPassword() + ") :");
            String password = sc.nextLine();
            Course newCourse = new Course(name, description, institution, Global.currentUser, year, true,
                    isPublic,
                    password);

            showResult(Coursecontroller.modifyCourse(newCourse, arr.get(n - 1)));
        }
    }

    public static void chooseCourse() {
        System.out.println("1-Attended  course");
        System.out.println("2-Created  course");
        int attendOrTeach = Integer.parseInt(sc.nextLine());
        if (attendOrTeach == 1) {
            showResult("Attended Courses:");
            for (int i = 0; i < Global.currentUser.getAttendedCourses().size(); i++) {
                showResult(i + 1 + " " + Global.currentUser.getAttendedCourses().get(i).getName());
            }
            int n = Integer.parseInt(sc.nextLine());
            if (n < 1 || Global.currentUser.getAttendedCourses().size() == 0
                    || n > Global.currentUser.getAttendedCourses().size()) {
                showResult("Enter valid number");
            } else {
                Global.currentCourse = Global.currentUser.getAttendedCourses().get(n - 1);
            }
        } else if (attendOrTeach == 2) {
            showResult("Teaching Courses:");
            for (int i = 0; i < Global.currentUser.getTeachingCourses().size(); i++) {
                showResult(i + 1 + " " + Global.currentUser.getTeachingCourses().get(i).getName());
            }
            int n = Integer.parseInt(sc.nextLine());
            if (n < 1 || Global.currentUser.getTeachingCourses().size() == 0
                    || n > Global.currentUser.getTeachingCourses().size()) {
                showResult("Enter valid number");
            } else {
                Global.currentCourse = Global.currentUser.getTeachingCourses().get(n - 1);
            }
        } else {
            showResult("Please pick a valid task");
        }
    }

    public static void closeCourse() {
        System.out.println("Choose which course you want to close:");
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (c.isOpen()) {
                arr.add(c);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Coursecontroller.closeCourse(arr.get(n - 1)));
        }
    }

    public static void opeanCourse() {
        System.out.println("Choose which course you want to open to public:");
        ArrayList<Course> arr = new ArrayList<Course>();
        for (Course c : Global.currentUser.getTeachingCourses()) {
            if (!c.isOpen()) {
                arr.add(c);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i + 1 + " " + arr.get(i).getName());
        }
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || arr.size() == 0 || n > arr.size()) {
            showResult("Enter valid number");
        } else {
            showResult(Coursecontroller.openCourse(arr.get(n - 1)));
        }
    }

}
