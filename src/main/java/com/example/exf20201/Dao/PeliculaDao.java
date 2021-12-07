package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cine;
import com.example.exf20201.Beans.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
