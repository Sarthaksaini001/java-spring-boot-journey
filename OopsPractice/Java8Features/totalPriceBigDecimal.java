import java.math.BigDecimal;
import java.util.List;

// product class
class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}


public class totalPriceBigDecimal {
    public static void main(String[] args) {
        List<Product> products = List.of(
        new Product("Phone", 1200),
        new Product("Case", 30),
        new Product("Laptop", 2500),
        new Product("Charger", 80)
    );

    BigDecimal finalProducts = products.stream()
    .filter( p -> p.price > 100)
    .map( p -> BigDecimal.valueOf(p.price))
    .reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println("Total Price above 100: " + finalProducts);





    }
}
