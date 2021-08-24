package edu.esculaing.arep.sparkheroku;

/**
 * Clase extendida de HttpSocketService, que se crea para procesar la API de Alpha Ventage.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class AlphaHttpStockService extends HttpStockService{

    String stock="fb";

    /**
     * Metodo sobre escrito que retorna una cadena que contiene una URL
     * @return cadena que lleva inscrita una URL
     */
    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=Q1QZFVJQ21K7C6XM";
    }

    /**
     * Metodo sobre escrito que cambia el valor del stock
     * @param stock nuevo valor que se le asignara al stock
     */
    @Override
    public void setStock(String stock) {
        this.stock=stock;
    }

    /**
     * Metodo que retorna el stock
     * @return stock
     */
    @Override
    public String getStock() {
        return stock;
    }
}
