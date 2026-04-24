import java.util.Scanner;

public class Temporary extends Employee {

    private int dailyWage;
    private int workDays;

    public Temporary(String employeeID, String name, Date birthday) {
        super(employeeID, name, birthday);
    }

    @Override
    protected void inputData(Scanner keyboard) {
        while (true) {
            System.out.printf("[일용직] %s님의 일당 입력 : ", name);
            dailyWage = keyboard.nextInt();
            if (dailyWage >= 25000 && dailyWage <= 95000) break;
            System.out.println("ERROR : 일당 범위 오류 (25,000 ~ 95,000원");
        }
        System.out.printf("[일용직] %s님의 작업 일수 입력 : ", name);
        workDays = keyboard.nextInt();
    }

    @Override
    protected long salary() {
        return (long) dailyWage * workDays;
    }

    @Override
    protected long totalPay() {
        return salary();
    }

    // 일용직 세금: 고정 6.6%
    @Override
    protected long tax() {
        return Math.round(totalPay() * 0.066);
    }

    @Override
    protected String note() { return "일용직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %,8d원  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                "0", "0", workDays, dailyWage,
                salary(), 0L, 0L,
                totalPay(), tax(), payment(), note());
    }
}