package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

public class Program {

	public static void main(String[] args) throws IOException {

		List<String> movies = getMovies();
		List<String> ids = getField(movies, "id");
		List<String> ranks = getField(movies, "rank");
		List<String> titles = getField(movies, "title");
		List<String> fullTitles = getField(movies, "fullTitle");
		List<String> year = getField(movies, "year");
		List<String> images = getField(movies, "image");
		List<String> crew = getField(movies, "crew");
		List<String> imDbRating = getField(movies, "imDbRating");
		List<String> imDbRatingCount = getField(movies, "imDbRatingCount");
		
		
		
		
	
		
		
		

//		JSONObject jObj = new JSONObject(line);
//		JSONArray jArr = jObj.getJSONArray("items");
//		
//		
//		JSONObject jsonObject = jArr.getJSONObject(0);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		Movie mov = mapper.readValue(jsonObject.toString(), Movie.class);
//		
//		System.out.println(mov);

	}

	private static List<String> getMovies()
			throws FileNotFoundException, IOException, MalformedURLException, ProtocolException {
		InputStream file = new FileInputStream("imdbKey.properties");
		Properties props = new Properties();
		props.load(file);

		URL url = new URL("https://imdb-api.com/API/Top250Movies/" + props.getProperty("api_key"));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = br.readLine();

		Pattern p = Pattern.compile("[{]([^{]*)[}]");
		Matcher m = p.matcher(line);
	
		List<String> movies = new ArrayList<>();

		while (m.find()) {
			movies.add(m.group(1));
		}
		return movies;
	}

	private static List<String> getField(List<String> movies, String field) throws IOException {

		Pattern p = Pattern.compile(field + "\":\"(.*?)\"");
		FileWriter fw = new FileWriter("output.txt");
		List<String> list = new ArrayList<>();
		for (String s : movies) {
						
			Matcher m = p.matcher(s);
			if (m.find()) {
				list.add(m.group(1));
			}
		}

		return list;
	}
}
