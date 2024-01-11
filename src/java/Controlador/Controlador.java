/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.GenerarNumSerie;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rfmoy
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Usuario usu = new Usuario();
    UsuarioDAO usuDAO = new UsuarioDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();

    int IdCliente;
    int IdProducto;
    int idEmpleado;
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double iva;
    double neto;
    String numeroSerie;
    VentasDAO vdao = new VentasDAO();
    double totalApagar;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {

            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
        if (menu.equals("Reportes")) {
            request.getRequestDispatcher("Reportes.jsp").forward(request, response);
        }

        if (menu.equals("Productos")) {

            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);

                    break;
                case "Agregar":

                    String Nombre = request.getParameter("txtNombre");
                    Double Precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int Stock = Integer.parseInt(request.getParameter("txtStock"));
                    String Estado = request.getParameter("txtEstado");

                    p.setNombre(Nombre);
                    p.setPrecio(Precio);
                    p.setStock(Stock);
                    p.setEstado(Estado);
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
                    break;
                case "Modificar":

                    IdProducto = Integer.parseInt(request.getParameter("idProducto"));
                    Producto pr = pdao.listarId(IdProducto);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":
                   
                    
                    String Nombre1 = request.getParameter("txtNombre");
                    Double Precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int Stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String Estado1 = request.getParameter("txtEstado");
                    p.setNombre(Nombre1);
                    p.setPrecio(Precio1);
                    p.setStock(Stock1);
                    p.setEstado(Estado1);

                    p.setIdProducto(IdProducto);
                    pdao.actualizar(p);

                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    IdProducto = Integer.parseInt(request.getParameter("idProducto"));
                    pdao.eliminar(IdProducto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Usuarios")) {

            switch (accion) {
                case "Listar":
                    List lista = usuDAO.listar();
                    request.setAttribute("usuarios", lista);

                    break;
                case "Agregar":

                    String Rut = request.getParameter("txtRut");
                    String Nombres = request.getParameter("txtNombres");
                    String Apellidos = request.getParameter("txtApellidos");
                    String Telefono = request.getParameter("txtTelefono");
                    String Estado = request.getParameter("txtEstado");
                    String Usuario = request.getParameter("txtUsuario");

                    usu.setRut(Rut);
                    usu.setNombres(Nombres);
                    usu.setApellidos(Apellidos);
                    usu.setTelefono(Telefono);
                    usu.setEstado(Estado);
                    usu.setUser(Usuario);
                    usuDAO.agregar(usu);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
                    break;

                case "Modificar":

                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    Usuario us = usuDAO.listarId(idEmpleado);
                    request.setAttribute("usuario", us);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":

                    String Rut1 = request.getParameter("txtRut");
                    String Nombres1 = request.getParameter("txtNombres");
                    String Apellidos1 = request.getParameter("txtApellidos");
                    String Telefono1 = request.getParameter("txtTelefono");
                    String Estado1 = request.getParameter("txtEstado");
                    String Usuario1 = request.getParameter("txtUsuario");

                    usu.setRut(Rut1);
                    usu.setNombres(Nombres1);
                    usu.setApellidos(Apellidos1);
                    usu.setTelefono(Telefono1);
                    usu.setEstado(Estado1);
                    usu.setUser(Usuario1);
                    usu.setIdEmpleado(idEmpleado);
                    usuDAO.actualizar(usu);

                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    usuDAO.eliminar(idEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);

        }

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);

                    break;

                case "Agregar":

                    String Rut = request.getParameter("txtRut");
                    String Nombres = request.getParameter("txtNombres");
                    String Direccion = request.getParameter("txtDireccion");
                    String Estado = request.getParameter("txtEstado");

                    c.setRut(Rut);
                    c.setNombres(Nombres);
                    c.setDireccion(Direccion);
                    c.setEstado(Estado);
                    cdao.agregar(c);

                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;

                case "Modificar":

                    IdCliente = Integer.parseInt(request.getParameter("IdCliente"));
                    Cliente cli = cdao.listarId(IdCliente);
                    request.setAttribute("cliente", cli);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":

                    String Rut1 = request.getParameter("txtRut");
                    String Nombres1 = request.getParameter("txtNombres");
                    String Direccion1 = request.getParameter("txtDireccion");
                    String Estado1 = request.getParameter("txtEstado");

                    c.setRut(Rut1);
                    c.setNombres(Nombres1);
                    c.setDireccion(Direccion1);
                    c.setEstado(Estado1);

                    c.setIdCliente(IdCliente);
                    cdao.actualizar(c);

                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    IdCliente = Integer.parseInt(request.getParameter("IdCliente"));
                    cdao.eliminar(IdCliente);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("Ventas")) {
            request.setAttribute("totalApagar", totalApagar);
            switch (accion) {
                case "BuscarC":
                    String rut = request.getParameter("codigoCliente");

                    c.setRut(rut);
                    c = cdao.buscar(rut);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroSerie);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalApagar", totalApagar);
                    break;

                case "BuscarP":

                    IdProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                    p = pdao.listarId(IdProducto);
                    request.setAttribute("c", c);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroSerie);
                    request.setAttribute("totalApagar", totalApagar);

                    break;

                case "Agregar":

                    request.setAttribute("lista", lista);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroSerie);
                    neto = 0.0;
                    iva = 0.0;
                    totalApagar = 0.0;
                    item = item + 1;
                    cod = p.getIdProducto();
                    descripcion = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    subtotal = precio * cant;

                    v = new Venta();

                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);

                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {

                        totalApagar = totalApagar + lista.get(i).getSubtotal();
                        neto = totalApagar * 1 / 1.19;
                        iva = neto * 0.19;

                    }
                    request.setAttribute("neto", neto);
                    request.setAttribute("iva", iva);
                    request.setAttribute("totalApagar", totalApagar);
                    request.setAttribute("lista", lista);

                    break;
                case "GenerarVenta":
                    //Actualizar Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idProducto = lista.get(i).getIdProducto();
                        ProductoDAO dao = new ProductoDAO();
                        pr = dao.buscar(idProducto);
                        int stockActual = pr.getStock() - cantidad;
                        dao.actualizarStock(idProducto, stockActual);
                    }
                    //Guardar Venta
                    v = new Venta();
                    v.setIdCliente(c.getIdCliente());
                    v.setIdEmpleado(1);
                    v.setNumeroSerie(numeroSerie);
                    v.setFecha("2023-12-18");
                    v.setMonto(totalApagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    int idv = Integer.parseInt(vdao.IdVenta());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setIdVenta(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());

                        vdao.GuardarDetalleVenta(v);
                    }
                    lista.clear();
                    break;
                case "Cancelar":

                    lista.clear();
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroSerie);
                    break;
                case "EliminarLista":
  
                    item = Integer.parseInt(request.getParameter("Item"));

                    for (int i = 0; i < lista.size(); i++) {

                        if (lista.get(i).getItem() == item) {
                            lista.remove(i);

                        }
                        request.setAttribute("nserie", numeroSerie);
                    }
                   
                    
                   
                    request.setAttribute("lista", lista);
                    request.setAttribute("c", c);
                    request.setAttribute("nserie", numeroSerie);
                    break;

                default:
                    numeroSerie = vdao.generarSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarNumSerie gs = new GenerarNumSerie();
                        numeroSerie = gs.NumSerie(incrementar);
                        request.setAttribute("nserie", numeroSerie);
                    }
                    request.getRequestDispatcher("Ventas.jsp").forward(request, response);

            }
            request.getRequestDispatcher("Ventas.jsp").forward(request, response);

        }

    }

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
