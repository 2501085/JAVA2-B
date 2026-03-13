//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    private String name;
    private int age;

    public void Introduce(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("안녕하세요! 저는 %s이고, 나이는 %d살입니다.", name, age);
    }
}