<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set, java.util.HashSet" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro Cliente</title>
    <style>
        body {
            font-family: Arial;
            padding: 20px;
        }
        form {
            max-width: 400px;
        }
        input, select {
            width: 100%;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Formulario de Registro</h1>
    <form action="RecibeDatos" method="post">

        Tipo Documento:
        <select name="tipodocumento" required>
            <%
                List<String> tipos = (List<String>) request.getAttribute("tiposDocumento");
                if (tipos != null && !tipos.isEmpty()) {
                    Set<String> sinDuplicados = new HashSet<>(tipos); // elimina duplicados
                    for (String tipo : sinDuplicados) {
            %>
                        <option value="<%= tipo %>"><%= tipo %></option>
            <%
                    }
                } else {
            %>
                    <option disabled>No hay documentos</option>
            <%
                }
            %>
        </select>
        
        Documento:
        <input type="text" name="documento" required>

        Nombre:
        <input type="text" name="nombres" required>

        Apellidos:
        <input type="text" name="apellidos" required>

        Género:
        <select name="genero" required>
            <%
                List<String> generos = (List<String>) request.getAttribute("generos");
                if (generos != null && !generos.isEmpty()) {
                    Set<String> sinDuplicados = new HashSet<>(generos); // elimina duplicados
                    for (String genero : sinDuplicados) {
            %>
                        <option value="<%= genero %>"><%= genero %></option>
            <%
                    }
                } else {
            %>
                    <option disabled>No hay géneros</option>
            <%
                }
            %>
        </select>


        Fecha Nacimiento:
        <input type="date" name="fecha_nacimiento" required>

        Email:
        <input type="email" name="email" required>

        Contraseña:
        <input type="password" name="password" required>

        Teléfono:
        <input type="text" name="telefono" required>

        Ciudad:
        <input type="text" name="ciudad" required>

        Barrio:
        <input type="text" name="barrio" required>

        Dirección:
        <input type="text" name="direccion" required>

        <input type="submit" value="Registrar">
    </form>
</body>
</html>
