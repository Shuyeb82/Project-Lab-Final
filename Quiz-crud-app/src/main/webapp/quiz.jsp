<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz - ${category}</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>${category} Quiz</h1>

    <form action="submitQuiz" method="post">
        <c:forEach var="q" items="${questions}" varStatus="status">
            <div class="question">
                <p class="question-text">${status.index + 1}. ${q.questionText}</p>

                <label class="option"><input type="radio" name="q_${q.id}" value="A" required> ${q.optionA}</label>
                <label class="option"><input type="radio" name="q_${q.id}" value="B"> ${q.optionB}</label>
                <label class="option"><input type="radio" name="q_${q.id}" value="C"> ${q.optionC}</label>
                <label class="option"><input type="radio" name="q_${q.id}" value="D"> ${q.optionD}</label>
            </div>
        </c:forEach>

        <button type="submit" class="btn btn-add">Submit Quiz</button>
    </form>
</div>
</body>
</html>
