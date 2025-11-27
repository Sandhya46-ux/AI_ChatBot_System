import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("AI Chatbot");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userText = inputField.getText();

                if (userText.trim().isEmpty()) return;

                chatArea.append("You: " + userText + "\n");

                String botReply = BotLogic.getBotResponse(userText);
                chatArea.append("Bot: " + botReply + "\n\n");

                inputField.setText("");
            }
        });

        frame.setVisible(true);
    }
}






// import java.awt.BorderLayout;
// import java.sql.Connection;
// import javax.swing.*;

// public class ChatbotGUI extends JFrame {

//     private JTextArea chatArea;
//     private JTextField userTextField;
//     private JButton sendButton;
//     private BotLogic bot;

//     public ChatbotGUI() {

//         Connection con = DatabaseHandler.getConnection();
//         bot = new BotLogic(con);

//         setTitle("AI Chatbot");
//         setSize(500, 500);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         chatArea = new JTextArea();
//         chatArea.setEditable(false);
//         chatArea.setLineWrap(true);

//         JScrollPane scrollPane = new JScrollPane(chatArea);

//         userTextField = new JTextField();
//         sendButton = new JButton("Send");

//         JPanel inputPanel = new JPanel(new BorderLayout());
//         inputPanel.add(userTextField, BorderLayout.CENTER);
//         inputPanel.add(sendButton, BorderLayout.EAST);

//         add(scrollPane, BorderLayout.CENTER);
//         add(inputPanel, BorderLayout.SOUTH);

//         // Events
//         sendButton.addActionListener(e -> sendMessage());
//         userTextField.addActionListener(e -> sendMessage());

//         setVisible(true);
//     }

//     private void sendMessage() {
//         System.out.println("sendMessage triggered");

//         String userMessage = userTextField.getText().trim();

//         if (!userMessage.isEmpty()) {
//             chatArea.append("You: " + userMessage + "\n");

//             String botReply = bot.getReply(userMessage);
//             chatArea.append("Bot: " + botReply + "\n\n");

//             // Save to database
//             DatabaseHandler.saveMessage("User", userMessage);
//             DatabaseHandler.saveMessage("Bot", botReply);

//             userTextField.setText("");
//         }
//     }

//     public static void main(String[] args) {

//         System.out.println("Testing DB connection...");
// System.out.println(DatabaseHandler.getConnection());

//         SwingUtilities.invokeLater(ChatbotGUI::new);
//     }
// }

