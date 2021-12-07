package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Cadena;
import com.example.exf20201.Beans.Cine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadenaDao extends DaoBase{
    public Cadena cadenaPorID(int idCadena){
        String sql = "select * from cadena where idcadena = ?";
        Cadena cadena = new Cadena();
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idCadena);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                cadena.setIdCadena(rs.getInt(1));
                cadena.setRazonSocial(rs.getString(2));
                cadena.setNombreComercial(rs.getString(3));
                cadena.setRuc(rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cadena;
    }
}
