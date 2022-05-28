package application.api;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;

import application.parser.HtmlRequest;

public class MarvelApiClient implements ContentApiClient {

	private String privateKey;
	private String publicKey;

	public MarvelApiClient(Properties props) {
		this.privateKey = props.getProperty("marvel_private_key");
		this.publicKey = props.getProperty("marvel_public_key");
	}

	public Optional<String> getJson() {

		String timeStamp = LocalDateTime.now().toString();
		try {
			String strHash = getHash(timeStamp);
			String urlString = getUrl(timeStamp, strHash);
			String json = new HtmlRequest().requestJson(urlString);

			return Optional.of(json);
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}

	}

	private String getUrl(String timeStamp, String strHash) {
		StringBuilder sb = new StringBuilder("https://gateway.marvel.com:443/v1/public/comics?orderBy=-focDate&limit=100");
		sb.append("&ts=" + timeStamp);
		sb.append("&apikey=" + publicKey);
		sb.append("&hash=" + strHash);
		return sb.toString();
	}

	private String getHash(String timeStamp) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(timeStamp.getBytes());
		md.update(privateKey.getBytes());
		md.update(publicKey.getBytes());
		byte[] hash = md.digest();

		StringBuilder sb = new StringBuilder();
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
		}
		String strHash = sb.toString();
		return strHash;
	}
}
