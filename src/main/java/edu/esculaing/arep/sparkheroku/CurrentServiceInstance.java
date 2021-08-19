package edu.esculaing.arep.sparkheroku;

public class CurrentServiceInstance {
    private static CurrentServiceInstance _instance = new CurrentServiceInstance();
    private HttpStockService serviceAlpha;
    private HttpStockService serviceIEX;
    private CurrentServiceInstance(){
        serviceAlpha = new AlphaHttpStockService();
        serviceIEX = new IEXHttpStockService();
    }
    public static CurrentServiceInstance getInstance(){
        return _instance;
    }
    public HttpStockService getServiceAlpha(){
        return serviceAlpha;
    }
    public HttpStockService getServiceIEX(){
        return serviceIEX;
    }
}
