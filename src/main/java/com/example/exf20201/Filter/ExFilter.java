package com.example.exf20201.Filter;

import com.example.exf20201.Beans.Empleado;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "ExFilter",urlPatterns ={"/Cartelera","/Reportes"} )
public class ExFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Empleado empleado = (Empleado) session.getAttribute("empleado");
        if(empleado !=null && empleado.getIdEmpleado() != 0 ) {
            chain.doFilter(request, response);
        }else{
            response.sendRedirect(request.getContextPath());
        }
    }
}
