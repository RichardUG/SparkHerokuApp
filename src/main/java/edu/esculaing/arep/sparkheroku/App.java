package edu.esculaing.arep.sparkheroku;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;

public class App {

    public static void main(String[] args){
        staticFiles.location("/public");
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req,res));
        get("/results", (req, res) -> resultsPage(req,res));
        get("/facadealpha", "application/json", (req, res) -> facadeAlpha(req,res));
        get("/facadeiex", "application/json", (req, res) -> facadeIex(req,res));
        get("/facadeheroku", "application/json", (req, res) -> facadeHeroku(req,res));
    }

    private static String inputDataPage(Request req, Response res){
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + " First name: <br>"
                + " <input type=\"text\" name=\"firstname\" value=\"Mickey\">"
                + " <br>"
                + " Last name: <br>"
                + " <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + " <br><br>"
                + " <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If  you click the \"Submit\" button, the form data will be sent to a page called \"/results\"."
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res){
        return req.queryParams("firstname")+ " " + req.queryParams("lastname");
    }

    static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String facadeAlpha(Request req, Response res){
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

    private static String facadeIex(Request req, Response res){
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

    private static String facadeHeroku(Request req, Response res){

        return "";
    }
}
