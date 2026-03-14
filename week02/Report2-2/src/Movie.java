public class Movie {
    // Field (멤버 변수)
    String title;       // 영화 제목
    String director;    // 감독
    int open;           // 개봉 년도
    String mainActor;   // 주연 배우
    double rankPoint;   // 평점

    // 5개의 값을 매개변수로 받는 생성자
    Movie(String title, String director, int open, String mainActor, double rankPoint) {
        this.title = title;
        this.director = director;
        this.open = open;
        this.mainActor = mainActor;
        this.rankPoint = rankPoint;
    }

    // Movie 정보 출력 메서드
    void printInfo() {
        System.out.printf("제목 : %s%n", title);
        System.out.printf("감독 : %s%n", director);
        System.out.printf("개봉 : %d%n", open);
        System.out.printf("주연 : %s%n", mainActor);
        System.out.printf("평점 : %.1f%n", rankPoint);
    }
}
