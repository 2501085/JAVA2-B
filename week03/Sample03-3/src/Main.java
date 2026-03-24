//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Book book = new Book("국어의 정석");
        Student student = new Student("홍길동");
        Teacher teacher = new Teacher("김홍도", "국어");
        ClassRoom classRoom = new ClassRoom(student, teacher);

        classRoom.startClass(book);

    }
}