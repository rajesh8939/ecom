import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class ECommerceApp {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Smartphone", 499.99));
        products.add(new Product(3, "Headphones", 99.99));

        System.out.println("Welcome to our e-commerce site!");
        System.out.println("Available Products:");

        for (Product product : products) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }

        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\nEnter product ID to add to cart (0 to checkout):");
            int productId = scanner.nextInt();

            if (productId == 0) {
                break;
            }

            boolean found = false;
            for (Product product : products) {
                if (product.getId() == productId) {
                    cart.addItem(product);
                    System.out.println(product.getName() + " added to cart.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Product not found.");
            }
        }

        System.out.println("\nCart:");
        for (Product item : cart.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        System.out.println("Total: $" + cart.calculateTotal());

        System.out.println("\nThank you for shopping with us!");
    }
}
