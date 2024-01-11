/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.ResultSet;
;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author rfmoy
 */


public class VentasDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String generarSerie() {
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {

        }

        return numeroserie;
    }

    public String IdVenta() {
        String idventas = "";
        String sql = "select max(IdVentas) from ventas";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idventas;
    }

    public int guardarVenta(Venta ve) 
    {
        String sql = "insert into ventas (IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, ve.getIdCliente());
            ps.setInt(2, ve.getIdEmpleado());
            ps.setString(3, ve.getNumeroSerie());
            ps.setString(4,ve.getFecha());
            ps.setDouble(5,ve.getMonto());
            ps.setString(6, ve.getEstado());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    public int GuardarDetalleVenta(Venta venta)
    {
        String sql = "insert into detalle_ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getIdVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4,venta.getPrecio());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }
    
    
}

