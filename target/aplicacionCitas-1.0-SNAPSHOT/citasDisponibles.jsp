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
        <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.20/index.global.min.js'></script>
        <script>

            document.addEventListener('DOMContentLoaded', function () {
                var calendarEl = document.getElementById('calendar');
                var calendar = new FullCalendar.Calendar(calendarEl, {
                    initialView: 'dayGridMonth'
                });
                calendar.render();
            });

        </script>
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
                            <h1 class="h3 mb-0 text-gray-800">Citas Disponibles</h1>
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


                                                <div id='calendar'></div>

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
