/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.OrdenDeProduccion;
import Vista.VistaMenu;
import Vista.VistaLogin;
import Vista.*; 
/**
 *
 * @author paezm
 */
public class MenuController {
    public static VistaMenu  ventana = new VistaMenu();
    public static void mostrar(){ 
        if (DatosController.datos.buscarOPI().getEstado() == OrdenDeProduccion.INICIADA) {
            ventana.getjToggleButton1().setText("Visualizar orden de produccion iniciada");
        }
        else {
            ventana.getjToggleButton1().setText("Iniciar orden de producción");
        }
        ventana.setVisible(true); ventana.setLocationRelativeTo(null);
    }
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void botonOp(){
        if (DatosController.datos.buscarOPI().getEstado() == OrdenDeProduccion.NULA) {
            OpController.mostrar();
            OpController.actualizar();
            ocultar();
        }
        else {
            OpController.mostrarOPI();
        }
    }
    
    public static void btnColores(){
        ColoresController.mostrar();
        ocultar();
    }
    
    public static void btnModelos(){
        ModelosController.mostrar();
        ocultar();
    }

    public static void btnLineas() {
        LineasController.mostrar();
        ocultar();
    }
}
