import java.util.Scanner;

public class Company {
    private Employee[] employees;
    private Scanner keyboard = new Scanner(System.in);

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    public void inputData() {
        for (int i = 0; i < employees.length; i++) {
            employees[i].inputData(keyboard);
        }
    }

    private void sortByPay() {
        Employee temp;
        for (int i = 0; i < employees.length - 1; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[i].payment() < employees[j].payment()) {
                    temp          = employees[i];
                    employees[i]  = employees[j];
                    employees[j]  = temp;
                }
            }
        }
    }

    // 영업직 커미션 산출 내역
    private void printSalesReport() {
        System.out.println();
        System.out.printf("%34s%n", "영업직 사원 커미션 산출 내역");
        printStar(65);
        System.out.printf("  %-6s  %-16s  %14s  %6s  %10s%n",
                "사번", "이름", "판매 실적", "요율", "커미션 금액");
        printStar(65);
        for (Employee e : employees) {
            if (e instanceof Salesman) {
                Salesman s = (Salesman) e;
                System.out.printf("%-6s  %-4s%-16s  %,14d원  %.1f %%  %,10d%n",
                        s.employeeID, s.name, s.birthday.toString(),
                        s.getSale(), s.getCommissionRate(), s.commission);
            }
        }
        printStar(65);
        System.out.println();
    }

    public void display() {
        printSalesReport();
        sortByPay();

        System.out.printf("%54s%n", "경복주식회사 급여 대장");
        printStar(120);
        System.out.printf(" %-6s  %-8s  %6s  %3s  %8s  %10s  %10s  %10s  %10s  %8s  %10s  %4s%n",
                "사번", "이름", "급-호", "day", "일당", "기본금",
                "인센티브", "커미션", "급여액", "세금", "지급액", "비고");
        printStar(120);

        long totalNet = 0;
        for (Employee e : employees) {
            totalNet += e.payment();
            System.out.println(e);
        }

        printStar(120);
        System.out.printf("%40s  %,15d 원%n", "지급액 합계 :", totalNet);
        printStar(120);
    }

    private void printStar(int n) {
        for (int i = 0; i < n; i++) System.out.print("*");
        System.out.println();
    }
}