
package DTO;

/**
 * Esta clase representa un data transfer object de un Cliente
 * para ser usado en presentacion.
 * @author Sebastian Moreno
 */
public class ClienteDTO {

    String idCliente;
    String nombres;
    String apellidoPaterno;
    String apellidoMaterno;

    public ClienteDTO() {
    }

    public ClienteDTO(String idCliente, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "idCliente=" + idCliente + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + '}';
    }

}
