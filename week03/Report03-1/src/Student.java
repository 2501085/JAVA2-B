public class Student {
    // 필드 (속성)
    String name;        // 이름
    String rollno;      // 학번
    String depart;      // 학과
    int birthYear;      // 생년 (나이 계산용)

    // 생성자
    Student(String name, String rollno, String depart, int birthYear) {
        this.name      = name;
        this.rollno    = rollno;
        this.depart    = depart;
        this.birthYear = birthYear;
    }

    // 나이 계산 메서드
    int getAge() {
        return 2026 - birthYear + 1; // 한국식 나이
    }

    // 정보 출력 메서드
    void printInfo() {
        System.out.printf("이름: %s, 학번: %s, 학과: %s, 나이: %d살%n",
                name, rollno, depart, getAge());
    }
}
