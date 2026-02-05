import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Collections: List.of creates an immutable list containing the specified
        // elements.
        // Generics: List<String> ensures the list only contains String objects.
        List<String> pluginClasses = List.of(
                "ErrorCountPlugin",
                "WarningCollectorPlugin");

        var plugins = PluginLoader.loadPlugins(pluginClasses);
        var analyzer = new LogAnalyzer(plugins);

        // Files: Path.of creates a Path instance pointing to the file system location.
        Path logFile = Path.of("application.log");
        Map<String, Object> results = analyzer.analyze(logFile);

        results.forEach((k, v) -> {
            System.out.println("[" + k + "] => " + v);
        });
    }
}
