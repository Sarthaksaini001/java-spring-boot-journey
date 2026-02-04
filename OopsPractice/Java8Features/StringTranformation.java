import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTranformation {
    public static void main(String[] args) {
        
    // Convert all strings to uppercase and sort them
    List<String> names = Arrays.asList("john", "alice", "bob", "charlie");
    // Expected output: [ALICE, BOB, CHARLIE, JOHN]

     List<String> finalNames = names.stream()
     .map(String::toUpperCase)
     .sorted()
     .collect(Collectors.toList());
     System.out.println("Final List : " + finalNames);


    }
}
