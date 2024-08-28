package com.netcodex.model;


import java.util.Date;

public class Mantenimiento {
    private int id;
    private int equipoId;
    private Date fechaMantenimiento;
    private String descripcion;
    private double costo;

    public Mantenimiento() {}

    public Mantenimiento(int id, int equipoId, Date fechaMantenimiento, String descripcion, double costo) {
        this.id = id;
        this.equipoId = equipoId;
        this.fechaMantenimiento = fechaMantenimiento;
        this.descripcion = descripcion;
        this.costo = costo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}