//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        // 본인의 생년월일 지정 (예: 2005년 3월 15일)
        Date birthday = new Date(2004, 1, 9);
        System.out.printf("생년월일 : %s%n", birthday.toString2());

        // 오늘의 날짜 지정 (2026년 3월 14일)
        Date today = new Date(2026, 3, 14);
        System.out.printf("오늘 날짜 : %s%n", today.toString2());

        // 2025년 2월 29일 지정 (오류인 날짜 - 2025년은 윤년이 아님)
        Date errorDate = new Date(2025, 2, 29);
        System.out.printf("오류 날짜 : %s (※ 2025년 2월 29일은 존재하지 않는 날짜입니다)%n",
                errorDate.toString2());

        // 년도만 2023년으로 수정
        errorDate.setYear(2023);
        System.out.printf("수정 후 날짜 : %s%n", errorDate.toString2());
    }
}