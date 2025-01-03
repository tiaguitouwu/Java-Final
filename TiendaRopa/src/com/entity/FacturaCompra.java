package com.entity;

import java.time.LocalDateTime;

public class FacturaCompra {
    private int id;
    private int idPedidoCompra;
    private LocalDateTime fechaFactura;
    private int estado;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public FacturaCompra(){
    }

    public FacturaCompra(int id, int idPedidoCompra, LocalDateTime fechaFactura, int estado, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idPedidoCompra = idPedidoCompra;
        this.fechaFactura = fechaFactura;
        this.estado = estado;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(int idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public LocalDateTime getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDateTime fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
        return "FacturaCompra{" + "id=" + id + ", idPedidoCompra=" + idPedidoCompra + ", fechaFactura=" + fechaFactura + ", estado=" + estado + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}