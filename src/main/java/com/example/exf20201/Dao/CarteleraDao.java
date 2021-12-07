package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cadena;
import com.example.exf20201.Beans.Cartelera;

import java.sql.*;
import java.util.ArrayList;

public class CarteleraDao extends DaoBase{

    public ArrayList<Cartelera> listaCartelera(){
        ArrayList<Cartelera> listaCartelera =new ArrayList<>();

        String sql = " select * from cartelera;";
        try (Connection connection = this.getConection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()){
                Cartelera cartelera = new Cartelera();
                cartelera.setIdCartelera(rs.getInt(1));
                PeliculaDao peliculaDao = new PeliculaDao();
                cartelera.setPelicula(peliculaDao.peliculaPorID(rs.getInt(2)));
                CineDao cineDao = new CineDao();
                cartelera.setCine(cineDao.cinePorID(rs.getInt(3)));
                cartelera.setTresD(rs.getInt(4));
                cartelera.setDoblada(rs.getInt(5));
                cartelera.setSubtitulada(rs.getInt(6));
                cartelera.setHorario(rs.getString(7));
                listaCartelera.add(cartelera);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaCartelera;

    }

    public void agregarFuncion(int idPelicula,int idCine, int es3D,String lenguaje, String horario){






    }

    public void borrarFuncion(int idCartelera){



    }

    public Cartelera obtenerCarteleraPorId(int idFuncion){
        String sql = "select * from cadena where idcartelera = ?";
        Cartelera cartelera = new Cartelera();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idFuncion);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                cartelera.setIdCartelera(rs.getInt(1));
                PeliculaDao peliculaDao = new PeliculaDao();
                cartelera.setPelicula(peliculaDao.peliculaPorID(rs.getInt(2)));
                CineDao cineDao = new CineDao();
                cartelera.setCine(cineDao.cinePorID(rs.getInt(3)));
                cartelera.setTresD(rs.getInt(4));
                cartelera.setDoblada(rs.getInt(5));
                cartelera.setSubtitulada(rs.getInt(6));
                cartelera.setHorario(rs.getString(7));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cartelera;
    }


}
