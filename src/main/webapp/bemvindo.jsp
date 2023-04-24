<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) { %>
<form action="logout" method="post">
  <input type="submit" value="Logout">
</form>
<% } %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Bem-vindo</title>
</head>
<body>
<h1>Bem-vindo</h1>
<p>Você fez login com sucesso.</p>
</body>
</html>
