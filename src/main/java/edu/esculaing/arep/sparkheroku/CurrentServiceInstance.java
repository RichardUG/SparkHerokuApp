package edu.esculaing.arep.sparkheroku;

/**
 * Clase que inicializa y da los servicios para consultar a las APIs.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService serviceAlpha;
    private HttpStockService serviceIEX;

    /**
     * Constructor de nuestra clase, el cual inicializa los diferentes servicios
     */
    private CurrentServiceInstance(){
        serviceAlpha = new AlphaHttpStockService();
        serviceIEX = new IEXHttpStockService();
    }

    /**
     * Metodo que retorna la instancias que contiene
     * @return Objeto de tipo CurrentServiceInstance
     */
    public static CurrentServiceInstance getInstance(){
        return _instance;
    }

    /**
     * Metodo que retorna el servicio de Alpha
     * @return Objeto tipo AlphaHttpStockService
     */
    public HttpStockService getServiceAlpha(){
        return serviceAlpha;
    }

    /**
     * Metodo que retorna el servicio de Iex
     * @return Objeto tipo IEXHttpStockService
     */
    public HttpStockService getServiceIEX(){
        return serviceIEX;
    }
}
