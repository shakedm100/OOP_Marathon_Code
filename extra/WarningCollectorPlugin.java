import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Generics: Specifying 'List<String>' as the type parameter.
public class WarningCollectorPlugin implements LogPlugin<List<String>> {

    @Override
    public String name() {
        return "Warning Collector";
    }

    @Override
    public List<String> analyze(Stream<String> logLines) {
        // Java Streams & Collections:
        // collect: Terminal operation to transform the stream elements into a
        // Collection.
        // Collectors.toList(): A collector that accumulates elements into a List.
        return logLines
                .filter(line -> line.contains("WARN"))
                .collect(Collectors.toList());
    }
}
