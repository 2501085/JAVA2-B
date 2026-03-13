public class Person {
    private String name;
    private int height;
    private float weight;
    private Date birthday;


    public Person(String name, int height, float weight, Date birthday) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s는 키가 %d Cm이고, 몸무게는 %.1fKg이고, 나이는 %s 입니다.",
                name,height,weight,birthday);
    }
}
