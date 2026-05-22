import java.util.List;

public class grouping {
public static void main(String[] args) {
    List<Integer> numbers = List.of(3, 8, 1, 6, 4, 9, 2, 7, 5);
    // Expected output: 945

    int product = numbers.stream()
    .filter( n -> n%2 != 0)
    .mapToInt(Integer::intValue)
    .reduce(1, (a, b ) -> a * b);

    System.out.println(product);
}
}
