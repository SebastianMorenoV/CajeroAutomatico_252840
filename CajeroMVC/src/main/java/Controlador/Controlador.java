
package Controlador;

import Modelo.Modelo;

/**
 * Representa el mediador entre la vista(Presentacion) y modelo (Datos)
 * Recibe parametros de la vista y delega responsabilidad a modelo.
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
    
    public void iniciarRetiro(){
        modelo.iniciarRetiro();
    }
    
    public void calcularRetiro(double monto){
        modelo.calcularRetiro(monto);
    }
    public void finalizarRetiro(){
        modelo.finalizarRetiro();
    }
}
