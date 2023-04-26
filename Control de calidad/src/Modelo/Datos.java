/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Datos {
    
    private Color colores[] = new Color[5];
    private ModeloDeZapatilla modelos[] = new ModeloDeZapatilla[3];
    private int idOrdenes = 0;
    private int codEstados[] = new int[3];
    private String descEstados[] = new String[3];
    

    public Color[] getColores() {
        return colores;
    }

    public void setColores(Color[] colores) {
        this.colores = colores;
    }

    public ModeloDeZapatilla[] getModelos() {
        return modelos;
    }

    public void setModelos(ModeloDeZapatilla[] modelos) {
        this.modelos = modelos;
    }

    public Datos() {
        
        
    }
    
}
