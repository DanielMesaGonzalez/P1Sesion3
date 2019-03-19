<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h1>REGISTRO</h1>
<form action="http://localhost:8080/Practica1_Sesion3/SegundoServlet" method=post>
Nombre: <input type=text name=username>
Email: <input type=text name=email>
Dirección: <input type=text name=home>
<input type=submit value=Send>
</form>
</body>
</html>