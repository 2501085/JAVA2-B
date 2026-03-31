// Person.java  — 부모 클래스
public class Person {
    String name; // 이름
    int    age;  // 나이

    // 생성자
    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // 자기소개 메서드
    void introduce() {
        System.out.printf("안녕하세요, 제 이름은 %s이고 %d살 입니다.%n", name, age);
    }
}
