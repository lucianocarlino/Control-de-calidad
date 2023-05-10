/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Color;
import Modelo.Datos;
import Vista.AgregarColor;
import Vista.GestionColores;
import javax.swing.JOptionPane;
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
                if (!p.getBajaLogica()) {
                Object[] fila = new Object[2];

                fila[0] = p.getCodigo();
                fila[1] = p.getDescripcion();

                tabla.addRow(fila);
            }
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
        
        String cadCodigo = ventAgregar.getTfCodigo().getText().trim();
        String descripcion = ventAgregar.getTfDescripcion().getText().trim();
        int codigo = 0;
        
        if(cadCodigo.equals("") || descripcion.equals("")){
            JOptionPane.showMessageDialog(ventana, "Error: Rellene los campos");
            return;
        }
        
        try{
            codigo = Integer.parseInt(cadCodigo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "Error: " + e.getMessage());
            return;
        }
        
        Color nuevo = new Color(descripcion, codigo);
        
        System.out.println(codigo);
        
        if(!DatosController.AgregarColor(nuevo))
            JOptionPane.showMessageDialog(ventana, "Error: Codigo ya usado");
        
        ventAgregar.getTfCodigo().setText("");
        ventAgregar.getTfDescripcion().setText("");
        actualizarTabla();
    }
}
