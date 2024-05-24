package Dao;


import Model.Personal;
import Db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalDao {

    public void insertPersonal(Personal personal) {
        String query = "INSERT INTO personal (ID_Documento, Tipo_de_Identificacion, Nombre, Apellido, Direccion, Correo_Electronico, Telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, personal.getIdDocumento());
            stmt.setString(2, personal.getTipoIdentificacion());
            stmt.setString(3, personal.getNombre());
            stmt.setString(4, personal.getApellido());
            stmt.setString(5, personal.getDireccion());
            stmt.setString(6, personal.getCorreoElectronico());
            stmt.setString(7, personal.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personal> getAllPersonal() {
        List<Personal> personalList = new ArrayList<>();
        String query = "SELECT * FROM personal";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                personalList.add(new Personal(
                    rs.getInt("ID_Documento"),
                    rs.getString("Tipo_de_Identificacion"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("Direccion"),
                    rs.getString("Correo_Electronico"),
                    rs.getString("Telefono")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalList;
    }

    public void updatePersonal(Personal personal) {
        String query = "UPDATE personal SET Tipo_de_Identificacion = ?, Nombre = ?, Apellido = ?, Direccion = ?, Correo_Electronico = ?, Telefono = ? WHERE ID_Documento = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, personal.getTipoIdentificacion());
            stmt.setString(2, personal.getNombre());
            stmt.setString(3, personal.getApellido());
            stmt.setString(4, personal.getDireccion());
            stmt.setString(5, personal.getCorreoElectronico());
            stmt.setString(6, personal.getTelefono());
            stmt.setInt(7, personal.getIdDocumento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePersonal(int idDocumento) {
        String query = "DELETE FROM personal WHERE ID_Documento = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idDocumento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}