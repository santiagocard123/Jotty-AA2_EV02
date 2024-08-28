<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.netcodex.model.Equipo" %>

<html>
<head>
    <title>Editar Equipo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Editar Equipo</h2>
    <form action="${pageContext.request.contextPath}/equipo" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${equipo.id}"/>

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" name="nombre" id="nombre" class="form-control" value="${equipo.nombre}" required/>
        </div>

        <div class="mb-3">
            <label for="marca" class="form-label">Marca:</label>
            <input type="text" name="marca" id="marca" class="form-control" value="${equipo.marca}" required/>
        </div>

        <div class="mb-3">
            <label for="modelo" class="form-label">Modelo:</label>
            <input type="text" name="modelo" id="modelo" class="form-control" value="${equipo.modelo}" required/>
        </div>

        <div class="mb-3">
            <label for="estado" class="form-label">Estado:</label>
            <input type="text" name="estado" id="estado" class="form-control" value="${equipo.estado}" required/>
        </div>

        <div class="mb-3">
            <label for="fecha_adquisicion" class="form-label">Fecha de Adquisición:</label>
            <input type="date" name="fecha_adquisicion" id="fecha_adquisicion" class="form-control" value="${equipo.fechaAdquisicion}" required/>
        </div>

        <button type="submit" class="btn btn-primary">Actualizar</button>
    </form>
    <a href="${pageContext.request.contextPath}/equipo?action=list" class="btn btn-secondary">Volver a la lista</a>
</div>
</body>
</html>