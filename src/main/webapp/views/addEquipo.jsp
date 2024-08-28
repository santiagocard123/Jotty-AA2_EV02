<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Agregar Equipo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Agregar Equipo</h2>
    <form action="${pageContext.request.contextPath}/equipo" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="action" value="add"/>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" name="nombre" required class="form-control" id="nombre" placeholder="Ingrese el nombre del equipo">
            <div class="invalid-feedback">Por favor, ingrese el nombre del equipo.</div>
        </div>
        <div class="mb-3">
            <label for="marca" class="form-label">Marca:</label>
            <input type="text" name="marca" required class="form-control" id="marca" placeholder="Ingrese la marca del equipo">
            <div class="invalid-feedback">Por favor, ingrese la marca del equipo.</div>
        </div>
        <div class="mb-3">
            <label for="modelo" class="form-label">Modelo:</label>
            <input type="text" name="modelo" required class="form-control" id="modelo" placeholder="Ingrese el modelo del equipo">
            <div class="invalid-feedback">Por favor, ingrese el modelo del equipo.</div>
        </div>
        <div class="mb-3">
            <label for="estado" class="form-label">Estado:</label>
            <input type="text" name="estado" required class="form-control" id="estado" placeholder="Ingrese el estado del equipo">
            <div class="invalid-feedback">Por favor, ingrese el estado del equipo.</div>
        </div>
        <div class="mb-3">
            <label for="fecha_adquisicion" class="form-label">Fecha de Adquisición:</label>
            <input type="date" name="fecha_adquisicion" required class="form-control" id="fecha_adquisicion" placeholder="Ingrese la fecha de adquisición">
            <div class="invalid-feedback">Por favor, ingrese la fecha de adquisición.</div>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
    </form>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/equipo?action=list" class="btn btn-secondary">Volver a la lista</a>
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