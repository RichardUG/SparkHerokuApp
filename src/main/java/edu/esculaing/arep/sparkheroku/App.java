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

public class App {


    public static void main(String[] args){
        staticFiles.location("/public");
        port(getPort());;
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req,res));
        get("/facadeiex", "application/json", (req, res) -> facadeIex(req,res));
        get("/JSClient", (req, res) -> facadeJSClient(req,res));
    }



    static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String facadeAlpha(Request req, Response res){
        System.out.println(req);
        System.out.println(res);
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

    private static String  facadeJSClient(Request req, Response res){
        String api = req.queryParams("api");
        String stock = req.queryParams("st");
        String pageContent="";
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
