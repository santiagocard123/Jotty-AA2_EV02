<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Netcodex Technology</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f0f0f0;
    }
    header {
      background-color: #03ef84;
      color: white;
      padding: 20px;
      text-align: center;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    nav {
      background-color: #343a40;
      overflow: hidden;
    }
    nav a {
      float: left;
      display: block;
      color: white;
      text-align: center;
      padding: 15px 20px;
      text-decoration: none;
      font-weight: 500;
    }
    nav a:hover {
      background-color: #495057;
      color: #ffffff;
    }
    h1, h2 {
      margin: 0;
    }
    h1 {
      font-size: 2.5rem;
      margin-bottom: 10px;
    }
    h2 {
      font-size: 1.75rem;
      margin-top: 0;
    }
    .container {
      padding: 20px;
      max-width: 1200px;
      margin: 0 auto;
      text-align: center;
    }
    .container img {
      width: 300px;
      height: auto;
      margin-bottom: 10px;
      animation: spin 10s linear infinite;
    }
    @keyframes spin {
      0% { transform: rotate(0deg); }
      100% { transform: rotate(360deg); }
    }
    footer {
      background-color: #343a40;
      color: white;
      text-align: center;
      padding: 10px;
      position: fixed;
      width: 100%;
      bottom: 0;
      box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
    }
    .footer-content {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 1rem;
    }
    .footer-content p {
      margin: 0;
    }
    .social-icons a {
      color: white;
      text-decoration: none;
      margin: 0 0.5rem;
      font-size: 1.5rem;
    }
    .social-icons a:hover {
      color: #06ed16;
    }
  </style>
</head>
<body>
<header>
  <h1>Netcodex Technology</h1>
</header>
<nav>
  <a href="equipo?action=list">Equipos</a>
  <a href="mantenimiento?action=list">Mantenimientos</a>
  <a href="usuario?action=list">Usuarios</a>
  <a href="views/addEquipo.jsp">Agregar Equipo</a>
  <a href="views/addMantenimiento.jsp">Agregar Mantenimiento</a>
  <a href="views/addUsuario.jsp">Agregar Usuario</a>
</nav>
<div class="container">
  <img src="img/Netcodex.png" alt="Netcodex Logo">
  <h2>Bienvenido a la aplicacion de mantenimiento de equipos</h2>
  <p>Utiliza la barra de navegacion para acceder a las diferentes secciones de la aplicacion.</p>
</div>
<footer>
  <div class="footer-content">
    <p>Santiago Cardenas Jotty &copy; 2024</p>
    <div class="social-icons">
      <a href="https://wa.me/yourwhatsapplink" target="_blank" title="WhatsApp"><i class="fab fa-whatsapp"></i></a>
      <a href="https://www.instagram.com/yourinstagram" target="_blank" title="Instagram"><i class="fab fa-instagram"></i></a>
      <a href="https://www.linkedin.com/in/yourlinkedin" target="_blank" title="LinkedIn"><i class="fab fa-linkedin"></i></a>
    </div>
  </div>
</footer>
</body>
</html>
