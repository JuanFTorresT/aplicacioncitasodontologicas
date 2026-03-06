<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <title>Crear Odontólogo</title>
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
                            <h1 class="h3 mb-0 text-gray-800">Registrar Odontólogo</h1>
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
                                                    <h1 class="h4 text-gray-900 mb-4">Crea un Odontólogo</h1>
                                                </div>
                                                <form class="user">
                                                    <div class="form-group">
                                                        <input type="txtIdentificacion" class="form-control form-control-user" name="txtIdentificacion"
                                                               placeholder="Identificación">
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                                            <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                                                   placeholder="Nombre">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <input type="text" class="form-control form-control-user" id="exampleLastName"
                                                                   placeholder="Apellido">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="email" class="form-control form-control-user" id="exampleInputEmail"
                                                               placeholder="Dirección">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="email" class="form-control form-control-user" id="exampleInputEmail"
                                                               placeholder="Celular">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Fecha de nacimiento</label>
                                                        <input type="date" class="form-control form-control-user" id="exampleInputEmail">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="email" class="form-control form-control-user" id="exampleInputEmail"
                                                               placeholder="Especialidad">
                                                    </div>

                                                    <a href="login.html" class="btn btn-primary btn-user btn-block">
                                                        Crear Odontólogo
                                                    </a>
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
