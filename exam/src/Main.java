public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Temporary("250108", "정서윤", new Date(2003,  5, 10)),
                new Salesman ("124567", "한송이", new Date(2011,  4, 19), "3", "4"),
                new Temporary("456213", "이대한", new Date(1999,  5, 13)),
                new Salesman ("424561", "최명길", new Date(2012,  4, 20), "3", "2"),
                new Salesman ("124655", "정통파", new Date(2013, 12, 20), "2", "3"),
                new Regular  ("348967", "진접음", new Date(1987,  6, 22), "4", "5"),
                new Manager  ("245778", "한민국", new Date(2012, 12, 20), "3", "1"),
                new Regular  ("234567", "홍길동", new Date(2010,  3,  7), "2", "3"),
                new Regular  ("348988", "코로나", new Date(2011,  8, 10), "1", "4"),
                new Manager  ("345678", "한국인", new Date(2012,  7, 20), "1", "1"),
                new Researcher("112233","김연구", new Date(1990,  2, 14), "3", "2")
        };

        Company company = new Company(employees);
        company.inputData();
        company.display();
    }
}