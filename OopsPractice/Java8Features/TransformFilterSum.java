import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class TransformFilterSum {
    public static void main(String[] args) {
        
    // Add 5 to each number, keep only those >= 10, then find sum
    List<Integer> numbers = Arrays.asList(2, 5, 8, 3, 9, 1);
    // Expected output: Sum of [10, 13, 14] = 37
    

    //. ------  Code I wrote First ----- 
    // List<Integer> fiveAddedNumbers = numbers.stream()
    // .map( n -> n+5)
    // .filter( n -> n >= 10 )
    // .collect(Collectors.toList());
    // System.out.println("Result : " + fiveAddedNumbers);

    // int sum = fiveAddedNumbers.stream()
    // .mapToInt(Integer::intValue)
    // .sum();
    // System.out.println("Sum : " + sum);
    // }
    

    /// ------ Code with Error Handling ------ 
    OptionalInt sum = numbers.stream()
    .map(n -> n + 5)
    .filter(n -> n >= 10)
    .mapToInt(n -> n)
    .reduce(Integer::sum);

    sum.ifPresentOrElse(
        s -> System.out.println("Sum : " + s),
        () -> System.out.println("No numbers found >= 10 after adding 5")
    );
}
}

