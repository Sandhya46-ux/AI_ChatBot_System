import java.sql.*;

public class BotLogic {

    private Connection con;

    public BotLogic(Connection con) {
        this.con = con;
    }

    public String getReply(String userInput) {
        try {
            String sql = "SELECT reply FROM bot_responses WHERE keyword = ? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userInput.toLowerCase());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("reply");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "I didn't understand that!";
    }
}

