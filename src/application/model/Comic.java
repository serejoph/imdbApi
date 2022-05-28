package application.model;

public class Comic implements Content{

	private String title;
	private String urlImage;
	private String rating;
	private String year;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String title() {
		// TODO Auto-generated method stub
		return this.title;
	}

	@Override
	public String urlImage() {
		// TODO Auto-generated method stub
		return this.urlImage;
	}


	@Override
	public String year() {
		// TODO Auto-generated method stub
		return this.year;
	}

	@Override
	public String toString() {
		return "Comic [title=" + title + ", urlImage=" + urlImage + ", year=" + year + "]";
	}

	public String type() {
		return "Comic";
	}
	
	
}
