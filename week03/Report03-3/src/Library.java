public class Library {
    String    libraryName;          // 도서관 이름
    Member[]  members;              // 회원 목록
    Book[]    books;                // 도서 목록
    int       memberCount;          // 현재 회원 수
    int       bookCount;            // 현재 도서 수

    Library(String libraryName) {
        this.libraryName = libraryName;
        this.members     = new Member[100];
        this.books       = new Book[100];
        this.memberCount = 0;
        this.bookCount   = 0;
    }

    // ── 회원 가입 ──────────────────────────────
    void registerMember(Member member) {
        members[memberCount] = member;
        memberCount++;
        System.out.printf("✔ 회원 가입 완료: %s (%s)%n",
                member.name, member.memberId);
    }

    // ── 도서 입고 ──────────────────────────────
    void addBook(Book book) {
        books[bookCount] = book;
        bookCount++;
        System.out.printf("✔ 도서 입고 완료: 『%s』 — %s%n",
                book.title, book.author);
    }

    // ── 도서 대출 ──────────────────────────────
    void borrowBook(Member member, String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                if (!books[i].isBorrowed) {
                    books[i].isBorrowed = true;
                    System.out.printf("✔ 대출 완료: %s님이 『%s』을(를) 대출했습니다.%n",
                            member.name, title);
                } else {
                    System.out.printf("✘ 대출 불가: 『%s』은(는) 현재 대출 중입니다.%n", title);
                }
                return;
            }
        }
        System.out.printf("✘ 도서 없음: 『%s』을(를) 찾을 수 없습니다.%n", title);
    }

    // ── 도서 반납 ──────────────────────────────
    void returnBook(Member member, String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equals(title)) {
                if (books[i].isBorrowed) {
                    books[i].isBorrowed = false;
                    System.out.printf("✔ 반납 완료: %s님이 『%s』을(를) 반납했습니다.%n",
                            member.name, title);
                } else {
                    System.out.printf("✘ 반납 오류: 『%s』은(는) 대출된 상태가 아닙니다.%n", title);
                }
                return;
            }
        }
        System.out.printf("✘ 도서 없음: 『%s』을(를) 찾을 수 없습니다.%n", title);
    }

    // ── 대출 현황 출력 ─────────────────────────
    void printStatus() {
        System.out.println("\n========== 대출 현황 ==========");
        for (int i = 0; i < bookCount; i++) {
            books[i].printInfo();
        }
        System.out.println("================================\n");
    }
}
