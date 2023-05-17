/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class LineaDeProduccion {
    
    private int numero;
    private String descripcion;
    
    private Boolean bajaLogica = false;
    
    public LineaDeProduccion(int numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }
    public LineaDeProduccion() {
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }

    @Override
    public String toString() {
        return numero + " - " + descripcion;
    }
}
