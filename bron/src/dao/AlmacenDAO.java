/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Almacen;
import SwimgBD.util.DatetoLocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.BaseDatosUtil;

/**
 *
 * @author Aaroncin
 */
public class AlmacenDAO implements DAO<Almacen>{   
    
    public AlmacenDAO() {
    }
    
    
    public List<Almacen> listarTodos(){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idAlmacen, stock"
                + " FROM almacen";
        List<Almacen> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Almacen a = new Almacen(rs.getInt(1), rs.getInt(2));
                lista.add(a);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Almacen> listarId(int id) {
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idAlmacen, stock"
                + " FROM almacen WHERE idAlmacen like ?";
        List<Almacen> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Almacen a = new Almacen(rs.getInt(1), rs.getInt(2));
                lista.add(a);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void insertar(Almacen a){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "insert into almacen" + 
                "(idAlmacen, stock)"
                + "VALUES(?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdAlmacen());
            ps.setInt(2, a.getStock());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    public void modificar(Almacen a){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "update almacen " + 
                "set idAlmacen = ?, stock = ?"
                + " WHERE idAlmacen = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdAlmacen());
            ps.setInt(2, a.getStock());
            ps.setInt(3, a.getIdAlmacen());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        } 
    }
    public void borrar(Almacen a){
       Connection con = BaseDatosUtil.creaConexion();
        String sql = "delete from almacen"
                + " WHERE idAlmacen = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getIdAlmacen());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
