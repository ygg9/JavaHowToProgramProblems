package Week2.Week2ReviewedProgram;

public class Date {
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int month;
    private int day;
    private int year;

    Date(){
        this.month = 0;
        this.day = 0;
        this.year = 0;
    }

    Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

}
