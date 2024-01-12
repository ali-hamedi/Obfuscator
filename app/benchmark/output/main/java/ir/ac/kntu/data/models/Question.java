package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import ir.ac.kntu.Main;

import ir.ac.kntu.data.models.enums.*;

public class Question {

    private String name;

    private String description;

    private String body;

    private String point;

    private Difficulty difficulty;

    private Type type;

    private String answer;

    private HashMap<User, ArrayList<String>> submitsList;

    private HashMap<User, String> finalSubmitList;

    private HashMap<User, Integer> usersPoint;

    public Question(String name, String description, String body, int point, Difficulty difficulty, Type type,
            String answer) {
        this.name = String.valueOf(name);
        this.description = String.valueOf(description);
        this.body = String.valueOf(body);
        this.point = String.valueOf(point);
        this.difficulty = difficulty;
        this.type = type;
        this.answer = String.valueOf(answer);
        this.submitsList = new HashMap<User, ArrayList<String>>();
        this.usersPoint = new HashMap<User, Integer>();
        this.finalSubmitList = new HashMap<User, String>();
    }

    public String getAnswer() {
        return Main.decode(answer);
    }

    public String getDescription() {
        return Main.decode(description);
    }

    public String getBody() {
        return Main.decode(body);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return Main.decode(name);
    }

    public int getPoint() {
        return Integer.parseInt(Main.decode(point));
    }

    public Type getType() {
        return type;
    }

    public HashMap<User, ArrayList<String>> getSubmitsList() {
        return submitsList;
    }

    public HashMap<User, Integer> getUsersPoint() {
        return usersPoint;
    }

    public HashMap<User, String> getFinalSubmitList() {
        return finalSubmitList;
    }

    public void setSubmitsList(HashMap<User, ArrayList<String>> submitsList) {
        this.submitsList = submitsList;
    }

    public void setFinalSubmitList(HashMap<User, String> finalSubmitList) {
        this.finalSubmitList = finalSubmitList;
    }

    public int getDifficultyInt() {
        if (this.difficulty == Difficulty.Easy) {
            return Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="));
        } else if (this.difficulty == Difficulty.Medium) {
            return Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWOHyUhELYOy3U3mHVGxElw="));
        } else if (this.difficulty == Difficulty.Hard) {
            return Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWKHyUhELYOy3U3mHVGxElw="));
        } else if (this.difficulty == Difficulty.VeryHard) {
            return Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWWHyUhELYOy3U3mHVGxElw="));
        } else {
            return -Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWCHyUhELYOy3U3mHVGxElw="));
        }
    }

    public String getDifficultyString() {
        if (this.difficulty == Difficulty.Easy) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPtpzQyAIa32EjjGFS0F1k=");
        } else if (this.difficulty == Difficulty.Medium) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPloyMiV+Gf2krhGla2FVs=");
        } else if (this.difficulty == Difficulty.Hard) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXPgpzUvAIa32EjjGFS0F1k=");
        } else if (this.difficulty == Difficulty.VeryHard) {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXP+ozUyAuTcoCbLF1u7GFY=");
        } else {
            return Main.decode("YWFhYWFhYWFhYWFhYWFhYXOqyElFLIKz3EznHFCwE10=");
        }
    }

    
    public boolean equals(Object obj) {
        Question e = (Question) obj;
        return (Main.decode(this.name).equals(e.getName()) && Main.decode(this.description) == e.getDescription() && Main.decode(this.body) == e.getBody()
                && Integer.parseInt(Main.decode(this.point)) == e.getPoint());
    }

    
    public int hashCode() {
        return Objects.hash(Main.decode(name), Main.decode(description), Main.decode(body), Integer.parseInt(Main.decode(point)));
    }

}
