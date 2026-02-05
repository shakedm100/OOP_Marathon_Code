package visitor;

import java.util.ArrayList;
import java.util.List;

import Book;
import Fruit;
import ItemElement;
import ShoppingCartVisitor;
import ShoppingCartVisitorImpl;

/*
The Visitor Pattern is used to separate an algorithm from the object structure on which 
it operates. This allows you to add new operations (Visitors) to existing object structures 
without modifying those structures.
 */

// --- 1. The Element Interface ---
// Every item in our store must implement this. 
// It allows a "Visitor" to enter and perform an operation.
interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}

// --- 2. Concrete Elements ---
// These are the stable classes. We don't want to modify these often.

class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int price, String isbn) {
        this.price = price;
        this.isbnNumber = isbn;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        // Double Dispatch: The book tells the visitor "Visit me! I am a Book!"
        return visitor.visit(this);
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        // Double Dispatch: The fruit tells the visitor "Visit me! I am a Fruit!"
        return visitor.visit(this);
    }
}

// --- 3. The Visitor Interface ---
// This defines what operations can be performed on the elements.
// Notice it has a specific method for EACH concrete element type.
interface ShoppingCartVisitor {
    int visit(Book book);

    int visit(Fruit fruit);
}

// --- 4. Concrete Visitor ---
// This contains the actual business logic (The Algorithm).
// If we want to change how we calculate cost, we only change THIS class.
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        // Logic: Books are tax-free if cost > 50 (just an example rule)
        if (cost > 50) {
            cost = cost - 5;
        }
        System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}

// --- 5. Client Code ---
public class visitor {

    public static void main(String[] args) {
        // 1. Create the items (The Object Structure)
        List<ItemElement> items = new ArrayList<>();
        items.add(new Book(20, "1234"));
        items.add(new Book(100, "5678"));
        items.add(new Fruit(10, 2, "Banana"));
        items.add(new Fruit(5, 5, "Apple"));

        // 2. Create the algorithm (The Visitor)
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();

        // 3. Execute the algorithm over the structure
        int total = 0;
        for (ItemElement item : items) {
            // The item accepts the visitor, and the magic happens inside
            total = total + item.accept(visitor);
        }

        System.out.println("Total Cost = " + total);
    }
}