/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Almacen;
import Models.Producto;
import Models.Usuario;
import util.BaseDatosUtil;
import SwimgBD.util.DatetoLocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Aaroncin
 */
public class ProductoDAO implements DAO<Producto>{

    public ProductoDAO() {
    }
    
    public List<Producto> listarTodos(){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idproducto,color,talla,modelo,suela,idcategoria,usuario_dni_usuario"
                + " FROM producto";
        List<Producto> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto(rs.getInt(1),rs.getInt(6),rs.getInt(7),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(3));
                int j=rs.getInt(1);
                p.setIdproducto(j);
                lista.add(p);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    public List<Producto> listarid(int id) {
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idproducto,color,talla,modelo,suela,idcategoria,usuario_dni_usuario"
                + " FROM producto WHERE idproducto like ?";
        List<Producto> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto(rs.getInt(1),rs.getInt(6),rs.getInt(7),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(3));
                int j=rs.getInt(1);
                p.setIdproducto(j);
                lista.add(p);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    public void insertar(Producto p){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "insert into producto VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,p.getIdproducto());
            ps.setString(2,p.getColor());
            ps.setString(3,p.getTalla());
            ps.setString(4,p.getModelo());
            ps.setString(5,p.getSuela());
            ps.setInt(6,p.getIdcategoria());
            ps.setInt(7,p.getUsuario_dni_usuario());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void modificar(Producto p){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "update producto " + 
                "set idproducto = ?,color = ?,talla = ?,modelo = ?,suela = ?, idcategoria = ?,usuario_dni_usuario = ?"
                + " WHERE idproducto = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,p.getIdproducto());
            ps.setString(2,p.getColor());
            ps.setString(3,p.getTalla());
            ps.setString(4,p.getModelo());
            ps.setString(5,p.getSuela());
            ps.setInt(6,p.getIdcategoria());
            ps.setInt(7,p.getUsuario_dni_usuario());
            ps.setInt(8,p.getIdproducto());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    public void borrar(Producto producto){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "delete from producto"
                + " WHERE idproducto = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdproducto());
            System.out.println(producto.getIdproducto());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
