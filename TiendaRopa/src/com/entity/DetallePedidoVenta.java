package com.entity;

import java.time.LocalDateTime;

public class DetallePedidoVenta {
    private int id;
    private int idPedidoVenta;
    private int idRopa;
    private float precio;
    private int cantidad;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public DetallePedidoVenta() {
    }

    public DetallePedidoVenta(int id, int idPedidoVenta, int idRopa, float precio, int cantidad, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idPedidoVenta = idPedidoVenta;
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

    public int getIdPedidoVenta() {
        return idPedidoVenta;
    }

    public void setIdPedidoVenta(int idPedidoVenta) {
        this.idPedidoVenta = idPedidoVenta;
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
        return "DetallePedidoVenta{" + "id=" + id + ", idPedidoVenta=" + idPedidoVenta + ", idRopa=" + idRopa + ", precio=" + precio + ", cantidad=" + cantidad + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
