package com.libreriaHarryPotter.modelDAO;

import com.libreriaHarryPotter.configuracion.Conexion;
import com.libreriaHarryPotter.model.Carrito;
import com.libreriaHarryPotter.model.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author RogerCardo
 */
public class CompraDAO {
    
    // Variables para conectar con la base de datos
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    // variable de tipo entero para checkear respuestas...
    int response = 0;
    
    public int GenerarCompra(Compra compra){
        int idcompras;
        String sql= "insert into compras(idcliente, idpago, FechaCompra, cantidad, valorTotal)values(?,?,?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            //Statements para insertar parametros como datos en la base de datos
            ps.setInt(1, compra.getCliente().getId());
            ps.setInt(2, compra.getIdpago());
            ps.setString(3, compra.getFechaCompra());
            ps.setInt(4, compra.getCantidad());
            ps.setDouble(5, compra.getValorTotal());
            response=ps.executeUpdate();
            
            // Detalles de la compra
            sql="Select @@IDENTITY AS idcompras";
            rs=ps.executeQuery(sql);
            rs.next();
            idcompras=rs.getInt("idcompras");
            rs.close();
            
            for (Carrito detalle : compra.getDetallecompras()) {
                sql="insert into detallecompras(idlibro, idcompras, cantidad, precioCompra)values(?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdlibro());
                ps.setInt(2, idcompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getSubTotal());
                response=ps.executeUpdate();
                
            }   
                
        } catch (Exception e) {
            
        }
        return response;
    }
}
