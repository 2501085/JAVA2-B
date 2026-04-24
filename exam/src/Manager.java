import java.util.Scanner;

public class Manager extends Regular {

    protected long allowance;

    public Manager(String employeeID, String name, Date birthday,
                   String grade, String step) {
        super(employeeID, name, birthday, grade, step);
        computeAllowance();
    }

    private void computeAllowance() {
        long base = salary();
        double rate;
        if (base <= 1800000)      rate = 0.06;
        else if (base <= 2400000) rate = 0.05;
        else                      rate = 0.04;
        allowance = Math.round(base * rate);
    }

    @Override
    protected void inputData(Scanner keyboard) {
        // 관리직은 별도 입력 없음
    }

    @Override
    protected long totalPay() {
        return salary() + allowance;
    }

    @Override
    protected String note() { return "관리직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %8s  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                grade, step, 0, "0원",
                salary(), allowance, 0L,
                totalPay(), tax(), payment(), note());
    }
}