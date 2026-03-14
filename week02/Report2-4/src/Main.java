//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        System.out.println("JAVA 처음하기");

        // Book 객체 생성
        Book book1 = new Book("Android", "김철수");
        Book book2 = new Book("Bible", "작자미상");

        // 출력 - toString() 자동 호출
        System.out.println(book1);
        System.out.println(book2);
    }
}