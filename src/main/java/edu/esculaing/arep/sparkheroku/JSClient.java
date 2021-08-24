package edu.esculaing.arep.sparkheroku;

import com.google.gson.Gson;

/**
 * Clase que crea el contenido y la logica que mostrara el cliente web.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class JSClient {
    private static String pageContent;
    private Gson gson;

    /**
     * Constructor de nuestra clase
     */
    private JSClient(){}

    /**
     * Metodo que crea y almacena en un String el codigo para desplegar el cliente web
     * @return cadena que lleva el codigo para consifgurar la pagina web
     */
    public static String  Principal(){
        pageContent
            = "<!doctype html>"
            + "<html lang=\"en\">"
            + "<head>"
            + "  <!-- Required meta tags -->"
            + "  <meta charset=\"utf-8\">"
            + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
            + "  <!-- Bootstrap CSS -->"
            + "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">"
            + "  <title>Heroku-Spark</title>"
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
            + "    if(window.miVentana){"
            + "      miVentana.close();"
            + "    }"
            + "    if(document.getElementById(\"IEXCloud\").checked){"
            + "      miVentana = window.open( \"JSClient\"+\"?api=\"+paraIEX()+\"&st=\"+document.getElementById(\"digite\").value, \"ventana1\", \"height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300\");"
            + "    }"
            + "    if(document.getElementById(\"AlphaVantage\").checked){"
            + "      miVentana = window.open( \"JSClient\"+\"?api=\"+paraAlpha()+\"&st=\"+document.getElementById(\"digite\").value, \"ventana1\", \"height=screen.height,width=screen.width,left=300,location=yes,menubar=no,resizable=no,scrollbars=yes,status=no,titlebar=yes,top=300\");"
            + "    }"
            + "    miVentana.moveTo(-100, -100);"
            + "  }"
            + "</script>"
            + "<center>"
            + "<body background=\"https://github.com/RichardUG/SparkHerokuApp/blob/master/img/wallper.png?raw=true\" >"
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
            + "  <div id=\"container\"></div>"
            + "  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>"
            + "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>"
            + "  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>"
            + "</body>"
            + "</center>"
            + "</html>";
        return pageContent;
    }


}
