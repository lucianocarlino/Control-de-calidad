/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Usuario {
    private int id;
    private String nombreDeUsuario;
    private String contraseña;
    private long documento;
    private String apynom;
    private String email;

    public Usuario(int id, String nombreDeUsuario, String contraseña, long documento, String apynom, String email) {
        this.id = id;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contraseña = contraseña;
        this.documento = documento;
        this.apynom = apynom;
        this.email = email;
    }
    
    public Usuario() {
        
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public String getApynom() {
        return apynom;
    }

    public void setApynom(String apynom) {
        this.apynom = apynom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
    
    
}
