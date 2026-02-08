package Extra_Questions;

// --- Composite: Leaf (המצב הייחודי - Extrinsic State) ---
class Tree implements ForestComponent {
    private int x, y;
    private int hp;
    private boolean isBurning;
    private TreeType type; // מצביע למידע המשותף

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.hp = 100;
        this.isBurning = false;
    }

    @Override
    public void accept(ForestVisitor visitor) {
        visitor.visit(this); // השלב השני ב-Double Dispatch
    }

    // Getters למצב הייחודי שה-Visitor צריך
    public int getHp() {
        return hp;
    }

    public boolean isBurning() {
        return isBurning;
    }

    public TreeType getType() {
        return type;
    }
}
