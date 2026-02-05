package SOLID.LSP;

public class Duck extends FlyingBird {
    @Override
    public void eat() {
        System.out.println("Duck eating...");
    }

    @Override
    public void fly() {
        System.out.println("Duck flying...");
    }
}
