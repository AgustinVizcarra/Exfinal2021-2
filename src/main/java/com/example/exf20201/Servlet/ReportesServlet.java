package com.example.exf20201.Servlet;

import com.example.exf20201.Dao.ReportesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReportesServlet", value = "/Reportes")
public class ReportesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ReportesDao reportesDao = new ReportesDao();
        ArrayList<Integer> estadisticas = reportesDao.listarReportes();
        String cineMaxCartelera = reportesDao.cineMaxCartelera();
        request.setAttribute("estadisticas",estadisticas);
        request.setAttribute("cineMax",cineMaxCartelera);
        RequestDispatcher view = request.getRequestDispatcher("reportes/listareportes.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
