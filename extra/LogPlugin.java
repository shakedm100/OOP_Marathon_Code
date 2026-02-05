import java.util.stream.Stream;

public interface LogPlugin<T> {
    String name();

    T analyze(Stream<String> logLines) throws Exception;
}
