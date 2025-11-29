
public class BotLogic {

    public static String getBotResponse(String userMessage) {
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Please say something.";
        }

        // Fetch reply from DB
        String reply = DatabaseHandler.getReply(userMessage);

        return reply;
    }
}









// import java.sql.*;

// public class BotLogic {
//     private Connection con;

//     public BotLogic(Connection dbConnection) {
//         this.con = dbConnection;
//     }

//     public String getReply(String userMessage) {
//         try {
//             String query = "SELECT response FROM bot_responses WHERE ? LIKE CONCAT('%', keyword, '%') LIMIT 1";
//             PreparedStatement ps = con.prepareStatement(query);
//             ps.setString(1, userMessage.toLowerCase());
//             ResultSet rs = ps.executeQuery();

//             if (rs.next()) {
//                 return rs.getString("response");
//             } else {
//                 return "Sorry, I don't understand that. Can you ask something else?";
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return "Error retrieving response from database.";
//         }
//     }
// }





// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

// public class BotLogic {

//     private Connection con;

//     public BotLogic(Connection con) {
//         this.con = con;
//     }

//     public String getReply(String userInput) {
//         try {
//             if (userInput == null || userInput.trim().isEmpty()) {
//                 return "Please type something.";
//             }

//             String cleanedInput = userInput.trim().toLowerCase();
//             System.out.println("[DEBUG] cleanedInput = " + cleanedInput);

//             // 1. EXACT MATCH
//             String sqlExact = "SELECT reply FROM bot_responses WHERE LOWER(keyword) = ? LIMIT 1";
//             System.out.println("[DEBUG] Running exact match query");
//             PreparedStatement ps1 = con.prepareStatement(sqlExact);
//             ps1.setString(1, cleanedInput);
//             ResultSet rs1 = ps1.executeQuery();

//             if (rs1.next()) {
//                 System.out.println("[DEBUG] Exact match FOUND");
//                 return rs1.getString("reply");
//             } else {
//                 System.out.println("[DEBUG] Exact match NOT found");
//             }

//             // 2. PARTIAL MATCH (CORRECT VERSION)
//             String sqlLike = "SELECT reply FROM bot_responses WHERE LOWER(?) LIKE CONCAT('%', LOWER(keyword), '%') LIMIT 1";
//             System.out.println("[DEBUG] Running partial match query");
//             PreparedStatement ps2 = con.prepareStatement(sqlLike);
//             ps2.setString(1, cleanedInput);
//             ResultSet rs2 = ps2.executeQuery();

//             if (rs2.next()) {
//                 System.out.println("[DEBUG] Partial match FOUND");
//                 return rs2.getString("reply");
//             } else {
//                 System.out.println("[DEBUG] Partial match NOT found");
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error occurred while generating reply.";
//         }

//         System.out.println("[DEBUG] Returning default message");
//         return "I didn't understand that!";
//     }
// }











// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

// public class BotLogic {

//     private Connection con;

//     public BotLogic(Connection con) {
//         this.con = con;
//     }

//     public String getReply(String userInput) {
//         try {
//             if (userInput == null || userInput.trim().isEmpty()) {
//                 return "Please type something.";
//             }

//             String cleanedInput = userInput.trim().toLowerCase();

//             // 1. Exact match
//             String sqlExact = "SELECT reply FROM bot_responses WHERE LOWER(keyword) = ? LIMIT 1";
//             PreparedStatement ps1 = con.prepareStatement(sqlExact);
//             ps1.setString(1, cleanedInput);
//             ResultSet rs1 = ps1.executeQuery();

//             if (rs1.next()) {
//                 return rs1.getString("reply");
//             }

//             // 2. Partial match (correct direction)
//             String sqlLike = "SELECT reply FROM bot_responses WHERE ? LIKE CONCAT('%', LOWER(keyword), '%') LIMIT 1";
//             PreparedStatement ps2 = con.prepareStatement(sqlLike);
//             ps2.setString(1, cleanedInput);
//             ResultSet rs2 = ps2.executeQuery();

//             if (rs2.next()) {
//                 return rs2.getString("reply");
//             }

//         } catch (Exception e) {
//             e.printStackTrace();
//             return "Error occurred while generating reply.";
//         }

//         return "I didn't understand that!";
//     }
// }



