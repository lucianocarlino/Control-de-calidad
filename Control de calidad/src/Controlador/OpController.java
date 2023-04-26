/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaOP;
import Vista.VistaMenu;
import Vista.*; 
import Modelo.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author paezm
 */
public class OpController {
    public static VistaOP  ventana = new VistaOP();
    public static void mostrar(){ ventana.setVisible(true);}
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void actualizar(){
        
        Datos datos = new Datos();
        
        ventana.setjComboBox1(new JComboBox(datos.getSKU()));        
    }
}
