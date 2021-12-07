package com.example.exf20201.Servlet;

import com.example.exf20201.Beans.Cartelera;
import com.example.exf20201.Dao.CarteleraDao;
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
        CarteleraDao carteleraDao = new CarteleraDao();
        PeliculaDao peliculaDao = new PeliculaDao();
        CineDao cineDao = new CineDao();
        if(action.equalsIgnoreCase("lista")){
            //listas a enviar
            request.setAttribute("listaCartelera",carteleraDao.listaCartelera());
            view = request.getRequestDispatcher("cartelera/lista.jsp");
            view.forward(request, response);

        }else if(action.equalsIgnoreCase("agregar")){
            request.setAttribute("listaPeliculas",peliculaDao.listaPeliculas());
            request.setAttribute("listaCine",cineDao.listaCines());
            view = request.getRequestDispatcher("cartelera/agregarFuncion.jsp");
            view.forward(request, response);

        }else if(action.equalsIgnoreCase("borrar")){
            String idFuncionStr = request.getParameter("idFuncion");
            int idFuncion = Integer.parseInt(idFuncionStr);

            carteleraDao.borrarFuncion(idFuncion);

            view = request.getRequestDispatcher("cartelera/lista.jsp");
            view.forward(request, response);

        }else if(action.equalsIgnoreCase("editar")){
            String idFuncionStr = request.getParameter("idFuncion");
            int idFuncion = Integer.parseInt(idFuncionStr);

            Cartelera cartelera = carteleraDao.obtenerCarteleraPorId(idFuncion);


        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if(action.equalsIgnoreCase("agregar")){
            String idPeliculaStr = request.getParameter("idPelicula");
            int idPelicula = Integer.parseInt(idPeliculaStr);

            String idCineStr = request.getParameter("idCine");
            int idCine = Integer.parseInt(idCineStr);

            String formatoStr = request.getParameter("formato");
            int formato = Integer.parseInt(formatoStr);

            String lenguajeStr = request.getParameter("lenguaje");

            String horario = request.getParameter("horario");


            CarteleraDao carteleraDao = new CarteleraDao();
            carteleraDao.agregarFuncion(idPelicula,idCine,formato,lenguajeStr,horario);

            session.setAttribute("msg","Guardado exitoso");
            response.sendRedirect(request.getContextPath() + "/Cartelera");
        }






    }
}
