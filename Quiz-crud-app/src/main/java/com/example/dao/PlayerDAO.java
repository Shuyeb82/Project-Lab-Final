package com.example.dao;

import com.example.model.Player;
import com.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    // CREATE - insert a new player and return the generated id
    public int insertPlayer(Player player) {
        String sql = "INSERT INTO players (name, category, score, total_questions) VALUES (?, ?, 0, 0)";
        int generatedId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, player.getName());
            ps.setString(2, player.getCategory());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedId = keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    // UPDATE - save score after quiz submission
    public boolean updateScore(int id, int score, int totalQuestions) {
        String sql = "UPDATE players SET score = ?, total_questions = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, score);
            ps.setInt(2, totalQuestions);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE - edit player's name/category (admin action)
    public boolean updatePlayerInfo(int id, String name, String category) {
        String sql = "UPDATE players SET name = ?, category = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, category);
            ps.setInt(3, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ - single player
    public Player getPlayerById(int id) {
        String sql = "SELECT id, name, category, score, total_questions, played_at FROM players WHERE id = ?";
        Player player = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    player = mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    // READ - leaderboard, highest score first
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT id, name, category, score, total_questions, played_at " +
                "FROM players ORDER BY score DESC, played_at ASC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                players.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    // DELETE
    public boolean deletePlayer(int id) {
        String sql = "DELETE FROM players WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Player mapRow(ResultSet rs) throws SQLException {
        return new Player(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("category"),
                rs.getInt("score"),
                rs.getInt("total_questions"),
                rs.getString("played_at")
        );
    }
}
