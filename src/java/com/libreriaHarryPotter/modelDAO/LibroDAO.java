/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libreriaHarryPotter.modelDAO;

import com.libreriaHarryPotter.configuracion.Conexion;
import com.libreriaHarryPotter.model.Libro;
import com.libreriaHarryPotter.model.Libro;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cardo
 */
public class LibroDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    // Metdodo para listar por ID
    public Libro listarId(int id){
        String sql="select * from libro where idlibro="+id;
        Libro libro = new Libro();
        try {
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               libro.setIdlibro(rs.getInt(1));
               libro.setTitulo(rs.getString(2));
               libro.setCantidadStock(rs.getInt(3));
               libro.setPrecio(rs.getDouble(4));
               libro.setFoto(rs.getBinaryStream(5));
           }
        } catch (Exception e) {
            
        }
        return libro;
    }
    /*
    public void deleteLibro(int id){
        String sql="delete from libro where idLibro="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }*/
    
    // Metodo listar...
    public List listar(){
        List<Libro> libros = new ArrayList();
        String sql="select * from libro";
        try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while (rs.next()) {
               
               Libro libro = new Libro();
               
               libro.setIdlibro(rs.getInt(1));
               libro.setTitulo(rs.getString(2));
               libro.setCantidadStock(rs.getInt(3));
               libro.setPrecio(rs.getDouble(4));
               libro.setFoto(rs.getBinaryStream(5));
               libros.add(libro);
           }
        } catch (Exception e){
            
        }
        return libros;
    }
    
    public void listarImg(int id, HttpServletResponse response){
        String sql="select * from libro where idlibro="+ id;
        
        InputStream inputStream = null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try{
            outputStream= response.getOutputStream();
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if(rs.next()) {
                inputStream=rs.getBinaryStream("foto");
            }
            bufferedInputStream =new BufferedInputStream(inputStream);
            bufferedOutputStream =new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
            
        } catch (Exception e){
            
        }
    }
    
    /*
    public void condicionalPrecio(){
        
    }*/
    
    
}
