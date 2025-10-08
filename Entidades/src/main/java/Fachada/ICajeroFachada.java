package Fachada;

import Entidades.Cajero;
import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Transaccion;


/**
 * Define el contrato para acceder a la lógica de negocio del cajero.
 * Opera exclusivamente con entidades del dominio.
 * @author Sebastian Moreno
 */
public interface ICajeroFachada {

    void inicializarDatos();

    Transaccion calcularRetiro(double monto);

    Transaccion finalizarRetiro();

    // Getters que devuelven las entidades completas
    Cliente getClienteEntidad();

    Cuenta getCuentaEntidad();

    Cajero getCajeroEntidad();

    Transaccion getTransaccionEntidad();
}