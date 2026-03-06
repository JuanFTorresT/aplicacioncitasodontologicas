<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <title>Ver Usuarios</title>
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
                        <h1 class="h3 mb-2 text-gray-800">Tables</h1>
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
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Usuario</th>
                                                <th>Rol</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Id</th>
                                                <th>Usuario</th>
                                                <th>Rol</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <% 
                                                List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
                                                for (Usuario usuario : listaUsuarios) {
                                            %>
                                            <tr>
                                                <td><%=usuario.getIdUsuario()%></td>
                                                <td><%=usuario.getUsuario()%></td>
                                                <td><%=usuario.getRol()%></td>
                                                <td class="d-flex ">
                                                    <!-- Formulario editar -->
                                                    <form action="ServletUsuario" method="GET">
                                                        <input type="hidden"  name="idUsuario" value="<%=usuario.getIdUsuario()%>">
                                                        <input type="hidden"  name="accion" value="editar">
                                                        <input type="submit" value="Editar" class="btn btn-primary mr-4">
                                                    </form>
                                                    <!-- Fin Formulario editar -->
                                                    <!-- Formulario eliminar -->
                                                    <form action="ServletUsuario" method="POST">
                                                        <input type="hidden"  name="idUsuario" value="<%=usuario.getIdUsuario()%>">
                                                        <input type="hidden"  name="accion" value="eliminar">
                                                         <input type="submit" value="Eliminar" class="btn btn-danger mr-4">
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
