<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Responsable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <title>Ver Datos Responsable</title>
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
                            <h1 class="h3 mb-0 text-gray-800">Datos del responsable</h1>
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

                                                <!--FORMULARIO VER / EDITAR PACIENTE-->
                                                <form action="ServletPaciente" method="POST" class="user">

                                                    <%
                                                        Responsable responsableAEditar = (Responsable) request.getAttribute("ResponsableEditar");
                                                        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                                                    %>


                                                    <!--FORMULARIO  RESPONSABLE-->
                                                    <div class="formularioResponsable" id="formularioResponsable" >

                                                        <div class="text-center">
                                                            <h1 class="h4 text-gray-900 mb-4">Datos del Responsable</h1>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Identificación:</label>
                                                            <input type="text" class="form-control form-control-user" id="txtIdentificacionResponsable" name="txtIdentificacionResponsable"
                                                                   value="<%=responsableAEditar.getIdentificacion()%>" disabled>
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                            <label>Nombre:</label>
                                                                <input type="text" class="form-control form-control-user" id="txtNombreResponsable" name="txtNombreResponsable"
                                                                       value="<%=responsableAEditar.getNombre()%>" disabled>
                                                            </div>
                                                            <div class="col-sm-6">
                                                            <label>Apellido:</label>
                                                                <input type="text" class="form-control form-control-user" id="txtApellidoResponsable" name="txtApellidoResponsable"
                                                                       value="<%=responsableAEditar.getApellido()%>" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Dirección:</label>
                                                            <input type="text" class="form-control form-control-user" id="txtDireccionResponsable" name="txtDireccionResponsable"
                                                                   value="<%=responsableAEditar.getDireccion()%>" disabled>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Celular:</label>
                                                            <input type="number" class="form-control form-control-user" id="txtCelularResponsable" name="txtCelularResponsable"
                                                                   value="<%=responsableAEditar.getCelular()%>" disabled>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Fecha de nacimiento</label>
                                                            <input type="date" class="form-control form-control-user" id="fechaNacResponsable" name="fechaNacResponsable" value="<%=formatoFecha.format(responsableAEditar.getFechaNacimiento())%>" disabled>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Parentesco:</label>
                                                            <input type="text" class="form-control form-control-user" name="txtParentescoResponsable" id="txtParentescoResponsable"
                                                                   value="<%=responsableAEditar.getParentesco()%>" disabled>
                                                        </div>

                                                    </div>
                                                    <!--FIN FORMULARIO CREAR SECRETARIO-->

                                                    <input type="hidden"  name="accion" value="crear">

                                                    <!--<input type="hidden"  name="crearRol" id="crearRol" value="">-->

                                                    <button type="button" class="btn btn-warning btn-user btn-block" id="btnActivarEdicion">Editar Responsable</button>
                                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Guardar Cambios">

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

        <script src="js/formularioVerEditarResponsable.js"></script>

    </body>
</html>
