import java.util.Arrays;
import java.util.List;

public class CountOccurence {
    public static void main(String[] args) {
    // Count how many strings have length greater than 4
    List<String> words = Arrays.asList("Java", "Python", "C", "JavaScript", "Go", "Ruby");
    // Expected output: 2

    long wordCount = words.stream()
    .filter(s -> s.length() > 4)
    .count();
    System.out.println(wordCount);

    }
}
