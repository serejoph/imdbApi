package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teste {
	public static void main(String[] args) throws IOException {
		
		InputStream file = new FileInputStream("imdbKey.properties");
		Properties props = new Properties();
		props.load(file);

		URL url = new URL("https://imdb-api.com/API/Top250Movies/" + props.getProperty("api_key"));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String json = br.readLine();
		System.out.println(json);
		
		Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);
		matcher.find();
		String[] moviesArray = matcher.group(1).split("\\},\\{");
		
		System.out.println(moviesArray[2]);
	}
}