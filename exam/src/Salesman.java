import java.util.Scanner;

public class Salesman extends Regular {

    private long sale;
    private double commissionRate;
    protected long commission;

    public Salesman(String employeeID, String name, Date birthday,
                    String grade, String step) {
        super(employeeID, name, birthday, grade, step);
    }

    @Override
    protected void inputData(Scanner keyboard) {
        System.out.printf("[영업직] %s님의 판매 금액 입력 : ", name);
        sale = keyboard.nextLong();
        System.out.printf("[영업직] %s님의 커미션 비율 입력 : ", name);
        commissionRate = keyboard.nextDouble();
        double rate = Math.min(commissionRate, 5.0);
        commission = Math.round(sale * rate / 100.0);
    }

    public long getSale()           { return sale; }
    public double getCommissionRate() { return commissionRate; }

    @Override
    protected long totalPay() {
        return salary() + commission;
    }

    @Override
    protected String note() { return "영업직"; }

    @Override
    public String toString() {
        return String.format("%-6s  %-4s%-16s  %s급-%s호  %2d  %8s  %,10d원  %,8d원  %,8d원  %,10d원  %,8d원  %,10d원  %s",
                employeeID, name, birthday.toString(),
                grade, step, 0, "0원",
                salary(), 0L, commission,
                totalPay(), tax(), payment(), note());
    }
}