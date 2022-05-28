package application;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import model.Movie;

public class Program {

	public static void main(String[] args) throws IOException, IntrospectionException {

		InputStream file = new FileInputStream("imdbKey.properties");
		Properties props = new Properties();
		props.load(file);
		String apiKey = props.getProperty("api_key");
		
		List<String> movieString = new ImdbApiClient(apiKey).getMovies();
		List<Movie> movies = movieString.stream().map(new JsonParser()::stringToMovie).collect(Collectors.toList());
		Writer writer = new FileWriter(new File("movies.html"));
		HtmlGenerator gen = new HtmlGenerator(writer);
		gen.generateHtml(movies);
		writer.close();

	}

	

	

}
