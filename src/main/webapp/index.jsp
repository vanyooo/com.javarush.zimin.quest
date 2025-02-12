<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 10.02.2025
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Квесты онлайн</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/styles.css">
</head>
<body class="bg-dark text-light">

<div class="container text-center mt-5">
  <h1 class="display-4 fw-bold">Квест начинается здесь</h1>
  <h2 class="mt-3">Тебе надо представиться</h2>
  <div class="mt-4 p-4 bg-secondary text-light rounded shadow-lg">
    <form action="quest.jsp" method="get" class="mt-3">
      <div class="input-group mb-3">
        <input type="text" name="userName" class="form-control" placeholder="Введите имя...">
        <button type="submit" class="btn btn-warning">Далее</button>
      </div>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>