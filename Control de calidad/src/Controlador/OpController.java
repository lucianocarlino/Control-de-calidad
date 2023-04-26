/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaOP;
import Vista.VistaMenu;
import Vista.*; 
import Modelo.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author paezm
 */
public class OpController {
    public static VistaOP  ventana = new VistaOP();
    public static void mostrar(){ ventana.setVisible(true); ventana.setLocationRelativeTo(null);}
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void actualizar(){
        
        Object SKUs[] = DatosController.datos.getSKUA();
        Object coloress[] = DatosController.datos.getDescripcionesA();

        JComboBox modelos = ventana.getjComboBox1();
        modelos.setModel(new DefaultComboBoxModel(SKUs));

        JComboBox listaColores = ventana.getjComboBox2();
        listaColores.setModel(new DefaultComboBoxModel(coloress));
    }
    
    public static void btnCancelar(){
        ocultar();
        MenuController.mostrar();
    }
}
