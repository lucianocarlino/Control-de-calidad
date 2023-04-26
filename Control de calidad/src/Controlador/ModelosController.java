/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Datos;
import Modelo.ModeloDeZapatilla;
import Vista.GestionModelos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUCIANO
 */
public class ModelosController {
    public static GestionModelos ventana = new GestionModelos();
    public static void mostrar(){ 
        ventana.setVisible(true); 
        ventana.setLocationRelativeTo(null);
        actualizarTabla();
    }
    public static void ocultar(){ventana.setVisible(false);}
    public static void cerrar() {ocultar(); MenuController.mostrar();}
    
    public static void actualizarTabla(){
        DefaultTableModel tabla = (DefaultTableModel) ventana.getjTable1().getModel();
        Datos datos = new Datos();
        
        tabla.setNumRows(0);
        for(ModeloDeZapatilla p : datos.getModels()){
            Object[] fila = new Object[10];
            
            fila[0] = p.getSKU();
            fila[1] = p.getDenominacion();
            
            tabla.addRow(fila);
        }
    }
}
