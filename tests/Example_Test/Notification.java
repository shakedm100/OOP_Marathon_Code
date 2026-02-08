// Strategy Interface
interface NotificationPolicy {
    boolean shouldNotify(Observer subscriber, Event event);
}

// Concrete Strategy: Defines specific rules for the campus
class StandardPolicy implements NotificationPolicy {
    @Override
    public boolean shouldNotify(Observer subscriber, Event event) {
        String userType = subscriber.getUserType();

        // Rule 1: Security gets everything
        if (userType.equals("Security")) {
            return true;
        }

        // Rule 2: Maintenance only gets "Technical" or "Door" issues
        if (userType.equals("Maintenance")) {
            return event.getType().equals("Door") || event.getType().equals("Technical");
        }

        // Rule 3: Students only get high severity warnings (Severity > 3)
        if (userType.equals("Student")) {
            return event.getSeverity() > 3;
        }

        return false;
    }
}