import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.print("Bienvenue\n");
        Scanner scanner = new Scanner(System.in);
        List<Command> command = new LinkedList<>();
        command.add(new Quit());
        command.add(new Fibo());
        command.add(new Freq());


        String tmp;
        Boolean bool = true;
        while(bool.equals(true)){
            tmp = scanner.nextLine();
            for (int i = 0; i < command.size(); i++) {
                if (command.get(i).name().equals(tmp)){
                    bool = command.get(i).run(scanner);
                }
            }
            if (bool.equals(true))
                System.out.print("Unknown command\n");
        }
    }
}

