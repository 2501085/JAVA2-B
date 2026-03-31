//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        // 도서관 생성
        Library lib = new Library("경복 도서관");

        System.out.println("===== " + lib.libraryName + " =====\n");

        // ── 회원 가입 ──────────────────
        Member m1 = new Member("M001", "홍길동");
        Member m2 = new Member("M002", "김영희");
        lib.registerMember(m1);
        lib.registerMember(m2);

        System.out.println();

        // ── 도서 입고 ──────────────────
        Book b1 = new Book("자바의 정석",   "남궁성");
        Book b2 = new Book("클린 코드",     "로버트 마틴");
        Book b3 = new Book("객체지향의 사실과 오해", "조영호");
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);

        // ── 대출 현황 (대출 전) ──────────
        lib.printStatus();

        // ── 도서 대출 ──────────────────
        lib.borrowBook(m1, "자바의 정석");
        lib.borrowBook(m2, "클린 코드");
        lib.borrowBook(m2, "자바의 정석"); // 이미 대출 중 → 오류 메시지

        // ── 대출 현황 (대출 후) ──────────
        lib.printStatus();

        // ── 도서 반납 ──────────────────
        lib.returnBook(m1, "자바의 정석");

        // ── 대출 현황 (반납 후) ──────────
        lib.printStatus();
    }
}