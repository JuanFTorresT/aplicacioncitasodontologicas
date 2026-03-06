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
                                                <form action="ServletUsuario" method="POST" class="user">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control form-control-user" name="txtUsuario"
                                                               placeholder="Usuario">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="password" class="form-control form-control-user" name="txtContrasena" 
                                                               placeholder="Contraseña">
                                                    </div>
                                                    <div class="form-group">
                                                        <select class="form-control rounded-pill select-user" name="txtRol">
                                                            <option selected>Selecciona el Rol</option>
                                                            <option value="Admin">Admin</option>
                                                            <option value="Odontologo">Odontologo</option>
                                                            <option value="Secretario">Secretario</option>
                                                        </select>
                                                    </div>

                                                    <input type="hidden"  name="accion" value="crear">

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

    </body>
</html>
