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
    public static void mostrar(){
        boolean activarBotones = (DatosController.datos.buscarOPI().getEstado() != OrdenDeProduccion.INICIADA);
        ventana.getjButton1().setEnabled(activarBotones);
        ventana.getjButton2().setEnabled(activarBotones);
        ventana.setVisible(true); 
        ventana.setLocationRelativeTo(null);
    }
    public static void mostrarOPI(){
        ventanaOPI.setValores(DatosController.datos.buscarOPI());
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

        JComboBox modelos = ventana.getjComboBox1();
        modelos.setModel(new DefaultComboBoxModel(SKUs));

        actualizarColores();
    }
    
    public static void actualizarColores(){
        String modelos = ventana.getjComboBox1().getSelectedItem().toString().split("-")[0].trim();
        
        ModeloDeZapatilla modelo = DatosController.getModeloPorSKU(modelos);
        
        Object Codigos[] = DatosController.datos.getCodigosA(modelo);
        Object Numeros[] = DatosController.getNumerosLineas();
         
        ventana.getjComboBox2().setModel(new DefaultComboBoxModel(Codigos));
        ventana.getjComboBox3().setModel(new DefaultComboBoxModel(Numeros));
    }
    
    public static void btnCancelar(){
        ocultar();
        MenuController.mostrar();
    }
    
    public static void btnIniciar(){
        String modelos = ventana.getjComboBox1().getSelectedItem().toString().split("-")[0].trim();
        String colores = ventana.getjComboBox2().getSelectedItem().toString().split("-")[0].trim();
        String lineas = ventana.getjComboBox3().getSelectedItem().toString().split("-")[0].trim();
        int cantidad = Integer.parseInt(ventana.getTextFieldCantidad().getText());
        
        ModeloDeZapatilla modelo = DatosController.getModeloPorSKU(modelos);
        Color color = DatosController.getColorPorCodigo(Integer.parseInt(colores));
        LineaDeProduccion linea = DatosController.getLineaPorNumero(Integer.parseInt(lineas));
        
        boolean opIniciada = DatosController.iniciarOP(modelo, color, linea, cantidad);

        if (opIniciada) {
            JOptionPane.showMessageDialog(ventana, "La orden de producción fue iniciada");
            mostrarOPI();
        }
        else {
            JOptionPane.showMessageDialog(ventana, "Error iniciando la orden de produccion");
        }
    }

    public static void terminarProduccion() {
        DatosController.datos.buscarOPI().terminar();
        cerrar();
    }
}
