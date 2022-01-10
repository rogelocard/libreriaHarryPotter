<%-- 
    Document   : index
    Created on : Jan 8, 2022, 1:19:17 AM
    Author     : cardo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <span><a class="navbar-brand mb-0 h1" href="Controlador?accion=home">Harry Books - Tienda Online</a></span>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active mb-auto" aria-current="page" href="Controlador?accion=home">Libros Disponibles</a>
                  </li>
                  <li class="nav-item">
                    <button class="btn btn-outline-success" type="submit">
                      <a class="nav-link" href="Controlador?accion=Carrito">
                        <i class='bx bx-cart-alt'>(<label style="color:darkorange">${contador}</label>)</i>  
                        Carrito de Compras
                      </a>
                    </button>
                  </li>
                </ul>
              </div>
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Iniciar Session
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="Controlador?accion=Ingresar">Iniciar Session</a></li>
                      <li><a class="dropdown-item" href="#">Mis compras</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#">Salir</a></li>
                    </ul>
                  </li>
              </ul>
            </div>
        </nav>
        <h5 style="margin-top: 25px; margin-left: 15px;">Libros Disponibles</h5>
        <div class="container mt-5"></div>
          <div class="row">
              <c:forEach var="libro" items="${libros}">
                  <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <div class="card-header">
                                <h5>${libro.getTitulo()}</h5>
                            </div>
                            <div class="card-body">
                                <img src="ControladorIMG?id=${libro.getIdlibro()}" width="150" height="180" style="align-content: center;">
                                <label> Cántidad disponible: ${libro.getCantidadStock()} </label>
                                <p>Precio: $${libro.getPrecio()}0</p>
                                <label>Agregar al carrito: </label>
                                <input type="hidden" id="idlib" value="${car.getIdlibro()}" class="form-control text-center" min="1">
                                <input type="number" id="Cantidad" value="${car.getCantidad()}0" class="form-control text-center" min="1">
                            </div>
                            <div class="card-footer text-center">
                                <div>
                                    <a href="Controlador?accion=AgregarCarrito&id=${libro.getIdlibro()}" class="btn btn-outline-info">Agregar</a>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div>
              </c:forEach>
          </div>  
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
