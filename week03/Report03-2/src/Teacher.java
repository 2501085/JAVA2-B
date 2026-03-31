// Teacher.java  — Person 상속
public class Teacher extends Person {

    Teacher(String name, int age) {
        super(name, age);
    }

    // 수업하기
    void teach() {
        System.out.printf("%s 선생님이 수업을 합니다.%n", name);
    }

    // 채점하기
    void grade() {
        System.out.printf("%s 선생님이 과제를 채점합니다.%n", name);
    }
}