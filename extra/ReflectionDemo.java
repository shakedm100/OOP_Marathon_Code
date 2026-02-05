
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SecretAgent {
    private String codeName = "Double-O-Seven";

    private void revealIdentity(String mission) {
        System.out.println("Agent " + codeName + " reporting for: " + mission);
    }
}
public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            // Create an instance of the class
            SecretAgent agent = new SecretAgent();

            // 1. Accessing a Private Field
            Field nameField = SecretAgent.class.getDeclaredField("codeName");
            nameField.setAccessible(true); // This is the "magic" key
            
            // Change the value of the private field
            nameField.set(agent, "Johnny English");
            System.out.println("New Code Name: " + nameField.get(agent));

            // 2. Invoking a Private Method
            // getDeclaredMethod(name, parameterTypes)
            Method method = SecretAgent.class.getDeclaredMethod("revealIdentity", String.class);
            method.setAccessible(true);
            
            // Invoke the method: method.invoke(objectInstance, arguments)
            method.invoke(agent, "Operation Reflection");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}