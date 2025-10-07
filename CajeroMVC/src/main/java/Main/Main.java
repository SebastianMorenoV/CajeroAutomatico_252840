/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VistaMenuPrincipal;

/**
 *
 * @author Sebastian Moreno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Controlador control = new Controlador(modelo);
        VistaMenuPrincipal vista = new VistaMenuPrincipal(control);
        modelo.agregarObsevador(vista);
        control.ingresarBanco();
    }
    
}
