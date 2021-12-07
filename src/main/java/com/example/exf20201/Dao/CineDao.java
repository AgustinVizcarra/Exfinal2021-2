package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cadena;
import com.example.exf20201.Beans.Cine;
import com.example.exf20201.Beans.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CineDao extends DaoBase{

    public ArrayList<Cine> listaCines(){
        ArrayList<Cine> listaCines = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM movies.cine;";

        try (Connection connection = this.getConection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sentenciaSQL)) {
            while (rs.next()){
                Cine cine = new Cine();
                cine.setIdCine(rs.getInt(1));
                cine.setNombre(rs.getString(2));

                Cadena cadena = new Cadena();
                cadena.setIdCadena(rs.getInt(3));

                cine.setCadena(cadena);

                listaCines.add(cine);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaCines;

    }
}
