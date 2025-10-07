/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import DTO.CajeroDTO;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.TransaccionDTO;

/**
 *
 * @author Sebastian Moreno
 */
public interface IModelo {

    public ClienteDTO getCliente();

    public CajeroDTO getCajero();

    public CuentaDTO getCuenta();

    public TransaccionDTO getTransaccion();
}
