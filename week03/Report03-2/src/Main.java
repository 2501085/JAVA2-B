// Main.java
public class Main {
    public static void main(String[] args) {
        // 객체 생성
        Teacher  t = new Teacher ("영희", 24);
        Doctor   d = new Doctor  ("철수", 45);
        Engineer e = new Engineer("민수", 35);

        // 자기소개
        t.introduce();
        d.introduce();
        e.introduce();

        // 각 직업별 기능 수행
        t.teach();
        t.grade();
        d.treat();
        d.operate();
        e.develop();
        e.fixBug();
    }
}