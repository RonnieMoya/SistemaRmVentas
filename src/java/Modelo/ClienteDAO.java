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
public class ClienteDAO {
    
    Conexion cn =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Cliente buscar(String rut)
    {   
        
        Cliente cliente=new Cliente();
        
        String sql= "select * from cliente where Rut=?";
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setRut(rs.getString("Rut"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
            }
           
            
        } 
        catch (Exception e)
        {
            
        }
        return cliente;
    }
    
    public List listar()
    {
        String sql="select * from cliente";
        List<Cliente>lista=new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setRut(rs.getString("Rut"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setEstado(rs.getString("Estado"));
                lista.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

        
    }
    
    public int agregar(Cliente clien)
    {
        String sql= "insert into cliente (Rut,Nombres,Direccion,Estado)values(?,?,?,?)";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, clien.getRut());
            ps.setString(2, clien.getNombres());
            ps.setString(3, clien.getDireccion());
            ps.setString(4, clien.getEstado());
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp;
        
        
    }
    
    public Cliente listarId(int IdCliente){
        Cliente clie = new Cliente();
        String sql="select * from cliente where IdCliente="+IdCliente;
        
        try {
            
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {   
                
                clie.setRut(rs.getString(2));
                clie.setNombres(rs.getString(3));
                clie.setDireccion(rs.getString(4));
                clie.setEstado(rs.getString(5));
                
            }
            
        } catch (Exception e) {
        }
        return clie;
    }   
    
    public int actualizar(Cliente cli){
        
       String sql="update cliente set Rut=?, Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getRut());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setInt(5, cli.getIdCliente() );
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp; 
    }
    
    public void eliminar(int IdCliente)
    {
        String sql="delete from cliente where idCliente="+IdCliente;
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        
    }
}
