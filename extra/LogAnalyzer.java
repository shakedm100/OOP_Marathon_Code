import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class LogAnalyzer {

    private final List<LogPlugin<?>> plugins;

    // Generics: Wildcard usage to accept a list of plugins defined with different
    // types.
    public LogAnalyzer(List<LogPlugin<?>> plugins) {
        this.plugins = plugins;
    }

    public Map<String, Object> analyze(Path logFile) {
        // Collections: LinkedHashMap preserves the insertion order of keys.
        Map<String, Object> results = new LinkedHashMap<>();

        for (LogPlugin<?> plugin : plugins) {
            // Files & Exception Handling: Files.lines reads file lazily as a Stream.
            // try-with-resources ensures the stream is closed automatically.
            // Java Streams: A sequence of elements supporting sequential and parallel
            // aggregate operations.
            try (Stream<String> lines = Files.lines(logFile)) {
                Object result = plugin.analyze(lines);
                results.put(plugin.name(), result);
            } catch (IOException e) {
                // Exception Handling: Specific handling for IO errors.
                System.err.println("File error: " + logFile);
            } catch (Exception e) {
                // Exception Handling: General catch block for other errors.
                System.err.println("Plugin failed: " + plugin.name());
            }
        }
        return results;
    }
}
