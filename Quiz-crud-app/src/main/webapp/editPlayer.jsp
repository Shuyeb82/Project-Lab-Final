<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Player</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Edit Player</h1>
    <form action="updatePlayer" method="post">
        <input type="hidden" name="id" value="${player.id}">

        <label>Name:</label>
        <input type="text" name="name" value="${player.name}" required>

        <label>Category:</label>
        <select name="category" required>
            <option value="Crops" ${player.category == 'Crops' ? 'selected' : ''}>Crops</option>
            <option value="Geography" ${player.category == 'Geography' ? 'selected' : ''}>Geography</option>
            <option value="Academic Institutions" ${player.category == 'Academic Institutions' ? 'selected' : ''}>Academic Institutions</option>
        </select>

        <button type="submit" class="btn btn-edit">Update Player</button>
        <a class="btn btn-cancel" href="leaderboard">Cancel</a>
    </form>
</div>
</body>
</html>
