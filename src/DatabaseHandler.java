import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler {

    private static final String URL = "jdbc:mysql://localhost:3306/message";
    private static final String USER = "root";
    private static final String PASSWORD = "852714sandhya";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getReply(String keyword) {
        String reply = null;
        String sql = "SELECT reply FROM bot_responses WHERE keyword = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, keyword.trim().toLowerCase());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                reply = rs.getString("reply");
            } else {
                reply = "Sorry, I didn't understand that.";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reply;
    }

    // TEST MAIN
    public static void main(String[] args) {
        try {
            Connection con = getConnection();
            if (con != null) {
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Connection failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

















// import java.sql.*;

// public class DatabaseHandler {
//     private static Connection con;

//     public static Connection getConnection() {
//         if (con == null) {
//             try {
//                 Class.forName("com.mysql.cj.jdbc.Driver");
//                 Connection con = DriverManager.getConnection(
//                     "jdbc:mysql://localhost:3306/message", "root", "852714sandhya");
//                 System.out.println("Database connected!");
//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//         }
//         return con;
//     }

//     public static void saveMessage(String user, String message) {
//         try {
//             String query = "INSERT INTO chat_history(user, message) VALUES(?, ?)";
//             PreparedStatement ps = getConnection().prepareStatement(query);
//             ps.setString(1, user);
//             ps.setString(2, message);
//             ps.executeUpdate();
//         } catch(SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     public static ResultSet getMessages() {
//         try {
//             Statement stmt = getConnection().createStatement();
//             return stmt.executeQuery("SELECT * FROM chat_history");
//         } catch(SQLException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }






// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;

// public class DatabaseHandler {

//     private static final String URL = "jdbc:mysql://localhost:3306/message";
//     private static final String USER = "root";
//     private static final String PASS = "852714sandhya"; // if you have password, put it here

//     // Create a database connection
//     public static Connection getConnection() {
//         try {
//             return DriverManager.getConnection(URL, USER, PASS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

//     // Save chat to database
//     public static void saveMessage(String sender, String message) {
//         try (Connection con = getConnection()) {
//             if (con == null) return;

//             String sql = "INSERT INTO chat_history(user, message) VALUES (?, ?)";
//             PreparedStatement ps = con.prepareStatement(sql);
//             ps.setString(1, sender);
//             ps.setString(2, message);
//             ps.executeUpdate();

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
