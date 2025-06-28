/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import modelo.Conexion;

/**
 *
 * @author USER
 */
@WebServlet("/RecibeDatos")
public class RecibeDatosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecibeDatosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecibeDatosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        String tipodocumento = request.getParameter("tipodocumento");
        String documento = request.getParameter("documento");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String ciudad = request.getParameter("ciudad");
        String barrio = request.getParameter("barrio");
        String direccion = request.getParameter("direccion");

        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        try {
            // Crear consulta para insertar el cliente
            String sql = "INSERT INTO clientes (Tipo_Doc, doc, nombres, apellidos, Genero, fec_nacimiento, email, password, telefono, ciudad, barrio, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, tipodocumento);
            ps.setString(2, documento);
            ps.setString(3, nombres);
            ps.setString(4, apellidos);
            ps.setString(5, genero);         
            ps.setString(6, fechaNacimiento);
            ps.setString(7, email);
            ps.setString(8, password); // Puedes encriptar aquí si lo deseas
            ps.setString(9, telefono);
            ps.setString(10, ciudad);
            ps.setString(11, barrio);
            ps.setString(12, direccion);

            int resultado = ps.executeUpdate();

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                if (resultado > 0) {
                    out.println("<h2>✅ Cliente registrado exitosamente.</h2>");
                } else {
                    out.println("<h2>❌ Error al registrar el cliente.</h2>");
                }
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            conexion.desconectar();
        }
    }
}
