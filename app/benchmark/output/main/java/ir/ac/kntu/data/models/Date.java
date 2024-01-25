package ir.ac.kntu.data.models;

import java.util.Objects;
import ir.ac.kntu.Main;
import ir.ac.kntu.MyCipher;


public class Date {

    public String year;

    public String month;

    public String day;

    public Date(int year, int month, int day) {
        while (day > Integer.parseInt(MyCipher.getInstance().decode("b31e"))) {
            day = day - Integer.parseInt(MyCipher.getInstance().decode("b31e"));
            month = month + Integer.parseInt(MyCipher.getInstance().decode("b1"));
        }
        while (day > Integer.parseInt(MyCipher.getInstance().decode("b11c"))) {
            month = month - Integer.parseInt(MyCipher.getInstance().decode("b11c"));
            year = year + Integer.parseInt(MyCipher.getInstance().decode("b1"));
        }

        this.year = MyCipher.getInstance().encode(year);
        this.month = MyCipher.getInstance().encode(month);
        this.day = MyCipher.getInstance().encode(day);
    }

    public int getDay() {
        return Integer.parseInt(MyCipher.getInstance().decode(day));
    }

    public int getMonth() {
        return Integer.parseInt(MyCipher.getInstance().decode(month));
    }

    public int getYear() {
        return Integer.parseInt(MyCipher.getInstance().decode(year));
    }

    public void setDay(int day) {
        this.day = MyCipher.getInstance().encode(day);
    }

    public void setMonth(int month) {
        this.month = MyCipher.getInstance().encode(month);
    }

    public void setYear(int year) {
        this.year = MyCipher.getInstance().encode(year);
    }

    
    public boolean equals(Object obj) {
        Date d = (Date) obj;
        return (Integer.parseInt(MyCipher.getInstance().decode(this.year)) == d.getYear() && Integer.parseInt(MyCipher.getInstance().decode(this.month)) == d.getMonth() && Integer.parseInt(MyCipher.getInstance().decode(this.day)) == d.getDay());
    }

    
    public int hashCode() {
        return Objects.hash(Integer.parseInt(MyCipher.getInstance().decode(year)), Integer.parseInt(MyCipher.getInstance().decode(month)), Integer.parseInt(MyCipher.getInstance().decode(day)));
    }
}
