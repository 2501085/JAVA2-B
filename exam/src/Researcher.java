import java.util.Scanner;

public class Researcher extends Regular {

    private static final long RESEARCH_ALLOWANCE = 300000L;

    public Researcher(String employeeID, String name, Date birthday,
                      String grade, String step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    protected void inputData(Scanner keyboard) {
        // 연구직은 별도 입력 없음
    }

    @Override
    protected long totalPay() {
        return salary();  // 과세 대상은 기본급만
    }

    // 세금은 기본급에만 적용
    @Override
    protected long tax() {
        long total = totalPay();
        double rate;
        if (total <= 2000000)      rate = 0.066;
        else if (total <= 4000000) rate = 0.073;
        else                       rate = 0.085;
        return Math.round(total * rate);
    }

    // 실지급액 = 기본급 - 세금 + 비과세 연구수당
    @Override
    protected long payment() {
        return totalPay() - tax() + RESEARCH_ALLOWANCE;
    }

    @Override
    protected String note() { return "연구직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %8s  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                grade, step, 0, "0원",
                salary(), RESEARCH_ALLOWANCE, 0L,
                totalPay(), tax(), payment(), note());
    }
}