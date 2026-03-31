//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // Student 객체 생성
        Student s1 = new Student("홍길동", "2501085", "소프트웨어융합과", 2006);
        Student s2 = new Student("김영희", "2501001", "소프트웨어융합과", 2000);

        // 정보 및 나이 출력
        s1.printInfo();
        s2.printInfo();
    }
}