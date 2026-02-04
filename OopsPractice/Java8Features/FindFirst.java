import java.util.Arrays;
import java.util.List;

public class FindFirst {
    public static void main(String[] args) {
        
    // Find the first number divisible by 3
    List<Integer> numbers = Arrays.asList(2, 5, 8, 9, 12, 15);
    // Expected output: 9
    
    int findnumber = numbers.stream()
    .filter(n -> n % 3 == 0)
    .findFirst()
    .orElse(-1);
    System.out.println(findnumber);
    }
}
