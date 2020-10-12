
package dao;

import Models.Almacen;
import Models.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.BaseDatosUtil;
import SwimgBD.util.DatetoLocalDate;
public class UsuarioDAO implements DAO<Usuario>{

    public UsuarioDAO() {
    }
    
    public List<Usuario> listarTodos() {
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select dni_usuario,usuario,contrasena,nombres,apellidos,fecha_nacimiento,telefono,correo,tipo_usuario"
                + " FROM usuario";
        List<Usuario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DatetoLocalDate d = new DatetoLocalDate();
                Usuario dr = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(8),rs.getString(9),d.conversion(rs.getDate(6)));
                lista.add(dr);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
           
            e.printStackTrace();
        }
        return lista;
    
}
    public List<Usuario> listardni(int dni) {
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select dni_usuario,usuario,contrasena,nombres,apellidos,fecha_nacimiento,telefono,correo,tipo_usuario"
                + " FROM usuario WHERE dni_usuario like ?";
        List<Usuario> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + dni + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DatetoLocalDate d = new DatetoLocalDate();
                Usuario dr = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(8),rs.getString(9),d.conversion(rs.getDate(6)));
                lista.add(dr);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
public void insertar(Usuario usuario){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "insert into usuario VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getDni_usuario());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getNombres());
            ps.setString(5, usuario.getApellidos());
            ps.setDate(6, Date.valueOf(usuario.getFecha_nacimiento()));
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getCorreo());
            ps.setString(9, usuario.getTipo_usuario());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
}
public void modificar(Usuario usuario){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "update usuario " + 
                "set dni_usuario = ?, usuario = ?, contrasena = ?, nombres = ?, apellidos = ?,fecha_nacimiento = ?,telefono = ?,correo = ?,tipo_usuario = ?"
                + " WHERE dni_usuario = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getDni_usuario());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getNombres());
            ps.setString(5, usuario.getApellidos());
            ps.setDate(6, Date.valueOf(usuario.getFecha_nacimiento()));
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getCorreo());
            ps.setString(9, usuario.getTipo_usuario());
            ps.setInt(10, usuario.getDni_usuario());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
}

public void borrar(Usuario usuario){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "delete from usuario"
                + " WHERE dni_usuario = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getDni_usuario());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}