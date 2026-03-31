public class Member {
    String memberId;   // 회원 ID
    String name;       // 이름

    Member(String memberId, String name) {
        this.memberId = memberId;
        this.name     = name;
    }

    // 회원 정보 출력
    void printInfo() {
        System.out.printf("[회원] ID: %s, 이름: %s%n", memberId, name);
    }
}
