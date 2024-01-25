package ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Exercise {

    private String name;

    private String description;

    private Date startTime;

    private Date endTime;

    private Date endTimeAfterLatency;

    private String isBeta;

    private String lateRatio;

    private ArrayList<Question> questions;

    private HashMap<User, Integer> scoreTable;

    public Exercise(String name, String description, Date startTime, Date endTime, Date endTimeAfterLatency,
            boolean isBeta, double lateRatio) {
        this.name = MyCipher.getInstance().encode(name);
        this.description = MyCipher.getInstance().encode(description);
        this.startTime = startTime;
        this.endTime = endTime;
        this.lateRatio = MyCipher.getInstance().encode(lateRatio);
        this.isBeta = MyCipher.getInstance().encode(isBeta);
        this.scoreTable = new HashMap<User, Integer>();
        this.questions = new ArrayList<Question>();
        this.endTimeAfterLatency = endTimeAfterLatency;
    }

    public boolean isBeta() {
        return Boolean.parseBoolean(MyCipher.getInstance().decode(isBeta));
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setScoreTable(HashMap<User, Integer> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public HashMap<User, Integer> getScoreTable() {
        return scoreTable;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public String getDescription() {
        return MyCipher.getInstance().decode(description);
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getLateRatio() {
        return Double.parseDouble(MyCipher.getInstance().decode(lateRatio));
    }

    public String getName() {
        return MyCipher.getInstance().decode(name);
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTimeAfterLatency() {
        return endTimeAfterLatency;
    }

    
    public boolean equals(Object obj) {
        Exercise e = (Exercise) obj;
        return (MyCipher.getInstance().decode(this.name).equals(e.getName()) && this.startTime == e.getStartTime() && this.endTime == e.getEndTime());
    }

    
    public int hashCode() {
        return Objects.hash(MyCipher.getInstance().decode(name), startTime, endTime);
    }

}