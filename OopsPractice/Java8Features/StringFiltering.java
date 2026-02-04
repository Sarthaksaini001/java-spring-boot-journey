import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringFiltering {
    public static void main(String[] args) {
        
    // Find all strings that start with "A" and have length > 3
    List<String> words = Arrays.asList("Apple", "Ant", "Banana", "Avocado", "Cat", "Apricot");
    // Expected output: [Apple, Avocado, Apricot] 
    
    List<String> finalWords = words.stream()
    .filter( s -> s != null && s.startsWith("A") && s.length() >3)
    .collect(Collectors.toList());
    System.out.println("Final List: " + finalWords);

    }
}
