/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean.impl;

import edu.eci.arsw.parcial.Model.HttpConnection;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import edu.eci.arsw.parcial.bean.Clima;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Api OpenWeather
 *
 * @author Jonathan Prieto
 */
@Service("OpenWeather")
public class ClimaOpenWeather implements Clima {

    /**
     * Implementación de cache de manera concurrente.
     */
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
    Date date = new Date();
    int minutos = 0;

    /**
     * Obtener el contenido de la url especificada con la ciudad dada.
     *
     * @param clima nombre de la ciudad.
     * @throws IOException si el nombre de la ciudad no existe.
     */
    @Override
    public String obtenerAcciones(String clima) throws IOException {
        String urlData;
        int tiempoTranscurrido = date.getMinutes() - minutos;
        if (cache.containsKey(clima) && tiempoTranscurrido < 5) {
            urlData = cache.get(clima);
        } else {
            urlData = HttpConnection.getUrlData("http://api.openweathermap.org/data/2.5/weather?q=" + clima + "&APPID=33b204276dc51906ba9ddcf4d9704ac8");
            cache.put(clima, urlData);
            minutos = date.getMinutes();
        }
        return urlData;
    }

}
