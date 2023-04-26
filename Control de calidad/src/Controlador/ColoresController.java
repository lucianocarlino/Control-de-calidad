/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Color;
import Modelo.Datos;
import Vista.AgregarColor;
import Vista.GestionColores;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LUCIANO
 */
public class ColoresController {
    public static GestionColores ventana = new GestionColores();
    public static AgregarColor ventAgregar = new AgregarColor();
    Datos datos = new Datos();
    
    public static void mostrar(){ 
        ventana.setVisible(true); 
        ventana.setLocationRelativeTo(null);
        actualizarTabla();
    }
    public static void ocultar(){ventana.setVisible(false);}
    public static void cerrar() {ocultar(); MenuController.mostrar();}
    
    public static void actualizarTabla(){
        DefaultTableModel tabla = (DefaultTableModel) ventana.getjTable1().getModel();
               
        tabla.setNumRows(0);
        for(Color p : DatosController.datos.getColors()){
            Object[] fila = new Object[2];
            
            fila[0] = p.getCodigo();
            fila[1] = p.getDescripcion();
            
            tabla.addRow(fila);
        }
    }
    
    public static void btnCrear(){
        mostrarAgregar();
    }
    
    public static void mostrarAgregar(){
        ventAgregar.setVisible(true); 
        ventAgregar.setLocationRelativeTo(null);
        ventAgregar.getTfCodigo().setText("");
        ventAgregar.getTfDescripcion().setText("");
    }
    
    public static void btnEliminar(){
        int[] selected = ventana.getjTable1().getSelectedRows();
        
        for(int fila : selected){
            int id = Integer.parseInt(ventana.getjTable1().getValueAt(fila, 0).toString());
            
            DatosController.EliminarColor(id);
        }
        
        actualizarTabla();
    }
    
    public static void btnAgregar(){
        
        int codigo = Integer.parseInt(ventAgregar.getTfCodigo().getText());
        String descripcion = ventAgregar.getTfDescripcion().getText();
        
        Color nuevo = new Color(descripcion, codigo);
        
        DatosController.AgregarColor(nuevo);
        
        ventAgregar.getTfCodigo().setText("");
        ventAgregar.getTfDescripcion().setText("");
        actualizarTabla();
    }
}
