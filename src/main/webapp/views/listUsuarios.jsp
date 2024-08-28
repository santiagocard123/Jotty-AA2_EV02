<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.netcodex.model.Usuario" %>

<html>
<head>
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Lista de Usuarios</h2>
    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Teléfono</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            for (Usuario usuario : usuarios) {
        %>
        <tr>
            <td><%= usuario.getId() %></td>
            <td><%= usuario.getNombre() %></td>
            <td><%= usuario.getEmail() %></td>
            <td><%= usuario.getTelefono() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/usuario?action=edit&id=<%= usuario.getId() %>" class="btn btn-sm btn-success">Editar</a>
                <a href="${pageContext.request.contextPath}/usuario?action=delete&id=<%= usuario.getId() %>" class="btn btn-sm btn-danger">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/views/addUsuario.jsp" class="btn btn-primary">Agregar Nuevo Usuario</a>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
    </div>
</div>
</body>
</html>