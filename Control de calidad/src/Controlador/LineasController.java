/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Color;
import Modelo.Datos;
import Modelo.LineaDeProduccion;
import Vista.AgregarLinea;
import Vista.GestionLineas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LUCIANO
 */
public class LineasController {
    public static GestionLineas ventana = new GestionLineas();
    public static AgregarLinea ventAgregar = new AgregarLinea();
    
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
        for(LineaDeProduccion l : DatosController.datos.getLineas()){
                if (!l.getBajaLogica()) {
                Object[] fila = new Object[2];

                fila[0] = l.getNumero();
                fila[1] = l.getDescripcion();

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
        ventAgregar.getTfNumero().setText("");
        ventAgregar.getTfDescripcion().setText("");
    }
    
    public static void btnEliminar(){
        int[] selected = ventana.getjTable1().getSelectedRows();
        
        for(int fila : selected){
            int id = Integer.parseInt(ventana.getjTable1().getValueAt(fila, 0).toString());
            
            DatosController.EliminarLinea(id);
        }
        
        actualizarTabla();
    }
    
    public static void btnAgregar(){
        
        String cadCodigo = ventAgregar.getTfNumero().getText().trim();
        String descripcion = ventAgregar.getTfDescripcion().getText().trim();
        int numero = 0;
        
        if(cadCodigo.equals("") || descripcion.equals("")){
            JOptionPane.showMessageDialog(ventana, "Error: Rellene los campos");
            return;
        }
        
        try{
            numero = Integer.parseInt(cadCodigo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "Error: " + e.getMessage());
            return;
        }
        
        LineaDeProduccion nuevo = new LineaDeProduccion(numero, descripcion);
        
        System.out.println(numero);
        
        if(!DatosController.AgregarLinea(nuevo))
            JOptionPane.showMessageDialog(ventana, "Error: Codigo ya usado");
        
        ventAgregar.getTfNumero().setText("");
        ventAgregar.getTfDescripcion().setText("");
        ventAgregar.setVisible(false);
        
        actualizarTabla();
    }
}
