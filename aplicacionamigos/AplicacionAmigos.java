/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionamigos;

import aplicacionamigos.models.gestorAmigos;
import aplicacionamigos.models.views.ventanaPrincipal;

/**
 *  Clase principal que inicializa la aplicacion de la gestion de amigos
 * 
 * @author Sofia Bermudez
 * @version 1.0.0
 * @since 26032025
 */
public class AplicacionAmigos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gestorAmigos gestor= new gestorAmigos();
        ventanaPrincipal ventana = new ventanaPrincipal();
        ventana.setVisible(true);
    }
    
}
