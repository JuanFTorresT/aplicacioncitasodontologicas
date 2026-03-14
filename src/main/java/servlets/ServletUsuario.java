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
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("idUsuario"));

        Usuario nuevoUsuario = controladorUsuario.obtenerUsuario(id);

        request.setAttribute("usuarioEditar", nuevoUsuario);

        request.getRequestDispatcher("editarUsuario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        //---------DATOS USUARIO
        String usuario = request.getParameter("txtUsuario");
        String contrasena = request.getParameter("txtContrasena");
        String rol = request.getParameter("txtRol");
        //---------FIN DATOS USUARIO

        String accion = request.getParameter("accion");
        String rolACrear = request.getParameter("crearRol");

        Usuario nuevoUsuario = new Usuario(0, usuario, contrasena, rol);

        if ("crear".equals(accion)) {
            if ("crearOdontologo".equals(rolACrear)) {
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

                Horario horarioNuevo = new Horario(0, horaInicioHorario, horaFinHorario);

                Odontologo odontologoNuevo = new Odontologo();
                odontologoNuevo.setIdentificacion(identificacionOdonto);
                odontologoNuevo.setNombre(nombreOdonto);
                odontologoNuevo.setApellido(apellidoOdonto);
                odontologoNuevo.setDireccion(direccionOdonto);
                odontologoNuevo.setCelular(celularOdonto);
                odontologoNuevo.setFechaNacimiento(fechaNacOdonto);
                odontologoNuevo.setEspecialidad(especialidad);
                odontologoNuevo.setHorario(horarioNuevo);
                odontologoNuevo.setUsuario(nuevoUsuario);

                controladorUsuario.crearUsuario(nuevoUsuario);
                controladorHorario.crearHorario(horarioNuevo);
                controladorOdontologo.crearOdontologo(odontologoNuevo);
                System.out.println("Usuario creado.");

                System.out.println("Horario y odontologo creado correctamente");
                response.sendRedirect("CargarTablaUsuarios");
            }

            if ("crearSecretario".equals(rolACrear)) {
                //---------DATOS SECRETARIO
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

                Secretario secretarioNuevo = new Secretario();
                secretarioNuevo.setIdentificacion(identificacionSecre);
                secretarioNuevo.setNombre(nombreSecre);
                secretarioNuevo.setApellido(apellidoSecre);
                secretarioNuevo.setDireccion(direccionSecre);
                secretarioNuevo.setCelular(celularSecre);
                secretarioNuevo.setFechaNacimiento(fechaNacSecre);
                secretarioNuevo.setSector(sector);
                secretarioNuevo.setUsuario(nuevoUsuario);
                //---------FIN DATOS SECRETARIO
                controladorUsuario.crearUsuario(nuevoUsuario);
                controladorSecretario.crearSecretario(secretarioNuevo);
                System.out.println("Usuario creado.");

                System.out.println("secretario creado correctamente");
                response.sendRedirect("CargarTablaUsuarios");
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
