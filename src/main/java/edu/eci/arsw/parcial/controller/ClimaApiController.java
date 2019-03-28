/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.parcial.service.ClimaServicios;

/**
 * ApiRest que permite acceder a un conjunto de datos por medio del protocolo
 * http, usando los verbos del mismo.
 *
 */
@RestController
@RequestMapping("/clima")
public class ClimaApiController {

    @Autowired
    private ClimaServicios cs;

    @RequestMapping(method = RequestMethod.GET, path = "/{city}")
    public ResponseEntity<?> getAcciones(@PathVariable("city") String city) {
        try {
            return new ResponseEntity<>(cs.obtenerClimaCiudad(city), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener el estado del clima de: " + city, HttpStatus.NOT_FOUND);
        }
    }
}
