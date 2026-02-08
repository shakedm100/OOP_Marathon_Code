import java.util.*;

// --- Flyweight Pattern: המצב המשותף (Intrinsic State) ---
// מחלקה זו מכילה את הנתונים הכבדים שמשותפים לכל העצים מאותו זן
class TreeType {
    private String botanicalName;
    private String texture3DModel; // נתון כבד מאוד
    private double burnRate;

    public TreeType(String botanicalName, String texture3DModel, double burnRate) {
        this.botanicalName = botanicalName;
        this.texture3DModel = texture3DModel;
        this.burnRate = burnRate;
    }

    public String getBotanicalName() {
        return botanicalName;
    }
    // מתודות ציור וחישוב המשתמשות במידע הכבד יופיעו כאן
}



