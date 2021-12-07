package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cartelera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                listaCartelera.add(cartelera);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaCartelera;

    }


}