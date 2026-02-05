package SOLID.DIP;

public class NotificationService {
    private MessageSender messageSender;

    // Depend on abstraction (MessageSender) not implementation (EmailSender)
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message) {
        messageSender.sendMessage(message);
    }
}
