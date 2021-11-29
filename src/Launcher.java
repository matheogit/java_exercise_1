import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print("Bienvenue\n");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("quit")){
            return;
        }
        else{
            System.out.print("Unknown command");
        }
    }
}
