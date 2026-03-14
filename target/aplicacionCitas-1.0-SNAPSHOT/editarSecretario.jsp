<%@page import="logica.Secretario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Odontologo"%>
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
                            <h1 class="h3 mb-0 text-gray-800">Editar Secretario</h1>
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
                                                    <h1 class="h4 text-gray-900 mb-4">Edita un Secretario</h1>
                                                </div>
                                                <form class="user" action="ServletSecretario" method="POST">
                                                    <%
                                                        Secretario secretarioAEditar = (Secretario) request.getAttribute("secretarioEditar");
                                                        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                                                    %>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control form-control-user" name="txtIdentificacionSecre"
                                                               value="<%=secretarioAEditar.getIdentificacion()%>">
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                                            <input  type="text" class="form-control form-control-user" name="txtNombreSecre"
                                                                   value="<%=secretarioAEditar.getNombre()%>">
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <input type="text" class="form-control form-control-user" name="txtApellidoSecre"
                                                                   value="<%=secretarioAEditar.getApellido()%>">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtDireccionSecre"
                                                               value="<%=secretarioAEditar.getDireccion()%>">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="number" class="form-control form-control-user" id="exampleInputEmail" name="txtCelularSecre"
                                                               value="<%=secretarioAEditar.getCelular()%>">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Fecha de nacimiento</label>
                                                        <input type="date" class="form-control form-control-user" id="exampleInputEmail" name="fechaNacSecre"
                                                               value="<%=formatoFecha.format(secretarioAEditar.getFechaNacimiento())%>">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control form-control-user" id="exampleInputEmail" name="txtSectorSecre"
                                                               value="<%=secretarioAEditar.getSector()%>">
                                                    </div>

                                                  

                                                    <input type="hidden" id="id" name="idSecretario" value="<%=secretarioAEditar.getIdPersona()%>">
                                                    <input type="hidden"  name="accion" value="editar">

                                                    <input type="submit" class="btn btn-primary btn-user btn-block" value="Editar Secretario">
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
