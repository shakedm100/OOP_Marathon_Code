/**
 * The Delegate Pattern is a technique where an object, instead of performing a
 * task itself,
 * hands off (delegates) that task to another helper object. It is a fundamental
 * alternative
 * to inheritance.
 * How it works
 * 
 * Imagine a Manager (Delegator) and a Developer (Delegate).
 * 
 * The Manager is responsible for "delivering software," but they don't write
 * the code themselves.
 * 
 * Instead, they hold a reference to a Developer and call the developer's
 * writeCode() method when work needs to be done.
 */

// 1. The Delegate Interface (The Contract)
interface Worker {
   void performTask();
}

// 2. The Concrete Delegate (The actual worker)
class JavaDeveloper implements Worker {
   @Override
   public void performTask() {
      System.out.println("Writing efficient Java code.");
   }
}

// 3. Another Concrete Delegate
class GraphicDesigner implements Worker {
   @Override
   public void performTask() {
      System.out.println("Designing a beautiful UI.");
   }
}

// 4. The Delegator (The one assigning the task)
class ProjectManager {
   private Worker delegate;

   // We inject the delegate here
   public ProjectManager(Worker delegate) {
      this.delegate = delegate;
   }

   public void work() {
      System.out.print("Manager delegates: ");
      // The delegation happens here:
      delegate.performTask();
   }
}

// 5. Client Code
public class Company {
   public static void main(String[] args) {
      // Create the delegate
      Worker dev = new JavaDeveloper();

      // Create the delegator and assign the delegate
      ProjectManager manager = new ProjectManager(dev);

      // The manager appears to do the work, but the developer actually does it
      manager.work();
   }
}