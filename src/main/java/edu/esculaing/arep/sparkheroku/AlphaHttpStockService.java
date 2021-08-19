package edu.esculaing.arep.sparkheroku;

public class AlphaHttpStockService extends HttpStockService{

    String stock="fb";
    @Override
    public String getURL() {
        return "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stock+"&apikey=Q1QZFVJQ21K7C6XM";
    }

    @Override
    public void setStock(String stock) {
        this.stock=stock;
    }

    @Override
    public String getStock() {
        return stock;
    }
}
