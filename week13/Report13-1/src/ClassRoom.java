import java.util.ArrayList;

public class ClassRoom {
    private String className;
    private ArrayList<Student> students;

    public ClassRoom(String className, ArrayList<Student> students) {
        this.className = className;
        this.students = students;
    }

    public String getClassName() { return className; }
    public ArrayList<Student> getStudents() { return students; }

    public float getClassAvg() {
        float total = 0;
        for (int i = 0; i < students.size(); i++) {
            total += students.get(i).avg();
        }
        return total / students.size();
    }

    // 반 석차
    public int getRank(int index) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).sum() > sum) rank++;
        }
        return rank;
    }

    // 학년 석차 (전체 학생 중)
    public int getGradeRank(int index, ArrayList<Student> allStudents) {
        int rank = 1;
        int sum = students.get(index).sum();
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).sum() > sum) rank++;
        }
        return rank;
    }
}