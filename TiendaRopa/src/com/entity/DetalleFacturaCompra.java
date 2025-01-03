package com.entity;

import java.time.LocalDateTime;

public class DetalleFacturaCompra {
    private int id;
    private int idFacturaCompra;
    private int idRopa;
    private float precio;
    private int cantidad;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public DetalleFacturaCompra() {
    }

    public DetalleFacturaCompra(int id, int idFacturaCompra, int idRopa, float precio, int cantidad, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idFacturaCompra = idFacturaCompra;
        this.idRopa = idRopa;
        this.precio = precio;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public int getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(int idRopa) {
        this.idRopa = idRopa;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        return "DetalleFacturaCompra{" + "id=" + id + ", idFacturaCompra=" + idFacturaCompra + ", idRopa=" + idRopa + ", precio=" + precio + ", cantidad=" + cantidad + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }

    
}
