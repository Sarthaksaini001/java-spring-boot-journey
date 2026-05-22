
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class evenDecendingSquare {
 public static void main(String[] args) {
     List<Integer> numbers = List.of(3, 8, 1, 6, 4, 9, 2, 7, 5);
     // Expected output: [64, 36, 16, 4]

     List<Integer> finalNumber = numbers.stream()
     .filter( n -> n %2 == 0 )
     .sorted(Comparator.reverseOrder())
     .map( n -> n * n)
     .collect(Collectors.toList());

     System.out.println(finalNumber);
 }
}
