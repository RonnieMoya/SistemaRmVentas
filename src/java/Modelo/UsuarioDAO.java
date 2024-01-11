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

public class UsuarioDAO {
    
    Conexion cn =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Usuario Validar(String User, String Rut) {
        Usuario usuario = new Usuario();
        String consulta = "SELECT * FROM empleado WHERE User = ? AND Rut = ?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, User);
            ps.setString(2, Rut);
            rs = ps.executeQuery();
            rs.next();
            do {
                usuario.setIdEmpleado(rs.getInt("IdEmpleado"));
                usuario.setRut(rs.getString("Rut"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setTelefono(rs.getString("Telefono")); 
                usuario.setEstado(rs.getString("Estado"));
                usuario.setUser(rs.getString("User"));
                
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;

    }
        
    //Operaciones Crud
    
    public List listar()
    {
        String sql="select * from empleado";
        List<Usuario>lista=new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setIdEmpleado(rs.getInt("idEmpleado"));
                usuario.setRut(rs.getString("Rut"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setTelefono(rs.getString("Telefono")); 
                usuario.setEstado(rs.getString("Estado"));
                usuario.setUser(rs.getString("User"));
                lista.add(usuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

        
    }
    
    public int agregar(Usuario us)
    {
        String sql="insert into empleado(Rut,Nombres,Apellidos,Telefono,Estado,User)values(?,?,?,?,?,?)";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, us.getRut());
            ps.setString(2, us.getNombres());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getTelefono());
            ps.setString(5, us.getEstado());
            ps.setString(6, us.getUser());
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp;
        
        
    }
    
    public Usuario listarId(int idEmpleado){
        Usuario usu = new Usuario();
        String sql="select * from empleado where IdEmpleado="+idEmpleado;
        
        try {
            
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {   
                
                usu.setRut(rs.getString(2));
                usu.setNombres(rs.getString(3));
                usu.setApellidos(rs.getString(4));
                usu.setTelefono(rs.getString(5)); 
                usu.setEstado(rs.getString(6));
                usu.setUser(rs.getString(7));
            }
            
        } catch (Exception e) {
        }
        return usu;
    }   
    
    public int actualizar(Usuario us){
        
       String sql="update empleado set Rut=?, Nombres=?,Apellidos=?,Telefono=?,Estado=?,User=? where idEmpleado=?";
        
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, us.getRut());
            ps.setString(2, us.getNombres());
            ps.setString(3, us.getApellidos());
            ps.setString(4, us.getTelefono());
            ps.setString(5, us.getEstado());
            ps.setString(6, us.getUser());
            ps.setInt(7, us.getIdEmpleado() );
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        return resp; 
    }
    
    public void eliminar(int idEmpleado)
    {
        String sql="delete from empleado where idEmpleado="+idEmpleado;
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch (Exception e){
            
        }
        
    }
    
}
