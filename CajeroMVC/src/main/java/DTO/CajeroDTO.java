/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Sebastian Moreno
 */
public class CajeroDTO {

    String identificadorCajero;
    int dineroDisponible;

    public CajeroDTO(String identificadorCajero, int dineroDisponible) {
        this.identificadorCajero = identificadorCajero;
        this.dineroDisponible = dineroDisponible;
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
