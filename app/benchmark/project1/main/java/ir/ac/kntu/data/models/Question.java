package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import ir.ac.kntu.data.models.enums.*;

public class Question {

    private String name;

    private String description;

    private String body;

    private int point;

    private Difficulty difficulty;

    private Type type;

    private String answer;

    private HashMap<User, ArrayList<String>> submitsList;

    private HashMap<User, String> finalSubmitList;

    private HashMap<User, Integer> usersPoint;

    public Question(String name, String description, String body, int point, Difficulty difficulty, Type type,
            String answer) {
        this.name = name;
        this.description = description;
        this.body = body;
        this.point = point;
        this.difficulty = difficulty;
        this.type = type;
        this.answer = answer;
        this.submitsList = new HashMap<User, ArrayList<String>>();
        this.usersPoint = new HashMap<User, Integer>();
        this.finalSubmitList = new HashMap<User, String>();
    }

    public String getAnswer() {
        return answer;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
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
            return 1;
        } else if (this.difficulty == Difficulty.Medium) {
            return 2;
        } else if (this.difficulty == Difficulty.Hard) {
            return 3;
        } else if (this.difficulty == Difficulty.VeryHard) {
            return 4;
        } else {
            return -1;
        }
    }

    public String getDifficultyString() {
        if (this.difficulty == Difficulty.Easy) {
            return "easy";
        } else if (this.difficulty == Difficulty.Medium) {
            return "medium";
        } else if (this.difficulty == Difficulty.Hard) {
            return "hard";
        } else if (this.difficulty == Difficulty.VeryHard) {
            return "very hard";
        } else {
            return "";
        }
    }

    @Override
    public boolean equals(Object obj) {
        Question e = (Question) obj;
        return (this.name.equals(e.getName()) && this.description == e.getDescription() && this.body == e.getBody()
                && this.point == e.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, body, point);
    }

}
