/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rfmoy
 */
public class Venta {
    Integer IdVenta;
    Integer Item;
    Integer IdCliente;
    Integer IdEmpleado;
    Integer IdProducto;
    String NumeroSerie;
    String DescripcionP;
    String fecha;
    Double precio;
    Integer cantidad;
    Double Subtotal;
    Double monto;
    String estado;

    public Venta() {
    }

    public Venta(Integer IdVenta, Integer Item, Integer IdCliente, Integer IdEmpleado, Integer IdProducto, String NumeroSerie, String DescripcionP, String fecha, Double precio, Integer cantidad, Double subtotal, Double monto, String estado) {
        this.IdVenta = IdVenta;
        this.Item = Item;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.IdProducto = IdProducto;
        this.NumeroSerie = NumeroSerie;
        this.DescripcionP = DescripcionP;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.Subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(Integer IdVenta) {
        this.IdVenta = IdVenta;
    }

    public Integer getItem() {
        return Item;
    }

    public void setItem(Integer Item) {
        this.Item = Item;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Integer IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public Integer getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(Integer IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.Subtotal = subtotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
