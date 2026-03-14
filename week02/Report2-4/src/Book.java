public class Book {
    // Field (멤버 변수) - private
    private String title;   // 책 이름
    private String author;  // 저자

    // 생성자
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // toString 메서드
    public String toString() {
        return String.format("책 제목 : %s,  저자 : %s", title, author);
    }
}
