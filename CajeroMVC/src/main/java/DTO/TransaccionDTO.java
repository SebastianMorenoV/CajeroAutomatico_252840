
package DTO;

import java.time.LocalDateTime;

/**
 * Esta clase representa una transaccion temporal o final dependiendo de el estado de el sistema.
 * Utilizada en la vista para crear o finalizar una transaccion.
 * @author Sebastian Moreno
 */
public class TransaccionDTO {

    String identificador;
    ClienteDTO cliente;
    CuentaDTO cuenta;
    LocalDateTime fechaHora;
    String estado;
    String tipo;
    double monto;
    double comision;
    double saldoRestante;

    public TransaccionDTO() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(double saldoRestante) {
        this.saldoRestante = saldoRestante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CuentaDTO getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaDTO cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" + "identificador=" + identificador + ", cliente=" + cliente + ", cuenta=" + cuenta + ", fechaHora=" + fechaHora + ", estado=" + estado + ", tipo=" + tipo + ", monto=" + monto + ", comision=" + comision + ", saldoRestante=" + saldoRestante + '}';
    }

}
