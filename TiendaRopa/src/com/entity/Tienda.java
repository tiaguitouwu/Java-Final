package com.entity;

import java.time.LocalDateTime;

public class Tienda {
    private int id;
    private String descripcionTienda;
    private String direccion;
    private String telefono;
    private String correo;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Tienda() {
    }

    public Tienda(int id, String descripcionTienda, String direccion, String telefono, String correo, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.descripcionTienda = descripcionTienda;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionTienda() {
        return descripcionTienda;
    }

    public void setDescripcionTienda(String descripcionTienda) {
        this.descripcionTienda = descripcionTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaUltModificacion() {
        return fechaUltModificacion;
    }

    public void setFechaUltModificacion(LocalDateTime fechaUltModificacion) {
        this.fechaUltModificacion = fechaUltModificacion;
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", descripcionTienda=" + descripcionTienda + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}