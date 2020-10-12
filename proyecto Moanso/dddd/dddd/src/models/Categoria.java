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
public class Categoria {
    private int idCategoria;
    private String categoria,genero;
    
    public Categoria(){
    }

    public Categoria(String categoria, String genero) {
        this.categoria = categoria;
        this.genero = genero;
    }

    public Categoria(int idCategoria, String categoria, String genero) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.genero = genero;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "categoria=" + categoria  ;
    }
    
    
}
