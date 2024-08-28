<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.netcodex.model.Mantenimiento" %>

<html>
<head>
    <title>Editar Mantenimiento</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Editar Mantenimiento</h2>
    <form action="${pageContext.request.contextPath}/mantenimiento" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${mantenimiento.id}"/>

        <div class="mb-3">
            <label for="equipo_id" class="form-label">ID del Equipo:</label>
            <input type="number" name="equipo_id" id="equipo_id" class="form-control" value="${mantenimiento.equipoId}" required/>
        </div>

        <div class="mb-3">
            <label for="fecha_mantenimiento" class="form-label">Fecha de Mantenimiento:</label>
            <input type="date" name="fecha_mantenimiento" id="fecha_mantenimiento" class="form-control" value="${mantenimiento.fechaMantenimiento}" required/>
        </div>

        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción:</label>
            <textarea name="descripcion" id="descripcion" class="form-control" required>${mantenimiento.descripcion}</textarea>
        </div>

        <div class="mb-3">
            <label for="costo" class="form-label">Costo:</label>
            <input type="number" step="0.01" name="costo" id="costo" class="form-control" value="${mantenimiento.costo}" required/>
        </div>

        <button type="submit" class="btn btn-primary">Actualizar</button>
    </form>
    <a href="${pageContext.request.contextPath}/mantenimiento?action=list" class="btn btn-secondary">Volver a la lista</a>
</div>
</body>
</html>