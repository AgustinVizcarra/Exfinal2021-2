package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cartelera;
import com.example.exf20201.Beans.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PeliculaDao extends DaoBase{

    public ArrayList<Pelicula> listaPeliculas(){
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM movies.pelicula;";

        try (Connection connection = this.getConection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sentenciaSQL)) {
            while (rs.next()){
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
