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
import logica.Responsable;
import logica.Paciente;
import logica.Secretario;
import logica.Usuario;
import logica.controladores.ControladorHorario;
import logica.controladores.ControladorOdontologo;
import logica.controladores.ControladorPaciente;
import logica.controladores.ControladorResponsable;
import logica.controladores.ControladorSecretario;
import logica.controladores.ControladorUsuario;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "ServletResponsable", urlPatterns = {"/ServletResponsable"})
public class ServletResponsable extends HttpServlet {

    ControladorPaciente controladorPaciente = new ControladorPaciente();
    ControladorResponsable controladorResponsable = new ControladorResponsable();

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
        int id = Integer.parseInt(request.getParameter("idResponsable"));
        
        Responsable nuevoResponsable = controladorResponsable.obtenerResponsable(id);

        request.setAttribute("ResponsableEditar", nuevoResponsable);

        request.getRequestDispatcher("verEditarResponsable.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {

            //---------DATOS PACIENTE
            String identificacionPaciente = request.getParameter("txtIdentificacionPaciente");
            String nombrePaciente = request.getParameter("txtNombrePaciente");
            String apellidoPaciente = request.getParameter("txtApellidoPaciente");
            String direccionPaciente = request.getParameter("txtDireccionPaciente");
            String celularPaciente = request.getParameter("txtCelularPaciente");

            Date fechaNacPaciente = null;
            try {
                String fechaTexto = request.getParameter("fechaNacPaciente");

                System.out.println("Fecha recibida: " + fechaTexto);
                fechaNacPaciente = formatter.parse(fechaTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(fechaNacPaciente.getDate());
            String tipoSangre = request.getParameter("tipoSangre");
            boolean tieneSeguro = request.getParameter("tieneSeguro") != null;
            System.out.println(request.getParameter("tieneSeguro"));
            //---------FIN DATOS PACIENTE

            Paciente pacienteNuevo = new Paciente();
            pacienteNuevo.setIdentificacion(identificacionPaciente);
            pacienteNuevo.setNombre(nombrePaciente);
            pacienteNuevo.setApellido(apellidoPaciente);
            pacienteNuevo.setDireccion(direccionPaciente);
            pacienteNuevo.setCelular(celularPaciente);
            pacienteNuevo.setFechaNacimiento(fechaNacPaciente);
            pacienteNuevo.setTipoSangre(tipoSangre);
            pacienteNuevo.setTieneSeguro(tieneSeguro);

            //---------DATOS Responsable
            String identificacionResponsable = request.getParameter("txtIdentificacionResponsable");
            String nombreResponsable = request.getParameter("txtNombreResponsable");
            String apellidoResponsable = request.getParameter("txtApellidoResponsable");
            String direccionResponsable = request.getParameter("txtDireccionResponsable");
            String celularResponsable = request.getParameter("txtCelularResponsable");
            Date fechaNacResponsable = null;
            try {
                String fechaNacSecreTexto = request.getParameter("fechaNacResponsable");
                fechaNacResponsable = formatter.parse(fechaNacSecreTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            String parentescoResponsable = request.getParameter("txtParentescoResponsable");
            
            System.out.println("Identificacion responsable = " + identificacionResponsable);
            
            Responsable responsableNuevo = new Responsable();
            responsableNuevo.setIdentificacion(identificacionResponsable);
            responsableNuevo.setNombre(nombreResponsable);
            responsableNuevo.setApellido(apellidoResponsable);
            responsableNuevo.setDireccion(direccionResponsable);
            responsableNuevo.setCelular(celularResponsable);
            responsableNuevo.setFechaNacimiento(fechaNacResponsable);
            responsableNuevo.setParentesco(parentescoResponsable);

            if (identificacionResponsable != "") {
                pacienteNuevo.setResponsable(responsableNuevo);
                controladorResponsable.crearResponsable(responsableNuevo);
                controladorPaciente.crearPaciente(pacienteNuevo);
                System.out.println("paciente con responsable creado correctamente");
                response.sendRedirect("CargarTablaPacientes");

            } else {
                controladorPaciente.crearPaciente(pacienteNuevo);
                System.out.println("paciente sin respponsable creado correctamente");
                response.sendRedirect("CargarTablaPacientes");
            }

        }
        /*
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
         */

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("idResponsable"));
            
            Responsable responsableAEditar = controladorResponsable.obtenerResponsable(id);
            
            String identificacionResponsable = request.getParameter("txtIdentificacionResponsable");
            String nombreResponsable = request.getParameter("txtNombreResponsable");
            String apellidoResponsable = request.getParameter("txtApellidoResponsable");
            String direccionResponsable = request.getParameter("txtDireccionResponsable");
            String celularResponsable = request.getParameter("txtCelularResponsable");
            Date fechaNacResponsable = null;
            try {
                String fechaNacSecreTexto = request.getParameter("fechaNacResponsable");
                fechaNacResponsable = formatter.parse(fechaNacSecreTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            String parentescoResponsable = request.getParameter("txtParentescoResponsable");
            
            responsableAEditar.setIdentificacion(identificacionResponsable);
            responsableAEditar.setNombre(nombreResponsable);
            responsableAEditar.setApellido(apellidoResponsable);
            responsableAEditar.setDireccion(direccionResponsable);
            responsableAEditar.setCelular(celularResponsable);
            responsableAEditar.setFechaNacimiento(fechaNacResponsable);
            responsableAEditar.setParentesco(parentescoResponsable);
            
            
            try {
                controladorResponsable.editarResponsable(responsableAEditar);
                System.out.println("Responsable editado correctamente");
                response.sendRedirect("CargarTablaPacientes");

            } catch (Exception e) {
                System.out.println("Error al editar el responsable.");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
