package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cine;
import com.example.exf20201.Beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao extends DaoBase{
    public Pelicula peliculaPorID(int idPelicula){
        String sql = "select * from pelicula where idpelicula = ?";
        Pelicula pelicula = new Pelicula();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idPelicula);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setNombre(rs.getString(2));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pelicula;
    }

    public ArrayList<Pelicula> listaPeliculas(){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM movies.pelicula;";

        try (Connection connection = this.getConection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sentenciaSQL)) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setNombre(rs.getString(2));
                listaPeliculas.add(pelicula);
            }
        }catch (SQLException e){
           e.printStackTrace();
       }
        return listaPeliculas;
     }
}
