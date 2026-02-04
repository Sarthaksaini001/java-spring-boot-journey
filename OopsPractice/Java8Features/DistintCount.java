import java.util.Arrays;
import java.util.List;

public class DistintCount {
    public static void main(String[] args) {
    // Remove duplicates and count unique elements
    List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 5);
    // Expected output: 5
    
    long count = numbers.stream()
    .distinct()
    .count();
    System.out.println("Total unique element: " + count);




    }
}
