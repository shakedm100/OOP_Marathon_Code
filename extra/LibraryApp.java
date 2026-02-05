import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s (%d)", title, author, year);
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // This method accepts a Lambda (Predicate) to define "what" to search for
    public List<Book> findBooks(Predicate<Book> filter) {
        return books.stream()
                    .filter(filter)
                    .collect(Collectors.toList());
    }

    // This method accepts a Lambda (Consumer) to define "what" to do with each book
    public void processBooks(Consumer<Book> action) {
        for (Book book : books) {
            action.accept(book);
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));

        // 1. Using a Lambda to filter for books published after 1940
        System.out.println("Books after 1940:");
        List<Book> modernBooks = library.findBooks(book -> book.year > 1940);
        modernBooks.forEach(System.out::println);

        // 2. Using a Lambda to search by author
        System.out.println("\nBooks by Tolkien:");
        library.findBooks(b -> b.author.contains("Tolkien"))
               .forEach(System.out::println);

        // 3. Using a Lambda to perform a custom action (Printing uppercase titles)
        System.out.println("\nUppercase Titles:");
        library.processBooks(book -> System.out.println(book.title.toUpperCase()));
    }
}