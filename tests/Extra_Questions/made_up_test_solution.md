Question 2: Shallow Copy vs. Deep Copy

Shallow Copy: Copies the object's field values exactly as they are. If a field is a reference type (a pointer to another object), only the memory address is copied. Both the original and the copy point to the same underlying object in memory.

Deep Copy: Creates a completely new independent copy of the object and recursively creates new copies of all objects it references.

Question 3: Early Binding vs. Late Binding

Early Binding (Static): The compiler determines which function to call at compile-time.

Example: Function Overloading (Methods with the same name but different parameters).

Late Binding (Dynamic): The specific function to be called is determined at runtime based on the actual object type in memory.

Example: Method Overriding (Polymorphism, where a child class overrides a parent method).

Question 4: Composition over Inheritance

Inheritance creates a rigid "is-a" relationship. Deep inheritance hierarchies lead to the "Fragile Base Class" problem, where changes in a parent class inadvertently break child classes. It also exposes implementation details.

Composition creates a flexible "has-a" relationship. Objects contain other objects to define behavior. This allows changing behavior at runtime (e.g., swapping a Strategy) and reduces coupling.

Question 5: Observer Pattern Scenarios

Best Scenario: "A stock trading system where when a stock price changes, all traders tracking it need to receive real-time updates."

Question 6: True / False

False. The Open/Closed Principle states a class should be open for extension but closed for modification.

True. Unchecked Exceptions (like RuntimeException in Java) do not require explicit try-catch blocks or throws declarations.

False. A static method belongs to the class, not an instance. It cannot access instance variables (this.variable) because it runs without a specific object context.

Part C: Practical Application

Question 7 (Python - Inheritance & Super)

Output:

Initializing SmartPhone...
Device iPhone initialized
---
Loading iOS...
Device is creating sparks...

Question 8 (Java - Polymorphism)

Output:

Woof
Fetching ball
Meow

Question 9 (Observer Bug Analysis)

1. Why is there no output?
The programmer forgot to trigger the notification in the setter method.
Missing line:

notifyObservers(); // This line is missing inside setMeasurements()


Without this call, the temperature variable updates, but the update() method of the registered observers is never invoked.

2. Loose Coupling Explanation:
The Observer pattern provides loose coupling because the WeatherData (Subject) only knows about the Observer interface, not the concrete CurrentConditionsDisplay class.

Why is this better? We can add new display types (e.g., ForecastDisplay, StatisticsDisplay) in the future without ever modifying the WeatherData code. If WeatherData held a direct reference to CurrentConditionsDisplay, adding a new display would require changing the WeatherData class, violating the Open/Closed Principle.