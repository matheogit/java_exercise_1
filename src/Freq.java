import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Freq implements Command {
    @Override
    public String name() {
        return "freq";
    }
    @Override
    public boolean run(Scanner scanner) {
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
            return false;

        } catch(IOException e){
            System.out.print("Unreadable file IOException: "+ e + "\n");
            return true;
        }
    }
}
