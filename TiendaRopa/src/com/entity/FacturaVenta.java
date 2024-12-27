package com.entity;

import java.time.LocalDateTime;

public class FacturaVenta {
    private int id;
    private int idPedidoVenta;
    private LocalDateTime fechaFactura;
    private int idTimbrado;
    private int estado;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public FacturaVenta(){
    }
    public FacturaVenta(int id, int idPedidoVenta, LocalDateTime fechaFactura, int idTimbrado, int estado, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idPedidoVenta = idPedidoVenta;
        this.fechaFactura = fechaFactura;
        this.idTimbrado = idTimbrado;
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

    public int getIdPedidoVenta() {
        return idPedidoVenta;
    }

    public void setIdPedidoVenta(int idPedidoVenta) {
        this.idPedidoVenta = idPedidoVenta;
    }

    public LocalDateTime getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(LocalDateTime fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(int idTimbrado) {
        this.idTimbrado = idTimbrado;
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
        return "FacturaVenta{" + "id=" + id + ", idPedidoVenta=" + idPedidoVenta + ", fechaFactura=" + fechaFactura + ", idTimbrado=" + idTimbrado + ", estado=" + estado + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
