package edu.esculaing.arep.sparkheroku;

/**
 * Clase extendida de HttpSocketService, que se crea para procesar la API de Iex Cloud.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class IEXHttpStockService extends HttpStockService{
    String stock="aapl";

    /**
     * Metodo sobre escrito que retorna una cadena que contiene una URL
     * @return cadena que lleva inscrita una URL
     */
    @Override
    public String getURL() {
        return "https://cloud.iexapis.com/stable/stock/"+stock+"/quote?token=pk_8a6cc2e8c79a4d01a8e938fb171f1d9c";
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
