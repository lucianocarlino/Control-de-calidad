/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Datos;
import Vista.VistaLogin;
import Vista.*;
import javax.swing.JOptionPane;

public class LoginController {
    public static VistaLogin  ventana = new VistaLogin();
    public static void mostrar(){ ventana.setVisible(true); ventana.setLocationRelativeTo(null);}
    public static void ocultar(){ventana.setVisible(false);}

    public static void botonContinuar()
    {
       String usuario=  ventana.getjTextField1().getText(); 
       String clave = ventana.getjTextField2().getText();
       
       int estadoLogin = DatosController.login(usuario, clave);
       
       if (estadoLogin == Datos.LOGGEDIN) {
           LoginController.ocultar();
           MenuController.mostrar();
       }
       else {
           String mensaje = (estadoLogin == Datos.CONTRASEÑA_INCORRECTA) ? "Usuario o contraseña incorrectos" : "Usuario inexistente";
           JOptionPane.showMessageDialog(ventana, mensaje);
           ventana.getTfUsuario().setText("");
           ventana.getTfClave().setText("");
       }
    }
    
}
