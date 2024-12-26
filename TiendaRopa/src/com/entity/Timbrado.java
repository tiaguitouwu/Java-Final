package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Timbrado {
    private int id;
    private int idTipoComprobante;
    private LocalDate inicioVigencia;
    private LocalDate finVigencia;
    private String usuario;
    private LocalDateTime fechaUltModificacion;

    public Timbrado() {
    }

    public Timbrado(int id, int idTipoComprobante, LocalDate inicioVigencia, LocalDate finVigencia, String usuario, LocalDateTime fechaUltModificacion) {
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

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(LocalDate finVigencia) {
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
