package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Timbrado {
    private int id;
    private int idTipoComprobante;
    private LocalDateTime inicioVigencia;
    private LocalDateTime finVigencia;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Timbrado() {
    }

    public Timbrado(int id, int idTipoComprobante, LocalDateTime inicioVigencia, LocalDateTime finVigencia, String usuario, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idTipoComprobante = idTipoComprobante;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.usuario = usuario;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public LocalDateTime getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDateTime inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDateTime getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(LocalDateTime finVigencia) {
        this.finVigencia = finVigencia;
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
        return "Timbrado{" + "id=" + id + ", idTipoComprobante=" + idTipoComprobante + ", inicioVigencia=" + inicioVigencia + ", finVigencia=" + finVigencia + ", usuario=" + usuario + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
