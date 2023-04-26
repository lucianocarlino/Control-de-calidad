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
public class Datos {
    
    private Color colores[] = new Color[5];
    private ModeloDeZapatilla modelos[] = new ModeloDeZapatilla[3];
    private int idOrdenes = 0;
    private int codEstados[] = new int[3];
    private String descEstados[] = new String[3];
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<ModeloDeZapatilla> models = new ArrayList<>();
    
    
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
        
        //Agregar modelos
        
        colors.add(new Color("Rojo", 111));
        colors.add(new Color("Azul", 111));
        colors.add(new Color("Amarillo", 111));
        colors.add(new Color("Verde", 111));
        colors.add(new Color("Morado", 111));
        
        models.add(new ModeloDeZapatilla("111", "Lindo"));
        models.add(new ModeloDeZapatilla("222", "Feo"));
        models.add(new ModeloDeZapatilla("333", "Masomenos"));
        
        modelos[0] = new ModeloDeZapatilla("111", "Lindo");
        modelos[1] = new ModeloDeZapatilla("222", "Feo");
        modelos[2] = new ModeloDeZapatilla("333", "Masomenos");
        
        colores[0] = new Color("Rojo", 111);
        colores[1] = new Color("Azul", 111);
        colores[2] = new Color("Amarillo", 111);
        colores[3] = new Color("Verde", 111);
        colores[4] = new Color("Morado", 111);
        
    }
    
    public String[] getSKU(){
        
        String SKUs[] = new String[3];
        for (int x=0; x<3; x++){
            SKUs[x] = modelos[x].getSKU();
        }
        return SKUs;
    }
    
    public int[] getCodigos(){
        
        int codigos[] = new int[5];
        for (int x=0; x<5; x++){
            codigos[x] = colores[x].getCodigo();
        }
        return codigos;
    }
    
    public String[] getDescripciones(){
        
        String descripciones[] = new String[5];
        for (int x=0; x<5; x++){
            descripciones[x] = colores[x].getDescripcion();
        }
        return descripciones;
    }

    @Override
    public String toString() {
        return "Datos{" + "colores=" + colores + ", modelos=" + modelos + ", idOrdenes=" + idOrdenes + ", codEstados=" + codEstados + ", descEstados=" + descEstados + '}';
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<ModeloDeZapatilla> getModels() {
        return models;
    }

    public void setModels(ArrayList<ModeloDeZapatilla> models) {
        this.models = models;
    }
    
    
}
