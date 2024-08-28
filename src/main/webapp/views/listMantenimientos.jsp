<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.netcodex.model.Mantenimiento" %>

<html>
<head>
    <title>Lista de Mantenimientos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Lista de Mantenimientos</h2>
    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Equipo ID</th>
            <th>Fecha de Mantenimiento</th>
            <th>Descripción</th>
            <th>Costo</th>
            <th>Acciones</th>
        </tr>
        <%
            List<Mantenimiento> mantenimientos = (List<Mantenimiento>) request.getAttribute("mantenimientos");
            for (Mantenimiento mantenimiento : mantenimientos) {
        %>
        <tr>
            <td><%= mantenimiento.getId() %></td>
            <td><%= mantenimiento.getEquipoId() %></td>
            <td><%= mantenimiento.getFechaMantenimiento() %></td>
            <td><%= mantenimiento.getDescripcion() %></td>
            <td><%= mantenimiento.getCosto() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/mantenimiento?action=edit&id=<%= mantenimiento.getId() %>" class="btn btn-sm btn-success">Editar</a>
                <a href="${pageContext.request.contextPath}/mantenimiento?action=delete&id=<%= mantenimiento.getId() %>" class="btn btn-sm btn-danger">Eliminar</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/views/addMantenimiento.jsp" class="btn btn-primary">Agregar Nuevo Mantenimiento</a>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
    </div>
</div>
</body>
</html>