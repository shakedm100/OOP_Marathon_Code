package SOLID.DIP;

/**
 * Dependency Inversion Principle
 * 
 * The dependency inversion principle (DIP) states that high-level modules
 * should not
 * depend on low-level modules. Both should depend on abstractions.
 */

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}
