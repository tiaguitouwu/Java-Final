
package com.entity;

import java.time.LocalDateTime;

public class Categoria {
    private int id;
    private String descripcionCategoria;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Categoria() {
    }

    public Categoria(int id, String descripcionCategoria, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.descripcionCategoria = descripcionCategoria;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
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
        return "Categoria{" + "id=" + id + ", descripcionCategoria=" + descripcionCategoria + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
