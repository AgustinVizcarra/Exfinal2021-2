<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.exf20201.Beans.Pelicula" %>
<%@ page import="com.example.exf20201.Beans.Cine" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean scope="request" id="listaPeliculas" type="java.util.ArrayList<com.example.exf20201.Beans.Pelicula>"/>
<jsp:useBean scope="request" id="listaCine" type="java.util.ArrayList<com.example.exf20201.Beans.Cine>"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Nueva Funcion</title>
        <jsp:include page="../includes/headCss.jsp" />
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-4">
                <div class="col"></div>
                <div class="col-md-6">
                    <h1 class='mb-3'>Nueva Funcion</h1>
                    <hr>
                    <jsp:include page="../includes/infoMsgs.jsp" />
                    <form method="POST" action="<%=request.getContextPath()%>/Cartelera?action=agregar">
                        <div class="mb-3">
                            <label class="form-label" for="peliculaId">Pelicula</label>
                            <select name="idPelicula" id="peliculaId" class="form-control">
                                <% for (Pelicula pelicula : listaPeliculas) {%>
                                <option value="<%=pelicula.getIdPelicula()%>"><%=pelicula.getNombre()%>
                                </option>
                                <% }%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="cineId">Cine</label>
                            <select name="idCine" id="cineId" class="form-control">
                                <% for (Cine cine : listaCine) {%>
                                <option value="<%=cine.getIdCine()%>"><%=cine.getNombre()%>
                                </option>
                                <% }%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="formatoId">Formato</label>
                            <select name="formato" id="formatoId" class="form-control">
                                <option value="0">No es 3D</option>
                                <option value="1">Si es 3D</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="lenguajeId">Lenguaje</label>
                            <select name="lenguaje" id="lenguajeId" class="form-control">
                                <option value="doblada">Doblada</option>
                                <option value="subtitulada">Subtitulada</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="horarioId">Horario</label>
                            <input type="text" class="form-control form-control-sm" id="horarioId" name="horario">
                        </div>

                        <a href="<%= request.getContextPath()%>/Cartelera" class="btn btn-danger">Cancelar</a>
                        <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Crear</button>
                        <!--input type="submit" value="Guardar" class="btn btn-primary"/-->
                    </form>
                </div>
                <div class="col"></div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
