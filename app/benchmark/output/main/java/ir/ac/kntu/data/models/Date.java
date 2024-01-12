package ir.ac.kntu.data.models;

import java.util.Objects;
import ir.ac.kntu.Main;

public class Date {

    public String year;

    public String month;

    public String day;

    public Date(int year, int month, int day) {
        while (day > Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWK4yElFLIKz3EznHFCwE10="))) {
            day = day - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWK4yElFLIKz3EznHFCwE10="));
            month = month + 1;
        }
        while (day > Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWC6yElFLIKz3EznHFCwE10="))) {
            month = month - Integer.parseInt(Main.decode("YWFhYWFhYWFhYWFhYWFhYWC6yElFLIKz3EznHFCwE10="));
            year = year + 1;
        }

        this.year = String.valueOf(year);
        this.month = String.valueOf(month);
        this.day = String.valueOf(day);
    }

    public int getDay() {
        return Integer.parseInt(Main.decode(day));
    }

    public int getMonth() {
        return Integer.parseInt(Main.decode(month));
    }

    public int getYear() {
        return Integer.parseInt(Main.decode(year));
    }

    public void setDay(int day) {
        this.day = String.valueOf(day);
    }

    public void setMonth(int month) {
        this.month = String.valueOf(month);
    }

    public void setYear(int year) {
        this.year = String.valueOf(year);
    }

    public boolean equals(Object obj) {
        Date d = (Date) obj;
        return (Integer.parseInt(Main.decode(this.year)) == d.getYear()
                && Integer.parseInt(Main.decode(this.month)) == d.getMonth()
                && Integer.parseInt(Main.decode(this.day)) == d.getDay());
    }

    public int hashCode() {
        return Objects.hash(Integer.parseInt(Main.decode(year)), Integer.parseInt(Main.decode(month)),
                Integer.parseInt(Main.decode(day)));
    }
}
