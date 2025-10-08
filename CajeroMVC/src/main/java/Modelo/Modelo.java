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
 * Actúa como mediador entre la fachada (dominio) y la vista (presentación) mediante patron observer. Es
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
    /**
     * Encargado de inicializar los datos de el cliente(cuenta) y avisar las vistas que se pueden actualizar.
     */
    public void ingresarBanco() {
        cajeroFachada.inicializarDatos();
        this.transaccionActual = cajeroFachada.getTransaccionEntidad();
        notificarObservadores(TipoEvento.INCIALIZAR_DATOS);
    }
    /**
     * Encargado de notificar que el retiro se puede comenzar a crear.
     */
    public void iniciarRetiro() {
        notificarObservadores(TipoEvento.INICIAR_RETIRO);
    }
    /**
     * Metodo para calcular el retiro temporal (cuando un retiro no ha sido concluido).
     * Delega la logica a la fachada para la creacion de una transaccion y valida que la transaccion a sido valida.
     * Si la transaccion es valida notifica a quien este escuchando para su actualización.
     * Sino notifica que no se pudo hacer la transacción.
     * @param monto el monto en dinero que se utiliza para crear una transaccion temporal.
     */
    public void calcularRetiro(double monto) {
        Transaccion transaccionCalculada = cajeroFachada.calcularRetiro(monto);

        if (transaccionCalculada == null) {
            notificarObservadores(TipoEvento.FONDOS_INSUFICIENTES);
            return;
        }

        this.transaccionActual = transaccionCalculada;
        notificarObservadores(TipoEvento.CALCULOS_REALIZADOS);
    }
    /**
     * Metodo final para un retiro.
     * Solo sucede si una transaccion temporal existe, delega la tarea hacia la fachada.
     * Notifica que un retiro fue finalizado a sus suscriptores
     */
    public void finalizarRetiro() {
        this.transaccionActual = cajeroFachada.finalizarRetiro();
        notificarObservadores(TipoEvento.FINALIZAR_RETIRO);
    }
    /**
     * Convierte un cliente entidad a un DTO
     * @return un ClienteDTO
     */
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
    /**
     * Metodo auxiliar para ocultar el numero de cuenta.
     * Solo es una simulacion, para ver que los datos no viajen como se reciben
     * @param numero numero de cuenta a ocultar.
     * @return El numero de cuenta ocultado menos los 4 ultimos digitos.
     */
    private String ocultarNumeroCuenta(String numero) {
        if (numero == null || numero.length() < 16) {
            return "**** **** **** ****";
        }
        String ultimosCuatroDigitos = numero.replaceAll("\\s+", "").substring(12);
        return "**** **** **** " + ultimosCuatroDigitos;
    }
    /**
     * Metodo de patron observer que actualiza a todos sus suscriptores
     * les notifica con los mismos datos de modelo y un evento para que sepan como actuar en cada caso.
     * @param evento es el evento que esta sucediendo en modelo.
     */
    public void notificarObservadores(TipoEvento evento) {
        for (Observador observador : observadores) {
            observador.actualiza(this, evento);
        }
    }
    /**
     * Funciona para agregar un nuevo suscriptor o escuchante a este modelo.
     * @param observador el suscriptor a los cambios de esta clase.
     */
    public void agregarObsevador(Observador observador) {
        observadores.add(observador);
    }
}
