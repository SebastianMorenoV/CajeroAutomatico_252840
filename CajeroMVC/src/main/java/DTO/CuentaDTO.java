
package DTO;

/** 
 * Esta clase Data transfer Object representa una cuenta de un cliente
 * utilizada en la vista para saber cuanto dinero hay en la cuenta de un cliente.
 * @author Sebastian Moreno
 */
public class CuentaDTO {

    String numeroCuenta;
    String tipoCuenta;
    String numeroTarjeta;
    String idCliente;
    double saldo;

    public CuentaDTO() {
    }

    public CuentaDTO(String numeroCuenta, String tipoCuenta, String numeroTarjeta, String idCliente, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.numeroTarjeta = numeroTarjeta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" + "numeroCuenta=" + numeroCuenta + ", tipoCuenta=" + tipoCuenta + ", numeroTarjeta=" + numeroTarjeta + ", idCliente=" + idCliente + ", saldo=" + saldo + '}';
    }
    
}
