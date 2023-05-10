/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Color {
    
    private String descripcion;
    private int codigo;
    
    private Boolean bajaLogica = false;

    public Color(String descripcion, int codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    public Color() {
        
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Boolean getBajaLogica() {
        return bajaLogica;
    }

    public void setBajaLogica(Boolean bajaLogica) {
        this.bajaLogica = bajaLogica;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + descripcion;
    }
}
