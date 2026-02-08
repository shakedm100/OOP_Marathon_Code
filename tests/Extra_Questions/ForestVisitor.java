package Extra_Questions;

// --- Visitor Interface ---
// הממשק המאפשר הוספת פעולות חדשות (Open/Closed Principle)
interface ForestVisitor {
    void visit(Tree tree);

    void visit(Region region);
}