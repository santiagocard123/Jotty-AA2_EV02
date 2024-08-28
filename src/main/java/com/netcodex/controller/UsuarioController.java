package com.netcodex.controller;

import com.netcodex.dao.UsuarioDAO;
import com.netcodex.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsuarioController", value = "/usuario")
public class UsuarioController extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<Usuario> usuarios = usuarioDAO.listUsuarios();
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("views/listUsuarios.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = usuarioDAO.getUsuarioById(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("views/editUsuario.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            usuarioDAO.deleteUsuario(id);
            response.sendRedirect("usuario?action=list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Usuario usuario = new Usuario();
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuarioDAO.addUsuario(usuario);
            response.sendRedirect("usuario?action=list");
        } else if ("update".equals(action)) {
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("id")));
            usuario.setNombre(request.getParameter("nombre"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setTelefono(request.getParameter("telefono"));
            usuarioDAO.updateUsuario(usuario);
            response.sendRedirect("usuario?action=list");
        }
    }
}
