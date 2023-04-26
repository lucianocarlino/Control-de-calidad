/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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

    public Datos() {
        
        //Agregar modelos
        
        colors.add(new Color("Rojo", 111));
        colors.add(new Color("Azul", 222));
        colors.add(new Color("Amarillo", 333));
        colors.add(new Color("Verde", 444));
        colors.add(new Color("Morado", 555));
        
        models.add(new ModeloDeZapatilla("111", "Lindo"));
        models.add(new ModeloDeZapatilla("222", "Feo"));
        models.add(new ModeloDeZapatilla("333", "Masomenos"));
        
        usuarios.add(new SupervisorDeLinea(1, "admin", "1234", 1234, "supervisor", "sup@mail.com"));
        
        ordenDeProduccion = new OrdenDeProduccion();
        
    }
    
    public Object[] getSKUA(){
        
        ArrayList<String> SKUs = new ArrayList<>();
        for (ModeloDeZapatilla m : models){
            SKUs.add(m.getSKU());
        }
        return SKUs.toArray();
    }
    
    public Object[] getCodigosA(){
        
        ArrayList<Integer> codigos = new ArrayList<>();
        for (Color m : colors){
            codigos.add(m.getCodigo());
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
    
    public boolean iniciarOP(long id, int dia, int mes, int año, ModeloDeZapatilla modelo, Color color, SupervisorDeLinea supervisor) {
        if (ordenDeProduccion.getEstado() == OrdenDeProduccion.NULA){
            ordenDeProduccion = new OrdenDeProduccion(id, dia, mes, año, modelo, color, supervisor);
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
