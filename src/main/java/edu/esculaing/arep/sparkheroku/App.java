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
        get("/JSClient", (req, res) -> facadeJSClient(req,res));
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
        System.out.println(req);
        System.out.println(res);
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

    private static String  facadeJSClient(Request req, Response res) {
        String pageContent
                = "<!doctype html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "  <!-- Required meta tags -->"
                + "  <meta charset=\"utf-8\">"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + "  <!-- Bootstrap CSS -->"
                + "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
                + "  <title>Hello, world!</title>"
                + "</head>"
                + "<script  type=\"text/javascript\" lang=\"JavaScript\">"
                + "  function paraIEX() {"
                + "    return \"facadeiex\""
                + "  }"
                + "</script>"
                + "<script  type=\"text/javascript\" lang=\"JavaScript\">"
                + "  function paraAlpha() {"
                + "    return \"facadealpha\""
                + "  }"
                + "</script>"
                + "<script  type=\"text/javascript\" lang=\"JavaScript\">"
                + "  function informacionAPI() {"
                + "    window.alert(\"Elija la API la cual desea consultar.\");"
                + "  }"
                + "</script>"
                + "<script  type=\"text/javascript\" lang=\"JavaScript\">"
                + "  function informacionStock() {"
                + "    window.alert(\"Introduzca le nombre del stock que desea consultar con la API que elegira.\");"
                + "  }"
                + "</script>"
                + "<script  type=\"text/javascript\" lang=\"JavaScript\">"
                + "  function ChangeStockOriginal() {"
                + "    if(document.getElementById(\"IEXCloud\").checked){"
                + "      document.getElementById(\"digite\").value=\"aapl\""
                + "    }"
                + "    if(document.getElementById(\"AlphaVantage\").checked){"
                + "      document.getElementById(\"digite\").value=\"fb\""
                + "    }"
                + "  }"
                + "</script>"
                + "<script>"
                + "  function abrir() {"
                + "    if(document.getElementById(\"IEXCloud\").checked){"
                + "      miVentana = window.open( paraIEX()+\"?st=\"+document.getElementById(\"digite\").value, \"ventana1\", \"height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300\");"
                + "    }"
                + "    if(document.getElementById(\"AlphaVantage\").checked){"
                + "      miVentana = window.open( paraAlpha()+\"?st=\"+document.getElementById(\"digite\").value, \"ventana1\", \"height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300\");"
                + "    }"
                + "    miVentana.moveTo(-100, -100);"
                + "  }"
                + "</script>"
                + "<center>"
                + "<body background=\"https://github.com/RichardUG/SparkHerokuApp/blob/master/img/wallper.png?raw=true\" brightness=\"150\">"
                + "  <br><br><br><br>"
                + "  <h1><FONT COLOR=\"black\">Java Scrip Client</FONT></h1>"
                + "  <h2><FONT COLOR=\"black\">Consultas API</FONT></h2>"
                + "  <br>"
                + "  <b><big><FONT COLOR=\"black\">Stock =</FONT></big></b> <input type=\"text\" id=\"digite\" value=\"aapl\">"
                + "  <button class=\"btn btn-toggle\" onclick=\"informacionStock()\"><img src=\"https://github.com/RichardUG/SparkHerokuApp/blob/master/img/interrogacion.jpg?raw=true\" width=\"20\" height=\"20\" ></button>"
                + "  <br><br>"
                + "  <h4><FONT COLOR=\"black\">Seleccione la API que desea consultar</FONT></h4>"
                + "  <br>"
                + "  <div class=\"btn-group btn-group-toggle\" data-toggle=\"buttons\" onchange=\"ChangeStockOriginal()\">"
                + "    <label class=\"btn btn-secondary active\" >"
                + "      <input type=\"radio\" name=\"options\" id=\"IEXCloud\" autocomplete=\"off\"  checked> IEXCloud API"
                + "    </label>"
                + "    <label class=\"btn btn-secondary\">"
                + "      <input type=\"radio\" name=\"options\" id=\"AlphaVantage\" autocomplete=\"off\" > Alpha vantage API"
                + "    </label>"
                + "  </div>"
                + "  <button class=\"btn btn-toggle\" onclick=\"informacionAPI()\"><img src=\"https://github.com/RichardUG/SparkHerokuApp/blob/master/img/interrogacion.jpg?raw=true\" width=\"20\" height=\"20\"></button>"
                + "  <br><br>"
                + "  <div type=\"button\" name=\"boton3\" id=\"boton3\" class=\"btn btn-primary active\" align=\"center\" onclick=\"abrir()\">Buscar</a></div>"
                + "  <div id=\"container\">"
                + "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>"
                + "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>"
                + "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>"
                + "</body>"
                + "</center>"
                + "</html>";
        return pageContent;
    }

}
