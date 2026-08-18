package com.example.servlet;

import com.example.dao.PlayerDAO;
import com.example.dao.QuestionDAO;
import com.example.model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/submitQuiz")
public class SubmitQuizServlet extends HttpServlet {

    private final QuestionDAO questionDAO = new QuestionDAO();
    private final PlayerDAO playerDAO = new PlayerDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String category = (String) session.getAttribute("category");
        Object playerIdObj = session.getAttribute("playerId");

        if (category == null || playerIdObj == null) {
            response.sendRedirect("start");
            return;
        }

        int playerId = (int) playerIdObj;
        List<Question> questions = questionDAO.getQuestionsByCategory(category);

        int score = 0;
        for (Question q : questions) {
            String submitted = request.getParameter("q_" + q.getId());
            if (submitted != null && submitted.equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }
        int total = questions.size();

        playerDAO.updateScore(playerId, score, total);

        request.setAttribute("score", score);
        request.setAttribute("total", total);
        request.setAttribute("playerName", session.getAttribute("playerName"));
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
