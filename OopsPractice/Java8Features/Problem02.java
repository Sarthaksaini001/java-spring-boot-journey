import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Problem Statement
 * Write a Java 8 program that reads a list of integers, removes duplicates, sorts them, and prints:
 * 
 * 1. the sum of all even numbers,
 * 2. the product of all odd numbers,
 * 3. the first number greater than 50 (or a message if none).
 */
public class Problem02 {
    public static void main(String[] args){
    List<Integer> number = Arrays.asList(2,3,2,7,56,45,34,5,45,56,54);
     
    // removes duplicates, sorts them, and prints
    List<Integer> unique = number.stream()
    .distinct()
    .sorted()
    .collect(Collectors.toList());
    
    // the sum of all even numbers
    int sumEven = unique.stream()
    .filter( n -> n % 2 == 0)
    .mapToInt( n -> n)
    .sum();
    System.out.println(sumEven);

    // the product of all odd numbers
    int productOdd = unique.stream()
    .filter( n -> n % 2 != 0)
    .mapToInt( n -> n )
    .reduce(1,(a,b) -> a * b);
    System.out.println(productOdd);

    //the first number greater than 50 (or a message if none)
    unique.stream()
    .filter( n -> n > 50 )
    .findFirst()
    .ifPresentOrElse(
        n -> System.out.println("Number: " + n),
        () -> System.out.println("No Number is find")
    );


    }
}
