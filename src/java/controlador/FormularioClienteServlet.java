/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Conexion;
/**
 *
 * @author USER
 */
@WebServlet("/FormularioCliente")
public class FormularioClienteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		try {
			List < String > tiposDoc = new ArrayList < > ();
			List < String > generos = new ArrayList < > ();
			// Primer query
			PreparedStatement ps1 = con.prepareStatement("SELECT descripcion_tipodocumento FROM tipodocumento");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				tiposDoc.add(rs1.getString(1));
			}
			rs1.close();
			ps1.close();
			// Segundo query
			PreparedStatement ps2 = con.prepareStatement("SELECT descripcion_genero FROM genero");
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				generos.add(rs2.getString(1));
			}
			rs2.close();
			ps2.close();
			request.setAttribute("tiposDocumento", tiposDoc);
			request.setAttribute("generos", generos);
			RequestDispatcher rd = request.getRequestDispatcher("registroCliente.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("Error: " + e.getMessage());
		} finally {
			conexion.desconectar();
		}
	}
}