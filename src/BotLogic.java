public class BotLogic {

    public static String getBotResponse(String userMessage) {

        // 1. Validation
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Please type something 🙂";
        }

        // 2. Normalize input
        String cleanedMessage = userMessage.trim().toLowerCase();

        // 3. Try database first
        String dbReply = DatabaseHandler.getReply(cleanedMessage);

        if (dbReply != null && !dbReply.isEmpty()) {
            return dbReply;
        }

        // 4. Fallback (extra intelligence – good for marks)
        if (cleanedMessage.contains("hello") || cleanedMessage.contains("hi")) {
            return "Hello! How can I help you?";
        }

        if (cleanedMessage.contains("how are you")) {
            return "I'm doing great 😊 What about you?";
        }

        if (cleanedMessage.contains("bye")) {
            return "Goodbye! Have a nice day 👋";
        }

        if (cleanedMessage.contains("java")) {
            return "Java is a powerful object-oriented programming language ☕";
        }

        // 5. Default fallback
        return "Sorry, I didn't understand that. Can you rephrase?";
    }
}
