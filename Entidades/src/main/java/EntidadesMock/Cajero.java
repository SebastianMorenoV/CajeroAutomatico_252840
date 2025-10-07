/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesMock;

/**
 *
 * @author Sebastian Moreno
 */
public class Cajero {
    String identificadorCajero;
    int dineroDisponible;

    public Cajero(String identificadorCajero, int dineroDisponible) {
        this.identificadorCajero = identificadorCajero;
        this.dineroDisponible = dineroDisponible;
    }

    public Cajero() {
    }

    public String getIdentificadorCajero() {
        return identificadorCajero;
    }

    public void setIdentificadorCajero(String identificadorCajero) {
        this.identificadorCajero = identificadorCajero;
    }

    public int getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(int dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
    
}
