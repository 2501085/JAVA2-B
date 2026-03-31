import java.util.Scanner;

public class Input {

    // ── 사원 정보 입력 ─────────────────────────
    public static Employee[] inputEmployees() {
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("사원 수를 입력하세요: ");
        int n = keyboard.nextInt();

        Employee[] emps = new Employee[n];

        System.out.printf("%n사번  이름    부서 보훈 급 호 공제액%n");
        System.out.printf("*******************************************%n");

        for (int i = 0; i < n; i++) {
            System.out.printf("%d번째 사원 정보 입력%n", i + 1);

            System.out.printf("  사번     : ");
            int id = keyboard.nextInt();

            System.out.printf("  이름     : ");
            String name = keyboard.next();

            System.out.printf("  부서코드 (1경리 2인사 3영업 4생산 5A/S): ");
            int part = keyboard.nextInt();

            System.out.printf("  보훈대상 (1=예 0=아니오): ");
            int spInput = keyboard.nextInt();
            boolean special = (spInput == 1);

            System.out.printf("  급 (1~3): ");
            int grade = keyboard.nextInt();

            System.out.printf("  호봉 (1~5): ");
            int cls = keyboard.nextInt();

            System.out.printf("  개인공제(저축, 최대 300000): ");
            int aid = keyboard.nextInt();
            if (aid > 300000) aid = 300000; // 월 30만원 초과 불가

            emps[i] = new Employee(id, name, part, special, grade, cls, aid);
            System.out.printf("*******************************************%n");
        }

        return emps;
    }
}
