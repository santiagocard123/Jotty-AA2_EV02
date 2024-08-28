package com.netcodex.controller;

import com.netcodex.dao.MantenimientoDAO;
import com.netcodex.model.Mantenimiento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MantenimientoController", value = "/mantenimiento")
public class MantenimientoController extends HttpServlet {
    private MantenimientoDAO mantenimientoDAO = new MantenimientoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Mantenimiento> mantenimientos = mantenimientoDAO.listMantenimientos();
            request.setAttribute("mantenimientos", mantenimientos);
            request.getRequestDispatcher("views/listMantenimientos.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Mantenimiento mantenimiento = mantenimientoDAO.getMantenimientoById(id);
            request.setAttribute("mantenimiento", mantenimiento);
            request.getRequestDispatcher("views/editMantenimiento.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            mantenimientoDAO.deleteMantenimiento(id);
            response.sendRedirect("mantenimiento?action=list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            Mantenimiento mantenimiento = new Mantenimiento();
            mantenimiento.setEquipoId(Integer.parseInt(request.getParameter("equipo_id")));
            mantenimiento.setFechaMantenimiento(java.sql.Date.valueOf(request.getParameter("fecha_mantenimiento")));
            mantenimiento.setDescripcion(request.getParameter("descripcion"));
            mantenimiento.setCosto(Double.parseDouble(request.getParameter("costo")));
            mantenimientoDAO.addMantenimiento(mantenimiento);
            response.sendRedirect("mantenimiento?action=list");
        } else if ("update".equals(action)) {
            Mantenimiento mantenimiento = new Mantenimiento();
            mantenimiento.setId(Integer.parseInt(request.getParameter("id")));
            mantenimiento.setEquipoId(Integer.parseInt(request.getParameter("equipo_id")));
            mantenimiento.setFechaMantenimiento(java.sql.Date.valueOf(request.getParameter("fecha_mantenimiento")));
            mantenimiento.setDescripcion(request.getParameter("descripcion"));
            mantenimiento.setCosto(Double.parseDouble(request.getParameter("costo")));
            mantenimientoDAO.updateMantenimiento(mantenimiento);
            response.sendRedirect("mantenimiento?action=list");
        }
    }
}