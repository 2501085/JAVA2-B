public class TV {
    // Member 변수 (속성)
    String brand;   // 제조사
    int year;       // 년도
    int inch;       // 인치
    String type;    // TV 종류

    // 생성자
    TV(String brand, int year, int inch, String type) {
        this.brand = brand;
        this.year = year;
        this.inch = inch;
        this.type = type;
    }

    // TV 정보 출력 메서드
    void printInfo() {
        System.out.printf("우리집 TV는 %s에서 만든 %d년형 %d 인치 %s TV 입니다%n",
                brand, year, inch, type);
    }
}
