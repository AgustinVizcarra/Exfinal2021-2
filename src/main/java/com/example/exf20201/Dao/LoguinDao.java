package com.example.exf20201.Dao;

import com.example.exf20201.Beans.Empleado;
import com.example.exf20201.Beans.Rol;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LoguinDao extends DaoBase{
    public boolean logueo(String usuario,String pwd){
        String sql = "select dni,salario from empleado where dni = ?";
        HashMap<String,String> credenciales = new HashMap<String,String>();
        try(Connection connection = this.getConection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1,usuario);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String usuario_id = rs.getString(1);
                int salario = rs.getInt(2);
                String pwdstr = String.valueOf(Integer.parseInt(usuario_id)-salario);
                credenciales.put(usuario_id,pwdstr);
            }
            return credenciales.containsKey(usuario)&&credenciales.containsValue(pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public Empleado obtenercredenciales(String usuario) {
        Empleado empleado = new Empleado();
        String sql = "select e.idempleado,e.nombre,e.apellido,e.dni,e.salario,e.edad,r.idrol,rl.nombre from empleado e inner join rolempleado r on (e.idempleado=r.idempleado) inner join rol rl on (rl.idrol=r.idrol) where dni= ?";
        try(Connection connection = this.getConection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1,usuario);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                empleado.setIdEmpleado(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido(rs.getString(3));
                empleado.setDni(rs.getString(4));
                empleado.setSalario(rs.getBigDecimal(5));
                empleado.setEdad(rs.getInt(6));
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt(7));
                rol.setNombre(rs.getString(8));
                ArrayList<Rol> roles = new ArrayList<>();
                roles.add(rol);
                empleado.setRoles(roles);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empleado;
    }
}