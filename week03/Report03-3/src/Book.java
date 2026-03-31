public class Book {
    String  title;      // 제목
    String  author;     // 저자
    boolean isBorrowed; // 대출 여부

    Book(String title, String author) {
        this.title      = title;
        this.author     = author;
        this.isBorrowed = false; // 초기: 대출 가능
    }

    // 책 정보 출력
    void printInfo() {
        String status = isBorrowed ? "대출 중" : "대출 가능";
        System.out.printf("[책] %s / %s — %s%n", title, author, status);
    }
}
