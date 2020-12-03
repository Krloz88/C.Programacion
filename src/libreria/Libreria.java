/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.awt.Menu;
import libreria.interfaz.menu;
import libreria.servicios.ClienteServicio;

/**
 *
 * @author k
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu menu = new menu();
        
        menu.menuOpciones();
            
    }
}
