### Question 2

Yes, we should add a constructor to an abstract class. Because usually the abstract class has some fields that need to be initialized, and the constructor is the best way to do it.

### Question 3

Function overload is when we have multiple functions with the same name but different parameters.

Function override is when we have multiple functions with the same name and the same parameters but different return types.

### Question 4

Constructor is a special method that is called when an object is created. It is used to initialize the object.

Copy constructor is a constructor that creates a copy of an object. It is used to copy the values of the fields of an object to another object.

### Question 5

The answer is b.

Scenario: Nina wants to initialize a Trapezoid differently depending on whether it is right-angled or isosceles. Reasoning: In Java (and many OOP languages), constructors must have the same name as the class.

If Nina tries to write two constructors, they might have the same parameter types (e.g., 3 doubles), creating a signature conflict.

Even if the parameters differ, new Trapezoid(...) is ambiguous about which shape is being created.

Static Factory Methods (e.g., Trapezoid.createRightAngled(...) and Trapezoid.createIsosceles(...)) are the standard solution to this problem. They allow descriptive names and clear intent, which is a classic use case for static methods.

### Question 6

Checked exceptions are exceptions that are checked at compile time. Unchecked exceptions are exceptions that are not checked at compile time (Runtime exceptions).

For example, if we try to open a file that does not exist, we will get a checked exception. If we try to divide by zero, we will get an unchecked exception.

In the following example, if we were to remove the try-catch block, the compiler would not let us compile the code.
public class CheckedExample {
    public static void main(String[] args) {
        File file = new File("some_document.txt");

        // The compiler forces us to handle this because 
        // FileReader constructor throws a Checked Exception
        try {
            FileReader reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Handled: File was not found.");
        }
    }
}

public class UncheckedExample {
    public static void main(int x, int y) {
        System.out.println(x / y); // Throws ArithmeticException
    }
}

### Question 7

True

False - delegate design pattern is another way to achieve the same result

True

False - Factory's job is to concentrate object creation logic while having a simple way to add new types of objects. In short - factory's main purpose is OCP and SRP.

False - SRP is about single responsibility of each class.

True

Extremely False - design patterns are proffesional guidelines, not strict rules that must be followed.

### Question 8

Vehicle Toyota created
Car Corolla ready
---
Toyota Corolla is purring
Engine Starting...

### Question 9

C B 

### Question 10

a. Obviously Singleton

b.

corrected code:

public static Logger getInstance()
{
    if(instance == null)
    {
        instance = new Logger();
    }
    return instance;
}

Because a singleton is supposed to be initialized only once, we need to make sure that getinstance() creates the instance only once (or a finite amount of times).

There is also a thread safety issue. But it hardly believe Or will care.