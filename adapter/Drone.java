// 1. The Target Interface
interface ModernRobot {
    void moveForward();
}

// 2. The Adaptee (Incompatible Legacy Class)
class LegacyDrone {
    public void activateRotors() {
        System.out.println("Drone rotors spinning...");
    }
    
    public void applyThrust() {
        System.out.println("Drone moving forward via thrust.");
    }
}

// 3. The Adapter
class DroneAdapter implements ModernRobot {
    private LegacyDrone drone;

    public DroneAdapter(LegacyDrone drone) {
        this.drone = drone;
    }

    @Override
    public void moveForward() {
        // Translating the single 'moveForward' call into 
        // the sequence the legacy system requires.
        drone.activateRotors();
        drone.applyThrust();
    }
}

// 4. Client Code
public class Main {
    public static void main(String[] args) {
        LegacyDrone myOldDrone = new LegacyDrone();
        
        // The client wants a ModernRobot. We provide the Adapter.
        ModernRobot adaptedRobot = new DroneAdapter(myOldDrone);
        
        System.out.println("Client: Commanding the robot to move...");
        adaptedRobot.moveForward();
    }
}