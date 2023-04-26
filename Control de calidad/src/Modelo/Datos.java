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
    
    private int idOrdenes = 0;
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<ModeloDeZapatilla> models = new ArrayList<>();

    public Datos() {
        
        //Agregar modelos
        
        colors.add(new Color("Rojo", 111));
        colors.add(new Color("Azul", 222));
        colors.add(new Color("Amarillo", 333));
        colors.add(new Color("Verde", 444));
        colors.add(new Color("Morado", 555));
        
        models.add(new ModeloDeZapatilla("111", "Lindo"));
        models.add(new ModeloDeZapatilla("222", "Feo"));
        models.add(new ModeloDeZapatilla("333", "Masomenos"));
        
    }
    
    public Object[] getSKUA(){
        
        ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            SKUs.add(m.getSKU());
        }
        return SKUs.toArray();
    }
    
    public Object[] getDescripcionesA(){
        
        ArrayList<String> descrip = new ArrayList<>();
        for (Color m : colors){
            descrip.add(m.getDescripcion());
        }
        return descrip.toArray();
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
