/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ModeloDeZapatilla {

    private String SKU;
    private String Denominacion;
    private ArrayList<Color> colores = new ArrayList<>();

    public ModeloDeZapatilla(String SKU, String Denominacion, ArrayList<Color> colores) {
        this.SKU = SKU;
        this.Denominacion = Denominacion;
        this.colores = colores;
    }
    public ModeloDeZapatilla() {
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    public ArrayList<Color> getColores() {
        return colores;
    }

    public void setColores(ArrayList<Color> colores) {
        this.colores = colores;
    }

    @Override
    public String toString() {
        return SKU + " - " + Denominacion;
    }
    
    
}
