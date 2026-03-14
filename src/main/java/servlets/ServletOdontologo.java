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
import javax.swing.text.DateFormatter;
import logica.Horario;
import logica.Odontologo;
import logica.Secretario;
import logica.Usuario;
import logica.controladores.ControladorHorario;
import logica.controladores.ControladorOdontologo;
import logica.controladores.ControladorSecretario;
import logica.controladores.ControladorUsuario;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "ServletOdontologo", urlPatterns = {"/ServletOdontologo"})
public class ServletOdontologo extends HttpServlet {

    ControladorUsuario controladorUsuario = new ControladorUsuario();
    ControladorHorario controladorHorario = new ControladorHorario();
    ControladorOdontologo controladorOdontologo = new ControladorOdontologo();
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
        int id = Integer.parseInt(request.getParameter("idOdontologo"));

        Odontologo nuevoOdontologo = controladorOdontologo.obtenerOdontologo(id);

        request.setAttribute("odontologoEditar", nuevoOdontologo);

        request.getRequestDispatcher("editarOdontologo.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String accion = request.getParameter("accion");

        Odontologo odontologoseleccionado = controladorOdontologo.obtenerOdontologo(Integer.parseInt(request.getParameter("idOdontologo")));
        Horario horarioNuevo = odontologoseleccionado.getHorario();

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idOdontologo"));
            try {
                controladorHorario.eliminarHorario(odontologoseleccionado.getHorario().getIdHorario());
                controladorUsuario.eliminarUsuario(odontologoseleccionado.getUsuario().getIdUsuario());
                controladorOdontologo.eliminarOdontologo(id);
                System.out.println("Odontologo eliminado con exito");
                response.sendRedirect("CargarTablaOdontologos");

            } catch (Exception e) {
                System.out.println("Error al eliminar el Odontologo.");
            }
        }

        if ("editar".equals(accion)) {

            //---------DATOS ODONTOLOGO
            String identificacionOdonto = request.getParameter("txtIdentificacionOdonto");
            String nombreOdonto = request.getParameter("txtNombreOdonto");
            String apellidoOdonto = request.getParameter("txtApellidoOdonto");
            String direccionOdonto = request.getParameter("txtDireccionOdonto");
            String celularOdonto = request.getParameter("txtCelularOdonto");

            Date fechaNacOdonto = null;
            try {
                String fechaTexto = request.getParameter("fechaNacOdonto");

                System.out.println("Fecha recibida: " + fechaTexto);
                fechaNacOdonto = formatter.parse(fechaTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(fechaNacOdonto.getDate());
            String especialidad = request.getParameter("txtEspecialidadOdonto");
            //---------FIN DATOS ODONTOLOGO

            //---------DATOS HORARIO
            String horaInicioHorario = request.getParameter("horarioInicio");
            String horaFinHorario = request.getParameter("horarioFin");
            //---------FIN DATOS HORARIO

            horarioNuevo.setHoraInicio(horaInicioHorario);
            horarioNuevo.setHoraFin(horaFinHorario);
            Odontologo edicionOdontologo = new Odontologo(especialidad, horarioNuevo, odontologoseleccionado.getUsuario(), odontologoseleccionado.getListaTurnos(), odontologoseleccionado.getIdPersona(), identificacionOdonto, nombreOdonto, apellidoOdonto, direccionOdonto, celularOdonto, fechaNacOdonto);
            try {
                controladorHorario.editarHorario(horarioNuevo);
                controladorOdontologo.editarOdontologo(edicionOdontologo);
                System.out.println("Odontologo editado correctamente");
                response.sendRedirect("CargarTablaOdontologos");

            } catch (Exception e) {
                System.out.println("Error al editar el Odontologo.");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
