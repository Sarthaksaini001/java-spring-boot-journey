import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FinfLongestString {
    public static void main(String[] args) {
    
    // Find the longest string in the list
    List<String> words = Arrays.asList("cat", "elephant", "dog", "butterfly", "ant");
    // Expected output: "butterfly" or "No words found" if empty
    // Hint: Use .max() with Comparator.comparingInt()
    
    String longestString = words.stream()
            .max(Comparator.comparingInt(String::length))
            .orElse("No words found");
    
    System.out.println(longestString);

}
}
