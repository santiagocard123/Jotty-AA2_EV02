package com.netcodex.dao;

import com.netcodex.model.Equipo;
import com.netcodex.web.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private Connection getConnection() {
        return DBConnection.getConnection();
    }

    public void addEquipo(Equipo equipo) {
        String sql = "INSERT INTO Equipos (nombre, marca, modelo, estado, fecha_adquisicion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, equipo.getNombre());
                pstmt.setString(2, equipo.getMarca());
                pstmt.setString(3, equipo.getModelo());
                pstmt.setString(4, equipo.getEstado());
                pstmt.setDate(5, new java.sql.Date(equipo.getFechaAdquisicion().getTime()));
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Equipo> listEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM Equipos";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setId(rs.getInt("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setMarca(rs.getString("marca"));
                    equipo.setModelo(rs.getString("modelo"));
                    equipo.setEstado(rs.getString("estado"));
                    equipo.setFechaAdquisicion(rs.getDate("fecha_adquisicion"));
                    equipos.add(equipo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar equipos: " + e.getMessage());
            e.printStackTrace();
        }
        return equipos;
    }

    public void updateEquipo(Equipo equipo) {
        String sql = "UPDATE Equipos SET nombre = ?, marca = ?, modelo = ?, estado = ?, fecha_adquisicion = ? WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, equipo.getNombre());
                pstmt.setString(2, equipo.getMarca());
                pstmt.setString(3, equipo.getModelo());
                pstmt.setString(4, equipo.getEstado());
                pstmt.setDate(5, new java.sql.Date(equipo.getFechaAdquisicion().getTime()));
                pstmt.setInt(6, equipo.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteEquipo(int id) {
        String sql = "DELETE FROM Equipos WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar equipo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Equipo getEquipoById(int id) {
        Equipo equipo = null;
        String sql = "SELECT * FROM Equipos WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    equipo = new Equipo();
                    equipo.setId(rs.getInt("id"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setMarca(rs.getString("marca"));
                    equipo.setModelo(rs.getString("modelo"));
                    equipo.setEstado(rs.getString("estado"));
                    equipo.setFechaAdquisicion(rs.getDate("fecha_adquisicion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener equipo por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return equipo;
    }
}