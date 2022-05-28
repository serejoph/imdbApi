package application.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import application.model.Comic;
import application.model.Content;

public class ComicParser implements ContentParser {

	@Override
	public List<? extends Content> parse(String json) {
		List<String> comicStringList = getComicStringList(json);
		List<? extends Content> comics = comicStringList.stream().map(this::stringToComic).collect(Collectors.toList());
		return comics;
	}

	private List<String> getComicStringList(String json) {
		Pattern p = Pattern.compile("results\":\\[(.*?)\\]}}");
		Matcher m = p.matcher(json);
		m.find();
		String allComicsSingleString = m.group(1);

		String[] comicsArray = allComicsSingleString.split("\\}\\},\\{");

		comicsArray[0] = comicsArray[0].substring(1);
		int arraySize = comicsArray.length;
		int lastStringLength = comicsArray[arraySize - 1].length();
		comicsArray[arraySize - 1] = comicsArray[arraySize - 1].substring(0, lastStringLength - 2);

		List<String> comicStringList = Arrays.asList(comicsArray);
		return comicStringList;

	}
	
	private Comic stringToComic(String string){
		Comic comic = new Comic();
		
		Pattern p = Pattern.compile("\"title\":\"(.*?)\"");
		Matcher m = p.matcher(string);
		if(m.find()) comic.setTitle(m.group(1));
		p = Pattern.compile("\\((\\d{4})\\)");
		m = p.matcher(m.group(1));
		if(m.find()) comic.setYear(m.group(1));
		p = Pattern.compile("\"images\":\\[\\{\"path\":\"(.*?)\"");
		m = p.matcher(string);
		if(m.find()) comic.setUrlImage(m.group(1)+"/portrait_uncanny.jpg");
		
		return comic;
	}
}
