package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoCompra {
    private int id;
    private String nroPedido;
    private int idProveedor;
    private int idTienda;
    private LocalDateTime fechaPedido;
    private int estado;
    private String usuario;
    private LocalDateTime fechaUltModificacion;
    private DetallePedidoCompra detallePedidoCompra;

    public PedidoCompra() {
    }

    public PedidoCompra(int id, String nroPedido, int idProveedor, int idTienda, LocalDateTime fechaPedido, int estado, String usuario, LocalDateTime fechaUltModificacion,DetallePedidoCompra detallePedidoCompra) {
        this.id = id;
        this.nroPedido = nroPedido;
        this.idProveedor = idProveedor;
        this.idTienda = idTienda;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
        this.detallePedidoCompra = detallePedidoCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
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
        return "PedidoCompra{" + "id=" + id + ", nroPedido=" + nroPedido + ", idProveedor=" + idProveedor + ", idTienda=" + idTienda + ", fechaPedido=" + fechaPedido + ", estado=" + estado + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
