package SOLID.LSP;

public class Ostrich extends Bird {
    @Override
    public void eat() {
        System.out.println("Ostrich eating...");
    }

    // Ostrich is a Bird but NOT a FlyingBird, so it doesn't have the fly() method
    // that it can't implement correctly. This adheres to LSP.
}
