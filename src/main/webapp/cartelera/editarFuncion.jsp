<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.exf20201.Beans.Pelicula" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="Cartelera" type="com.example.exf20201.Beans.Cartelera" scope="request"/>
<jsp:useBean scope="request" id="listaPeliculas" type="java.util.ArrayList<com.example.exf20201.Beans.Pelicula>" class="java.util.ArrayList"/>
<!--jsp:useBean scope="request" id="listaCine" type="java.util.ArrayList<com.example.exf20201.Beans.Cine>" class="java.util.ArrayList"/-->
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Funcion</title>
        <jsp:include page="../includes/headCss.jsp" />
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-4">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class='mb-3'>Editar Funcion</h1>
                    <hr>
                    <jsp:include page="../includes/infoMsgs.jsp" />
                    <form method="POST" action="<%=request.getContextPath()%>/Cartelera?action=editar&idFuncion=<%=Cartelera.getIdCartelera()%>">

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
                        <input type="submit" value="Guardar" class="btn btn-primary"/>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
