/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaMenu;
import Vista.VistaLogin;
import Vista.*; 
/**
 *
 * @author paezm
 */
public class MenuController {
    public static VistaMenu  ventana = new VistaMenu();
    public static void mostrar(){ ventana.setVisible(true); ventana.setLocationRelativeTo(null);}
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void botonOp(){
        OpController.mostrar();
        OpController.actualizar();
        ocultar();
    }
    
    public static void btnColores(){
        ColoresController.mostrar();
        ocultar();
    }
    
    public static void btnModelos(){
        ModelosController.mostrar();
        ocultar();
    }
}
