// Engineer.java  — Person 상속
public class Engineer extends Person {

    Engineer(String name, int age) {
        super(name, age);
    }

    // 개발하기
    void develop() {
        System.out.printf("%s 엔지니어가 프로그램을 개발합니다.%n", name);
    }

    // 버그 수정
    void fixBug() {
        System.out.printf("%s 엔지니어가 프로젝트의 버그를 수정합니다.%n", name);
    }
}
