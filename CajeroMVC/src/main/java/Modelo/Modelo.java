package Modelo;

import DTO.CajeroDTO;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.TransaccionDTO; 
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Transaccion;
import Fachada.CajeroFachada;
import Fachada.ICajeroFachada;
import Vista.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 * Actúa como mediador entre la fachada (dominio) y la vista (presentación). Es
 * responsable de convertir las entidades del dominio en DTOs para la vista.
 *
 * @author Sebastian Moreno
 */
public class Modelo implements IModelo {

    private final List<Observador> observadores;
    private final ICajeroFachada cajeroFachada;
    private Transaccion transaccionActual; 

    public Modelo() {
        this.observadores = new ArrayList<>();
        this.cajeroFachada = new CajeroFachada();
    }

    public void ingresarBanco() {
        cajeroFachada.inicializarDatos();
        this.transaccionActual = cajeroFachada.getTransaccionEntidad();
        notificarObservadores(TipoEvento.INCIALIZAR_DATOS);
    }

    public void iniciarRetiro() {
        notificarObservadores(TipoEvento.INICIAR_RETIRO);
    }

    public void calcularRetiro(double monto) {
        Transaccion transaccionCalculada = cajeroFachada.calcularRetiro(monto);

        if (transaccionCalculada == null) {
            notificarObservadores(TipoEvento.FONDOS_INSUFICIENTES);
            return;
        }

        this.transaccionActual = transaccionCalculada;
        notificarObservadores(TipoEvento.CALCULOS_REALIZADOS);
    }

    public void finalizarRetiro() {
        this.transaccionActual = cajeroFachada.finalizarRetiro();
        notificarObservadores(TipoEvento.FINALIZAR_RETIRO);
    }

    @Override
    public ClienteDTO getCliente() {
        Cliente clienteEntidad = cajeroFachada.getClienteEntidad();
        return new ClienteDTO(
                clienteEntidad.getIdCliente(),
                clienteEntidad.getNombre(),
                clienteEntidad.getApellidoPaterno(),
                clienteEntidad.getApellidoMaterno()
        );
    }

    @Override
    public CuentaDTO getCuenta() {
        Cuenta cuentaEntidad = cajeroFachada.getCuentaEntidad();
        return new CuentaDTO(
                cuentaEntidad.getNumeroCuenta(),
                cuentaEntidad.getTipoCuenta(),
                cuentaEntidad.getNumeroTarjeta(), 
                cuentaEntidad.getIdCliente(),
                cuentaEntidad.getSaldo()
        );
    }

    @Override
    public CajeroDTO getCajero() {
        return new CajeroDTO(
                cajeroFachada.getCajeroEntidad().getIdentificadorCajero(),
                cajeroFachada.getCajeroEntidad().getDineroDisponible()
        );
    }

    @Override
    public TransaccionDTO getTransaccion() {
        Cliente clienteEntidad = transaccionActual.getCliente();
        Cuenta cuentaEntidad = cajeroFachada.getCuentaEntidad();

        TransaccionDTO dto = new TransaccionDTO();
        dto.setIdentificador(transaccionActual.getId());
        dto.setFechaHora(transaccionActual.getFechaHora());
        dto.setEstado(transaccionActual.getEstado());
        dto.setTipo(transaccionActual.getTipo());
        dto.setMonto(transaccionActual.getMonto());
        dto.setComision(transaccionActual.getComision());
        dto.setSaldoRestante(transaccionActual.getSaldoRestante());

        if (clienteEntidad != null) {
            dto.setCliente(new ClienteDTO(
                    clienteEntidad.getIdCliente(), clienteEntidad.getNombre(),
                    clienteEntidad.getApellidoPaterno(), clienteEntidad.getApellidoMaterno()));
        }
        dto.setCuenta(new CuentaDTO(
                cuentaEntidad.getNumeroCuenta(), cuentaEntidad.getTipoCuenta(),
                ocultarNumeroCuenta(cuentaEntidad.getNumeroTarjeta()),
                cuentaEntidad.getIdCliente(), cuentaEntidad.getSaldo()));

        return dto;
    }

    private String ocultarNumeroCuenta(String numero) {
        if (numero == null || numero.length() < 16) {
            return "**** **** **** ****";
        }
        String ultimosCuatroDigitos = numero.replaceAll("\\s+", "").substring(12);
        return "**** **** **** " + ultimosCuatroDigitos;
    }

    public void notificarObservadores(TipoEvento evento) {
        for (Observador observador : observadores) {
            observador.actualiza(this, evento);
        }
    }

    public void agregarObsevador(Observador observador) {
        observadores.add(observador);
    }
}
