//Write a program to demonstrate e-commerce website using inheritance, abstract class and dynamic polymorphism.
import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class Product {
    protected int id;
    protected String name, description;
    protected double price, discount;

    public Product(int id, String name, String description, double price, double discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public abstract double calculateFinalPrice();

    public void displayInfo() {
        System.out.println(name + " | Final Price: " + calculateFinalPrice() + " Rupees");
    }
}

class Clothing extends Product {
    public Clothing(int id, String name, String desc, double p, double d) {
        super(id, name, desc, p, d);
    }
    public double calculateFinalPrice() {
        return price - (price * (discount / 100));
    }
}

class Electronics extends Product {
    public Electronics(int id, String name, String desc, double p, double d) {
        super(id, name, desc, p, d);
    }
    public double calculateFinalPrice() {
        return (price - discount) + 5.0; 
    }
}

class Sports extends Product {
    public Sports(int id, String name, String desc, double p, double d) {
        super(id, name, desc, p, d);
    }
    public double calculateFinalPrice() {
        return price - discount;
    }
}

class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product p) {
        items.add(p);
        System.out.println(p.name + " added to cart!");
    }

    public void showCartDetails() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        double total = 0;
        System.out.println("\n--- Your Cart ---");
        for (Product p : items) {
            p.displayInfo();
            total += p.calculateFinalPrice();
        }
        System.out.println("Total Amount: " + total + " Rupees");
    }
}

class Inventory {
    private Clothing[] clothing = {
        new Clothing(102, "T-Shirt", "Cotton Shirt", 50, 10),
        new Clothing(104, "Jeans", "Slim Fit Denim", 80, 15),
        new Clothing(105, "Jacket", "Winter Leather Jacket", 150, 20)
    };

    private Electronics[] electronics = {
        new Electronics(101, "Laptop", "Gaming Laptop", 1200, 100),
        new Electronics(106, "Smartphone", "OLED Display 5G", 800, 50),
        new Electronics(107, "Headphones", "Noise Cancelling", 200, 20)
    };

    private Sports[] sports = {
        new Sports(103, "Football", "Size 5", 30, 5),
        new Sports(108, "Tennis Racket", "Carbon Fiber", 120, 15),
        new Sports(109, "Yoga Mat", "Non-slip Eco-friendly", 40, 8)
    };

    public void displayInventory(int choice) {
        System.out.println("---------------------------");
        Product[] selected = getArrayByChoice(choice);
        if (selected != null) {
            for (Product p : selected) {
                System.out.println("ID: " + p.id + " | Name: " + p.name + " | Price: " + p.price);
            }
        }
        System.out.println("---------------------------");
    }

    public Product getProductById(int id) {
        Product[][] all = {clothing, electronics, sports};
        for (Product[] category : all) {
            for (Product p : category) {
                if (p.id == id) return p;
            }
        }
        return null;
    }

    private Product[] getArrayByChoice(int choice) {
        return switch (choice) {
            case 1 -> clothing;
            case 2 -> electronics;
            case 3 -> sports;
            default -> null;
        };
    }
}

public class Prg2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Cart myCart = new Cart();
        Inventory inv = new Inventory();
        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1: Clothes | 2: Electronics | 3: Sports | 4: View Cart/Checkout | 5: Exit");
            System.out.print("Select an option: ");
            int option = Integer.parseInt(input.readLine());

            if (option >= 1 && option <= 3) {
                inv.displayInventory(option);
                System.out.print("Enter Product ID to add to cart (or 0 to go back): ");
                int prodId = Integer.parseInt(input.readLine());
                if (prodId != 0) {
                    Product p = inv.getProductById(prodId);
                    if (p != null) myCart.addProduct(p);
                    else System.out.println("Product not found!");
                }
            } else if (option == 4) {
                myCart.showCartDetails();
                System.out.println("Press 1 to Checkout (Empty Cart) or 2 to go Back: ");
                if (input.readLine().equals("1")) {
                    System.out.println("Order Placed Successfully! Thank you for shopping.");
                    running = false;
                }
            } else {
                running = false;
            }
        }
    }
}