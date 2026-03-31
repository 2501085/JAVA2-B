public class Output {

    // ── 부서 이름 배열 ─────────────────────────
    private static final String[] PART_NAME =
            {"경리과", "인사과", "영업팀", "생산과", "A/S팀"};

    // ── 급여 명세서 전체 출력 ──────────────────
    public static void printAll(Employee[] emps) {
        printHeader();
        for (int i = 0; i < emps.length; i++) {
            printEmployee(emps[i]);
        }
        printFooter();
    }

    // ── 헤더 출력 ──────────────────────────────
    private static void printHeader() {
        System.out.printf("%n");
        System.out.printf("===========================================================" +
                "====================%n");
        System.out.printf("%-6s %-6s %-6s %-3s %-5s %9s %8s %8s %8s %6s %10s%n",
                "이름", "사번", "부서명", "원호", "급-호",
                "본봉", "업무수당", "직급수당", "공제금액", "세금", "수령액");
        System.out.printf("===========================================================" +
                "====================%n");
    }

    // ── 개별 사원 출력 ─────────────────────────
    private static void printEmployee(Employee emp) {
        String special = emp.isSpecial() ? "O" : "X";
        String partName = PART_NAME[emp.getPart() - 1];
        String gradeStr = emp.getGrade() + " - " + emp.getCls();

        System.out.printf("%-6s %-6d %-6s %-3s %-5s %9s %8s %8s %8s %6s %10s%n",
                emp.getName(),
                emp.getId(),
                partName,
                special,
                gradeStr,
                formatNum(emp.getBasicPay()),
                formatNum(emp.getPartPay()),
                formatNum(emp.getGradePay()),
                formatNum(emp.getDeduction()),
                formatNum(emp.getTax()),
                formatNum(emp.getNetPay())
        );
    }

    // ── 푸터 출력 ──────────────────────────────
    private static void printFooter() {
        System.out.printf("===========================================================" +
                "====================%n");
    }

    // ── 숫자 포맷 (콤마) ───────────────────────
    private static String formatNum(int n) {
        // 세 자리마다 콤마 삽입
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int start = s.length() % 3;
        if (start > 0) sb.append(s, 0, start);
        for (int i = start; i < s.length(); i += 3) {
            if (sb.length() > 0) sb.append(',');
            sb.append(s, i, i + 3);
        }
        return sb.toString();
    }
}
