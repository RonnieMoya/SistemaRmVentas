<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Productos" method="POST">

                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombre()}"  name="txtNombre" required class="form-control"> 
                        </div>

                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txtPrecio" required class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}"  name="txtStock" required class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEstado()}" name="txtEstado"required class="form-control"> 
                        </div>

                        <input type="submit" name="accion" value="Agregar" id="Agregar" class="btn btn-info"> 
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success"> 
                    </form>
                </div>
            </div>
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" items="${productos}">
                        <tr>
                            <th>${pro.getIdProducto()}</th>
                            <td>${pro.getNombre()}</td>
                            <td>${pro.getPrecio()}</td>
                            <td>${pro.getStock()}</td>
                            <td>${pro.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Productos&accion=Modificar&idProducto=${pro.getIdProducto()}">Modificar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Productos&accion=Eliminar&idProducto=${pro.getIdProducto()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div>    
        </div>                   
    </body>
</html>
