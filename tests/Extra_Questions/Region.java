package Extra_Questions;

// --- Composite: Composite (אזור) ---
import java.util.ArrayList;
import java.util.List;

class Region implements ForestComponent {
    private List<ForestComponent> children = new ArrayList<>();
    private String name;

    public Region(String name) {
        this.name = name;
    }

    public void add(ForestComponent component) {
        children.add(component);
    }

    @Override
    public void accept(ForestVisitor visitor) {
        visitor.visit(this);
        // העברת ה-Visitor לכל הילדים ברקורסיה
        for (ForestComponent child : children) {
            child.accept(visitor);
        }
    }

    public String getName() {
        return name;
    }
}