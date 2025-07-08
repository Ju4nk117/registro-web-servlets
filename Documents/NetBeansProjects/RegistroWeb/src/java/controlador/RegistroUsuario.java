package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/registro_usuarios", "root", "4nakin");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO usuario (nombre, correo, clave) VALUES (?, ?, ?)");

            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setString(3, clave);

            int result = ps.executeUpdate();

            con.close();

            // Redirige a JSP para mostrar mensaje
            request.setAttribute("nombre", nombre);
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el servidor");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si accede por GET, redirige al formulario
        response.sendRedirect("index.html");
    }
}

