import java.util.Scanner;

public class Contract extends Employee {

    public Contract(String employeeID, String name, Date birthday) {
        super(employeeID, name, birthday);
    }

    @Override
    protected void inputData(Scanner keyboard) {
        // 계약직은 별도 입력 없음
    }

    @Override
    protected long salary() {
        return 2000000L;
    }

    @Override
    protected long totalPay() {
        return salary();
    }

    @Override
    protected String note() { return "계약직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %8s  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                "0", "0", 0, "0원",
                salary(), 0L, 0L,
                totalPay(), tax(), payment(), note());
    }
}