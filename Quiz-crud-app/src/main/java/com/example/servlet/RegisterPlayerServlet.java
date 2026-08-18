package com.example.servlet;

import com.example.dao.PlayerDAO;
import com.example.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerPlayer")
public class RegisterPlayerServlet extends HttpServlet {

    private final PlayerDAO playerDAO = new PlayerDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");

        Player player = new Player(name, category);
        int playerId = playerDAO.insertPlayer(player);

        HttpSession session = request.getSession();
        session.setAttribute("playerId", playerId);
        session.setAttribute("playerName", name);
        session.setAttribute("category", category);

        response.sendRedirect("quiz");
    }
}
