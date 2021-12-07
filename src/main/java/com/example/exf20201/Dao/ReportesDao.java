package com.example.exf20201.Dao;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportesDao extends DaoBase{
    public ArrayList<Integer> listarReportes(){
        ArrayList<Integer> estadisticas = new ArrayList<>();
        String sql1= "select count(*) from empleado where idjefe is null";
        try(Connection connection = this.getConection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql1)){
            if(rs.next()) {
                estadisticas.add(rs.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql2= "select count(*) from cartelera where 3d=1";
        try(Connection connection = this.getConection();
            Statement statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(sql2)){
            if(rs.next()){
                estadisticas.add(rs.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql3="select count(*) from empleado where salario>9700 group by idcine";
        ArrayList<Integer> aux  = new ArrayList<>();
        try(Connection connection = this.getConection();
            Statement statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(sql3)){
            while(rs.next()){
                aux.add(rs.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        estadisticas.add(aux.size());
        return estadisticas;
    }
    public String cineMaxCartelera(){
        String cine = "";
        String sql="select nombre from cine where idcine=(select idcine from cartelera group by idcine order by count(*) desc limit 1)";
        try(Connection connection= this.getConection();
            Statement statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(sql)){
            if(rs.next()){
                cine=rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cine;
    }
}
