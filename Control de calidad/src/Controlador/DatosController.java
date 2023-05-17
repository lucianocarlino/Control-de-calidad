/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    
    public static boolean AgregarLinea(LineaDeProduccion nuevo){
        
        int numeroNuevo = nuevo.getNumero();
        
        for(LineaDeProduccion l : datos.getLineas()){
            if(numeroNuevo == l.getNumero())
                return false;
        }
        
        datos.getLineas().add(nuevo);
        return true;
        
    }
    
    public static void EliminarColor(int codigo){
        datos.eliminarColor(codigo);
    }
    
    public static void EliminarModelo(String SKU){
        datos.eliminarModelo(SKU);
    }
    
    public static void EliminarLinea(int numero){
        datos.eliminarLinea(numero);
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
    
    public static boolean iniciarOP(ModeloDeZapatilla modelo, Color color, LineaDeProduccion linea, int cantidad) {
        LocalDate ahora = LocalDate.now();
        
        boolean opIniciada = datos.iniciarOP(ahora, modelo, color, cantidad, (SupervisorDeLinea) datos.getLoggedIn(), linea);
    
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

    public static LineaDeProduccion getLineaPorNumero(int numero) {
        LineaDeProduccion linea = new LineaDeProduccion();
        
        for (LineaDeProduccion l: datos.getLineas()) {
            if (l.getNumero() == numero) {
                linea = l;
                break;
            }
        }
        
        return linea;
    }
    
    public static Object[] getNumerosLineas() {
        ArrayList<String> numeros = new ArrayList<>();
        /*for (Color m : colors){
            codigos.add(m.getCodigo());
        }*/
        
        for (LineaDeProduccion l : datos.getLineas()){
            if (!l.getBajaLogica()) {
                numeros.add(l.toString());
            }
        }
        
        return numeros.toArray();
    }
}
