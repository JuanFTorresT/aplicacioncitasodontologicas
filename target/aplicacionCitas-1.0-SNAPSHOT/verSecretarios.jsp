<%@page import="logica.Secretario"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Locale"%>
<%@page import="logica.Odontologo"%>
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <title>Ver Secretarios</title>
    </head>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper" >

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
                        <h1 class="h3 mb-2 text-gray-800">Secretarios registrados</h1>
                        <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                            For more information about DataTables, please visit the <a target="_blank"
                                                                                       href="https://datatables.net">official DataTables documentation</a>.</p>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="tablaVerOdontologos" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Identificación</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Celular</th>
                                                <th>Dirección</th>
                                                <th>Fecha de nacimiento</th>
                                                <th>Sector</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Id</th>
                                                <th>Identificación</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Celular</th>
                                                <th>Dirección</th>
                                                <th>Fecha de nacimiento</th>
                                                <th>Sector</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <%
                                                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");

                                                List<Secretario> listaSecretarios = (List<Secretario>) request.getAttribute("listaSecretarios");
                                                for (Secretario secretario : listaSecretarios) {
                                            %>
                                            <tr>
                                                <td><%=secretario.getIdPersona()%></td>
                                                <td><%=secretario.getIdentificacion()%></td>
                                                <td><%=secretario.getNombre()%></td>
                                                <td><%=secretario.getApellido()%></td>
                                                <td><%=secretario.getCelular()%></td>
                                                <td><%=secretario.getDireccion()%></td>
                                                <td><%=formatoFecha.format(secretario.getFechaNacimiento())%></td>
                                                <td><%=secretario.getSector()%></td>
                                                
                                                <td class="d-flex ">
                                                    <!-- Formulario editar -->
                                                    <form action="ServletSecretario" method="GET">
                                                        <input type="hidden"  name="idSecretario" value="<%=secretario.getIdPersona()%>">
                                                        <!--<input type="hidden"  name="accion" value="editar">-->
                                                        <!-- <input type="submit" value="Editar" class="btn btn-primary mr-4"> -->
                                                        <button type="submit" class="btn shadow-sm mr-2" style="background: none; border: none;" title="Editar">
                                                            <i class="fas fa-edit" style="color: rgb(255, 143, 0);" ></i>
                                                        </button>
                                                    </form>
                                                    <!-- Fin Formulario editar -->
                                                    <!-- Formulario eliminar -->
                                                    <form action="ServletSecretario" method="POST">
                                                        <input type="hidden"  name="idSecretario" value="<%=secretario.getIdPersona()%>">
                                                        <input type="hidden"  name="accion" value="eliminar">
                                                        <button type="submit" class="btn shadow-sm mr-2" style="background: none; border: none;" title="Eliminar">
                                                            <i class="fas fa-trash" style="color: rgb(255, 0, 0);" ></i>
                                                        </button>
                                                    </form>
                                                    <!-- Fin Formulario eliminar -->
                                                </td>
                                            </tr>

                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <%@include file="componentes/footer.jsp" %>

            </div>
            <!-- End Of Content Wrapper -->

        </div>
        <!-- End Of  Page Wrapper -->

        <!-- Modal cerrar sesion component -->
        <%@include file="componentes/modalCerrarSesion.jsp" %>
        <!-- End of modal cerrar sesion component -->

        <!-- Referencias javascript component -->
        <%@include file="componentes/referenciasJS.jsp" %>
        <!-- End of Referencias javascript component -->


        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
    </body>
</html>
