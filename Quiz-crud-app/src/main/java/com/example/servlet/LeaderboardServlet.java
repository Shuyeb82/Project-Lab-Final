package com.example.servlet;

import com.example.dao.PlayerDAO;
import com.example.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/leaderboard")
public class LeaderboardServlet extends HttpServlet {

    private final PlayerDAO playerDAO = new PlayerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Player> players = playerDAO.getAllPlayers();
        request.setAttribute("players", players);
        request.getRequestDispatcher("leaderboard.jsp").forward(request, response);
    }
}
