import java.util.ArrayList;

public class Student extends Person implements Constants {
    private String studentID;
    private ArrayList<Subject> subjects;

    public Student(String name, String gender) {
        super(name, gender);
        subjects = new ArrayList<>();
        subjects.add(new Subject(titles[0])); // 국어
        subjects.add(new Subject(titles[1])); // 영어
        subjects.add(new Subject(titles[2])); // 수학
        if (getGender().equals("남")) {
            subjects.add(new Subject(titles[3])); // 기술
        } else {
            subjects.add(new Subject(titles[4])); // 가정
        }
    }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }
    public ArrayList<Subject> getSubjects() { return subjects; }
    public Subject getSubject(int index) { return subjects.get(index); }

    protected int sum() {
        int total = 0;
        for (int i = 0; i < subjects.size(); i++) {
            total += subjects.get(i).getScore();
        }
        return total;
    }

    public float avg() {
        return sum() / (float) subjects.size();
    }
}