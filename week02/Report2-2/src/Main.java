//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        // movie1 객체 생성
        Movie movie1 = new Movie("헤라클레스", "레니 할린", 2014, "켈란 루츠", 6.9);

        // movie2 객체 생성
        Movie movie2 = new Movie("노아", "대런 아로노프스키", 2004, "러셀 크로우", 7.3);

        // movie2 평점을 8.2로 변경
        movie2.rankPoint = 8.2;

        // movie1, movie2 출력
        System.out.println("[ movie1 ]");
        movie1.printInfo();

        System.out.println();

        System.out.println("[ movie2 ]");
        movie2.printInfo();

        System.out.println();

        // movie1 감독 이름(할린)만 출력
        // "레니 할린" 에서 공백 기준으로 split → 성[0]=레니, 이름[1]=할린
        String[] nameParts = movie1.director.split(" ");
        System.out.printf("movie1 감독 이름 : %s%n", nameParts[1]);
    }
}