/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class OrdenDeProduccion {

    public final static int NULA = 0;
    public final static int INICIADA = 1;
    
    private long id;
    private int estado;
    private int dia;
    private int mes;
    private int año;
    
    private ModeloDeZapatilla modelo;
    private Color color;
    private SupervisorDeLinea supervisor;

    public OrdenDeProduccion(long id, int dia, int mes, int año, ModeloDeZapatilla modelo, Color color, SupervisorDeLinea supervisor) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.modelo = modelo;
        this.color = color;
        this.supervisor = supervisor;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
}
