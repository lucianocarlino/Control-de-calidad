/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Color;
import Modelo.Datos;
import Modelo.ModeloDeZapatilla;
import Vista.AgregarModelo;
import Vista.GestionModelos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    public static void btnEliminar(){
        int[] selected = ventana.getjTable1().getSelectedRows();
        
        for(int fila : selected){
            String id = ventana.getjTable1().getValueAt(fila, 0).toString();
            
            DatosController.EliminarModelo(id);
        }
        
        actualizarTabla();
    }
    
    public static void mostrarAgregar() {
        ventAgregar.setVisible(true);
        ventAgregar.setLocationRelativeTo(null);
        ventAgregar.getTfSKU().setText("");
        ventAgregar.getTfDenominacion().setText("");
        actualizarColores();
    }
    
    public static void actualizarColores(){
        DefaultTableModel tabla = (DefaultTableModel) ventAgregar.getTableColores().getModel();
               
        tabla.setNumRows(0);
        for(Color p : DatosController.datos.getColors()){
                if (!p.getBajaLogica()) {
                Object[] fila = new Object[3];

                fila[0] = false;
                fila[1] = p.getCodigo();
                fila[2] = p.getDescripcion();

                tabla.addRow(fila);
            }
        }
    }
    
    public static void btnAgregar(){
        
        String sku = ventAgregar.getTfSKU().getText().trim();
        String denominacion = ventAgregar.getTfDenominacion().getText().trim();
        ArrayList<Integer> codigos = new ArrayList<>();
        ArrayList<Color> colores = new ArrayList<>();
        DefaultTableModel tabla = (DefaultTableModel) ventAgregar.getTableColores().getModel();
        
        for(int i = 0; i < tabla.getRowCount(); i++){
            System.out.println(tabla.getValueAt(i, 0).toString());
            
            if(tabla.getValueAt(i, 0).toString() == "true"){
                System.out.println(tabla.getValueAt(i, 1).toString());
                codigos.add(Integer.parseInt(tabla.getValueAt(i, 1).toString()));
            }       
        }
        
        for(Integer cod : codigos){
            System.out.println(cod.intValue());
            colores.add(DatosController.getColorPorCodigo(cod.intValue()));      
        }
        
        if(sku.equals("") || denominacion.equals("")){
            JOptionPane.showMessageDialog(ventana, "Error: Rellene los campos");
            return;
        }
        
        if(colores.isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Error: Seleccione al menos un color");
            return;
        }
        
        ModeloDeZapatilla nuevo = new ModeloDeZapatilla(sku, denominacion, colores);
        
        if(!DatosController.AgregarModelo(nuevo))
            JOptionPane.showMessageDialog(ventana, "Error: SKU ya usado");
        
        ventAgregar.getTfSKU().setText("");
        ventAgregar.getTfDenominacion().setText("");
        actualizarColores();
        actualizarTabla();
    }
}
