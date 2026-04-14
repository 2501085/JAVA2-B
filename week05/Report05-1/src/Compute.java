public class Compute {
    private static final int    BASE_FEE = 1660;
    private static final double TAX_RATE = 0.07;

    // Kw당 단가 계산 (실효 사용량 기준)
    private double calcUsageFee(int effectiveUsage) {
        double fee = 0;
        int remaining = effectiveUsage;

        if (remaining <= 0) return 0;

        // 구간별 누진 계산
        int[] limits = {100, 100, 100, 100, 100, Integer.MAX_VALUE};
        double[] rates = {184.1, 223.8, 278.3, 353.6, 466.4, 643.9};

        for (int i = 0; i < limits.length && remaining > 0; i++) {
            int portion = Math.min(remaining, limits[i]);
            fee += portion * rates[i];
            remaining -= portion;
        }
        return fee;
    }

    // 사용 요금 = 기본 요금 + 사용량 요금
    public int calcCharge(ElectricUser user) {
        double usageFee = calcUsageFee(user.getEffectiveUsage());
        return (int)(BASE_FEE + usageFee);
    }

    // 세금 = 사용 요금 * 7%  (절사)
    public int calcTax(int charge) {
        return (int)(charge * TAX_RATE);
    }

    // 납부 요금 = 사용 요금 + 세금
    public int calcPayment(int charge, int tax) {
        return charge + tax;
    }

    // 납부 요금 기준 내림차순 버블 정렬
    public void sortByPayment(ElectricUser[] users, int[] payments) {
        int n = users.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (payments[j] < payments[j + 1]) {
                    // payments 교환
                    int tmpP = payments[j];
                    payments[j] = payments[j + 1];
                    payments[j + 1] = tmpP;
                    // users 교환
                    ElectricUser tmpU = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = tmpU;
                }
            }
        }
    }
}