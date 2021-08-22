import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpHeroku {
    public static String HerokuJSON(String site) throws IOException {
        String inputLine = null;
        StringBuffer herokuJSON = new StringBuffer();
        URL siteURL = new URL(site);
        URLConnection urlConnection = siteURL.openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            while ((inputLine = reader.readLine()) != null) {
                herokuJSON.append(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return herokuJSON.toString();
    }
}
