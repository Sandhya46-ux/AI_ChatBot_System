import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        String userMessage = request.getParameter("message");

        if (userMessage == null || userMessage.trim().isEmpty()) {
            out.print("Please enter a message.");
            return;
        }

        String botReply = BotLogic.getBotResponse(userMessage);
        out.print(botReply);
    }
}
