<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Agregar Usuario</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Agregar Usuario</h2>
    <form action="${pageContext.request.contextPath}/usuario" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="action" value="add"/>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" name="nombre" required class="form-control" id="nombre" placeholder="Ingrese el nombre del usuario">
            <div class="invalid-feedback">Por favor, ingrese el nombre del usuario.</div>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" name="email" required class="form-control" id="email" placeholder="Ingrese el email del usuario">
            <div class="invalid-feedback">Por favor, ingrese el email del usuario.</div>
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono:</label>
            <input type="text" name="telefono" required class="form-control" id="telefono" placeholder="Ingrese el teléfono del usuario">
            <div class="invalid-feedback">Por favor, ingrese el teléfono del usuario.</div>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
    </form>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/usuario?action=list" class="btn btn-secondary">Volver a la lista</a>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary">Volver a la Página Principal</a>
    </div>
</div>

<script>
    (function () {
        'use strict'

        var forms = document.querySelectorAll('.needs-validation')

        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>
</html>