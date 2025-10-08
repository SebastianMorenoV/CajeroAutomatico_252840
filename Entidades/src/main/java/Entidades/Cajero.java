
package Entidades;

/**
 * Esta clase representa un cajero dentro de un banco
 * Simulando que deberia de tener dinero valido para poder retirar o hacer movimientos.
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
