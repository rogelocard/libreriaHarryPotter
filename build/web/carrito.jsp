<%-- 
    Document   : carrito
    Created on : Jan 8, 2022, 1:27:08 AM
    Author     : cardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- CDN de framework Bootstap para estilos-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- CDN de libreria para usar iconos Boxicon.com-->
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="Controlador?accion=home">Harry Books - Tienda Online</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <button class="btn btn-outline-success" type="submit"><a class="nav-link" href="Controlador?accion=home">Seguir Comprando</a></button>
                  </li>
                </ul>
              </div>
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Iniciar Session
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="#">Iniciar Session</a></li>
                      <li><a class="dropdown-item" href="#">Mis compras</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Salir</a></li>
                    </ul>
                  </li>
              </ul>
            </div>
        </nav>
        <div class="container mt-4">
            <h3><i class='bx bx-cart-alt'></i>Carrito de compras</h3>
            <br/>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead class="table-light">
                          <tr>
                            <th scope="col">Acciones</th>
                            <th scope="col">Item</th>
                            <th scope="col">Libros</th>
                            <th scope="col">Cantidad</th>
                            <th scope="col">Valor Unitario</th>
                            <th scope="col">Valor Total</th>
                          </tr>
                        </thead>
                        <tbody>
                            
                          <c:forEach var="car" items="${carrito}">
                              <tr>
                                <td>
                                  <input type="hidden" id="idbook" value="${car.getIdlibro()}">
                                  <a href="" id="btnDelete" style="text-decoration: none">Eliminar</a>
                                </td>
                                <th scope="row">${car.getItem()}</th>
                                <td>${car.getNombres()}</td>
                                <td>
                                    <input type="hidden" id="idlib" value="${car.getIdlibro()}" class="form-control text-center" min="1">
                                    <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                                </td>
                                <td>$${car.getPrecioCompra()}0</td>
                                <td>$${car.getSubTotal()}0</td>
              
                              </tr>
                          </c:forEach>
                            
                          
                          
                        </tbody>
                      </table>
                      
                      <div class="float-end" style="margin-right: 40px;">
                          Valor total de compra: <span style="font-weight: bold; margin-left: 5px;">$${subTotal}0</span>
                      </div>
                      <br>
                      <hr>
                      <div>
                        <a href="Controlador?accion=GenerarCompra" class="btn btn-info btn-block float-end">Confirmar Compra</a>
                        <a href="Controlador?accion=GenerarCompra" class="btn btn-danger btn-block float-start">Cancelar Compra</a>
                      </div>
                </div>
            </div>
        </div>
    <!-- Libreria JQuery https://code.jquery.com/ -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    
    <!-- CDN Sweet Alert para los prompts y alertars: https://sweetalert.js.org/guides/-->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <!-- Archivo JavaScript con Funciones -->
    <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>
