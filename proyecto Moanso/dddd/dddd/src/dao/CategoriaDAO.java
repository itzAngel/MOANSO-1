/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Almacen;
import Models.Categoria;
import util.BaseDatosUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaroncin
 */
public class CategoriaDAO implements DAO<Categoria>{

    public CategoriaDAO() {
    }
    
    @Override
    public List<Categoria> listarTodos(){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idcategoria, categoria, genero"
                + " FROM categoria";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(c);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<Categoria> listarId(int id) {
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "select idcategoria, categoria, genero"
                + " FROM categoria WHERE idcategoria like ?";
        List<Categoria> lista = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(c);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public void insertar(Categoria categoria){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "insert into categoria" + 
                "(idcategoria, categoria, genero)"
                + "VALUES(?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getCategoria());
            ps.setString(3, categoria.getGenero());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    @Override
    public void modificar(Categoria categoria){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "update categoria " + 
                "set idcategoria = ?, categoria = ?, genero = ?"
                + " WHERE idcategoria = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.setString(2, categoria.getCategoria());
            ps.setString(3, categoria.getGenero());
            ps.setInt(4, categoria.getIdCategoria());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    @Override
    public void borrar(Categoria categoria){
        Connection con = BaseDatosUtil.creaConexion();
        String sql = "delete from categoria"
                + " WHERE idcategoria = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoria.getIdCategoria());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
