package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImdbApiClient {

	private String apiKey;
	
	public ImdbApiClient(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public List<String> getMovies()
			throws FileNotFoundException, IOException, MalformedURLException, ProtocolException {
		
		URL url = new URL("https://imdb-api.com/API/Top250Movies/" + this.apiKey);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = br.readLine();

		Pattern p = Pattern.compile("\\{([^{]*)\\}");
		Matcher m = p.matcher(line);

		List<String> movies = new ArrayList<>();

		while (m.find()) {
			movies.add(m.group(1));
		}
		return movies;
	}
	
}
