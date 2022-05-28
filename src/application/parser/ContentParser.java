package application.parser;

import java.util.List;

import application.model.Content;

public interface ContentParser {

	List<? extends Content> parse(String json);
	
}
