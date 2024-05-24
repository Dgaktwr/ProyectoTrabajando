package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Db.DatabaseConnection;
import Model.Registro;

public class RegistroDao {

	public void insertarRegistro(Registro registro) {
		String sql = "INSERT INTO registro (ID_Documento, Fecha_Ingreso, Fecha_Salida) VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, registro.getIdDocumento());
			pstmt.setDate(2, registro.getFechaIngreso());
			pstmt.setDate(3, registro.getFechaSalida());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarRegistro(Registro registro) {
		String sql = "UPDATE registro SET Fecha_Ingreso=?, Fecha_Salida=? WHERE ID_Documento=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDate(1, registro.getFechaIngreso());
			pstmt.setDate(2, registro.getFechaSalida());
			pstmt.setInt(3, registro.getIdDocumento());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarRegistro(int idDocumento) {
		String sql = "DELETE FROM registro WHERE ID_Documento=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idDocumento);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Registro consultarRegistro(int idDocumento) {
		String sql = "SELECT * FROM registro WHERE ID_Documento=?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idDocumento);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Registro registro = new Registro();
				registro.setIdDocumento(rs.getInt("ID_Documento"));
				registro.setFechaIngreso(rs.getDate("Fecha_Ingreso"));
				registro.setFechaSalida(rs.getDate("Fecha_Salida"));
				return registro;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
