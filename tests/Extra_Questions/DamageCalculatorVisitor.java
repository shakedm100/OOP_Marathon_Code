package Extra_Questions;

// --- Concrete Visitor: חישוב נזק ---
class DamageCalculatorVisitor implements ForestVisitor {
    private double totalDamage = 0;

    @Override
    public void visit(Tree tree) {
        // לוגיקה לחישוב נזק לעץ בודד
        // לדוגמה: אם העץ נשרף לגמרי, הנזק הוא 100 דולר, אחרת יחסי ל-HP
        if (tree.getHp() < 100) {
            totalDamage += (100 - tree.getHp()) * 10;
        }
    }

    @Override
    public void visit(Region region) {
        // בדרך כלל אין נזק ישיר לאזור עצמו, אלא לתכולתו.
        // אבל אם היה צריך, יכולנו לחשב כאן.
        System.out.println("Calculating damage for region: " + region.getName());
    }

    public double getTotalDamage() {
        return totalDamage;
    }
}