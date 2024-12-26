package com.entity;

import java.time.LocalDateTime;

public class Cliente {
    private int id;
    private String razonSocial;
    private String nombre;
    private String apellido;
    private String ruc;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Cliente() {
    }

    public Cliente(int id, String razonSocial, String nombre, String apellido, String ruc, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ruc = ruc;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
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
        return "Cliente{" + "id=" + id + ", razonSocial=" + razonSocial + ", nombre=" + nombre + ", apellido=" + apellido + ", ruc=" + ruc + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
