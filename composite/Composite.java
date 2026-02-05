package composite;
import java.util.ArrayList;
import java.util.List;

// 1. The Component Interface (The common language)
interface IParkingComponent {
   void showDetails(String indent);
}

// 2. Leaf Node: Parking Spot (Has no children)
class ParkingSpot implements IParkingComponent {
   private String id;

   public ParkingSpot(String id) {
      this.id = id;
   }

   @Override
   public void showDetails(String indent) {
      System.out.println(indent + "- Spot: " + id);
   }
}

// 3. Leaf Node: Passage (Structure, has no children)
class Passage implements IParkingComponent {
   private String name;

   public Passage(String name) {
      this.name = name;
   }

   @Override
   public void showDetails(String indent) {
      System.out.println(indent + "- Passage: " + name);
   }
}

// 4. Composite: A Generic Container (Can hold Leafs or other Composites)
// This reduces code duplication for Floors and Areas
abstract class ParkingComposite implements IParkingComponent {
   private String name;
   private List<IParkingComponent> components = new ArrayList<>();

   public ParkingComposite(String name) {
      this.name = name;
   }

   public void addComponent(IParkingComponent component) {
      components.add(component);
   }

   @Override
   public void showDetails(String indent) {
      System.out.println(indent + "+ " + name);
      for (IParkingComponent component : components) {
         // Recursively call showDetails on children
         component.showDetails(indent + "  ");
      }
   }
}

// 5. Concrete Composites
class ParkingArea extends ParkingComposite {
   public ParkingArea(String name) {
      super(name);
   }
}

class ParkingFloor extends ParkingComposite {
   public ParkingFloor(String name) {
      super(name);
   }
}

// 6. Client Code
public class Composite {
   public static void main(String[] args) {
      // Create Leafs (Spots & Passages)
      IParkingComponent spot1 = new ParkingSpot("A-101");
      IParkingComponent spot2 = new ParkingSpot("A-102");
      IParkingComponent passageEast = new Passage("East Wing Hallway");

      // Create Composite (Area) and add Leafs
      ParkingArea areaA = new ParkingArea("Zone A (VIP)");
      areaA.addComponent(spot1);
      areaA.addComponent(spot2);

      // Create Composite (Floor) and add Area + Passage
      ParkingFloor floor1 = new ParkingFloor("Level 1");
      floor1.addComponent(areaA);
      floor1.addComponent(passageEast);

      // Recursively print the entire structure
      System.out.println("Parking Lot Structure:");
      floor1.showDetails("");
   }
}