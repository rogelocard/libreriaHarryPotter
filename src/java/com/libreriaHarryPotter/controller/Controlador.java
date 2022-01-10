package com.libreriaHarryPotter.controller;

import com.libreriaHarryPotter.configuracion.Fecha;
import com.libreriaHarryPotter.model.Carrito;
import com.libreriaHarryPotter.model.Cliente;
import com.libreriaHarryPotter.model.Compra;
import com.libreriaHarryPotter.model.Libro;
import com.libreriaHarryPotter.model.Pago;
import com.libreriaHarryPotter.modelDAO.ClienteDAO;
import com.libreriaHarryPotter.modelDAO.CompraDAO;
import com.libreriaHarryPotter.modelDAO.LibroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cardo
 */
public class Controlador extends HttpServlet {
    
    ClienteDAO clientedao=new ClienteDAO();
    Cliente c=new Cliente();
    int r;
    
    LibroDAO libro = new LibroDAO(); // // Instancia de la clase  LibroDAO
    
    Libro l= new Libro(); // Referencia a la entidad producto
    
    List<Libro> libros = new ArrayList<>();
    
    List<Carrito> listaCarrito= new ArrayList<>();
    int item;
    int idlibro;
    String nombres;
    double precioCompra; // precio
    int cantidad=1;
    double subTotal=0.00; // total a pagar
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String accion=request.getParameter("accion");
            
            // metodo de validacion de Usuario para Login
            if(accion.equals("Ingresar")){
                String nom=request.getParameter("txtnom");
                String contra=request.getParameter("txtpass");
                c.setNombres(nombres);
                c.setPassword(contra);
                r=clientedao.validar(c);
                if(r==1){
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            
            libros = libro.listar();
            
            switch (accion) {
                // captura del ID que se quiere anadir al carrito
                case "AgregarCarrito":
                    int posicion = 0;
                    cantidad = 1;
                    
                    int idlibro=Integer.parseInt(request.getParameter("id"));
                    
                    l=libro.listarId(idlibro);
                    
                    if (listaCarrito.size() > 0) {
                        for(int i=0; i < listaCarrito.size(); i++) {
                            if(idlibro==listaCarrito.get(i).getIdlibro()){
                                posicion=i;
                            }
                        }
                        if(idlibro==listaCarrito.get(posicion).getIdlibro()){
                            cantidad=listaCarrito.get(posicion).getCantidad()+cantidad;
                            double subtotal = listaCarrito.get(posicion).getPrecioCompra()*cantidad;
                            listaCarrito.get(posicion).setCantidad(cantidad);
                            listaCarrito.get(posicion).setSubTotal(subtotal);
                        }else{
                            item= item + 1;
                    
                            Carrito car=new Carrito();
                            car.setItem(item);
                            car.setIdlibro(l.getIdlibro());
                            car.setNombres(l.getTitulo());
                            car.setPrecioCompra(l.getPrecio()); // Valor unitario
                            car.setCantidad(cantidad);
                            car.setSubTotal(cantidad*l.getPrecio()); // Formula para calcular el valor total. 
                            listaCarrito.add(car);
                        }
                    } else {
                        item = item + 1;
                    
                        Carrito car=new Carrito();
                        car.setItem(item);
                        car.setIdlibro(l.getIdlibro());
                        car.setNombres(l.getTitulo());
                        car.setPrecioCompra(l.getPrecio()); // Valor unitario
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*l.getPrecio()); // Formula para calcular el valor total. 
                        listaCarrito.add(car);
                    }
                    
            
                    
                    // Variable contador para saber cuantos libros se van acumulando...
                    
                    request.setAttribute("contador", listaCarrito.size());
                    
                    // vamos a seguir mostrando los libros... request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                    request.getRequestDispatcher("Controlador?accion=home").forward(request, response); 
                    
                    break;
                
                case "Delete":
                    int idHarryBook=Integer.parseInt(request.getParameter("idbook")); // "idlibro" o btnDelete
                    for (int i=0; i < listaCarrito.size(); i++) {
                        if(listaCarrito.get(i).getIdlibro()==idHarryBook) {
                            listaCarrito.remove(i);
                        }
                    }
                    
                    break;
                    
                case "ActualizarCantidad":
                    int idlib= Integer.parseInt(request.getParameter("idl"));
                    int amount = Integer.parseInt(request.getParameter("Cantidad"));
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if(listaCarrito.get(i).getIdlibro()==idlib){
                            listaCarrito.get(i).setCantidad(amount);
                            double nuevaCantidad=listaCarrito.get(i).getPrecioCompra()*amount;
                            listaCarrito.get(i).setSubTotal(nuevaCantidad);
                        }
                    }
                    
                case "Carrito":
                    subTotal = 0.00;
                    request.setAttribute("carrito", listaCarrito); // atributo carrito que vendra de la lista
                    // Bucle para sumar la column subtotal...
                    for (int i = 0; i < listaCarrito.size(); i++ ) {
                      subTotal= subTotal + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("subTotal", subTotal); 
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                    break;
                
                case "GenerarCompra":
                    Cliente cliente=new Cliente();
                    cliente.setId(1); // Cliente generado manualmente en bd con ID = 1
                    CompraDAO dao=new CompraDAO();
                    Compra compra= new Compra(cliente, 1, Fecha.fechaBD(), cantidad, subTotal, listaCarrito);
                    int res=dao.GenerarCompra(compra);
                    if(res!=0&&subTotal>0) {
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
                
                default:
                   request.setAttribute("libros", libros);
                   request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
