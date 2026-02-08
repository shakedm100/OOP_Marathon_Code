package Extra_Questions;

// --- Composite Interface ---
interface ForestComponent {
    // פעולה זו היא ה"דלת" שדרכה ה-Visitor נכנס (Double Dispatch)
    void accept(ForestVisitor visitor);
}
