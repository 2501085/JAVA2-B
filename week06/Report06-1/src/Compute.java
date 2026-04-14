public class Compute implements Chargeable, Sortable {

    // 구간별 누진 단가 계산 (실효 사용량 기준)
    private double calcUsageFee(int effectiveUsage) {
        double fee = 0;
        int remaining = effectiveUsage;
        if (remaining <= 0) return 0;

        int[]    limits = { 100, 100, 100, 100, 100, Integer.MAX_VALUE };
        double[] rates  = { 184.1, 223.8, 278.3, 353.6, 466.4, 643.9 };

        for (int i = 0; i < limits.length && remaining > 0; i++) {
            int portion = Math.min(remaining, limits[i]);
            fee += portion * rates[i];
            remaining -= portion;
        }
        return fee;
    }

    // Chargeable 구현
    @Override
    public int calcCharge(AbstractUser user) {
        return (int)(BASE_FEE + calcUsageFee(user.getEffectiveUsage()));
    }

    @Override
    public int calcTax(int charge) {
        return (int)(charge * TAX_RATE);
    }

    @Override
    public int calcPayment(int charge, int tax) {
        return charge + tax;
    }

    // Sortable 구현 - 납부 요금 내림차순 버블 정렬
    @Override
    public void sortByPayment(AbstractUser[] users, int[] payments) {
        int n = users.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (payments[j] < payments[j + 1]) {
                    int tmpP = payments[j];
                    payments[j] = payments[j + 1];
                    payments[j + 1] = tmpP;

                    AbstractUser tmpU = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = tmpU;
                }
            }
        }
    }
}