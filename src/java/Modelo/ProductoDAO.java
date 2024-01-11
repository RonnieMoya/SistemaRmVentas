/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rfmoy
 */
public class ProductoDAO {
    
    Conexion cn =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    int p;
 
    public Producto buscar (int id)
    {
        Producto p=new Producto();
        
        String sql="select * from producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        
        return p;
    }
    
    public int actualizarStock(int id,int stock)
    {
        String sql="update producto set Stock=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,stock );
            ps.setInt(2,id );
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return resp;
    }
    
     public List listar()
    {
        String sql="select * from producto";
        List<Producto>lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Producto producto = new Producto();
                
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setNombre(rs.getString("Nombre"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setStock(rs.getInt("Stock")); 
                producto.setEstado(rs.getString("Estado"));
                
                lista.add(producto);

            }
        } catch (SQLException ex) {
            
        }
        return lista;

        
    }
    
    public int agregar(Producto prod)
    {
        String sql="insert into producto(Nombre,Precio,Stock,Estado)values(?,?,?,?)";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            
            ps.setString(1, prod.getNombre());
            ps.setDouble(2, prod.getPrecio());
            ps.setInt   (3, prod.getStock());
            ps.setString(4, prod.getEstado());
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp;
        
        
    }
    
    public Producto listarId(int IdProducto){
        Producto pro = new Producto();
        String sql="select * from producto where IdProducto="+IdProducto;
        
        try {
            
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {   
                pro.setIdProducto(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getDouble(3));
                pro.setStock(rs.getInt(4));
                pro.setEstado(rs.getString(5));
                
            }
            
        } catch (Exception e) {
        }
        return pro;
    }   
    
    public int actualizar(Producto pr){
        
       String sql="update producto set Nombre=?,Precio=?,Stock=?,Estado=? where IdProducto=?";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setDouble(2, pr.getPrecio());
            ps.setInt(3, pr.getStock());
            ps.setString(4, pr.getEstado());
            ps.setInt(5, pr.getIdProducto() );
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp; 
    }
    
    public void eliminar(int IdProducto)
    {
        String sql="delete from producto where IdProducto="+IdProducto;
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        
    }
  
}
