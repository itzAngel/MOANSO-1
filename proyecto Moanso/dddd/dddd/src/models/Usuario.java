/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;

/**
 *
 * @author Aaroncin
 */
public class Usuario {
    private int dni_usuario;
    private String usuario,contrasena,nombres,apellidos,telefono,correo,tipo_usuario;
    private LocalDate fecha_nacimiento;
    
    
    public Usuario(){
    }

    public Usuario(String usuario, String contrasena, String nombres, String apellidos, String telefono, String correo, String tipo_usuario, LocalDate fecha_nacimiento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo_usuario = tipo_usuario;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario(int dni_usuario, String usuario, String contrasena, String nombres, String apellidos, String telefono, String correo, String tipo_usuario, LocalDate fecha_nacimiento) {
        this.dni_usuario = dni_usuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.tipo_usuario = tipo_usuario;
        this.fecha_nacimiento = fecha_nacimiento;
    }

   

    public int getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(int dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "usuario=" + dni_usuario;
    }

    
}
