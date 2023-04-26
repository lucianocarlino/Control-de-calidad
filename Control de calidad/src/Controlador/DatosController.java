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
    
    public static void AgregarColor(Color nuevo){
        datos.getColors().add(nuevo);
    }
    
    public static void AgregarModelo(ModeloDeZapatilla nuevo){
        datos.getModels().add(nuevo);
    }
}
