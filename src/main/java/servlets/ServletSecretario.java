/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Secretario;

import logica.controladores.ControladorSecretario;
import logica.controladores.ControladorUsuario;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "ServletSecretario", urlPatterns = {"/ServletSecretario"})
public class ServletSecretario extends HttpServlet {

    ControladorUsuario controladorUsuario = new ControladorUsuario();
    ControladorSecretario controladorSecretario = new ControladorSecretario();

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
        System.out.println("Se entro en el get del servelt usuario");
        int id = Integer.parseInt(request.getParameter("idSecretario"));

        Secretario nuevoSecretario = controladorSecretario.obtenerSecretario(id);

        request.setAttribute("secretarioEditar", nuevoSecretario);

        request.getRequestDispatcher("editarSecretario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String accion = request.getParameter("accion");

        Secretario secretarioseleccionado = controladorSecretario.obtenerSecretario(Integer.parseInt(request.getParameter("idSecretario")));

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idSecretario"));
            try {
                controladorUsuario.eliminarUsuario(secretarioseleccionado.getUsuario().getIdUsuario());
                controladorSecretario.eliminarSecretario(id);
                System.out.println("Secrertario eliminado con exito");
                response.sendRedirect("CargarTablaSecretarios");

            } catch (Exception e) {
                System.out.println("Error al eliminar el Secretario.");
            }
        }

        if ("editar".equals(accion)) {

            //---------------------DATOS SECRETARIO
            String identificacionSecre = request.getParameter("txtIdentificacionSecre");
            String nombreSecre = request.getParameter("txtNombreSecre");
            String apellidoSecre = request.getParameter("txtApellidoSecre");
            String direccionSecre = request.getParameter("txtDireccionSecre");
            String celularSecre = request.getParameter("txtCelularSecre");
            Date fechaNacSecre = null;
            try {
                String fechaNacSecreTexto = request.getParameter("fechaNacSecre");
                fechaNacSecre = formatter.parse(fechaNacSecreTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sector = request.getParameter("txtSectorSecre");


            Secretario edicionSecretario = new Secretario(sector, secretarioseleccionado.getUsuario(), secretarioseleccionado.getIdPersona(), identificacionSecre, nombreSecre, apellidoSecre, direccionSecre, celularSecre, fechaNacSecre);
            try {

                controladorSecretario.editarSecretario(edicionSecretario);
                System.out.println("Secretario editado correctamente");
                response.sendRedirect("CargarTablaSecretarios");

            } catch (Exception e) {
                System.out.println("Error al editar el Secretario.");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
