<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Logueo</title>
        <jsp:include page="../includes/headCss.jsp"></jsp:include>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/resources/css/signin.css'/>
    </head>
    <body class="text-center">
        <main class="form-signin">
            <form method="post" action="<%=request.getContextPath()%>/Login">
                <h1 class="h3 mb-3 fw-normal">Por favor loguearse</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" name="inputEmail"
                           placeholder="name@example.com">
                    <label for="floatingInput">Nombre de Usuario(DNI)</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" name="inputPassword"
                           placeholder="Password">
                    <label for="floatingPassword">Contraseña</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                <% if (request.getAttribute("err") != null) { %>
                <div class="text-danger mt-2">
                    <%=request.getAttribute("err")%>
                </div>
                <%} %>
            </form>
        </main>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
