/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class SupervisorDeLinea extends Usuario{
    
    private LineaDeProduccion linea;

    public SupervisorDeLinea(int id, String nombreDeUsuario, String contraseña, long documento, String apynom, String email, LineaDeProduccion linea) {
        super(id, nombreDeUsuario, contraseña, documento, apynom, email);
        this.linea = linea;
    }

    public LineaDeProduccion getLinea() {
        return linea;
    }

    public void setLinea(LineaDeProduccion linea) {
        this.linea = linea;
    }
}

