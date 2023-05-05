/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Datos {
    public static final int LOGGEDIN = 1;
    public static final int CONTRASEÑA_INCORRECTA = -1;
    public static final int USUARIO_INEXISTENTE = -2;
    
    private int idOrdenes = 0;
    private Usuario loggedIn;
    private ArrayList<Color> colors = new ArrayList<>();
    private ArrayList<ModeloDeZapatilla> models = new ArrayList<>();
    private OrdenDeProduccion ordenDeProduccion;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<LineaDeProduccion> lineas = new ArrayList<>();

    public Datos() {
        
        //Agregar modelos
        
        colors.add(new Color("Rojo", 111));
        colors.add(new Color("Azul", 222));
        colors.add(new Color("Amarillo", 333));
        colors.add(new Color("Verde", 444));
        colors.add(new Color("Morado", 555));
        
        models.add(new ModeloDeZapatilla("111", "Lindo", colors));
        models.add(new ModeloDeZapatilla("222", "Feo", colors));
        models.add(new ModeloDeZapatilla("333", "Masomenos", colors));
        
        lineas.add(new LineaDeProduccion(1, "Linea 1"));
        usuarios.add(new SupervisorDeLinea(1, "admin", "1234", 1234, "supervisor", "sup@mail.com", lineas.get(0)));
        
        lineas.add(new LineaDeProduccion(2, "Linea 2"));
        
        ordenDeProduccion = new OrdenDeProduccion();
        
    }
    
    public Object[] getSKUA(){
        
        /*ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            SKUs.add(m.getSKU());
        }
        return SKUs.toArray();*/
        
        ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            SKUs.add(m.toString());
        }
        return SKUs.toArray();
    }
    
    public Object[] getCodigosA(ModeloDeZapatilla model){
        
        ArrayList<String> codigos = new ArrayList<>();
        /*for (Color m : colors){
            codigos.add(m.getCodigo());
        }*/
        
        for (Color m : model.getColores()){
            codigos.add(m.toString());
        }
        
        return codigos.toArray();
    }
    
    public void eliminarColor(int codigo){
        
        int index = -1;
        
        for(Color c : colors){
            if(c.getCodigo() == codigo){
                index = colors.indexOf(c);
                break;
            }
        }
        
        colors.remove(index);
    }
    
    public void eliminarModelo(String codigo){
        
        int index = -1;
        
        for(ModeloDeZapatilla c : models){
            if(c.getSKU() == codigo){
                index = models.indexOf(c);
                break;
            }
        }
        
        models.remove(index);
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<ModeloDeZapatilla> getModels() {
        return models;
    }

    public void setModels(ArrayList<ModeloDeZapatilla> models) {
        this.models = models;
    }
    
    public boolean iniciarOP(long id, LocalDate fechaInicio, ModeloDeZapatilla modelo, Color color, int cantidad, SupervisorDeLinea supervisor, LineaDeProduccion linea) {
        if (ordenDeProduccion.getEstado() == OrdenDeProduccion.NULA) {
            ordenDeProduccion = new OrdenDeProduccion(id, fechaInicio, modelo, color, cantidad, supervisor, linea);
            return true;
        }
        else {
            return false;
        }
    }

    public OrdenDeProduccion getOrdenDeProduccion() {
        return ordenDeProduccion;
    }
    
    public Usuario getUsuarioPorId(int id) {
        Usuario usuario = new Usuario();
        
        for (Usuario u: usuarios) {
            if (u.getId() == id) {
                usuario = u;
                break;
            }
        }
        
        return usuario;
    }
    
    public Usuario getUsuarioPorUsername(String nombre) {
        Usuario usuario = new Usuario();
        
        for (Usuario u: usuarios) {
            if (u.getNombreDeUsuario().equals(nombre)) {
                usuario = u;
                break;
            }
        }
        
        return usuario;
    }

    public Usuario getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Usuario loggedIn) {
        this.loggedIn = loggedIn;
    }
    
}
