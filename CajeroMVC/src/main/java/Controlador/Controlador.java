/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo;

/**
 *
 * @author Sebastian Moreno
 */
public class Controlador {
    Modelo modelo;
    public Controlador(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void ingresarBanco(){
        modelo.ingresarBanco();
    }
    
    public void iniciarTransaccion(){
        modelo.iniciarTransaccion();
    }
    
    public void calcularTransaccion(double monto){
        modelo.calcularTransaccion(monto);
    }
}
