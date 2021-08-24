import edu.esculaing.arep.sparkheroku.*;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import java.io.IOException;
/**
 * Clase que en escencia es el cliente de pruebas.
 * @author Richard Santiago Urrea Garcia
 * @version 1.0.  (23 de Agosto del 2021)
 */
public class TestClient {

    /**
     * prueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API y la consulta directa a Alpha ventage API, ambos siendo consultados a Facebook como es por
     * defecto en nuestro caso.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuAlphafbVSAlphafb() throws IOException, JSONException {
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=fb", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    /**
     * prueba de desigualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API hacia Microsoft y la consulta directa a Alpha ventage API hacia Facebook.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaDiferenteHerokuAlphafbVSAlphaMSTF() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=MSTF", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertNotEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    /**
     * prueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Alpha
     * ventage API hacia Google y la consulta directa a Alpha ventage API hacia Google también.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuAlphaGOOGVSAlphaGOOG() throws IOException, JSONException{
        String ExpectedJSON="",site="https://sparkheroku.herokuapp.com/facadealpha?st=GOOG", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceAlpha();
        stockService.setStock("GOOG");
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }

    /**
     * pprueba de igualdad entre el contenido de lo que obtiene nuestro servicio Heroku en la consulta a Iex Cloud
     * API y la consulta directa a Iex Cloud API ambas con stock como aapl.
     * @throws IOException Controla excepciones generadas por mala conexión
     * @throws JSONException Controla excepciones generadas por tipos JSON
     */
    @Test
    public void PruebaIgualHerokuIEXvsIEX() throws IOException, JSONException{
        String ExpectedJSON="",site="https://cloud.iexapis.com/stable/stock/aapl/quote?token=pk_8a6cc2e8c79a4d01a8e938fb171f1d9c", HerokuJSON="";
        HttpStockService stockService = CurrentServiceInstance.getInstance().getServiceIEX();
        ExpectedJSON = stockService.TimeSeriesDaily();
        HerokuJSON = HttpHeroku.HerokuJSON(site);
        JSONAssert.assertEquals(ExpectedJSON,HerokuJSON.toString(),true);
    }
}
