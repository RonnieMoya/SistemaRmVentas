<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-expand-lg nvbar-light bg-info">
            <div class="container-fluid">
                  
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?menu=Home"target="myFrame">Home</a>
                        </li>
                       
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?menu=Productos&accion=Listar"target="myFrame" >Productos</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?menu=Usuarios&accion=Listar"target="myFrame" >Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar"target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="Controlador?menu=Ventas&accion=default"target="myFrame">NuevaVenta</a>
                            
                        </li>
                    </ul>

                </div>
                 
                <div class="dropdown">
                    <img src="Imagenes/user_person_people_6100.png" alt="10" width="50"/>
                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown">
                     ${usuario.getNombres()}
                    </button>    
                        
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                             
                        </a>
                        <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                        <a class="dropdown-item" href="#">${usuario.getUser()}@gmail.com</a>
                        <div class="dropdown-divider"> </div>
                        <form action="Validar" method="POST">
                          <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>  
                        </form>
                        
                    </div>
                </div>
            </div>
                       
        </nav>
                        <div class="m-4" style="height: 650px;width: ">
                            <div class="d-flex col-sm-12 ">
                                <img class="col-sm-2"src="Imagenes/Palabra Ventas.jpeg" alt="70" width="170" />  
                                <h1 class="text-center text-info col-sm-10 " > Sistema de Ventas</h1>
                            </div>
                            
                           
                    
                            <iframe name="myFrame" style="height: 100%;width: 100%; border: none">
                                
                            </iframe>
                        </div>            
                        
         
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
