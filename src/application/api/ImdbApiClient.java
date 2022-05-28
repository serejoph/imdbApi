package application.api;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import application.parser.HtmlRequest;

public class ImdbApiClient implements ContentApiClient {

	private String apiKey;

	public ImdbApiClient(Properties props) {
		this.apiKey = props.getProperty("imdb_api_key");
	}

	public Optional<String> getJson() {
		try {
			String json = new HtmlRequest().requestJson("https://imdb-api.com/API/Top250Movies/" + apiKey);
			return Optional.of(json);
		} catch (IOException e) {
			return Optional.empty();
		}

	}

}
