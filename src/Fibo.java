import java.util.Scanner;

class Fibo implements Command {
    @Override
    public String name() {
        return "fibo";
    }
    @Override
    public boolean run(Scanner scanner) {
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
        return false;
    }
}
