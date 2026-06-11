public class Subject {
    private String subjectName;
    private int score;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.score = 0;
    }

    public String getSubjectName() { return subjectName; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getGrade() {
        String name = subjectName;
        if (name.equals("국어")) {
            switch (score / 10) {
                case 10: case 9: return "수";
                case 8: return "우";
                case 7: return "미";
                case 6: return "양";
                default: return "가";
            }
        } else if (name.equals("영어") || name.equals("수학")) {
            switch (score / 10) {
                case 10: return "A0";
                case 9: return score >= 95 ? "A0" : "A+";
                case 8: return score >= 85 ? "B0" : "B+";
                case 7: return score >= 75 ? "C0" : "C+";
                case 6: return score >= 65 ? "D0" : "D+";
                default: return "F";
            }
        } else {
            // 선택과목 (기술/가정)
            if (score >= 90) return "A";
            else if (score >= 80) return "B";
            else if (score >= 70) return "C";
            else if (score >= 60) return "D";
            else return "F";
        }
    }
}