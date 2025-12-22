public class BotLogic {
    public static String getBotResponse(String userMessage) {
        return DatabaseHandler.getReply(userMessage);
    }
}
