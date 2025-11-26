import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.*;

public class ChatbotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField userTextField;
    private JButton sendButton;
    private BotLogic bot;

    public ChatbotGUI() {

        Connection con = DatabaseHandler.getConnection();
        bot = new BotLogic(con);

        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        userTextField = new JTextField();
        sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(userTextField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Events
        sendButton.addActionListener(e -> sendMessage());
        userTextField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    private void sendMessage() {
        System.out.println("sendMessage triggered");

        String userMessage = userTextField.getText().trim();

        if (!userMessage.isEmpty()) {
            chatArea.append("You: " + userMessage + "\n");

            String botReply = bot.getReply(userMessage);
            chatArea.append("Bot: " + botReply + "\n\n");

            // Save to database
            DatabaseHandler.saveMessage("User", userMessage);
            DatabaseHandler.saveMessage("Bot", botReply);

            userTextField.setText("");
        }
    }

    public static void main(String[] args) {

        System.out.println("Testing DB connection...");
System.out.println(DatabaseHandler.getConnection());

        SwingUtilities.invokeLater(ChatbotGUI::new);
    }
}

