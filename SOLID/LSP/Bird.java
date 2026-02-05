package SOLID.LSP;

/**
 * Liskov Substitution Principle
 * 
 * The Liskov substitution principle (LSP) states that if S is a subtype of T,
 * then objects of type T may be replaced with objects of type S without
 * altering
 * any of the desirable properties of the program.
 * 
 * Another definition is:
 * The Liskov substitution principle (LSP) states that functions that use
 * pointers or
 * references to base classes must be able to use pointers or references of
 * derived classes
 * without knowing it.
 */
public abstract class Bird {
    public void eat() {
        System.out.println("I create output therefore I am");
    }
}
