/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package control.de.calidad;

import Vista.VistaLogin;
import Vista.VistaMenu;
import Controlador.*;

/**
 *
 * @author User
 */
public class ControlDeCalidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        LoginController loginController = new LoginController();
        loginController.mostrar();
    }
    
}
