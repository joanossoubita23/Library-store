import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    void updateBook(Book book);
    Book deleteBook(int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
}
