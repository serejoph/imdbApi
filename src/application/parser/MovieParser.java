package application.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.model.Content;
import application.model.Movie;

public class MovieParser implements ContentParser{

	public List<? extends Content> parse(String json) {

		List<String> moviesString = jsonToMovieStrings(json);
		List<Movie> movies = stringToMovie(moviesString);

		return movies;

	}

	private List<String> jsonToMovieStrings(String json) {
		Pattern p = Pattern.compile("\\{([^{]*)\\}");
		Matcher m = p.matcher(json);

		List<String> moviesString = new ArrayList<>();

		while (m.find()) {
			moviesString.add(m.group(1));
		}
		return moviesString;
	}

	private List<Movie> stringToMovie(List<String> moviesString) {
		Pattern p;
		Matcher m;
		List<Movie> movies = new ArrayList<>();

		for (String movie : moviesString) {

			Movie mov = new Movie();
			p = Pattern.compile(":\"(.*?)\"");
			m = p.matcher(movie);

			m.find();
			mov.setId(m.group(1));
			m.find();
			mov.setRank(Integer.valueOf(m.group(1)));
			m.find();
			mov.setTitle(m.group(1));
			m.find();
			mov.setFullTitle(m.group(1));
			m.find();
			mov.setYear(Integer.valueOf(m.group(1)));
			m.find();
			mov.setImage(m.group(1));
			m.find();
			mov.setCrew(m.group(1));
			m.find();
			mov.setImDbRating(Double.valueOf(m.group(1)));
			m.find();
			mov.setImDbRatingCount(Integer.valueOf(m.group(1)));
			movies.add(mov);
		}
		return movies;
	}




}
