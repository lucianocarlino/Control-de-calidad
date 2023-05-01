/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class OrdenDeProduccion {

    public final static int NULA = 0;
    public final static int INICIADA = 1;
    
    private long id;
    private int estado;
    private LocalDate fechaInicio;
    private int cantidad;
    
    private ModeloDeZapatilla modelo;
    private Color color;
    private SupervisorDeLinea supervisor;
    private LineaDeProduccion linea;

    public OrdenDeProduccion(long id, LocalDate fechaInicio, ModeloDeZapatilla modelo, Color color, int cantidad, SupervisorDeLinea supervisor, LineaDeProduccion linea) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.modelo = modelo;
        this.color = color;
        this.cantidad = cantidad;
        this.supervisor = supervisor;
        this.linea = linea;
        this.estado = INICIADA;
    }

    OrdenDeProduccion() {
        this.estado = NULA;
    }

    public SupervisorDeLinea getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(SupervisorDeLinea supervisor) {
        this.supervisor = supervisor;
    }

    public ModeloDeZapatilla getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDeZapatilla modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
