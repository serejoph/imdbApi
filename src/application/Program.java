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

import model.Movie;

public class Program {

	public static void main(String[] args) throws IOException {

		List<String> movieString = getMovies();
		List<String> ids = getFieldList(movieString, "id");
		List<String> ranks = getFieldList(movieString, "rank");
		List<String> titles = getFieldList(movieString, "title");
		List<String> fullTitles = getFieldList(movieString, "fullTitle");
		List<String> year = getFieldList(movieString, "year");
		List<String> images = getFieldList(movieString, "image");
		List<String> crew = getFieldList(movieString, "crew");
		List<String> imDbRating = getFieldList(movieString, "imDbRating");
		List<String> imDbRatingCount = getFieldList(movieString, "imDbRatingCount");

		List<Movie> movieList = new ArrayList<>();

		for (int i = 0; i < movieString.size(); i++) {
			Movie mov = new Movie();
			mov.setId(ids.get(i));
			mov.setRank(Integer.valueOf(ranks.get(i)));
			mov.setTitle(titles.get(i));
			mov.setFullTitle(fullTitles.get(i));
			mov.setCrew(crew.get(i));
			mov.setYear(Integer.valueOf(year.get(i)));
			mov.setImage(images.get(i));
			mov.setImDbRating(Double.valueOf(imDbRating.get(i)));
			mov.setImDbRatingCount(Integer.valueOf(imDbRatingCount.get(i)));
			movieList.add(mov);
		}

		movieList.forEach(System.out::println);

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

		Pattern p = Pattern.compile("\\{([^{]*)\\}");
		Matcher m = p.matcher(line);

		List<String> movies = new ArrayList<>();

		while (m.find()) {
			movies.add(m.group(1));
		}
		return movies;
	}

	private static List<String> getFieldList(List<String> movies, String field) throws IOException {

		Pattern p = Pattern.compile(field + "\":\"(.*?)\"");
		List<String> fieldList = new ArrayList<>();
		for (String s : movies) {

			Matcher m = p.matcher(s);
			if (m.find()) {
				fieldList.add(m.group(1));
			}
		}
		return fieldList;
	}

}
