<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 12.02.2025
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Выбор квеста</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<%
    String userName = request.getParameter("userName");
%>
<body class="bg-dark text-light text-center">
<div class="container mt-5">
    <h1 class="fw-bold">Выберите квест</h1>
    <hr class="bg-light">

    <div class="d-flex flex-column align-items-center gap-3">
        <!-- Кнопка для выбора квеста 1 -->
        <form action="gameServlet" method="get">
            <input type="hidden" name="userName" value="<%= userName %>">
            <input type="hidden" name="quest" value="1">
            <button type="submit" class="btn btn-primary btn-lg">Выбрать квест 1</button>
        </form>

        <!-- Кнопка для выбора квеста 2 -->
        <form action="gameServlet" method="get">
            <input type="hidden" name="userName" value="<%= userName %>">
            <input type="hidden" name="quest" value="2">
            <button type="submit" class="btn btn-success btn-lg">Выбрать квест 2</button>
        </form>

        <!-- Кнопка для создания своего квеста -->
        <form action="createQuest.jsp" method="get">
            <input type="hidden" name="userName" value="<%= userName %>">
            <button type="submit" class="btn btn-warning btn-lg">Сделать свой квест</button>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

