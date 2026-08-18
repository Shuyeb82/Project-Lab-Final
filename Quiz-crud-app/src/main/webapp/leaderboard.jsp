<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Leaderboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Leaderboard</h1>
    <a class="btn btn-add" href="start">+ Play Quiz</a>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Score</th>
            <th>Played At</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${players}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.category}</td>
                <td>${p.score} / ${p.totalQuestions}</td>
                <td>${p.playedAt}</td>
                <td>
                    <a class="btn btn-edit" href="editPlayer?id=${p.id}">Edit</a>
                    <a class="btn btn-delete" href="deletePlayer?id=${p.id}"
                       onclick="return confirm('Delete this player record?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
