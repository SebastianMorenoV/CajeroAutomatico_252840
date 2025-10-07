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
import EntidadesMock.Transaccion;
import Vista.Observador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private Transaccion transaccion;
    
    public Modelo() {
        this.cajero = new Cajero("CAJERO-001", 50000);

        // Asignar como el cliente que "inició sesión"
        this.cliente = new Cliente("1", "Juan", "Velasquez", "Perez");

        // Crear cuenta de prueba y asociarla al cliente
        this.cuenta = new Cuenta("1234-5678", "Débito", "4152 3138 2132 2332", "1", 34010.50);
        
        this.transaccion = new Transaccion();
        
    }
    
    public void ingresarBanco() {
        notificarObservadores(TipoEvento.INCIALIZAR_DATOS);
    }
    
    public void iniciarRetiro() {
        notificarObservadores(TipoEvento.INICIAR_RETIRO);
    }
    
    public void calcularRetiro(double monto) {
        if (monto < 0 || monto > cuenta.getSaldo()) {
            notificarObservadores(TipoEvento.FONDOS_INSUFICIENTES);
            return;
        }
        
        transaccion.setEstado("Pendiente");
        transaccion.setTipo("Retiro");
        transaccion.setCliente(cliente);
        transaccion.setMonto(monto);
        //Calculos necesarios
        final double TASA_DE_COMISION = 0.02;
        double saldo = cuenta.getSaldo();
        double montoComision = monto * TASA_DE_COMISION;
        transaccion.setComision(montoComision);
        double saldoRestante = saldo - monto - montoComision;
        transaccion.setSaldoRestante(saldoRestante);
        
        notificarObservadores(TipoEvento.CALCULOS_REALIZADOS);
    }
    
    public void finalizarRetiro() {
        //Actualiza los datos de la cuenta de el cliente.
        cuenta.setSaldo(transaccion.getSaldoRestante());
        // Finaliza la transaccion y asigna datos no incluidos.
        transaccion.setFechaHora(LocalDateTime.now());
        transaccion.setId(String.valueOf(new Random().nextInt())); //id random no especifica en las reglas de negocio.
        transaccion.setEstado("Exitosa");
        
        notificarObservadores(TipoEvento.FINALIZAR_RETIRO);
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
    
    @Override
    public CuentaDTO getCuenta() {
        return new CuentaDTO(
                cuenta.getNumeroCuenta(),
                cuenta.getTipoCuenta(),
                cuenta.getNumeroTarjeta(),
                cuenta.getIdCliente(),
                cuenta.getSaldo()
        );
    }
    
    @Override
    public CajeroDTO getCajero() {
        return new CajeroDTO(
                cajero.getIdentificadorCajero(),
                cajero.getDineroDisponible()
        );
    }
    
    public TransaccionDTO getTransaccion() {
        TransaccionDTO transaccionDTO = new TransaccionDTO();
        transaccionDTO.setIdentificador(transaccion.getId());
        transaccionDTO.setFechaHora(transaccion.getFechaHora());
        transaccionDTO.setEstado(transaccion.getEstado());
        transaccionDTO.setTipo(transaccion.getTipo());
        transaccionDTO.setCliente(new ClienteDTO(transaccion.getCliente().getIdCliente(), transaccion.getCliente().getNombre(),
                transaccion.getCliente().getApellidoPaterno(), transaccion.getCliente().getApellidoMaterno()));
        transaccionDTO.setCuenta(new CuentaDTO(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getNumeroTarjeta(), cuenta.getIdCliente(), cuenta.getSaldo()));
        transaccionDTO.setMonto(transaccion.getMonto());
        transaccionDTO.setComision(transaccion.getComision());
        transaccionDTO.setSaldoRestante(transaccion.getSaldoRestante());
        
        return transaccionDTO;
    }
}
