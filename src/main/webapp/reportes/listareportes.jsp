<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='resources/css/bootstrap.min.css'/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="job"/>
            </jsp:include>
            <div class="row mb-5 mt-4">
                <div class="col-md-7">
                    <h1 class=''>Lista de Reportes</h1>
                </div>
            </div>
            <table class="table">
                <tr>
                    <th>#empleados sin jefe</th>
                    <th># pelis en 3D</th>
                    <th>salario mayor a 9700</th>
                    <th>Cine con mayor # de pelis</th>
                </tr>
            </table>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>