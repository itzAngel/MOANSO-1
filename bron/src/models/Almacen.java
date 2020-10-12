/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Aaroncin
 */
public class Almacen {
    private int idAlmacen,stock;
    
    
    public Almacen(){
    }

    public Almacen(int stock) {
        this.stock = stock;
    }

    public Almacen(int idAlmacen, int stock) {
        this.idAlmacen = idAlmacen;
        this.stock = stock;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Almacen{" + "idAlmacen=" + idAlmacen + ", stock=" + stock + '}';
    }
    
    
    
}
