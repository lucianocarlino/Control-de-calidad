/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.time.LocalDate;

/**
 *
 * @author LUCIANO
 */
public class DatosController {
    public static Datos datos = new Datos();
    
    public static boolean AgregarColor(Color nuevo){
        
        int codigoNuevo = nuevo.getCodigo();
        
        for(Color c : datos.getColors()){
            if(c.getCodigo() == codigoNuevo)
                return false;
        }
        datos.getColors().add(nuevo);
        return true;
    }
    
    public static boolean AgregarModelo(ModeloDeZapatilla nuevo){
        
        String codigoNuevo = nuevo.getSKU();
        
        for(ModeloDeZapatilla c : datos.getModels()){
            if(codigoNuevo.equals(c.getSKU()))
                return false;
        }
        
        datos.getModels().add(nuevo);
        return true;
        
    }
    
    public static void EliminarColor(int codigo){
        datos.eliminarColor(codigo);
    }
    
    public static void EliminarModelo(String SKU){
        datos.eliminarModelo(SKU);
    }
    
    public static ModeloDeZapatilla getModeloPorSKU(String sku) {
        ModeloDeZapatilla modelo = new ModeloDeZapatilla();
        
        for (ModeloDeZapatilla m: datos.getModels()) {
            if (m.getSKU().equals(sku)) {
                modelo = m;
                break;
            }
        }
        
        return modelo;
    }
    
    public static Color getColorPorCodigo(int codigo) {
        Color color = new Color();
        
        for (Color m: datos.getColors()) {
            if (m.getCodigo() == codigo) {
                color = m;
                break;
            }
        }
        
        return color;
    }
    
    public static boolean iniciarOP(ModeloDeZapatilla modelo, Color color) {
        LocalDate now = LocalDate.now();
        
        boolean opIniciada = datos.iniciarOP(1, now.getDayOfMonth(), now.getMonthValue(), now.getYear(), modelo, color, (SupervisorDeLinea) datos.getLoggedIn());
    
        return opIniciada;
    }

    public static int login(String nombre, String contraseña) {
        Usuario usuario = datos.getUsuarioPorUsername(nombre);
        
        try {
            if (usuario.getContraseña().equals(contraseña)) {
                datos.setLoggedIn(usuario);
                return Datos.LOGGEDIN;
            }
            else {
                return Datos.CONTRASEÑA_INCORRECTA;
            }
        }
        catch (Exception e) {
            return Datos.USUARIO_INEXISTENTE;
        }
    }
}
