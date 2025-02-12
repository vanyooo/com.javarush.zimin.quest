<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 10.02.2025
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Answer" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Квесты онлайн</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="bg-dark text-light">
<div class="bg-secondary bg-opacity-50 text-dark p-4 rounded shadow-sm mx-auto" style="max-width: 90%;">
    <h1 class="fw-bold text-center">Путь домой</h1>
    <hr class="bg-light">
    <h2>
    </h2>
    <p class="fs-4 fw-semibold text-center" style="font-weight: bold; color: white; text-shadow: 2px 2px 5px black;">
        <%=request.getAttribute("text")%>
    </p>
    <%
        Answer answerOne = (Answer) request.getAttribute("answer1");
        Answer answerTwo = (Answer) request.getAttribute("answer2");
        session.getAttribute("questNumber");
    %>
    <div class="mt-4 d-flex justify-content-center gap-4">
        <form action="gameServlet" method="post">
            <input type="hidden" name="answerId" value=<%=answerOne.getId()%>>
            <button type="submit"
                    class="btn btn-primary btn-lg px-5"><%=((Answer) request.getAttribute("answer1")).getText()%>
            </button>
        </form>
        <form action="gameServlet" method="post">
            <input type="hidden" name="answerId" value=<%=answerTwo.getId()%>>
            <button type="submit"
                    class="btn btn-danger btn-lg px-5"><%=((Answer) request.getAttribute("answer2")).getText()%>
            </button>
        </form>
    </div>
    <div class="alert alert-info fixed-bottom start-0 m-3 shadow-lg" style="max-width: 400px;">
        <strong>Имя игрока:</strong> <%= session.getAttribute("userName")%> <br>
        <strong>Количество игр:</strong> <%= session.getAttribute("counter")%>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
