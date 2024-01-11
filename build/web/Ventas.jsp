<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Administracion de Ventas</title>
        <style>
            @media print
            {
                .parte01, .btn, .accion{
                    display:none;
                }
            }
        </style>    
    </head>
    <body>
        <div class="d-flex">

            <div class="col-sm-4 parte01">
                <div class="card">
                    <form action="Controlador?menu=Ventas" method="POST">
                        <div class="card-body">

                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-12 d-flex"> 
                                    
                                    <input type="text" name="codigoCliente" value="${c.getRut()}" required class="form-control" placeholder="RutCliente"> 
                                    <input type="submit" name="accion" value="BuscarC" class="btn btn-outline-info">

                                    <div class="col-sm-6">
                                        <input type="text" value="${c.getNombres()}" name="nombresCliente" class="form-control" placeholder="Datos del Cliente">
                                    </div><br>

                                </div>


                            </div>
                        </div>
                                  
                    </form>
                    <form action="Controlador?menu=Ventas" method="POST">                
                        <div class="card-body">                
                            <div class="form-group">
                                <label>Datos del Producto</label>

                            </div>
                            <!--Datos del Producto -->         
                            <div class="form-group d-flex ">
                                <div class="col-sm- d-flex col-sm-12">

                                    <input type="number" name="codigoProducto" value="${producto.getIdProducto()}" required value="0" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarP" class="btn btn-outline-info">BuscarP</button>


                                    <div class="col-sm-6">
                                        <input type="text" name="nombreProducto" value="${producto.getNombre()}" class="form-control" placeholder="Producto">
                                    </div>

                                </div>
                            </div><br>    

                            <div class="form-group d-flex">
                                <div class="col-sm-6 ">
                                    
                                    <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$ Precio">
                                </div>
                                <div class="col-sm-3">
                                    
                                    <input type="number" name="cantidad" value="1" class="form-control" placeholder="0">
                                </div> 
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock" >
                                </div>
                            </div>
                            <!--Boton agregar producto -->
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</button>
                                </div>

                            </div>

                        </div>
                     </form> 

                </div>
            </div>

            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>N°Serie</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>   
                        <br>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nro</th>
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>SubTotal</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdProducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                       
                                        <a href="Controlador?menu=Ventas&accion=EliminarLista&Item=${list.getItem()}" class="btn btn-danger" style="margin-left: 10px">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>

                <div class="card-footer d-flex">
                    <div class="col-sm-4">
                        <a href="Controlador?menu=Ventas&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                        <a href="Controlador?menu=Ventas&accion=Cancelar" " class="btn btn-danger">Cancelar</a>
                        
                    </div>
                    <div class="col-sm-3 ml-auto d-flex">
                        <label>Neto:</label>
                        <input type="text" name="txtNeto" value=" ${neto}" class="form-control">
                        
                    </div>
                         <div class="col-sm-2 ml-auto d-flex">
                        <label>Iva:</label>
                        <input type="text" name="txtNeto" value=" ${iva}" class="form-control">
                        
                    </div>
                    <div class="col-sm-3 ml-auto d-flex">
                        <label>Total:</label>
                        <input type="text" name="txtTotal" value= ${totalApagar} class="form-control">
                        
                    </div>
                </div>
            </div>

        </div>



        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
