
package com.entity;

import java.time.LocalDateTime;

public class Ropa {
    private int id;
    private String descripcion;
    private int idTalla;
    private int idCategoria;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Ropa() {
    }

    public Ropa(int id, String descripcion, int idTalla, int idCategoria, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.idTalla = idTalla;
        this.idCategoria = idCategoria;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
        return "Ropa{" + "id=" + id + ", descripcion=" + descripcion + ", idTalla=" + idTalla + ", idCategoria=" + idCategoria + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}