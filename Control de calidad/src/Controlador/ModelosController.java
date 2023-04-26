/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Datos;
import Modelo.ModeloDeZapatilla;
import Vista.AgregarModelo;
import Vista.GestionModelos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUCIANO
 */
public class ModelosController {
    public static GestionModelos ventana = new GestionModelos();
    public static AgregarModelo ventAgregar = new AgregarModelo();
    
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
        for(ModeloDeZapatilla p : DatosController.datos.getModels()){
            Object[] fila = new Object[2];
            
            fila[0] = p.getSKU();
            fila[1] = p.getDenominacion();
            
            tabla.addRow(fila);
        }
    }
    
    public static void btnCrear(){
        mostrarAgregar();
    }
    
    public static void mostrarAgregar() {
        ventAgregar.setVisible(true);
        ventAgregar.setLocationRelativeTo(null);
        ventAgregar.getTfSKU().setText("");
        ventAgregar.getTfDenominacion().setText("");
    }
    
    public static void btnEliminar(){
        
    }
    
    public static void btnAgregar(){
        
        String sku = ventAgregar.getTfSKU().getText();
        String denominacion = ventAgregar.getTfDenominacion().getText();
        
        ModeloDeZapatilla nuevo = new ModeloDeZapatilla(sku, denominacion);
        
        DatosController.AgregarModelo(nuevo);
        
        ventAgregar.getTfSKU().setText("");
        ventAgregar.getTfDenominacion().setText("");
        actualizarTabla();
    }
}
