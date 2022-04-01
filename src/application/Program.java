package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

	public static void main(String[] args) throws IOException {

		InputStream file = new FileInputStream("imdbKey.properties");
		Properties props = new Properties();
		props.load(file);

		URL url = new URL("https://imdb-api.com/pt-br/API/Top250Movies/" + props.getProperty("api_key"));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		System.out.println(con.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String line = br.readLine();

		Pattern p = Pattern.compile("\\[\\{.*\\}\\]");
		Matcher m = p.matcher(line);
		m.find();
		String s = m.group();

		System.out.println(s);

		p = Pattern.compile("[{](.*?)[}]");
		m = p.matcher(s);

		List<String> movies = new ArrayList<>();

		while (m.find()) {
			movies.add(m.group(1).replace('"', Character.MIN_VALUE));
		}
		List<String> ids = new ArrayList<>();
		movies.forEach(x ->{
			String[] fields = x.split(",");
			String[] id = fields[0].split(":");
			ids.add(id[1]);
		});
		
		ids.forEach(System.out::println);

		
		
		
		
		
		
		
		
		
		
		
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
}
