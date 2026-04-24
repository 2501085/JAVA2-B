import java.time.LocalDate;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setYear(int year) {
        if (year >= 1) this.year = year;
        else System.err.println("ERROR : 년도 오류");
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) this.month = month;
        else System.err.println("ERROR : 월 오류");
    }

    public void setDay(int day) {
        boolean flag = false;
        if (day >= 1) {
            if (leapYear(year) && month == 2) {
                if (day <= 29) this.day = day;
                else flag = true;
            } else {
                if (month == 1 || month == 3 || month == 5 || month == 7
                        || month == 8 || month == 10 || month == 12) {
                    if (day <= 31) this.day = day;
                    else flag = true;
                } else if (month == 2) {
                    if (day <= 28) this.day = day;
                    else flag = true;
                } else {
                    if (day <= 30) this.day = day;
                    else flag = true;
                }
            }
        } else {
            flag = true;
        }
        if (flag) System.err.println("ERROR : 일자 오류");
    }

    public void setDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    private boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    @Override
    public String toString() {
        return String.format("(%4d년 %2d월 %2d일)", year, month, day);
    }
}