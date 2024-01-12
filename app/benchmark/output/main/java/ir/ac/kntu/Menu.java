package ir.ac.kntu;

import java.util.Scanner;

import ir.ac.kntu.views.View;

public class Menu extends View {

    public static int shoMenuHandler() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XCEMFq6GVc="));
        String n = String.valueOf(-Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")));
        if (Global.currentUser == null) {
            n = String.valueOf(mainMenu());
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO46wUqQeef2krhGla2FVs="));
            if (Global.currentCourse == null) {
                n = String.valueOf(courseMenu());
            } else if (Global.currentExercise == null) {
                n = String.valueOf(exerciseMenu());
            } else {
                n = String.valueOf(questionMenu());
            }
        }
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXPUs3d7E87m4XWEMFq6GVc="));
        if (Integer.parseInt(Main.decode(n)) == Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="))) {
            n = String.valueOf(userMenu());
        }
        return Integer.parseInt(Main.decode(n));
    }

    public static int mainMenu() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56xQiTOuduyzLF1u7GFY="));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66xQuQ/7eumKqfSvMbjYFPr8v0RPuJVZnbdl+nA76"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO76xQuQ/7eumK8YTvMP1I="));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO86wYvRqzspyeaZjfRc3PEB9KdWNwhMDYBG/V2vcPs2E2FY7EmF2ux9Kkp77MJnw=="));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO96xQjTfudgzeMYSrXcj2eTWxI/7T8ZihsBRz290WC"));
        sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int userMenu() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56xUuReXOpiebMFq6GVc="));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wskReXT8EXuFVm5GlQ="));
        return Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw=")) + sc.nextLine());
    }

    public static int courseMenu() {
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wYvRqzc8iyMZX7dciaVb3FyNYQV1+SkJjzp4oSE"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wMuTunJt2KIMj3RaCFXj8ZRDVDG4md3gNNlRMRS"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO76wokS+jbq2LJc37dciZn/8M3NAUT702OaEsmH2bJ"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO86wYvRqzIoSebMirRPTJm/GZIuqb4by/tF5UTy9wt"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO96wQnTf/Y8iPJcTHLbyC9c4eOhTQVEuwk81CxZ9JL"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO+6wg7R+Kds2KKfjHNeCG7fMXmpigAsty5QjxFfyi4"));
        System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO/6wQjTePOt2KIMj3RaCFY1Iro51R6dnmwLGDju8VZ"));
        return Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw=")) + sc.nextLine());
    }

    public static int exerciseMenu() {
        String n = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wQ5R+3Jt2KIMjDbanPNjkV4ZolLqcvNuSSPoqeO"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wMuTunJt2KIfH7bZTbQAXMJiu6wZoH1J8g+gPku"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO76wokRuXbq2KIfH7bZTYig40FRrF2J0mGBvOrcVZm"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO86wQjTePOt2KIfH6eWCt+dh+6Q9bh3T3ub8ALZoqf"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO96wAuVqzOsS2bd37KfDEm23SX8MYOXJBRipJ3ZIPW"));
            n = String.valueOf(Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw=")) + sc.nextLine()));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO86wQjTePOt2KIfH6eWCt+dh+6Q9bh3T3ub8ALZoqf"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO96wAuVqzOsS2bd37KfDEm23SX8MYOXJBRipJ3ZIPW"));
            n = String.valueOf(Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw=")) + sc.nextLine()));
        }
        return Integer.parseInt(Main.decode(n));
    }

    public static int questionMenu() {
        String n = "YWFhYWFhYWFhYWFhYWFhYWGHyUhELYOy3U3mHVGxElw=";
        if (Global.currentCourse.getTeacher().equals(Global.currentUser)) {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO56wYvRqzc8mKYZzvNaTqmFFxJXKOOW5hGQRek21hY"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO66wMuTunJt2KIMi/LeCDXJybs07pvLe/IfPF7gABD"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO76wokRuXbq2KIMi/LeCAH+iF04Y8TQD7ll8/v+Zns"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO86wAuVqzcvi7JfTiefHO+dvFUCPAACnn3h3rgM7sa"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO96wA5Q+jY8iPJYyvbbif9U5Xie5QDkRs4W7WZ+MXj"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO+6wAuVqzOpyCEeyrNPTK14TWuOVKuGqkmn2toJ0pR"));
            n = String.valueOf(Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWWHyUhELYOy3U3mHVGxElw=")) + sc.nextLine()));
        } else {
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXO/6wYlUfvYoGKIMj+ebDbHX6ukJsI6N7pE7fKUv497"));
            System.out.println(Main.decode("YWFhYWFhYWFhYWFhYWFhYXOw6xQuVqzEvTebMjjXczKJrgXNSPHCd4y2Jw22uZhy"));
            n = String.valueOf(Integer.parseInt(Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWWHyUhELYOy3U3mHVGxElw=")) + sc.nextLine()));
        }

        return Integer.parseInt(Main.decode(n));
    }

}
