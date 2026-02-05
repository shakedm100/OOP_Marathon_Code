import java.util.ArrayList;
import java.util.List;

// The Singleton Class
class Gym {
    // 1. Static variable to hold the single instance
    private static Gym instance;

    // State of the gym (shared by everyone)
    private List<String> members;

    // 2. Private constructor: Prevents instantiation from other classes
    private Gym() {
        members = new ArrayList<>();
        System.out.println("--> A new Central Gym has been built! (Instance Created)");
    }

    // 3. Public static method: The global access point
    public static Gym getInstance() {
        // Lazy Initialization: Only create it if it doesn't exist yet
        if (instance == null) {
            instance = new Gym();
        }
        return instance;
    }

    // Business Logic
    public void addMember(String name) {
        members.add(name);
        System.out.println("Welcome, " + name + ". Total members: " + members.size());
    }
}

// Client Code
public class Singleton {
    public static void main(String[] args) {
        // ERROR: The following line would fail because the constructor is private:
        // Gym myGym = new Gym();

        // Correct usage: Ask for the instance
        System.out.println("Client 1: I want to join the gym.");
        Gym gym1 = Gym.getInstance();
        gym1.addMember("Alice");

        System.out.println("\nClient 2: I want to join the gym too.");
        Gym gym2 = Gym.getInstance(); // This returns the SAME object as gym1
        gym2.addMember("Bob");

        // Verification
        System.out.println("\nAre gym1 and gym2 the same object? " + (gym1 == gym2));
    }
}