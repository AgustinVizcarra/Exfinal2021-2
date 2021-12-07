package com.example.exf20201.Servlet;

import com.example.exf20201.Dao.CineDao;
import com.example.exf20201.Dao.PeliculaDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarteleraServlet", value = "/Cartelera")
public class CarteleraServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action") != null ? request.getParameter("action") : "lista";
        RequestDispatcher view;

        if(action.equalsIgnoreCase("lista")){
            //listas a enviar
            view = request.getRequestDispatcher("cartelera/lista.jsp");
            view.forward(request, response);

        }else if(action.equalsIgnoreCase("agregar")){
            PeliculaDao peliculaDao = new PeliculaDao();
            CineDao cineDao = new CineDao();

            request.setAttribute("listaPeliculas",peliculaDao.listaPeliculas());
            request.setAttribute("listaCine",cineDao.listaCines());
            view = request.getRequestDispatcher("cartelera/agregarFuncion.jsp");
            view.forward(request, response);

        }else if(action.equalsIgnoreCase("borrar")){




        }else if(action.equalsIgnoreCase("editar")){



        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action.equalsIgnoreCase("agregar")){
            String idPeliculaStr = request.getParameter("idPelicula");
            int idPelicula = Integer.parseInt(idPeliculaStr);

            String idCineStr = request.getParameter("idCine");
            int idCine = Integer.parseInt(idCineStr);

            String formatoStr = request.getParameter("formato");
            int formato = Integer.parseInt(formatoStr);

            String lenguaje = request.getParameter("lenguaje");
            String horario = request.getParameter("horario");





        }




    }
}
