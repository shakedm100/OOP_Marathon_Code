package flyweight;
import java.awt.Color;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 1. The Concrete Flyweight
// This class stores the "Heavy" data that is shared across many trees.
// This state is INTRINSIC (immutable/shared).
class TreeType {
    private String name;
    private Color color;
    private String otherTreeData; // Imagine this is a heavy texture or mesh

    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    // The draw method accepts Extrinsic state (x, y) as arguments.
    // It doesn't store them!
    public void draw(int x, int y) {
        System.out.println("Drawing Tree [" + name + ", Color: " + color + "] at (" + x + ", " + y + ")");
    }
}

// 2. The Flyweight Factory
// This encapsulates the complexity of caching flyweights.
class TreeFactory {
    // The cache (Pool)
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        // We use the name as the key for simplicity, but could be a complex key
        TreeType result = treeTypes.get(name);

        if (result == null) {
            // If it doesn't exist, create it and put it in the cache
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
            System.out.println("--> Creating new TreeType object: " + name);
        }
        return result;
    }
}

// 3. The Context
// This contains the EXTRINSIC state (unique to this specific tree instance).
// It's very lightweight.
class Tree {
    private int x;
    private int y;
    private TreeType type; // Reference to the shared Flyweight object

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        // We delegate the "heavy lifting" to the Flyweight type
        type.draw(x, y);
    }
}

// 4. The Client
// The Forest manages the trees.
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        // We ask the factory for a Type. It might return an existing one or a new one.
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        
        // We create the lightweight Tree object using that shared type
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void paint() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

// 5. Execution
public class flyweight {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // We are "planting" 4 trees, but only 2 Types exist.
        // The factory will reuse the "Oak" and "Pine" objects.
        
        forest.plantTree(10, 20, "Oak", Color.GREEN, "OakTextureStub");
        forest.plantTree(15, 25, "Oak", Color.GREEN, "OakTextureStub"); // Reuses Oak
        
        forest.plantTree(100, 200, "Pine", Color.DARK_GRAY, "PineTextureStub");
        forest.plantTree(105, 205, "Pine", Color.DARK_GRAY, "PineTextureStub"); // Reuses Pine

        System.out.println("\n--- Drawing Forest ---");
        forest.paint();
        
        // Verification of memory saving (conceptually)
        // Without Flyweight: 4 Texture Objects in RAM
        // With Flyweight:    2 Texture Objects in RAM
    }
}