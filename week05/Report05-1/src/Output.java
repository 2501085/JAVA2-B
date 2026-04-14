public class Output {
    private static final String LINE =
            "************************************************************";

    public void print(ElectricUser[] users) {
        Compute compute = new Compute();

        int n = users.length;
        int[] charges  = new int[n];
        int[] taxes    = new int[n];
        int[] payments = new int[n];

        for (int i = 0; i < n; i++) {
            charges[i]  = compute.calcCharge(users[i]);
            taxes[i]    = compute.calcTax(charges[i]);
            payments[i] = compute.calcPayment(charges[i], taxes[i]);
        }

        // 납부 요금 내림차순 정렬 (users 배열도 같이 정렬됨)
        compute.sortByPayment(users, payments);

        // 정렬 후 charges, taxes 재계산 (users 순서 변경됨)
        for (int i = 0; i < n; i++) {
            charges[i]  = compute.calcCharge(users[i]);
            taxes[i]    = compute.calcTax(charges[i]);
            payments[i] = compute.calcPayment(charges[i], taxes[i]);
        }

        System.out.println(LINE);
        System.out.printf("  %-6s %-6s %-7s %-12s %-10s %-12s %s%n",
                "번호", "이름", "사용량", "사용요금", "세금", "납부금액", "기타");
        System.out.println(LINE);

        for (int i = 0; i < n; i++) {
            String remark = users[i].isSupport() ? "지원가구" : "";
            System.out.printf("  %-6s %-6s %4dKw %,10d원 %,8d원 %,10d원 %s%n",
                    users[i].getUserNo(),
                    users[i].getUserName(),
                    users[i].getUsage(),
                    charges[i],
                    taxes[i],
                    payments[i],
                    remark);
        }

        System.out.println(LINE);
    }
}