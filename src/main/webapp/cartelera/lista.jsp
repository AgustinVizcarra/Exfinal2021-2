<%@ page import="com.example.exf20201.Beans.Cartelera" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    ArrayList<Cartelera> listaCartelera = (ArrayList<Cartelera>) request.getAttribute("listaCartelera");
%>


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
                <tbody class="text-center">
                <%
                    int  i = 1;
                    for (Cartelera cartelera : listaCartelera){
                %>
                    <tr>
                        <td>
                            <span><%=i%></span>
                        </td>
                        <td>
                            <span><%=cartelera.getCine().getCadena().getNombreComercial()%></span>
                        </td>
                        <td>
                            <span><%=cartelera.getCine().getNombre()%></span>
                        </td>
                        <td>
                            <span><%=cartelera.getPelicula().getNombre()%>-
                                <%if (cartelera.getTresD() == 1){%>
                                    3D
                                <%}
                                    if (cartelera.getSubtitulada() == 1){
                                %>
                                    Subtitulada
                                <%}
                                    if (cartelera.getDoblada() == 1){
                                %>
                                    Doblada
                                <%}%>
                            </span>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                <%}%>
                </tbody>
            </table>
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </body>
</html>
