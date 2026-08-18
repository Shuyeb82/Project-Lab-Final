package com.example.servlet;

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

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    private final QuestionDAO questionDAO = new QuestionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String category = (String) session.getAttribute("category");

        if (category == null) {
            response.sendRedirect("start");
            return;
        }

        List<Question> questions = questionDAO.getQuestionsByCategory(category);
        request.setAttribute("questions", questions);
        request.setAttribute("category", category);
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}
