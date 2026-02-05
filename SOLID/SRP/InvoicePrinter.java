package SOLID.SRP;

public class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        // Logic to print invoice
        System.out.println("Invoice details:");
        System.out.println("Customer: " + invoice.getCustomerName());
        System.out.println("Total Amount: " + invoice.calculateTotalWithTax());
    }
}
