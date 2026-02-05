import java.util.ArrayList;
import java.util.List;

// 1. The Observer Interface
// All smart devices must implement this to receive updates.
interface Observer {
    void update(float temperature);
}

// 2. The Subject Interface
// Defines methods to attach, detach, and notify observers.
interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}

// 3. Concrete Subject ( The Data Source )
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println("\n(WeatherStation) New Temperature detected: " + temperature + "°C");
        notifyObservers(); // Trigger the notification
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// 4. Concrete Observer A: Smart Fan
class SmartFan implements Observer {
    @Override
    public void update(float temperature) {
        if (temperature > 25) {
            System.out.println("  -> [SmartFan] It's hot! Turning ON fan.");
        } else {
            System.out.println("  -> [SmartFan] It's cool. Fan is OFF.");
        }
    }
}

// 5. Concrete Observer B: Wall Display
class WallDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("  -> [WallDisplay] Updating screen to show: " + temperature + "°C");
    }
}

// 6. Client Code
public class observer {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        // Create devices
        Observer fan = new SmartFan();
        Observer display = new WallDisplay();

        // Register devices to the station
        station.attach(fan);
        station.attach(display);

        // Simulate temperature changes
        station.setTemperature(22.0f); // Cool
        station.setTemperature(30.0f); // Hot (Fan should turn on)
    }
}