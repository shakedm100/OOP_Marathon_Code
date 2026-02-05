import java.util.stream.Stream;

// Generics: Specifying 'Long' as the return type for this plugin implementation.
public class ErrorCountPlugin implements LogPlugin<Long> {

    @Override
    public String name() {
        return "Error Counter";
    }

    @Override
    public Long analyze(Stream<String> logLines) {
        // Java Streams: Functional-style operations on streams of elements.
        // filter: Intermediate operation to select elements matching a predicate.
        // count: Terminal operation returning the number of elements.
        return logLines
                .filter(line -> line.contains("ERROR"))
                .count();
    }
}
