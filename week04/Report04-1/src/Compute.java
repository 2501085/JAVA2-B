public class Compute {

    // ── 기본급 테이블 [호봉-1][급-1] ──────────
    private static final int[][] BASIC_TABLE = {
            {1250000, 950000, 750000},   // 1호봉
            {1200000, 925000, 725000},   // 2호봉
            {1150000, 900000, 700000},   // 3호봉
            {1100000, 875000, 675000},   // 4호봉
            {1050000, 850000, 650000}    // 5호봉
    };

    // ── 직급 수당 테이블 [급-1] ────────────────
    private static final int[] GRADE_PAY = {300000, 200000, 100000};

    // ── 업무 수당 테이블 [부서코드-1] ──────────
    private static final int[] PART_PAY  = {250000, 250000, 350000, 350000, 300000};

    // ── 전체 사원 급여 계산 ────────────────────
    public static void computeAll(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            compute(emps[i]);
        }
    }

    // ── 개별 사원 급여 계산 ────────────────────
    private static void compute(Employee emp) {
        // 1. 기본급
        int basicPay = BASIC_TABLE[emp.getCls() - 1][emp.getGrade() - 1];
        emp.setBasicPay(basicPay);

        // 2. 직급 수당
        int gradePay = GRADE_PAY[emp.getGrade() - 1];
        emp.setGradePay(gradePay);

        // 3. 업무 수당
        int partPay = PART_PAY[emp.getPart() - 1];
        emp.setPartPay(partPay);

        // 4. 공제액 = 기본공제(기본급 3%) + 개인공제(저축)
        int basicDeduct = (int)(basicPay * 0.03);
        int deduction   = basicDeduct + emp.getAid();
        emp.setDeduction(deduction);

        // 5. 세금 계산
        // 과세 대상 금액 = (기본급 + 직급수당 + 업무수당) - 공제액
        int taxBase = (basicPay + gradePay + partPay) - deduction;
        int tax;

        if (emp.isSpecial()) {
            // 보훈 대상자: 기본급의 3%
            tax = (int)(basicPay * 0.03);
        } else {
            // 일반 세율 적용
            if (taxBase < 700000) {
                tax = 0;
            } else if (taxBase < 800000) {
                tax = (int)(taxBase * 0.05);
            } else if (taxBase < 1000000) {
                tax = (int)(taxBase * 0.07);
            } else {
                tax = (int)(taxBase * 0.09);
            }
        }
        emp.setTax(tax);

        // 6. 수령액 = (기본급 + 업무수당 + 직급수당) - 세금 - 공제액
        int netPay = (basicPay + partPay + gradePay) - tax - deduction;
        emp.setNetPay(netPay);
    }
}
