abstract class Sensor {
    protected String location;
    protected AlertManager manager;

    public Sensor(String location, AlertManager manager) {
        this.location = location;
        this.manager = manager;
    }

    // Abstract method to force subclasses to define their trigger behavior
    public abstract void trigger();
}

class SmokeSensor extends Sensor {
    public SmokeSensor(String location, AlertManager manager) {
        super(location, manager);
    }

    @Override
    public void trigger() {
        // Smoke is usually high severity (5)
        Event e = new Event("Smoke Detected", location, 5);
        manager.receiveEvent(e);
    }
}

class DoorSensor extends Sensor {
    public DoorSensor(String location, AlertManager manager) {
        super(location, manager);
    }

    @Override
    public void trigger() {
        // Door open is usually low severity (1)
        Event e = new Event("Door Left Open", location, 1);
        manager.receiveEvent(e);
    }
}