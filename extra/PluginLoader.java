import java.util.ArrayList;
import java.util.List;

public class PluginLoader {

    public static List<LogPlugin<?>> loadPlugins(List<String> classNames) {
        // Collections: List is an ordered collection interface. ArrayList is a
        // resizable array implementation.
        List<LogPlugin<?>> plugins = new ArrayList<>();

        for (String className : classNames) {
            try {
                // Reflections: Loading a class dynamically by name at runtime.
                Class<?> clazz = Class.forName(className);
                // Reflections: Creating a new instance using the default constructor.
                Object instance = clazz.getDeclaredConstructor().newInstance();

                if (instance instanceof LogPlugin) {
                    // Generics: Using wildcard <?> to handle any type of LogPlugin.
                    plugins.add((LogPlugin<?>) instance);
                }
            }catch(IllegalArgumentException e){
                System.err.println("Invalid arguments for constructor: " + className);
                e.printStackTrace();
            }catch(InstantiationException e){
                System.err.println("Failed to instantiate class: " + className);
                e.printStackTrace();
            }
            catch (Exception e) {
                // Exception Handling: Catching common exceptions (ClassNotFoundException,
                // InstantiationException, etc.)
                System.err.println("Failed to load plugin: " + className);
                e.printStackTrace();
            }
        }
        return plugins;
    }
}
