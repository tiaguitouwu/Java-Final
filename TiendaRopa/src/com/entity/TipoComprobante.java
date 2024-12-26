package com.entity;

import java.time.LocalDateTime;

public class TipoComprobante {
    private int id;
    private String descripcionTipoComprobante;
    private boolean esVenta;
    private boolean esCompra;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public TipoComprobante() {
    }

    public TipoComprobante(int id, String descripcionTipoComprobante, boolean esVenta, boolean esCompra, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.descripcionTipoComprobante = descripcionTipoComprobante;
        this.esVenta = esVenta;
        this.esCompra = esCompra;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionTipoComprobante() {
        return descripcionTipoComprobante;
    }

    public void setDescripcionTipoComprobante(String descripcionTipoComprobante) {
        this.descripcionTipoComprobante = descripcionTipoComprobante;
    }

    public boolean isEsVenta() {
        return esVenta;
    }

    public void setEsVenta(boolean esVenta) {
        this.esVenta = esVenta;
    }

    public boolean isEsCompra() {
        return esCompra;
    }

    public void setEsCompra(boolean esCompra) {
        this.esCompra = esCompra;
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
        return "TipoComprobante{" + "id=" + id + ", descripcionTipoComprobante=" + descripcionTipoComprobante + ", esVenta=" + esVenta + ", esCompra=" + esCompra + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
