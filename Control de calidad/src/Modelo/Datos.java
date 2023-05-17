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
    private ArrayList<OrdenDeProduccion> ordenes = new ArrayList<>();
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
        usuarios.add(new SupervisorDeLinea(1, "admin", "1234", 1234, "supervisor", "sup@mail.com"));
        
        lineas.add(new LineaDeProduccion(2, "Linea 2"));
    }
    
    public Object[] getSKUA(){
        
        /*ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            SKUs.add(m.getSKU());
        }
        return SKUs.toArray();*/
        
        ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            if (!m.getBajaLogica()) {
                SKUs.add(m.toString());
            }
        }
        return SKUs.toArray();
    }
    
    public Object[] getCodigosA(ModeloDeZapatilla model){
        
        ArrayList<String> codigos = new ArrayList<>();
        /*for (Color m : colors){
            codigos.add(m.getCodigo());
        }*/
        
        for (Color m : model.getColores()){
            if (!m.getBajaLogica()) {
                codigos.add(m.toString());
            }
        }
        
        return codigos.toArray();
    }
    
    public void eliminarColor(int codigo){
        
        int index = -1;
        
        for(Color c : colors){
            if(c.getCodigo() == codigo){
                index = colors.indexOf(c);
                c.setBajaLogica(Boolean.TRUE);
                break;
            }
        }
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

    public void eliminarLinea(int numero) {
        int index = -1;
        
        for(LineaDeProduccion l : lineas){
            if(l.getNumero() == numero){
                index = lineas.indexOf(l);
                break;
            }
        }
        
        lineas.remove(index);
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
    
    public OrdenDeProduccion buscarOPI() {
        OrdenDeProduccion opi = new OrdenDeProduccion();
        
        for (OrdenDeProduccion o: ordenes) {
            if (o.getEstado() == OrdenDeProduccion.INICIADA) {
                opi = o;
                break;
            }
        }
        
        return opi;
    }
    
    public boolean iniciarOP(LocalDate fechaInicio, ModeloDeZapatilla modelo, Color color, int cantidad, SupervisorDeLinea supervisor, LineaDeProduccion linea) {
        if (buscarOPI().getEstado() != OrdenDeProduccion.INICIADA) {
            OrdenDeProduccion o = new OrdenDeProduccion(ordenes.size() + 1, fechaInicio, modelo, color, cantidad, supervisor, linea);
            ordenes.add(o);
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<OrdenDeProduccion> getOrdenesDeProduccion() {
        return ordenes;
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

    public ArrayList<LineaDeProduccion> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDeProduccion> lineas) {
        this.lineas = lineas;
    }
}
