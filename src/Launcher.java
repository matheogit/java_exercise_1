import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print("Bienvenue\n");
        Scanner scanner = new Scanner(System.in);

        while(!scanner.nextLine().equals("quit")){
            System.out.print("Unknown command\n");
        }
    }
}
