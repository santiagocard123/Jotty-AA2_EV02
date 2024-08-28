package com.netcodex.dao;

import com.netcodex.model.Mantenimiento;
import com.netcodex.web.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MantenimientoDAO {
    private Connection getConnection() {
        return DBConnection.getConnection();
    }

    public void addMantenimiento(Mantenimiento mantenimiento) {
        String sql = "INSERT INTO Mantenimientos (equipo_id, fecha_mantenimiento, descripcion, costo) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, mantenimiento.getEquipoId());
                pstmt.setDate(2, new java.sql.Date(mantenimiento.getFechaMantenimiento().getTime()));
                pstmt.setString(3, mantenimiento.getDescripcion());
                pstmt.setDouble(4, mantenimiento.getCosto());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar mantenimiento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Mantenimiento> listMantenimientos() {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        String sql = "SELECT * FROM Mantenimientos";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Mantenimiento mantenimiento = new Mantenimiento();
                    mantenimiento.setId(rs.getInt("id"));
                    mantenimiento.setEquipoId(rs.getInt("equipo_id"));
                    mantenimiento.setFechaMantenimiento(rs.getDate("fecha_mantenimiento"));
                    mantenimiento.setDescripcion(rs.getString("descripcion"));
                    mantenimiento.setCosto(rs.getDouble("costo"));
                    mantenimientos.add(mantenimiento);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar mantenimientos: " + e.getMessage());
            e.printStackTrace();
        }
        return mantenimientos;
    }

    public void updateMantenimiento(Mantenimiento mantenimiento) {
        String sql = "UPDATE Mantenimientos SET equipo_id = ?, fecha_mantenimiento = ?, descripcion = ?, costo = ? WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, mantenimiento.getEquipoId());
                pstmt.setDate(2, new java.sql.Date(mantenimiento.getFechaMantenimiento().getTime()));
                pstmt.setString(3, mantenimiento.getDescripcion());
                pstmt.setDouble(4, mantenimiento.getCosto());
                pstmt.setInt(5, mantenimiento.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar mantenimiento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteMantenimiento(int id) {
        String sql = "DELETE FROM Mantenimientos WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar mantenimiento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Mantenimiento getMantenimientoById(int id) {
        Mantenimiento mantenimiento = null;
        String sql = "SELECT * FROM Mantenimientos WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    mantenimiento = new Mantenimiento();
                    mantenimiento.setId(rs.getInt("id"));
                    mantenimiento.setEquipoId(rs.getInt("equipo_id"));
                    mantenimiento.setFechaMantenimiento(rs.getDate("fecha_mantenimiento"));
                    mantenimiento.setDescripcion(rs.getString("descripcion"));
                    mantenimiento.setCosto(rs.getDouble("costo"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener mantenimiento por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return mantenimiento;
    }
}