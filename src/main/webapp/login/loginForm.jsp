<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Logueo</title>
        <jsp:include page="../includes/headCss.jsp"></jsp:include>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/resources/css/signin.css'/>
    </head>
    <body class="text-center">
        <main class="form-signin">
            <form method="post" action="<%=request.getContextPath()%>/">
                <h1 class="h3 mb-3 fw-normal"><u>Examen Final 2021-2</u></h1>
                <h1 class="h3 mb-3 fw-normal">Loguin</h1>
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
            <p></p>
            <p></p>
            <h5 class="h5 mb-3 fw-normal"><u>Grupo 5</u></h5>
            <h6 class="h6 mb-3 fw-normal">Agustin Vizcarra 20181454</h6>
            <h6 class="h6 mb-3 fw-normal">Ronny Pastor 	20185534</h6>
            <h6 class="h6 mb-3 fw-normal">Alonso Rosales 20191566</h6>
        </main>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
