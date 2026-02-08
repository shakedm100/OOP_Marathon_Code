import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// The data object representing a specific alert
class Event {
    private String type; // e.g., "Fire", "Motion"
    private String location; // e.g., "Building A"
    private int severity; // 1-5
    private LocalDateTime timestamp;

    public Event(String type, String location, int severity) {
        this.type = type;
        this.location = location;
        this.severity = severity;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s at %s (Severity: %d)", timestamp, type, location, severity);
    }
}