<% String currentPage = request.getParameter("currentPage"); %>
<jsp:useBean id="empleado" type="com.example.exf20201.Beans.Empleado" scope="session"
             class="com.example.exf20201.Beans.Empleado"/>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="#">Examen final</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
        <ul class="navbar-nav">
            <% if (empleado.getIdEmpleado() > 0) { %>
            <li class="nav-item">
                <a class="nav-link <%=currentPage.equals("cou") ? "active" : ""%>"
                   href="<%=request.getContextPath()%>/Cartelera">
                    Cartelera
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link <%=currentPage.equals("loc") ? "active" : ""%>"
                   href="<%=request.getContextPath()%>/Reportes">
                    Reportes
                </a>
            </li>
            <li class="nav-item">
                <span class="nav-link text-dark">
                    Bienvenido <%=empleado.getNombre()%> <%=empleado.getApellido()%> Rol:<%=empleado.getRoles().get(0).getNombre()%> (<a
                        href="<%=request.getContextPath()%>/?action=logout">Cerrar sesion</a>)
                </span>
            </li>
            <% } else { %>
            <a class="nav-link" style="color: #007bff;" href="<%=request.getContextPath()%>/">(Iniciar
                Sesion)</a>
            <% } %>
        </ul>
    </div>
</nav>
