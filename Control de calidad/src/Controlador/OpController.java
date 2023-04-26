/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.LoginController.ventana;
import static Controlador.MenuController.ventana;
import Vista.VistaOP;
import Vista.VistaMenu;
import Vista.*; 
import Modelo.*;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author paezm
 */
public class OpController {
    public static VistaOP ventana = new VistaOP();
    public static VistaOPIniciada ventanaOPI = new VistaOPIniciada();
    public static void mostrar(){ ventana.setVisible(true); ventana.setLocationRelativeTo(null);}
    public static void mostrarOPI(){
        ventanaOPI.setValores(DatosController.datos.getOrdenDeProduccion());
        ventanaOPI.setLocationRelativeTo(null);
        ventanaOPI.setVisible(true);
    }
    public static void ocultar(){ventana.setVisible(false);}
    
    public static void cerrar() {
        ventana.setVisible(false);
        ventanaOPI.setVisible(false);
        MenuController.mostrar();
    }
    
    public static void actualizar(){
        
        Object SKUs[] = DatosController.datos.getSKUA();
        Object coloress[] = DatosController.datos.getCodigosA();

        JComboBox modelos = ventana.getjComboBox1();
        modelos.setModel(new DefaultComboBoxModel(SKUs));

        JComboBox listaColores = ventana.getjComboBox2();
        listaColores.setModel(new DefaultComboBoxModel(coloress));
    }
    
    public static void btnCancelar(){
        ocultar();
        MenuController.mostrar();
    }
    
    public static void btnIniciar(){
        JComboBox modelos = ventana.getjComboBox1();
        JComboBox colores = ventana.getjComboBox2();
        
        ModeloDeZapatilla modelo = DatosController.getModeloPorSKU(modelos.getSelectedItem().toString());
        Color color = DatosController.getColorPorCodigo(Integer.parseInt(colores.getSelectedItem().toString()));
        
        boolean opIniciada = DatosController.iniciarOP(modelo, color);
        
        if (opIniciada) {
            JOptionPane.showMessageDialog(ventana, "La orden de producción fue iniciada");
            ventana.getjToggleButton1().setEnabled(false);
            ventana.getjToggleButton2().setEnabled(false);
            
            mostrarOPI();
        }
        else {
            JOptionPane.showMessageDialog(ventana, "Error iniciando la orden de produccion");
        }
    }
}
