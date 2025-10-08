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
