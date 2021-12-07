package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cadena;
import com.example.exf20201.Beans.Cartelera;
import com.example.exf20201.Beans.Cine;

import java.sql.*;
import java.util.ArrayList;

public class CineDao extends DaoBase{
    public Cine cinePorID(int idCine){
        String sql = "select * from cine where idcine = ?";
        Cine cine = new Cine();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idCine);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                cine.setIdCine(rs.getInt(1));
                cine.setNombre(rs.getString(2));
                CadenaDao cadenaDao = new CadenaDao();
                cine.setCadena(cadenaDao.cadenaPorID(rs.getInt(3)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return cine;

    }

    public ArrayList<Cine> listaCines() {
        ArrayList<Cine> listaCines = new ArrayList<>();
        String sentenciaSQL = "SELECT * FROM movies.cine;";

        try (Connection connection = this.getConection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sentenciaSQL)) {
            while (rs.next()) {
                Cine cine = new Cine();
                cine.setIdCine(rs.getInt(1));
                cine.setNombre(rs.getString(2));

                Cadena cadena = new Cadena();
                cadena.setIdCadena(rs.getInt(3));

                cine.setCadena(cadena);

                listaCines.add(cine);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCines;

    }
    }
