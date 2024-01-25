package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import ir.ac.kntu.Main;

import ir.ac.kntu.data.models.enums.*;
import ir.ac.kntu.MyCipher;


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
        this.name = MyCipher.getInstance().encode(name);
        this.description = MyCipher.getInstance().encode(description);
        this.body = MyCipher.getInstance().encode(body);
        this.point = MyCipher.getInstance().encode(point);
        this.difficulty = difficulty;
        this.type = type;
        this.answer = MyCipher.getInstance().encode(answer);
        this.submitsList = new HashMap<User, ArrayList<String>>();
        this.usersPoint = new HashMap<User, Integer>();
        this.finalSubmitList = new HashMap<User, String>();
    }

    public String getAnswer() {
        return MyCipher.getInstance().decode(answer);
    }

    public String getDescription() {
        return MyCipher.getInstance().decode(description);
    }

    public String getBody() {
        return MyCipher.getInstance().decode(body);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return MyCipher.getInstance().decode(name);
    }

    public int getPoint() {
        return Integer.parseInt(MyCipher.getInstance().decode(point));
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
            return Integer.parseInt(MyCipher.getInstance().decode("b1"));
        } else if (this.difficulty == Difficulty.Medium) {
            return Integer.parseInt(MyCipher.getInstance().decode("b2"));
        } else if (this.difficulty == Difficulty.Hard) {
            return Integer.parseInt(MyCipher.getInstance().decode("b3"));
        } else if (this.difficulty == Difficulty.VeryHard) {
            return Integer.parseInt(MyCipher.getInstance().decode("b4"));
        } else {
            return -Integer.parseInt(MyCipher.getInstance().decode("b1"));
        }
    }

    public String getDifficultyString() {
        if (this.difficulty == Difficulty.Easy) {
            return MyCipher.getInstance().decode("e54fe07a");
        } else if (this.difficulty == Difficulty.Medium) {
            return MyCipher.getInstance().decode("ed4bf76a243a");
        } else if (this.difficulty == Difficulty.Hard) {
            return MyCipher.getInstance().decode("e84fe167");
        } else if (this.difficulty == Difficulty.VeryHard) {
            return MyCipher.getInstance().decode("f64be17a713fc694b3");
        } else {
            return MyCipher.getInstance().decode("");
        }
    }

    
    public boolean equals(Object obj) {
        Question e = (Question) obj;
        return (MyCipher.getInstance().decode(this.name).equals(e.getName()) && MyCipher.getInstance().decode(this.description) == e.getDescription() && MyCipher.getInstance().decode(this.body) == e.getBody()
                && Integer.parseInt(MyCipher.getInstance().decode(this.point)) == e.getPoint());
    }

    
    public int hashCode() {
        return Objects.hash(MyCipher.getInstance().decode(name), MyCipher.getInstance().decode(description), MyCipher.getInstance().decode(body), Integer.parseInt(MyCipher.getInstance().decode(point)));
    }

}
