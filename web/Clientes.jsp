<%-- 
    Document   : Clientes
    Created on : 24-09-2023, 22:33:32
    Author     : rfmoy
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Administracion de Clientes</title>
    </head>
    <body>
       
       
   
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="POST">
                        <div class="form-group">
                            <label>Rut</label>
                            <input type="text" value="${cliente.getRut()}" name="txtRut" class="form-control"> 
                        </div> 
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${cliente.getNombres()}"  name="txtNombres" class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control"> 
                        </div>
                        
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control"> 
                        </div>
                        
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info"> 
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success"> 
                    </form>
                </div>
            </div>
            <div class="col-sm-9">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Rut</th>
                            <th>Nombres</th>
                            <th>Direccion</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cli" items="${clientes}">
                        <tr>
                            <th>${cli.getIdCliente()}</th>
                            <td>${cli.getRut()}</td>
                            <td>${cli.getNombres()}</td>
                            <td>${cli.getDireccion()}</td>
                            <td>${cli.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Modificar&IdCliente=${cli.getIdCliente()}">Modificar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Clientes&accion=Eliminar&IdCliente=${cli.getIdCliente()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>    
    </body>
</html>
