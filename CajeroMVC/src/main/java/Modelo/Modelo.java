/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import DTO.CajeroDTO;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.TransaccionDTO;
import EntidadesMock.Cajero;
import EntidadesMock.Cliente;
import EntidadesMock.Cuenta;
import Vista.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Moreno
 */
public class Modelo implements IModelo {

    List<Observador> observadores = new ArrayList<>();

    // Entidades internas del Modelo
    private Cajero cajero;
    private Cuenta cuenta;
    private Cliente cliente; // Es más claro tener un "cliente actual"

    public Modelo() {
        this.cajero = new Cajero("CAJERO-001", 50000);

        // Asignar como el cliente que "inició sesión"
        this.cliente = new Cliente("1", "Juan", "Velasquez", "Perez");

        // Crear cuenta de prueba y asociarla al cliente
        this.cuenta = new Cuenta("1234-5678", "Débito", "4152 3138 2132 2332", "1", 34010.50);

    }

    public void ingresarBanco() {
        notificarObservadores(TipoEvento.INCIALIZAR_DATOS);
    }

    public void iniciarTransaccion() {
        notificarObservadores(TipoEvento.INICIAR_TRANSACCION);
    }

    public void notificarObservadores(TipoEvento evento) {
        for (Observador observador : observadores) {
            observador.actualiza(this, evento);
        }
    }

    public void agregarObsevador(Observador observador) {
        observadores.add(observador);
    }

    public ClienteDTO getCliente() {
        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellidoPaterno(),
                cliente.getApellidoMaterno()
        );
    }

    public CuentaDTO getCuenta() {
        return new CuentaDTO(
                cuenta.getNumeroCuenta(),
                cuenta.getTipoCuenta(),
                cuenta.getNumeroTarjeta(),
                cuenta.getIdCliente(),
                cuenta.getSaldo()
        );
    }

    public CajeroDTO getCajero() {
        return new CajeroDTO(
                cajero.getIdentificadorCajero(),
                cajero.getDineroDisponible()
        );
    }

    public TransaccionDTO getTransaccion() {
        return new TransaccionDTO();
    }
}
