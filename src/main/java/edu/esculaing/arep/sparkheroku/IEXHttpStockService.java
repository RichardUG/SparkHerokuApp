package edu.esculaing.arep.sparkheroku;

public class IEXHttpStockService extends HttpStockService{
    String stock="aapl";
    @Override
    public String getURL() {
        return "https://cloud.iexapis.com/stable/stock/"+stock+"/quote?token=pk_8a6cc2e8c79a4d01a8e938fb171f1d9c";
    }

    @Override
    public void setStock(String stock) {

    }

    @Override
    public String getStock() {
        return null;
    }
}
