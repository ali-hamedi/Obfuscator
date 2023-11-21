package app.benchmark.project1.main.java.ir.ac.kntu.data.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Exercise {

    private String name;

    private String description;

    private Date startTime;

    private Date endTime;

    private Date endTimeAfterLatency;

    private boolean isBeta;

    private double lateRatio;

    private ArrayList<Question> questions;

    private HashMap<User, Integer> scoreTable;

    public Exercise(String name, String description, Date startTime, Date endTime, Date endTimeAfterLatency,
            boolean isBeta, double lateRatio) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lateRatio = lateRatio;
        this.isBeta = isBeta;
        this.scoreTable = new HashMap<User, Integer>();
        this.questions = new ArrayList<Question>();
        this.endTimeAfterLatency = endTimeAfterLatency;
    }

    public boolean isBeta() {
        return isBeta;
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
        return description;
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getLateRatio() {
        return lateRatio;
    }

    public String getName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTimeAfterLatency() {
        return endTimeAfterLatency;
    }

    @Override
    public boolean equals(Object obj) {
        Exercise e = (Exercise) obj;
        return (this.name.equals(e.getName()) && this.startTime == e.getStartTime() && this.endTime == e.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime);
    }

}