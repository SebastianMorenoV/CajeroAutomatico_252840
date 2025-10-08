package Fachada;

import Entidades.Cajero;
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Transaccion;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Implementación de la fachada que mockea los datos y la lógica del cajero.
 *
 * @author Sebastian Moreno
 */
public class CajeroFachada implements ICajeroFachada {

    private Cajero cajero;
    private Cuenta cuenta;
    private Cliente cliente;
    private Transaccion transaccion;

    @Override
    public void inicializarDatos() {
        this.cajero = new Cajero("CAJERO-001", 50000);
        this.cliente = new Cliente("1", "Juan", "Velasquez", "Perez");
        this.cuenta = new Cuenta("1234-5678", "Débito", "4152 3138 2132 2332", "1", 34010.50);
        this.transaccion = new Transaccion();
    }
    /**
     * Metodo para calcular un retiro dependiendo de un monto especifico.
     * Crea una transaccion "temporal" con la finalidad de que un usuario pueda ver el detalle de la transaccion en ese momento.
     * @param monto es el monto con el que se creara una transaccion.
     * @return la transaccion temporal en caso de que sea valida o null caso que no lo sea.
     */
    @Override
    public Transaccion calcularRetiro(double monto) {
        if (monto < 0 || monto > cuenta.getSaldo()) {
            return null; // El modelo interpretará esto como fondos insuficientes
        }

        transaccion.setEstado("Pendiente");
        transaccion.setTipo("Retiro");
        transaccion.setCliente(cliente);
        transaccion.setMonto(monto);

        final double TASA_DE_COMISION = 0.02;
        double saldo = cuenta.getSaldo();
        double montoComision = monto * TASA_DE_COMISION;
        transaccion.setComision(montoComision);
        double saldoRestante = saldo - monto - montoComision;
        transaccion.setSaldoRestante(saldoRestante);

        return this.transaccion; // Devuelve la entidad actualizada
    }
    /**
     * Metodo para finalizar un retiro
     * Contiene la logica para restar los montos hacia las debidas cuentas (Cajero y cuenta de cliente).
     * Añade datos a la transaccion temporal para que cambie de estado.
     * @return Una transaccion finalizada solamente, no puede regresar nulo. (Para este momento las llamadas a este metodo solo aceptaran datos validados)
     */
    @Override
    public Transaccion finalizarRetiro() {
        cuenta.setSaldo(transaccion.getSaldoRestante());
        transaccion.setFechaHora(LocalDateTime.now());
        transaccion.setId(String.valueOf(new Random().nextInt(99999)));
        transaccion.setEstado("Exitosa");

        return this.transaccion; // Devuelve la entidad finalizada
    }

    // --- Getters de Entidades ---
    @Override
    public Cliente getClienteEntidad() {
        return this.cliente;
    }

    @Override
    public Cuenta getCuentaEntidad() {
        return this.cuenta;
    }

    @Override
    public Cajero getCajeroEntidad() {
        return this.cajero;
    }

    @Override
    public Transaccion getTransaccionEntidad() {
        return this.transaccion;
    }
}
