package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoVenta {
    private int id;
    private int idCliente;
    private int idTienda;
    private LocalDateTime fechaPedido;
    private int estado;
    private String usuario;
    private LocalDateTime fechaUltModificacion;
    private String nroPedido;

    public PedidoVenta() {
    }

    public PedidoVenta(int id, String nroPedido, int idCliente, int idTienda, LocalDateTime fechaPedido, int estado, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.nroPedido = nroPedido;
        this.idCliente = idCliente;
        this.idTienda = idTienda;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
        return "PedidoVenta{" + "id=" + id + ", idCliente=" + idCliente + ", idTienda=" + idTienda + ", fechaPedido=" + fechaPedido + ", estado=" + estado + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
