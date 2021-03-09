package semester_projekt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {
	

	protected static String getAPIData() throws Exception {

        URL url = null;
        HttpURLConnection conn = null;
        String httpErgebnis = "";

        url  = new URL("https://www.tronalddump.io/random/quote");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); 

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

            String errorMessage = "HTTP-Fehler: " + conn.getResponseMessage();
            throw new Exception( errorMessage );

        } else {

            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            String zeile = "";
            while ( (zeile = reader.readLine()) != null) {

                httpErgebnis += zeile;
            }
        }

        return httpErgebnis;
	}
	
	protected static String parseJSON(String jsonString) throws JSONException, Exception {
		
		if (jsonString == null || jsonString.trim().length() == 0) {

			return "Leeres JSON-Objekt von Web-API erhalten.";
		}
		
		StringBuffer sbuf = new StringBuffer();		
		
		JSONObject jsonObject = new JSONObject( jsonString);
		
		String appearedString = jsonObject.getString("appeared_at");
		String quoteString = jsonObject.getString("value");
	
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(appearedString);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String date3 = sdf.format(date2);
		
		sbuf.append("'").append(quoteString).append("' - Donald Trump, ").append(date3);
		
		return sbuf.toString();
		
	}
	
	public static void main(String[] args) throws JSONException, Exception {
		String jsonDocument = "";
		try {
			jsonDocument = getAPIData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ergString = parseJSON (jsonDocument);
		System.out.println(ergString);
	}
}
