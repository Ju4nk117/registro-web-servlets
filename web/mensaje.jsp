<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registro exitoso</title>
</head>
<body>
    <h2>¡Registro exitoso!</h2>
    <p>Bienvenido, <strong><%= request.getAttribute("nombre") %></strong></p>
    <a href="index.html">Volver al formulario</a>
</body>
</html>
