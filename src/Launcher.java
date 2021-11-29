import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.print("Bienvenue\n");
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        while(!tmp.equals("quit")){
            if (tmp.equals("fibo")){
                System.out.print("Entrer une valeur:\n");
                int n = scanner.nextInt();
                int f0=0,f1=1,f=0;
                for (int i = 1; i < n; i++){
                    f = f0 + f1;
                    f0 = f1;
                    f1 = f;
                }
                if(n == 1){
                    System.out.print("1\n");
                }
                else{
                    System.out.print(f);
                    System.out.print("\n");
                }
                scanner.nextLine();
                tmp = scanner.nextLine();

            }else{
                System.out.print("Unknown command\n");
                tmp = scanner.nextLine();
            }
        }
    }
}
