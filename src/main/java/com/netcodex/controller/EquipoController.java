package com.netcodex.controller;

import com.netcodex.dao.EquipoDAO;
import com.netcodex.model.Equipo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EquipoController", value = "/equipo")
public class EquipoController extends HttpServlet {
    private EquipoDAO equipoDAO = new EquipoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Equipo> equipos = equipoDAO.listEquipos();
            request.setAttribute("equipos", equipos);
            request.getRequestDispatcher("views/listEquipos.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Equipo equipo = equipoDAO.getEquipoById(id);
            request.setAttribute("equipo", equipo);
            request.getRequestDispatcher("views/editEquipo.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            equipoDAO.deleteEquipo(id);
            response.sendRedirect("equipo?action=list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            Equipo equipo = new Equipo();
            equipo.setNombre(request.getParameter("nombre"));
            equipo.setMarca(request.getParameter("marca"));
            equipo.setModelo(request.getParameter("modelo"));
            equipo.setEstado(request.getParameter("estado"));
            equipo.setFechaAdquisicion(java.sql.Date.valueOf(request.getParameter("fecha_adquisicion")));
            equipoDAO.addEquipo(equipo);
            response.sendRedirect("equipo?action=list");
        } else if ("update".equals(action)) {
            Equipo equipo = new Equipo();
            equipo.setId(Integer.parseInt(request.getParameter("id")));
            equipo.setNombre(request.getParameter("nombre"));
            equipo.setMarca(request.getParameter("marca"));
            equipo.setModelo(request.getParameter("modelo"));
            equipo.setEstado(request.getParameter("estado"));
            equipo.setFechaAdquisicion(java.sql.Date.valueOf(request.getParameter("fecha_adquisicion")));
            equipoDAO.updateEquipo(equipo);
            response.sendRedirect("equipo?action=list");
        }
    }
}