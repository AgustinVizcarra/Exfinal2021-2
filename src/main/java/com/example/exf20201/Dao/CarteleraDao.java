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

        String sql = "insert into cartelera() values (?,?,?,?,?,?)";
        Cartelera cartelera = new Cartelera();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idPelicula);
            pstmt.setInt(2,idCine);
            pstmt.setInt(3,es3D);

            if(lenguaje.equalsIgnoreCase("doblada")){
                pstmt.setInt(4,1);
                pstmt.setInt(5,0);
            }else if(lenguaje.equalsIgnoreCase("subtitulada")){
                pstmt.setInt(4,0);
                pstmt.setInt(5,1);
            }

            pstmt.setString(6,horario);

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void borrarFuncion(int idCartelera){
        String sql = "delete from cartelera  where idcartelera = ?";
        Cartelera cartelera = new Cartelera();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idCartelera);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Cartelera obtenerCarteleraPorId(int idFuncion){
        String sql = "select * from cartelera where idcartelera = ?";
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

    public void editarCartelera(int idFuncion,int idPelicula, int es3D,String lenguaje, String horario){



    }



}
