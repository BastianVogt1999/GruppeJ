package semester_projekt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class Main {

	protected String holeDatenVonWebAPI() throws Exception {

        URL url                                = null;
        HttpURLConnection conn                 = null;
        String            httpErgebnisDokument = "";


        url  = new URL("https://www.tronalddump.io/random/quote");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Eigentlich nicht nötig, weil "GET" Default-Wert ist.

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {

            String errorMessage = "HTTP-Fehler: " + conn.getResponseMessage();
            throw new Exception( errorMessage );

        } else {

            InputStream is        = conn.getInputStream();
            InputStreamReader ris = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(ris);

            // JSON-Dokument zeilenweise einlesen
            String zeile = "";
            while ( (zeile = reader.readLine()) != null) {

                httpErgebnisDokument += zeile;
            }
        }

   //     Log.i(TAG4LOGGING, "JSON-String erhalten: " + httpErgebnisDokument);

        return httpErgebnisDokument;
	}
	
	protected String parseJSON(String jsonString) throws JSONException {
		
		if (jsonString == null || jsonString.trim().length() == 0) {

			return "Leeres JSON-Objekt von Web-API erhalten.";
		}
		
		// Für den Ergebnis-String wird ein StringBuffer-Objekt verwendet,
		// weil hiermit String-Konkatenationen effizienter sind.
		StringBuffer sbuf = new StringBuffer();		
		
		
		
		//JSONArray arrayResults = jsonObject.getJSONArray( "results" );
		JSONArray arrayResults = new JSONArray( jsonString );
		int anzPersonen = arrayResults.length();
		//Log.i(TAG4LOGGING, "Anzahl Einträge: " + anzPersonen);
		sbuf.append("Anzahl Datensätze von Web-API erhalten: ").append(anzPersonen).append("\n\n");
		
		
		// Einzelne Personen-Unterobjekte aus JSON-Objekt holen
		for (int i = 0; i < anzPersonen; i++) {
			
			//JSONObject resultObject = (JSONObject)arrayResults.get(i);
			JSONObject resultObject = arrayResults.getJSONObject(i);
			if (resultObject == null) {

				return "Fehler beim JSON-Parser: User-Objekt mit Index " + i + " war null.";
			}
			String timeString1 = resultObject.getString( "timestamp");
			String rateString1 = resultObject.getString( "rate");
			//String userString = parseUserObjekt( resultObject );
			String userString = timeString1 + "\n" + rateString1;
			sbuf.append( userString ).append("\n\n");
		}

		return sbuf.toString();
	}
	
}
