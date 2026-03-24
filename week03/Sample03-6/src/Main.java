//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Navigation navigation = new Navigation("아이 나비");
        Car car = new Car("소나타");

        car.drive();
        car.findRoute(navigation, "경복대", "서율역");
        car.stop();

    }
}