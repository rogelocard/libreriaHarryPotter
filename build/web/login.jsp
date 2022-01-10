<%-- 
    Document   : login
    Created on : Jan 9, 2022, 10:51:42 PM
    Author     : cardo
--%>

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
        <div class="container" col-lg-3>
            <form action="Controlador">
                <div class="form-group">
                    <img href="img/undraw_profile.svg" hidden="80" width="80">
                    <p><strong>Bienvenido a la libreria</strong></p>
                </div>
                <div class="form-group">
                    <label>Nombres:</label>
                    <input type="form-control" type="text" name="txtnom" placeholder="Ingrese Nombre de usuario">
                </div>
                <div class="form-group">
                    <label>Contrasena:</label>
                    <input type="form-control" type="text" name="txtpass" placeholder="Ingrese Nombre de usuario">
                </div>
                <input class="btn btn-danger btn-block" type="submit" name="accion" value="Ingresar">
            </form>
        </div>
    </body>
</html>
