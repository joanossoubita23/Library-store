import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
    private static   final String DB_USER="root";
    private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/Library_DB";
    private static   final String DB_PASSWORD="";
    public  static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("Library Connected to the Database ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return conn;

    }

}
