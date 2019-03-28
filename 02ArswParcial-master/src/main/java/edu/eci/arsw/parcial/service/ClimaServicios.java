/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.service;

import java.io.IOException;

/**
 * Servicios expuestos
 *
 * @author Jonathan Prieto
 */
public interface ClimaServicios {

    /**
     *
     * @param city Nombre de la ciudad a consultar su estado de clima
     * @return String, json con la información del estado del clima de la ciudad.
     * @throws IOException si el nombre de la ciudad no es valido
     */
    public String obtenerClimaCiudad(String city) throws IOException;
}
