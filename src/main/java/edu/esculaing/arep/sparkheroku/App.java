package edu.esculaing.arep.sparkheroku;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

/**
 * Clase encargada de ejecutar el programa.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class App {

    /**
     * Metodo inicializador de nuestro proyecto, que despliega por medio de Spark los distintos servisios
     * @param args argumentos de entrada
     */
    public static void main(String[] args){
        staticFiles.location("/public");
        port(getPort());;
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req,res));
        get("/facadeiex", "application/json", (req, res) -> facadeIex(req,res));
        get("/JSClient", (req, res) -> facadeJSClient(req,res));
    }

    /**
     * Metodo que analiza si ya se esta usando un puerto, para que en caso de que no designar uno por defecto
     * @return Numero del ppuerto que se usara
     */
    static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    /**
     * Metodo encargado de dirigir la secuencia para obtener la información de Alpha Ventage API
     * @param req Requisitos encomendados por la URL
     * @param res Responsabilidades impuestas por la URL
     * @return cadena que contiene el JSON de la API consultada
     */
    public static String facadeAlpha(Request req, Response res){
        String stock = req.queryParams("st");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        if(stock!=null && stock!=""){
            stockService.setStock(stock);
        }
        try {
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    /**
     * Metodo encargado de dirigir la secuencia para obtener la información de IEX Cloud API
     * @param req Requisitos encomendados por la URL
     * @param res Responsabilidades impuestas por la URL
     * @return cadena que contiene el JSON de la API consultada
     */
    public static String facadeIex(Request req, Response res){
        String stock = req.queryParams("st");
        String response = "None";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceIEX();
        if(stock!=null && stock!=""){
            stockService.setStock(stock);
        }
        try {
            response= stockService.TimeSeriesDaily();
        }catch (IOException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }

    /**
     * Metodo que despliega el cliente java script
     * @param req Requisitos encomendados por la URL
     * @param res Responsabilidades impuestas por la URL
     * @return cadena que contiene la estructura que se vera en pantalla
     */
    private static String  facadeJSClient(Request req, Response res){
        String api = req.queryParams("api");
        String stock = req.queryParams("st");
        String pageContent="";
        if(api==null){
            api="";
        }
        if(stock==null || stock==""){
            pageContent=JSClient.Principal();
        }
        try{
            if(api.equalsIgnoreCase("facadeiex")){
                pageContent=facadeIex(req,res);
            }
            else if(api.equalsIgnoreCase("facadealpha")){
                pageContent=facadeAlpha(req,res);
            }
        }catch (NullPointerException ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pageContent;
    }
}
