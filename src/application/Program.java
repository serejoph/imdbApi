package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Movie;

public class Program {

	public static void main(String[] args) throws IOException {
		
		
		
		InputStream file = new FileInputStream("imdbKey.properties");
		Properties props = new Properties();
		props.load(file);
		
		URL url = new URL("https://imdb-api.com/en/API/Top250Movies/" + props.getProperty("api_key"));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		System.out.println(con.getResponseCode());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String line = br.readLine();
		
		JSONObject jObj = new JSONObject(line);
		JSONArray jArr = jObj.getJSONArray("items");
		
		
		JSONObject jsonObject = jArr.getJSONObject(248);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Movie mov = mapper.readValue(jsonObject.toString(), Movie.class);
		
		System.out.println(mov.getFullTitle());
		
	}
}
