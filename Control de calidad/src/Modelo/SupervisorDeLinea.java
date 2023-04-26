/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class SupervisorDeLinea extends Usuario{
    
    private LineaDeProduccion linea;

    public SupervisorDeLinea(String nombreDeUsuario, String contraseña, long documento, String apynom, String email) {
        super(nombreDeUsuario, contraseña, documento, apynom, email);
    }

    public LineaDeProduccion getLinea() {
        return linea;
    }

    public void setLinea(LineaDeProduccion linea) {
        this.linea = linea;
    }
    
    public OrdenDeProduccion crearOrden(ModeloDeZapatilla Modelo, Color Color){
        //instanciacion int id = datos.idOrdenes + 1; //Instanciacion
        int estado = 0;
        System.out.println("Ingrese el dia");
        Scanner scanner = new Scanner(System.in);
        int dia = scanner.nextInt();
        System.out.println("Ingrese el mes");
        int mes = scanner.nextInt();
        System.out.println("Ingrese el anio");
        int anio = scanner.nextInt();
        ModeloDeZapatilla modelo = Modelo;
        Color color = Color;
        SupervisorDeLinea supervisor = this;
        
        OrdenDeProduccion orden = null;
        
        //orden.setId(id);
        orden.setEstado(estado);
        orden.setDia(dia);
        orden.setMes(mes);
        orden.setAño(anio);
        orden.setModelo(modelo);
        orden.setColor(color);
        orden.setSupervisor(supervisor);
        
        return orden;
    }
    
}

