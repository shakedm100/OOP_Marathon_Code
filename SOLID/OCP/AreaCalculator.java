package SOLID.OCP;

/**
 * Open/Closed Principle
 * 
 * The open/closed principle (OCP) states that software entities (classes,
 * modules, functions, etc.) should be open for extension, but closed for
 * modification.
 */
public class AreaCalculator {
    public double calculateTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}
