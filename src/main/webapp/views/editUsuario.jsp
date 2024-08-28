<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.netcodex.model.Usuario" %>

<html>
<head>
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Editar Usuario</h2>
    <form action="${pageContext.request.contextPath}/usuario" method="post">
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${usuario.id}"/>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" name="nombre" value="${usuario.nombre}" required class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" name="email" value="${usuario.email}" required class="form-control"/>
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono:</label>
            <input type="text" name="telefono" value="${usuario.telefono}" required class="form-control"/>
        </div>
        <input type="submit" value="Actualizar" class="btn btn-primary"/>
    </form>
    <a href="${pageContext.request.contextPath}/usuario?action=list" class="btn btn-secondary">Volver a la lista</a>
</div>
</body>
</html>