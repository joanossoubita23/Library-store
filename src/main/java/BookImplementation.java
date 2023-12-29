import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookImplementation implements BookDAO{
    private  Connection connection;

    public BookImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addBook(Book book) {
        try (PreparedStatement statement=connection.prepareStatement("INSERT INTO Book(title,author,price) VALUES(?,?,?)") ){
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setDouble(3,book.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateBook(Book book) {
        try (PreparedStatement statement=connection.prepareStatement("UPDATE Book SET title=?, author=?, price=? WHERE bookId=? ")){
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setDouble(3,book.getPrice());
            statement.setInt(4,book.getBookId());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteBook(int bookId) {
        try (PreparedStatement statement=connection.prepareStatement("DELETE FROM Book WHERE bookId=?")) {
            statement.setInt(1,bookId);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Book getBookById(int bookId) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }
}
