import java.util.Scanner;

public class Input {
    private Scanner keyboard = new Scanner(System.in);

    public ElectricUser[] inputData() {
        System.out.print("고객 수를 입력하세요 (최소 10명): ");
        int n = keyboard.nextInt();
        if (n < 10) n = 10;

        ElectricUser[] users = new ElectricUser[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("%d번째 사용자 번호 (5자리): ", i + 1);
            String no = keyboard.next();

            System.out.printf("%s 고객의 이름 입력: ", no);
            String name = keyboard.next();

            System.out.printf("%s 고객의 사용량 입력 : ", name);
            int kw = keyboard.nextInt();

            // 사용자 번호가 '9'로 시작하면 지원 가구
            if (no.charAt(0) == '9') {
                users[i] = new SupportUser(no, name, kw);
            } else {
                users[i] = new ElectricUser(no, name, kw);
            }
        }
        return users;
    }
}