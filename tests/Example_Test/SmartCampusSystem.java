public class SmartCampusSystem {
    public static void main(String[] args) {
        // 1. Setup System with a Policy
        NotificationPolicy policy = new StandardPolicy();
        AlertManager manager = new AlertManager(policy);

        // 2. Register Subscribers (Observer Pattern)
        manager.registerSubscriber(new SecurityTeam());
        manager.registerSubscriber(new MaintenanceTeam());
        manager.registerSubscriber(new StudentApp());

        // 3. Deploy Sensors
        Sensor cafeteriaSmoke = new SmokeSensor("Cafeteria", manager);
        Sensor libraryDoor = new DoorSensor("Library Back Door", manager);

        // 4. Simulate Events
        // Case A: High Severity Smoke (Should alert everyone per policy)
        cafeteriaSmoke.trigger();

        // Case B: Low Severity Door (Should alert only Security and Maintenance)
        libraryDoor.trigger();
    }
}