package SOLID.SRP;

/**
 * Single responsibility principle
 * 
 * The single-responsibility principle (SRP) states that there
 * should never be more than one reason for a class to change.
 * In other words, every class should have only one responsibility.
 */
public class Invoice {
    private double amount;
    private String customerName;

    public Invoice(double amount, String customerName) {
        this.amount = amount;
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    // Only business logic related to the invoice itself
    public double calculateTotalWithTax() {
        return amount * 1.17; // Assuming 17% tax
    }
}
