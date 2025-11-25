import java.sql.*;

public class DatabaseHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/message";
    private static final String USER = "root";
    private static final String PASS = ""; // add your password

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

