<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <title>Crear Paciente</title>
        <style>
            .select-user {
                height: 50px; /* igual al input */
                padding-left: 1rem;
                padding-right: 1rem;
                font-size: 0.8rem;
            }
        </style>
    </head>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar Component -->
            <%@include file="componentes/sidebar.jsp" %>
            <!-- End of Sidebar Component -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <%@include file="componentes/topbar.jsp" %>

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <div class="d-sm-flex align-items-center justify-content-between mb-4">
                            <h1 class="h3 mb-0 text-gray-800">Editar Pacientes</h1>
                        </div>
                        <!-- End Of Page Heading -->
                        <div class="d-sm-flex  justify-content-center mb-4">
                            <!-- Formulario creacion -->
                            <div class="card o-hidden border-0 shadow-lg my-5 w-50">
                                <div class="card-body">
                                    <!-- Nested Row within Card Body -->
                                    <div>
                                        <div>
                                            <div class="p-5">
                                                <div class="text-center">
                                                    <h1 class="h4 text-gray-900 mb-4">Edita un Paciente</h1>
                                                </div>
                                                <!--FORMULARIO CREAR PACIENTE-->
                                                <form action="ServletPaciente" method="POST" class="user">
                                                <%
                                                    Paciente pacienteAEditar = (Paciente) request.getAttribute("pacienteEditar");
                                                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                                                %>

                                                    <!--FORMULARIO CREAR PACIENTE-->
                                                    <div class="formularioPaciente" id="formularioPaciente">

                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" name="txtIdentificacionPaciente"
                                                                   value="<%=pacienteAEditar.getIdentificacion()%>">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="text" class="form-control form-control-user" name="txtNombrePaciente"
                                                                       value="<%=pacienteAEditar.getNombre()%>">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control form-control-user" name="txtApellidoPaciente"
                                                                       value="<%=pacienteAEditar.getApellido()%>">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtDireccionPaciente"
                                                                   value="<%=pacienteAEditar.getDireccion()%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="number" class="form-control form-control-user" id="exampleInputEmail" name="txtCelularPaciente"
                                                                   value="<%=pacienteAEditar.getCelular()%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Fecha de nacimiento</label>
                                                            <input type="date" class="form-control form-control-user" id="fechaNacPaciente" name="fechaNacPaciente"
                                                                   value="<%=formatoFecha.format(pacienteAEditar.getFechaNacimiento())%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <select class="form-control rounded-pill select-user" name="tipoSangre" id="tipoSangre" required>
                                                                <option value="">Seleccione su tipo de sangre</option>
                                                                <option value="A+" <%=pacienteAEditar.getTipoSangre().equals("A+")?"selected":""%>>A+</option>
                                                                <option value="A-" <%=pacienteAEditar.getTipoSangre().equals("A-")?"selected":""%>>A-</option>
                                                                <option value="B+" <%=pacienteAEditar.getTipoSangre().equals("B+")?"selected":""%>>B+</option>
                                                                <option value="B-" <%=pacienteAEditar.getTipoSangre().equals("B-")?"selected":""%>>B-</option>
                                                                <option value="AB+" <%=pacienteAEditar.getTipoSangre().equals("AB+")?"selected":""%>>AB+</option>
                                                                <option value="AB-" <%=pacienteAEditar.getTipoSangre().equals("AB-")?"selected":""%>>AB-</option>
                                                                <option value="O+" <%=pacienteAEditar.getTipoSangre().equals("O+")?"selected":""%>>O+</option>
                                                                <option value="O-" <%=pacienteAEditar.getTipoSangre().equals("O-")?"selected":""%>>O-</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="checkbox" id="tieneSeguro" name="tieneSeguro" <%=pacienteAEditar.isTieneSeguro()?"checked":""%>>
                                                            <label for="tieneSeguro">¿Tiene seguro?</label>
                                                        </div>



                                                    </div>
                                                       
                                                            <%--
                                                    <!--FIN FORMULARIO CREAR PACIENTE-->
                                                
                                                    
                                                    <%
                                                        if (pacienteAEditar.getResponsable()!= null) {
                                                    %>
                                                    <!--FORMULARIO CREAR RESPONSABLE-->
                                                    <div class="formularioResponsable" id="formularioResponsable" hidden>

                                                        <div class="text-center">
                                                            <h1 class="h4 text-gray-900 mb-4">Crea un Responsable</h1>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" name="txtIdentificacionResponsable"
                                                                   value="<%=pacienteAEditar.getResponsable().getIdentificacion()%>">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="text" class="form-control form-control-user" id="exampleFirstName" name="txtNombreResponsable"
                                                                       value="<%=pacienteAEditar.getResponsable().getNombre()%>">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control form-control-user" id="exampleLastName" name="txtApellidoResponsable"
                                                                       value="<%=pacienteAEditar.getResponsable().getApellido()%>">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtDireccionResponsable"
                                                                   value="<%=pacienteAEditar.getResponsable().getDireccion()%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="number" class="form-control form-control-user" id="exampleInputEmail" name="txtCelularResponsable"
                                                                   value="<%=pacienteAEditar.getResponsable().getCelular()%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Fecha de nacimiento</label>
                                                            <input type="date" class="form-control form-control-user" id="exampleInputEmail" name="fechaNacResponsable"
                                                                   value="<%=formatoFecha.format(pacienteAEditar.getResponsable().getFechaNacimiento())%>">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" name="txtParentescoResponsable" 
                                                                   value="<%=pacienteAEditar.getResponsable().getParentesco()%>">
                                                        </div>

                                                    </div>
                                                    <!--FIN FORMULARIO CREAR SECRETARIO-->
                                                    <%}%>
                                                    --%>
                                                    

                                                    <input type="hidden"  name="accion" value="editar">
                                                    <input type="hidden"  name="idPaciente" value="<%=pacienteAEditar.getIdPersona()%>">

                                                    <!--<input type="hidden"  name="crearRol" id="crearRol" value="">-->

                                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Crear Paciente">

                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- End Of Formulario creacion -->
                        </div>

                    </div>
                    <!-- End Of Begin Page Content -->

                </div>
                <!-- End of Main Content -->

                <%@include file="componentes/footer.jsp" %>

            </div>
            <!-- End Of Content Wrapper -->

        </div>
        <!-- End Of  Page Wrapper -->

        <!<!-- Modal cerrar sesion component -->
        <%@include file="componentes/modalCerrarSesion.jsp" %>
        <!<!-- End of modal cerrar sesion component -->

        <!<!-- Referencias javascript component -->
        <%@include file="componentes/referenciasJS.jsp" %>
        <!<!-- End of Referencias javascript component -->

        <script src="js/formularioEditarPaciente.js"></script>
    </body>
</html>
