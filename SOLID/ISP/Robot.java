package SOLID.ISP;

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    // Robot does not implement Eater interface because robots don't eat.
}
