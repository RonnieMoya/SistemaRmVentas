<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Administracion de Usuarios</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Usuarios" method="POST">
                        <div class="form-group">
                            <label>Rut</label>
                            <input type="text" value="${usuario.getRut()}" name="txtRut" required class="form-control"> 
                        </div> 
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${usuario.getNombres()}"  name="txtNombres" required class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text" value="${usuario.getApellidos()}" name="txtApellidos" required class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${usuario.getTelefono()}" name="txtTelefono" required  class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${usuario.getEstado()}" name="txtEstado" required  class="form-control"> 
                        </div>
                        <div class="form-group">
                            <label>Nombre Usuario</label>
                            <input type="text" value="${usuario.getUser()}"  name="txtUsuario" required  class="form-control"> 
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
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>User</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usu" items="${usuarios}">
                        <tr>
                            <th>${usu.getIdEmpleado()}</th>
                            <td>${usu.getRut()}</td>
                            <td>${usu.getNombres()}</td>
                            <td>${usu.getApellidos()}</td>
                            <td>${usu.getTelefono()}</td>
                            <td>${usu.getEstado()}</td>
                            <td>${usu.getUser()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Usuarios&accion=Modificar&idEmpleado=${usu.getIdEmpleado()}">Modificar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Usuarios&accion=Eliminar&idEmpleado=${usu.getIdEmpleado()}">Eliminar</a>
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
