import java.util.ArrayList;
import java.util.List;

class AlertManager {
    private List<Observer> subscribers = new ArrayList<>();
    private NotificationPolicy policy;

    public AlertManager(NotificationPolicy policy) {
        this.policy = policy;
    }

    // Dynamic registration of new user types
    public void registerSubscriber(Observer subscriber) {
        subscribers.add(subscriber);
    }

    // Main logic flow
    public void receiveEvent(Event event) {
        System.out.println("\n--- Processing Event: " + event.toString() + " ---");

        // Optional processing (augmenting data)
        processEvent(event);

        // Notify relevant subscribers based on Policy
        for (Observer sub : subscribers) {
            if (policy.shouldNotify(sub, event)) {
                sub.onAlertReceived(event);
            }
        }
    }

    private void processEvent(Event event) {
        // Example logic: Mark extremely high severity events as urgent
        if (event.getSeverity() == 5) {
            System.out.println("(System Note: This is a CRITICAL event)");
        }
    }
}