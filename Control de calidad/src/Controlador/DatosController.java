/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;

/**
 *
 * @author LUCIANO
 */
public class DatosController {
    public static Datos datos = new Datos();
    
    public static boolean AgregarColor(Color nuevo){
        
        int codigoNuevo = nuevo.getCodigo();
        
        for(Color c : datos.getColors()){
            if(c.getCodigo() == codigoNuevo)
                return false;
        }
        datos.getColors().add(nuevo);
        return true;
    }
    
    public static boolean AgregarModelo(ModeloDeZapatilla nuevo){
        
        String codigoNuevo = nuevo.getSKU();
        
        for(ModeloDeZapatilla c : datos.getModels()){
            if(codigoNuevo.equals(c.getSKU()))
                return false;
        }
        
        datos.getModels().add(nuevo);
        return true;
        
    }
    
    public static void EliminarColor(int codigo){
        datos.eliminarColor(codigo);
    }
    
    public static void EliminarModelo(String SKU){
        datos.eliminarModelo(SKU);
    }
}
