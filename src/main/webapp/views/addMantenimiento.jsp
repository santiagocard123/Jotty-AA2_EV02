<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Agregar Mantenimiento</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">Agregar Mantenimiento</h2>
    <form action="${pageContext.request.contextPath}/mantenimiento" method="post" class="needs-validation" novalidate>
        <input type="hidden" name="action" value="add"/>
        <div class="mb-3">
            <label for="equipo_id" class="form-label">ID del Equipo:</label>
            <input type="number" name="equipo_id" required class="form-control" id="equipo_id" placeholder="Ingrese el ID del equipo">
            <div class="invalid-feedback">Por favor, ingrese el ID del equipo.</div>
        </div>
        <div class="mb-3">
            <label for="fecha_mantenimiento" class="form-label">Fecha de Mantenimiento:</label>
            <input type="date" name="fecha_mantenimiento" required class="form-control" id="fecha_mantenimiento" placeholder="Ingrese la fecha de mantenimiento">
            <div class="invalid-feedback">Por favor, ingrese la fecha de mantenimiento.</div>
        </div>
        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción:</label>
            <textarea name="descripcion" required class="form-control" id="descripcion" placeholder="Ingrese la descripción del mantenimiento"></textarea>
            <div class="invalid-feedback">Por favor, ingrese la descripción del mantenimiento.</div>
        </div>
        <div class="mb-3">
            <label for="costo" class="form-label">Costo:</label>
            <input type="number" step="0.01" name="costo" required class="form-control" id="costo" placeholder="Ingrese el costo del mantenimiento">
            <div class="invalid-feedback">Por favor, ingrese el costo del mantenimiento.</div>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
    </form>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/mantenimiento?action=list" class="btn btn-secondary">Volver a la lista</a>
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