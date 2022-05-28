package application;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import application.api.ImdbApiClient;
import application.api.MarvelApiClient;
import application.model.Content;
import application.parser.ComicParser;
import application.parser.MovieParser;

public class Program {

	public static void main(String[] args) throws IOException, IntrospectionException {

		InputStream file = new FileInputStream("apikeys.properties");
		Properties props = new Properties();
		props.load(file);

		Optional<String> comicJson = new MarvelApiClient(props).getJson();
		Optional<String> movieJson = new ImdbApiClient(props).getJson();
		
		List<Content> content = new ArrayList<>();;
		
		if (comicJson.isPresent()) content.addAll(new ComicParser().parse(comicJson.get()));
		if (movieJson.isPresent()) content.addAll(new MovieParser().parse(movieJson.get()));
		
		content.sort(Comparator.comparing(x->x.title()));
		
		Writer writer = new FileWriter(new File("content.html"));
		HtmlGenerator gen = new HtmlGenerator(writer);
		gen.generateHtml(content);
		writer.close();
		
	}

}
