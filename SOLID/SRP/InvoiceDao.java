package SOLID.SRP;

public class InvoiceDao {
    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDatabase() {
        // Logic to save invoice to database
        System.out.println(
                "Saving invoice " + invoice.getCustomerName() + " to database with amount " + invoice.getAmount());
    }
}
