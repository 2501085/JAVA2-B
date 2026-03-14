//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // TV 객체 생성
        TV myTV = new TV("Samsung", 2017, 55, "LED");

        // TV 정보 출력
        myTV.printInfo();

        // 오늘 새로 구입한 TV
        TV newTV = new TV("Samsung", 2017, 55, "LED");
        newTV.printInfo();
    }
}