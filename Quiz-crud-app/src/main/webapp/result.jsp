<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Quiz Result</h1>
    <p class="result-text">Well done, <strong>${playerName}</strong>!</p>
    <p class="score-text">You scored <strong>${score}</strong> out of <strong>${total}</strong>.</p>

    <a class="btn btn-add" href="start">Play Again</a>
    <a class="btn btn-edit" href="leaderboard">View Leaderboard</a>
</div>
</body>
</html>
