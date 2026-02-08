package Extra_Questions;

import java.util.HashMap;
import java.util.Map;

// --- Flyweight Factory ---
// מבטיח שלא ייווצרו כפילויות של TreeType
class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String texture, double burnRate) {
        if (!treeTypes.containsKey(name)) {
            treeTypes.put(name, new TreeType(name, texture, burnRate));
        }
        return treeTypes.get(name);
    }
}