public class Main {
    public static void main(String[] args) {
        Input  input  = new Input();
        Output output = new Output();

        AbstractUser[] users = input.inputData();
        output.print(users);
    }
}