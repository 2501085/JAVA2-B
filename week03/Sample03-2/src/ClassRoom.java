public class ClassRoom {
    private Teacher teacher;
    private Student student;

    public ClassRoom(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    public void startClassr(Book book) {
        teacher.teach();
        student.study(book);
    }

    public void closeClass(){
        teacher.close();

    }
}
