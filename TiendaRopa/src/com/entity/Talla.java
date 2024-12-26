package com.entity;
import java.time.LocalDateTime;

public class Talla {
    private int id;
    private String descripcionTalla;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Talla() {
    }

    public Talla(int id, String descripcionTalla, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.descripcionTalla = descripcionTalla;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionTalla() {
        return descripcionTalla;
    }

    public void setDescripcionTalla(String descripcionTalla) {
        this.descripcionTalla = descripcionTalla;
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
        return "Talla{" + "id=" + id + ", descripcionTalla=" + descripcionTalla + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
