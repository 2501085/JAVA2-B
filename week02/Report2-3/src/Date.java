public class Date {
    // Member 변수
    private int year;
    private int month;
    private int day;

    // 생성자
    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // year setter (년도만 수정)
    void setYear(int year) {
        this.year = year;
    }

    // toString 메서드
    String toString2() {
        return String.format("%d년 %d월 %d일", year, month, day);
    }
}
