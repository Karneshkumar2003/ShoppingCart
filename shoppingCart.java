import java.util.ArrayList;
import java.util.Scanner;
class Item {
    private String name;
    private double quantity;
    private double pricePerUnit;
    public Item(String name, double quantityx, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }
    public double calculateCost() {
        return quantity * pricePerUnit;
    } 
    public String toString() {
        return name + " (" + quantity + " units @ " + pricePerUnit + " Rs/unit)";
    }
}
class ShoppingCart {
    private ArrayList<Item> items;
    private double discount;
    public ShoppingCart() {
        items = new ArrayList<>();
        discount = 0;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.calculateCost();
        }
        if (discount > 0) {
            total -= total * (discount / 100);
        }
        return total;
    }
    public void printBill() {
        System.out.println("Amount to be paid: " + calculateTotal() + " Rs");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the Supermarket App!");
        while (true) {
            System.out.print("Enter item name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done"))break;
            System.out.print("Enter quantity: ");
            double quantity = scanner.nextDouble();
            System.out.print("Enter price per unit: ");
            double pricePerUnit = scanner.nextDouble();
            scanner.nextLine();
            cart.addItem(new Item(name, quantity, pricePerUnit));
        }
        System.out.print("Enter discount percentage (or 0 for none): ");
        double discount = scanner.nextDouble();
        cart.setDiscount(discount);
        System.out.println("\nGenerating your bill...\n");
        cart.printBill();
    }
}
