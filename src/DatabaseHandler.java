import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler {

    private static final String URL =
        "jdbc:mysql://localhost:3306/message?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "852714sandhya";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getReply(String userMessage) {

        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Please type something.";
        }

        String input = userMessage.toLowerCase().trim();

        try (Connection con = getConnection()) {

            // Step 1: Exact keyword match
            String sql1 =
                "SELECT reply FROM bot_responses " +
                "WHERE LOWER(keyword) = ? LIMIT 1";

            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setString(1, input);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                return rs1.getString("reply");
            }

            // Step 2: Keyword inside sentence
            String sql2 =
                "SELECT reply FROM bot_responses " +
                "WHERE ? LIKE CONCAT('%', LOWER(keyword), '%') " +
                "ORDER BY LENGTH(keyword) DESC LIMIT 1";

            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, input);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                return rs2.getString("reply");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Database error occurred.";
        }

        return "Sorry, I didn't understand that.";
    }
}
