package com.example.model;

public class Player {

    private int id;
    private String name;
    private String category;
    private int score;
    private int totalQuestions;
    private String playedAt;

    public Player() {
    }

    public Player(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Player(int id, String name, String category, int score, int totalQuestions, String playedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.playedAt = playedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getPlayedAt() {
        return playedAt;
    }

    public void setPlayedAt(String playedAt) {
        this.playedAt = playedAt;
    }
}
