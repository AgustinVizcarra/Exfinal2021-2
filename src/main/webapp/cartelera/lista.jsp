<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cartelera</title>
        <jsp:include page="../includes/headCss.jsp"/>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-5 mt-4">
                <div class="col-md-7">
                    <h1>Lista de empleados</h1>
                </div>
            </div>
            <div class="col-md-5 col-lg-4 ms-auto my-auto text-md-end">
                <a href="<%= request.getContextPath()%>/Cartelera?action=agregar" class="btn btn-primary">Añadir Funcion</a>
            </div>
            <jsp:include page="../includes/infoMsgs.jsp"/>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Cadena</th>
                        <th>Cine</th>
                        <th>Pelicula</th>
                        <th>Horario</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>


                </tbody>
            </table>
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </body>
</html>
