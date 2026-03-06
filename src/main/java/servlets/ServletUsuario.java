/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Usuario;
import logica.controladores.ControladorUsuario;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

    ControladorUsuario controladorUsuario = new ControladorUsuario();

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

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         int id = Integer.parseInt(request.getParameter("idUsuario"));
            
        

        Usuario nuevoUsuario = controladorUsuario.obtenerUsuario(id);
        
        
        request.setAttribute("usuarioEditar", nuevoUsuario);
        
        request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("txtUsuario");
        String contrasena = request.getParameter("txtContrasena");
        String rol = request.getParameter("txtRol");
        String accion = request.getParameter("accion");
        
        

        Usuario nuevoUsuario = new Usuario(0, usuario, contrasena, rol);

        if ("crear".equals(accion)) {
            try {
                controladorUsuario.crearUsuario(nuevoUsuario);
                response.sendRedirect("CargarTablaUsuarios");
                System.out.println("Usuario creado.");

            } catch (Exception e) {
                System.out.println("Error al crear el usuario.");
            }
        }
        
        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            try {
                controladorUsuario.eliminarUsuario(id);
                System.out.println("Usuario eliminado correctamente");
                response.sendRedirect("CargarTablaUsuarios");

        
            } catch (Exception e) {
                System.out.println("Error al eliminar el usuario.");
            }
        }
        
        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idUsuario"));
            nuevoUsuario.setIdUsuario(id);
            nuevoUsuario.setContrasenia(controladorUsuario.obtenerUsuario(id).getContrasenia());
            try {
                controladorUsuario.editarUsuario(nuevoUsuario);
                System.out.println("Usuario eliminado correctamente");
                response.sendRedirect("CargarTablaUsuarios");

        
            } catch (Exception e) {
                System.out.println("Error al eliminar el usuario.");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
