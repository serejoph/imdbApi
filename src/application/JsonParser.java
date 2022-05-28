package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Movie;

public class JsonParser {

	public Movie stringToMovie(String movieString) {

		Movie mov = new Movie();
		Pattern p = Pattern.compile(":\"(.*?)\"");
		Matcher m = p.matcher(movieString);

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

		
		
		return mov;

	}
	
}
