<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.netcodex.model.Equipo" %>

<html>
<head>
    <title>Lista de Equipos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Lista de Equipos</h2>
    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Estado</th>
            <th>Fecha de Adquisición</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
            for (Equipo equipo : equipos) {
        %>
        <tr>
            <td><%= equipo.getId() %></td>
            <td><%= equipo.getNombre() %></td>
            <td><%= equipo.getMarca() %></td>
            <td><%= equipo.getModelo() %></td>
            <td><%= equipo.getEstado() %></td>
            <td><%= equipo.getFechaAdquisicion() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/equipo?action=edit&id=<%= equipo.getId() %>" class="btn btn-sm btn-success">Editar</a>
                <a href="${pageContext.request.contextPath}/equipo?action=delete&id=<%= equipo.getId() %>" class="btn btn-sm btn-danger">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/views/addEquipo.jsp" class="btn btn-primary">Agregar Nuevo Equipo</a>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
    </div>
</div>
</body>
</html>