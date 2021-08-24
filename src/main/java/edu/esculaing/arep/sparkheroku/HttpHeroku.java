package edu.esculaing.arep.sparkheroku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Clase que recopila la información del servicio desplegado en heroku que se desea consultar.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class HttpHeroku {
    /**
     * Metodo que recopila la información del servicio desplegado en heroku que se desea consultar
     * @param site url del servicio
     * @return cadena con la información del servicio en formato JSON
     * @throws IOException controla las excepciones generadas por conexiones mal establecidas
     */
    public static String HerokuJSON(String site) throws IOException {
        String inputLine = null;
        StringBuffer herokuJSON = new StringBuffer();
        URL siteURL = new URL(site);
        URLConnection urlConnection = siteURL.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            while ((inputLine = reader.readLine()) != null) {
                herokuJSON.append(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return herokuJSON.toString();
    }
}
