public class Main {
    public static void main(String[] args) {

        System.out.printf("************************************%n");
        System.out.printf("*       급  여  명  세  서         *%n");
        System.out.printf("************************************%n");

        // 1. 입력
        Employee[] emps = Input.inputEmployees();

        // 2. 계산
        Compute.computeAll(emps);

        // 3. 출력
        Output.printAll(emps);
    }
}