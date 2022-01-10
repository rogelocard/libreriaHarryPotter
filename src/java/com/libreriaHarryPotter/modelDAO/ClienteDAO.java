/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libreriaHarryPotter.modelDAO;

import com.libreriaHarryPotter.configuracion.Conexion;
import com.libreriaHarryPotter.model.Cliente;
import com.libreriaHarryPotter.model.Validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cardo
 */
public class ClienteDAO implements Validar{
    
    // Variables para conectar con la base de datos
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    int response=0;
    
    @Override
    public int validar(Cliente cliente) {
        String sql="Select * from  where nombres=? and password=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                response=response+1;
                cliente.setNombres(rs.getString("nombres"));
                cliente.setPassword(rs.getString("password"));
            }
            if(response==1){
                return 1;
            }else{
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
    }
    
}
