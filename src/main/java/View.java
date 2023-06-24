import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public String read(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
    public void out(String message) {
        System.out.println(message);
    }
}
