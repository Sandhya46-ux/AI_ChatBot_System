import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

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

                    String userText = inputField.getText().trim();
                    if (userText.isEmpty()) return;

                    chatArea.append("You: " + userText + "\n");

                    // MUST exist in BotLogic
                    String botReply = BotLogic.getBotResponse(userText);

                    chatArea.append("Bot: " + botReply + "\n\n");
                    inputField.setText("");
                }
            });

            frame.setVisible(true);
        });
    }
}
