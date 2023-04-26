/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class ModeloDeZapatilla {

    private String SKU;
    private String Denominacion;

    public ModeloDeZapatilla(String SKU, String Denominacion) {
        this.SKU = SKU;
        this.Denominacion = Denominacion;
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

}
