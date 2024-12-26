package com.entity;

import java.time.LocalDateTime;

public class Stock {
    private int id;
    private int idTienda;
    private int idRopa;
    private int cantidadExistencia;
    private LocalDateTime fechaUltModificacion;

    public Stock() {
    }

    public Stock(int id, int idTienda, int idRopa, int cantidadExistencia, LocalDateTime fechaUltModificacion) {
        this.id = id;
        this.idTienda = idTienda;
        this.idRopa = idRopa;
        this.cantidadExistencia = cantidadExistencia;
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdRopa() {
        return idRopa;
    }

    public void setIdRopa(int idRopa) {
        this.idRopa = idRopa;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public LocalDateTime getFechaUltModificacion() {
        return fechaUltModificacion;
    }

    public void setFechaUltModificacion(LocalDateTime fechaUltModificacion) {
        this.fechaUltModificacion = fechaUltModificacion;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", idTienda=" + idTienda + ", idRopa=" + idRopa + ", cantidadExistencia=" + cantidadExistencia + ", fechaUltModificacion=" + fechaUltModificacion + '}';
    }
    
}
