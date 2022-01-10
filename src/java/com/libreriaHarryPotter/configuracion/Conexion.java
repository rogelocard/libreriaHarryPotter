/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libreriaHarryPotter.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author cardo
 */
public class Conexion {
    
    Connection con;
    String url="jdbc:mysql://localhost:3306/libreria";
    String username="admin";
    String password="admin123";
    public Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println("hubo un error"+ e);
        }
        return con;
    }
    
    
}
