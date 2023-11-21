package app.benchmark.project1.main.java.ir.ac.kntu.data.models;

import java.util.Objects;

public class Date {

    public int year;

    public int month;

    public int day;

    public Date(int year, int month, int day) {
        while (day > 30) {
            day -= 30;
            month++;
        }
        while (day > 12) {
            month -= 12;
            year++;
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        Date d = (Date) obj;
        return (this.year == d.getYear() && this.month == d.getMonth() && this.day == d.getDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
