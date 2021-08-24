package edu.esculaing.arep.sparkheroku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Clase extendida que se encarga de procesar la información que se consulta y extrae de las APIs.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public abstract class HttpStockService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private HashMap<URL, String> Cache = new HashMap <URL, String> ();

    /**
     * Metodo que realiza la conexión a las diversas APIs y extrae su contenido
     * @return cadena que contiene el codigo JSON de la API consultada
     * @throws IOException controla las excepciones que se puedan generar por mala conexión con las APIs
     */
    public String TimeSeriesDaily() throws IOException{
        String responseStr =  "None";
        System.out.println(getURL());
        URL obj = new URL(getURL());
        if(Cache.containsKey(obj)){
            System.out.println("Contenido");
            return Cache.get(obj);
        }
        System.out.println("Nuevo");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            responseStr=response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        Cache.put(obj,responseStr);
        return responseStr;
    }

    /**
     * Metodo abstracto que retorna una cadena que contiene una URL
     * @return cadena que lleva inscrita una URL
     */
    abstract public String getURL();

    /**
     * Metodo abstracto que envia cambia el valor del stock
     * @param stock nuevo valor que se le asignara al stock
     */
    abstract public void setStock(String stock);

    /**
     * Metodo abstracto que retorna el stock
     * @return stock
     */
    abstract public String getStock();
}
