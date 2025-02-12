<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 12.02.2025
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Создание квеста</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-dark text-light text-center">
<div class="container mt-5">
  <h1 class="fw-bold">Создание квеста</h1>
  <hr class="bg-light">

  <form action="creatServlet" method="post" class="d-flex flex-column align-items-center gap-3">

    <!-- Первый вопрос -->
    <div class="card bg-secondary p-3 w-75">
      <h5>Вопрос 1</h5>
      <input type="text" name="questText1" class="form-control mb-2" placeholder="Введите текст вопроса" required>
      <input type="text" name="answer1_1" class="form-control mb-2" placeholder="Вариант ответа 1" required>
      <input type="text" name="answer1_2" class="form-control" placeholder="Вариант ответа 2" required>
    </div>

    <!-- Второй вопрос -->
    <div class="card bg-secondary p-3 w-75">
      <h5>Вопрос 2</h5>
      <input type="text" name="questText2" class="form-control mb-2" placeholder="Введите текст вопроса" required>
      <input type="text" name="answer2_1" class="form-control mb-2" placeholder="Вариант ответа 1" required>
      <input type="text" name="answer2_2" class="form-control" placeholder="Вариант ответа 2" required>
    </div>

    <!-- Третий вопрос -->
    <div class="card bg-secondary p-3 w-75">
      <h5>Вопрос 3</h5>
      <input type="text" name="questText3" class="form-control mb-2" placeholder="Введите текст вопроса" required>
      <input type="text" name="answer3_1" class="form-control mb-2" placeholder="Вариант ответа 1" required>
      <input type="text" name="answer3_2" class="form-control" placeholder="Вариант ответа 2" required>
    </div>

    <!-- Кнопка отправки -->
    <button type="submit" class="btn btn-primary btn-lg w-50">Добавить квест</button>
  </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

