package com.netcodex.dao;

import com.netcodex.model.Usuario;
import com.netcodex.web.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection getConnection() {
        return DBConnection.getConnection();
    }

    public void addUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nombre, email, telefono) VALUES (?, ?, ?)";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, usuario.getNombre());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getTelefono());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Usuario> listUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }

    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, usuario.getNombre());
                pstmt.setString(2, usuario.getEmail());
                pstmt.setString(3, usuario.getTelefono());
                pstmt.setInt(4, usuario.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int id) {
        String sql = "DELETE FROM Usuarios WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioById(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuarios WHERE id = ?";
        try (Connection conn = getConnection()) {
            if (conn == null) {
                throw new RuntimeException("No se pudo establecer la conexión a la base de datos");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setTelefono(rs.getString("telefono"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }
}