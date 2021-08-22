import edu.esculaing.arep.sparkheroku.*;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import java.io.IOException;
public class TestClient {

    @Test
    public void PruebaIgualHerokuAlphafbVSAlphafb() throws IOException, JSONException {
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=fb", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    @Test
    public void PruebaDiferenteHerokuAlphafbVSAlphaMSTF() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=MSTF", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertNotEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    @Test
    public void PruebaIgualHerokuAlphaGOOGVSAlphaGOOG() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=GOOG", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        stockService.setStock("GOOG");
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    @Test
    public void PruebaIgualHerokuIEXvsIEX() throws IOException, JSONException{
        String ExpectedJSON="",site="https://cloud.iexapis.com/stable/stock/aapl/quote?token=pk_8a6cc2e8c79a4d01a8e938fb171f1d9c", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceIEX();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }
}
