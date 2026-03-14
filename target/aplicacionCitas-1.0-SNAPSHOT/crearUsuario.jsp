<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <title>Crear Usuario</title>
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
                            <h1 class="h3 mb-0 text-gray-800">Registrar Usuario</h1>
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
                                                    <h1 class="h4 text-gray-900 mb-4">Crea un Usuario</h1>
                                                </div>
                                                <!--FORMULARIO CREAR USUARIO-->
                                                <form action="ServletUsuario" method="POST" class="user">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control form-control-user" name="txtUsuario"
                                                               placeholder="Usuario" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control form-control-user" name="txtContrasena" 
                                                               placeholder="Contraseña" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <select class="form-control rounded-pill select-user" name="txtRol" id="selectRol" required>
                                                            <option selected value="" disabled>Selecciona el Rol</option>
                                                            <option value="Admin">Admin</option>
                                                            <option value="Odontologo">Odontologo</option>
                                                            <option value="Secretario">Secretario</option>
                                                        </select>
                                                    </div>
                                                    <!--FIN FORMULARIO CREAR USUARIO-->
                                                    
                                                    <!--FORMULARIO CREAR ODONTOLOGO-->
                                                    <div class="formularioOdonto" id="formularioOdonto" hidden="true">
                                                        
                                                        <div class="text-center">
                                                            <h1 class="h4 text-gray-900 mb-4">Crea un Odontólogo</h1>
                                                        </div>

                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" name="txtIdentificacionOdonto"
                                                                   placeholder="Identificación">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="text" class="form-control form-control-user" name="txtNombreOdonto"
                                                                       placeholder="Nombre">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control form-control-user" name="txtApellidoOdonto"
                                                                       placeholder="Apellido">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtDireccionOdonto"
                                                                   placeholder="Dirección">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="number" class="form-control form-control-user" id="exampleInputEmail" name="txtCelularOdonto"
                                                                   placeholder="Celular">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Fecha de nacimiento</label>
                                                            <input type="date" class="form-control form-control-user" id="exampleInputEmail" name="fechaNacOdonto">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtEspecialidadOdonto"
                                                                   placeholder="Especialidad">
                                                        </div>
                                                   
                                                    
                                                        <!-- FORMULARIO HORARIO-->
                                                        <div class="text-center">
                                                            <h1 class="h4 text-gray-900 mb-4">Crea un Horario</h1>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Hora Inicio</label>
                                                            <input type="time" class="form-control form-control-user" name="horarioInicio">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Hora Fin</label>
                                                            <input type="time" class="form-control form-control-user" name="horarioFin">
                                                        </div>

                                                        <!-- FIN FORMULARIO HORARIO-->
                                                    </div>
                                                    <!--FIN FORMULARIO CREAR ODONTOLOGO-->

                                                    <!--FORMULARIO CREAR SECRETARIO-->
                                                    <div class="formularioSecre" id="formularioSecre" hidden="true">

                                                        <div class="text-center">
                                                            <h1 class="h4 text-gray-900 mb-4">Crea un Secretario</h1>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="txtIdentificacion" class="form-control form-control-user" name="txtIdentificacionSecre"
                                                                   placeholder="Identificación">
                                                        </div>
                                                        <div class="form-group row">
                                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                                <input type="text" class="form-control form-control-user" id="exampleFirstName" name="txtNombreSecre"
                                                                       placeholder="Nombre">
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <input type="text" class="form-control form-control-user" id="exampleLastName" name="txtApellidoSecre"
                                                                       placeholder="Apellido">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtDireccionSecre"
                                                                   placeholder="Dirección">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="number" class="form-control form-control-user" id="exampleInputEmail" name="txtCelularSecre"
                                                                   placeholder="Celular">
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Fecha de nacimiento</label>
                                                            <input type="date" class="form-control form-control-user" id="exampleInputEmail" name="fechaNacSecre">
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="txtIdentificacion" class="form-control form-control-user" name="txtSectorSecre" placeholder="Sector">
                                                        </div>

                                                    </div>
                                                    <!--FIN FORMULARIO CREAR SECRETARIO-->

                                                    <input type="hidden"  name="accion" value="crear">
                                                    <input type="hidden"  name="crearRol" id="crearRol" value="">

                                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Crear Usuario">

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
        
        <script src="js/formularioUsuario.js"></script>
    </body>
</html>
