import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddSquare {
    public static void main(String[] args) {
        
   // Square only the odd numbers
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // Expected output: [1, 9, 25, 49, 81]

    List<Integer> result = numbers.stream()
    .filter( n -> n %2 != 0 )
    .map( n -> n*n)
    .collect(Collectors.toList());
    System.out.println("Result: " + result);


    }
}
