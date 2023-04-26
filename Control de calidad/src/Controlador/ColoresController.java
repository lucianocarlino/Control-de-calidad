/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Color;
import Modelo.Datos;
import Vista.GestionColores;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LUCIANO
 */
public class ColoresController {
    public static GestionColores ventana = new GestionColores();
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
        for(Color p : datos.getColors()){
            Object[] fila = new Object[10];
            
            fila[0] = p.getCodigo();
            fila[1] = p.getDescripcion();
            
            tabla.addRow(fila);
        }
    }
}
