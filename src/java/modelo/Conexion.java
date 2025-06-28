/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class Conexion {
	private static Connection conn;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "123";
	private static final String URL = "jdbc:mysql://localhost:3306/crud_cliente";
	public Conexion() {
		conn = null;
	}
	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if(conn != null) {
				System.out.println("Conexion establecida");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error de conexion" + e);
		}
		return conn;
	}
	public void desconectar() {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Conexion finalizada correctamente.");
			}
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión: " + e.getMessage());
		}
	}
}