package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Db.DatabaseConnection;
import Model.Personal;

public class PersonalDao {

    public void insertarPersonal(Personal personal) {
        String sql = "INSERT INTO personal (ID_Documento, Tipo_de_Identificacion, Nombre, Apellido, Direccion, Correo_Electronico, Telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, personal.getIdDocumento());
            pstmt.setString(2, personal.getTipoIdentificacion());
            pstmt.setString(3, personal.getNombre());
            pstmt.setString(4, personal.getApellido());
            pstmt.setString(5, personal.getDireccion());
            pstmt.setString(6, personal.getCorreoElectronico());
            pstmt.setString(7, personal.getTelefono());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersonal(Personal personal) {
        String sql = "UPDATE personal SET Tipo_de_Identificacion=?, Nombre=?, Apellido=?, Direccion=?, Correo_Electronico=?, Telefono=? WHERE ID_Documento=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, personal.getTipoIdentificacion());
            pstmt.setString(2, personal.getNombre());
            pstmt.setString(3, personal.getApellido());
            pstmt.setString(4, personal.getDireccion());
            pstmt.setString(5, personal.getCorreoElectronico());
            pstmt.setString(6, personal.getTelefono());
            pstmt.setInt(7, personal.getIdDocumento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersonal(int idDocumento) {
        String sql = "DELETE FROM personal WHERE ID_Documento=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDocumento);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Personal consultarPersonal(int idDocumento) {
        String sql = "SELECT * FROM personal WHERE ID_Documento=?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idDocumento);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Personal personal = new Personal();
                personal.setIdDocumento(rs.getInt("ID_Documento"));
                personal.setTipoIdentificacion(rs.getString("Tipo_de_Identificacion"));
                personal.setNombre(rs.getString("Nombre"));
                personal.setApellido(rs.getString("Apellido"));
                personal.setDireccion(rs.getString("Direccion"));
                personal.setCorreoElectronico(rs.getString("Correo_Electronico"));
                personal.setTelefono(rs.getString("Telefono"));
                return personal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
