import java.util.Scanner;

public abstract class Employee {
    protected String employeeID;
    protected String name;
    protected Date birthday;

    public Employee(String employeeID, String name, Date birthday) {
        this.employeeID = employeeID;
        this.name = name;
        this.birthday = birthday;
    }

    // 각 직종마다 입력 내용이 다르므로 추상 메서드로 선언
    protected abstract void inputData(Scanner keyboard);

    // 기본급
    protected abstract long salary();

    // 세금 계산 (일용직은 오버라이드)
    protected long tax() {
        long total = totalPay();
        double rate;
        if (total <= 2000000)      rate = 0.066;
        else if (total <= 4000000) rate = 0.073;
        else                       rate = 0.085;
        return Math.round(total * rate);
    }

    // 지급액 = 기본급 + 수당
    protected abstract long totalPay();

    // 실지급액
    protected long payment() {
        return totalPay() - tax();
    }

    // 비고
    protected abstract String note();
}