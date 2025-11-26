import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/message";
    private static final String USER = "root";
    private static final String PASS = "852714sandhya"; // if you have password, put it here

    // Create a database connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Save chat to database
    public static void saveMessage(String sender, String message) {
        try (Connection con = getConnection()) {
            if (con == null) return;

            String sql = "INSERT INTO chat_history(user, message) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sender);
            ps.setString(2, message);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
