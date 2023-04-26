/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaOP;
import Vista.VistaMenu;
import Vista.*; 
/**
 *
 * @author paezm
 */
public class OpController {
     public static VistaOP  ventana = new VistaOP();
    public static void mostrar(){ ventana.setVisible(true);}
    public static void ocultar(){ventana.setVisible(false);}
    
}
