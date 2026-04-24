import java.util.Scanner;

public class Regular extends Employee {

    protected String grade;  // 직급 1~5
    protected String step;   // 호봉 1~5

    private static final long[][] BASIC_TABLE = {
            {2600000, 2800000, 3100000, 3400000, 3800000},
            {2650000, 2860000, 3170000, 3480000, 3890000},
            {2700000, 2920000, 3240000, 3560000, 3980000},
            {2750000, 2980000, 3310000, 3640000, 4070000},
            {2800000, 3040000, 3380000, 3720000, 4160000}
    };

    public Regular(String employeeID, String name, Date birthday,
                   String grade, String step) {
        super(employeeID, name, birthday);
        this.grade = grade;
        this.step  = step;
    }

    @Override
    protected void inputData(Scanner keyboard) {
        // 정규직은 별도 입력 없음
    }

    @Override
    protected long salary() {
        int g = Integer.parseInt(grade) - 1;
        int s = Integer.parseInt(step)  - 1;
        return BASIC_TABLE[s][g];
    }

    @Override
    protected long totalPay() {
        return salary();
    }

    @Override
    protected String note() { return "정규직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %8s  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                grade, step, 0, "0원",
                salary(), 0L, 0L,
                totalPay(), tax(), payment(), note());
    }
}