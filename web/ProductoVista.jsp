<%-- 
    Document   : ProductoVista
    Created on : 11/02/2022, 08:35:37 PM
    Author     : Alex
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width==device-width, initial-scale=1, shri">
        <title>Vista de productos</title>
    </head>
    <body>
        <div class="container">
            <div class="row"><h1>Productos</h1></div>
            <div class="row">
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Unidades</th>
                                <th>Valor</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="objP" items="${lista_productos}">
                                <tr>
                                    <td>${objP.getId_prod()}</td>                    
                                    <td>${objP.getNombre_prod()}</td>                    
                                    <td>${objP.getDescripcion_prod()}</td>                    
                                    <td>${objP.getUnd()}</td>                    
                                    <td>${objP.getValor()}</td>                    
                                    <td>
                                        <a type="button" class="btn btn-outline-success" style="height: 35px; width: 80px;" href="ProductoCTO?accion=ver&id=${objP.getId_prod()}">Ver</a>                  
                                        <a type="button" class="btn btn-outline-warning" style="height: 35px; width: 80px;" href="ProductoCTO?accion=editar&id=${objP.getId_prod()}">Editar</a>                    
                                        <a type="button" class="btn btn-outline-danger" style="height: 35px; width: 80px;" href="ProductoCTO?accion=eliminar&id=${objP.getId_prod()}">Eliminar</a>
                                    </td>                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
