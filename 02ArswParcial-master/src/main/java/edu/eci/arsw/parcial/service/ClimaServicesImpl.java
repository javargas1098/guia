/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.eci.arsw.parcial.bean.Clima;

/**
 * Implementación de los servicios expuestos
 *
 * @author Jonathan Prieto
 */
@Service
public class ClimaServicesImpl implements ClimaServicios {

    /**
     * Implementación con inversión de control para uso de otras apis.
     */
    @Autowired
    @Qualifier("OpenWeather")
    Clima clima;

    /**
     *
     * @param city the value of city
     * @throws IOException si no existe el nombre de la ciudad.
     */
    @Override
    public String obtenerClimaCiudad(String city) throws IOException {
        return clima.obtenerAcciones(city);
    }
}
