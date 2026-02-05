package SOLID.DIP;

public class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent: " + message);
    }
}
