<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="componentes/metaInf.jsp" %>
        <title>Consultorio Odontológico</title>
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
                            <h1 class="h3 mb-0 text-gray-800">Consultorio Odontológico</h1>
                        </div>
                        <!-- End Of Page Heading -->
                        
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
