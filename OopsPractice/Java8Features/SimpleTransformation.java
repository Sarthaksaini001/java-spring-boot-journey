import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTransformation {
    public static void main(String[] args) {
        
    // Double each number and collect to a list
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    // Expected output: [2, 4, 6, 8, 10]

    List<Integer> doubledNumber = numbers.stream()
    .map ( n -> n+n)
    .collect(Collectors.toList());

    System.out.println("Doubled Numbers : " + doubledNumber);
    }    
}
