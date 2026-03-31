// Doctor.java  — Person 상속
public class Doctor extends Person {

    Doctor(String name, int age) {
        super(name, age);
    }

    // 진료하기
    void treat() {
        System.out.printf("%s 의사가 환자를 진료합니다.%n", name);
    }

    // 수술하기
    void operate() {
        System.out.printf("%s 의사이 수술도 진행합니다.%n", name);
    }
}
