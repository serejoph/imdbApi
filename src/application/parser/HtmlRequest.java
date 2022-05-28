package application.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HtmlRequest {

	public String requestJson(String urlString) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String json = br.readLine();
		return json;
	}
	
}
