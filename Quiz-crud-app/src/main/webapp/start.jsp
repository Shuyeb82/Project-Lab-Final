<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Game</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Quiz Game</h1>
    <p class="subtitle">Test your knowledge on Crops, Geography &amp; Academic Institutions</p>

    <form action="registerPlayer" method="post">
        <label>Your Name:</label>
        <input type="text" name="name" required>

        <label>Choose a Category:</label>
        <select name="category" required>
            <option value="Crops">Crops</option>
            <option value="Geography">Geography</option>
            <option value="Academic Institutions">Academic Institutions</option>
        </select>

        <button type="submit" class="btn btn-add">Start Quiz</button>
    </form>

    <a class="btn btn-cancel" href="leaderboard" style="margin-top:16px; display:inline-block;">View Leaderboard</a>
</div>
</body>
</html>
