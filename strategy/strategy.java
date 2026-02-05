// 1. The Strategy Interface
// This defines the common action all strategies must implement.
interface ChessStrategy {
    void executeMove();
}

// 2. Concrete Strategy A: Aggressive
class AggressiveStrategy implements ChessStrategy {
    @Override
    public void executeMove() {
        System.out.println("Strategy: Attack diagonal enemy! (Risk high)");
    }
}

// 3. Concrete Strategy B: Defensive
class DefensiveStrategy implements ChessStrategy {
    @Override
    public void executeMove() {
        System.out.println("Strategy: Hold position and block enemy path.");
    }
}

// 4. Concrete Strategy C: Promotion
class PromotionStrategy implements ChessStrategy {
    @Override
    public void executeMove() {
        System.out.println("Strategy: Sprint forward to reach the 8th rank!");
    }
}

// 5. The Context (The Pawn)
// The Pawn doesn't know HOW to move; it delegates that to the current strategy.
class Pawn {
    private ChessStrategy currentStrategy;

    public Pawn(ChessStrategy startStrategy) {
        this.currentStrategy = startStrategy;
    }

    // This is the key method: allowing the strategy to be swapped at runtime
    public void setStrategy(ChessStrategy newStrategy) {
        this.currentStrategy = newStrategy;
    }

    public void move() {
        // Delegate the action to the strategy
        currentStrategy.executeMove();
    }
}

// 6. Client Code
public class strategy {
    public static void main(String[] args) {
        // Start the game with a defensive mindset
        Pawn myPawn = new Pawn(new DefensiveStrategy());
        System.out.print("Turn 1: ");
        myPawn.move();

        // Situation changes: An enemy is nearby! Swap to Aggressive.
        System.out.println("\n--> Enemy spotted!");
        myPawn.setStrategy(new AggressiveStrategy());
        System.out.print("Turn 2: ");
        myPawn.move();

        // Situation changes: The path is clear to the end. Swap to Promotion.
        System.out.println("\n--> Path clear!");
        myPawn.setStrategy(new PromotionStrategy());
        System.out.print("Turn 3: ");
        myPawn.move();
    }
}