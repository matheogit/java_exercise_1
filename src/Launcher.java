import java.util.*;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

            } else if(tmp.equals("freq")){
                System.out.print("Entrer un chemin de fichier\n");
                String path = scanner.nextLine();
                try {
                    String content = java.nio.file.Files.readString(Paths.get(path));
                    content = content.toLowerCase();
                    String[] words = content.split("\\W+");
                    Map<String, Long> map = Arrays.stream(words)
                            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
                    Map<String, Long> result = map.entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                    for (Map.Entry<String, Long> entry : result.entrySet()) {
                        System.out.print(entry.getKey() + " ");
                    }
                    System.out.print("\n");

                } catch(IOException e){
                    System.out.print("Unreadable file IOException: "+ e + "\n");
                }
                tmp = scanner.nextLine();

            } else{
                System.out.print("Unknown command\n");
                tmp = scanner.nextLine();
            }
        }
    }
}
