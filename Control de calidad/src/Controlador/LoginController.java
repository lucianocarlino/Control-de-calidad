/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.VistaLogin;
import Vista.*;

public class LoginController {
    public static VistaLogin  ventana = new VistaLogin();
    public static void mostrar(){ ventana.setVisible(true); ventana.setLocationRelativeTo(null);}
    public static void ocultar(){ventana.setVisible(false);}

    public static void botonContinuar()
    {
      String usuario=  ventana.getjTextField1().getText(); 
       String clave = ventana.getjTextField2().getText();
       if (usuario.equals("admin") && clave.equalsIgnoreCase("1234") ){
           LoginController.ocultar();
           MenuController.mostrar();
       }
       else{
           System.out.println("Usuario o Clave incorrectos"); 
       }
    }
    
}
