/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Aaroncin
 */
public class Producto {
    private int idproducto,idcategoria,usuario_dni_usuario;
    private String color,talla,modelo,suela;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getUsuario_dni_usuario() {
        return usuario_dni_usuario;
    }

    public void setUsuario_dni_usuario(int usuario_dni_usuario) {
        this.usuario_dni_usuario = usuario_dni_usuario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSuela() {
        return suela;
    }

    public void setSuela(String suela) {
        this.suela = suela;
    }
    
    public Producto(){
    }

    public Producto(int idcategoria, int usuario_dni_usuario, String color, String talla, String modelo, String suela) {
        this.idcategoria = idcategoria;
        this.usuario_dni_usuario = usuario_dni_usuario;
        this.color = color;
        this.talla = talla;
        this.modelo = modelo;
        this.suela = suela;
    }

    public Producto(int idProducto, int idcategoria, int usuario_dni_usuario, String color, String talla, String modelo, String suela) {
        this.idproducto = idproducto;
        this.idcategoria = idcategoria;
        this.usuario_dni_usuario = usuario_dni_usuario;
        this.color = color;
        this.talla = talla;
        this.modelo = modelo;
        this.suela = suela;
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setNombrePelicula(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Producto{" + "idproducto=" + idproducto + ", idcategoria=" + idcategoria + ", usuario_dni_usuario=" + usuario_dni_usuario + ", color=" + color + ", talla=" + talla + ", modelo=" + modelo + ", suela=" + suela + '}';
    }

    
}

