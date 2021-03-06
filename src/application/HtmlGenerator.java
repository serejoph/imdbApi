package application;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import application.model.Content;

public class HtmlGenerator {

	Writer writer;
	
	public HtmlGenerator(Writer writer) {
		this.writer = writer;
	}

	public void generateHtml(List<? extends Content> contents) throws IOException {

		String head =
				"<!DOCTYPE html>\r\n"
						+ "<html>"
						+ "<head>" 
						+ "<meta charset=\"utf-8\">"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
						+ "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\""
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">	"
						+ "</head>"
						+ "  <div class=\"container\">\r\n";
		
		StringBuilder sb = new StringBuilder();
		sb.append(head);
		for (Content content : contents) {
			sb.append(movieToHtml(content));
		}
		sb.append("</div>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</html>");
		
		writer.write(sb.toString());
	}
	
	private String movieToHtml(Content content) {
		String card = "<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 540px;\">\r\n"
				+ "      <div class=\"row g-0\">\r\n"
				+ "        <div class=\"col-md-4\">\r\n"
				+ "          <img src=\""
				+ content.urlImage()
				+ "\" class=\"img-fluid rounded-start\">\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"col-md-8\">\r\n"
				+ "          <div class=\"card-body\">\r\n"
				+ "            <h5 class=\"card-title\">"
				+ content.title()
				+ "</h5>\r\n"
				+ "            <p class=\"card-text\">"
				+"Ano: "
				+ content.year()
				+"</br>Tipo: "
				+ content.type()
				+ "</p>\r\n"
				+ "          \r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>";
		return card;
	}

}
