package com.example.exf20201.Servlet;

import com.example.exf20201.Beans.Empleado;
import com.example.exf20201.Dao.LoguinDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "loginform" : request.getParameter("action");
        HttpSession session = request.getSession();
        switch (action) {
            case "loginform":
                String err = request.getParameter("err");
                request.setAttribute("err",err);
                RequestDispatcher view = request.getRequestDispatcher("login/loginForm.jsp");
                view.forward(request, response);
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //System.out.println("Usuario: "+request.getParameter("inputEmail"));
        //System.out.println("Pwd: "+request.getParameter("inputPassword"));
        //verificamos que no haya campos nulos
        if(request.getParameter("inputEmail").equalsIgnoreCase("")||request.getParameter("inputPassword").equalsIgnoreCase("")){
            response.sendRedirect(request.getContextPath()+"/Login?err=campos vacios");
        }else{
            String usuario = request.getParameter("inputEmail");
            String pwd = request.getParameter("inputPassword");
            LoguinDao loguinDao = new LoguinDao();
            if(loguinDao.logueo(usuario,pwd)){
                Empleado empleado = loguinDao.obtenercredenciales(usuario);
                HttpSession employeesession = request.getSession();
                employeesession.setAttribute("empleado",empleado);
                switch (empleado.getRoles().get(0).getIdRol()){
                    case 1:
                        //redireccion al servlet de admin
                        System.out.println("Admin");
                        response.sendRedirect(request.getContextPath()+"/Reportes");
                        break;
                    case 2:
                        //redirrecion al servlet de gesto
                        System.out.println("Gestor");
                        response.sendRedirect(request.getContextPath()+"/Cartelera");
                        break;
                    case 3:
                        //redireccion al servlet de vendedor
                        System.out.println("Vendedor");
                        response.sendRedirect(request.getContextPath()+"/Cartelera");
                        break;
                    default:
                        System.out.println("Hubo error");
                        break;
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/Login?err=contra o usuario incorrectos");
            }
        }
    }
}
