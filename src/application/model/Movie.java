package application.model;

public class Movie implements Content{

	private String id;
	private Integer rank;
	private String title;
	private String fullTitle;
	private Integer year;
	private String image;
	private String crew;
	private Double imDbRating;
	private Integer imDbRatingCount;
	
	
	
	public Movie() {
	}
	
	public Movie(String id, Integer rank, String title, String fullTitle, Integer year, String image, String crew,
			Double imDbRating, Integer imDbRatingCount) {
		super();
		this.id = id;
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.year = year;
		this.image = image;
		this.crew = crew;
		this.imDbRating = imDbRating;
		this.imDbRatingCount = imDbRatingCount;
	}

	public Double getImDbRating() {
		return imDbRating;
	}
	public void setImDbRating(Double imDbRating) {
		this.imDbRating = imDbRating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFullTitle() {
		return fullTitle;
	}
	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}
	public Integer getImDbRatingCount() {
		return imDbRatingCount;
	}
	public void setImDbRatingCount(Integer imDbRatingCount) {
		this.imDbRatingCount = imDbRatingCount;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	

	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", imDbRating=" + imDbRating + ", image=" + image + ", fullTitle=" + fullTitle
				+ ", imDbRatingCount=" + imDbRatingCount + ", year=" + year + ", rank=" + rank + ", id=" + id
				+  ", crew=" + crew + "]";
	}

	@Override
	public String title() {
		
		return this.title;
	}

	@Override
	public String urlImage() {

		return this.image;
	}

	@Override
	public String year() {
	
		return this.year.toString();
	}

	public String type() {
		return "Movie";
	}
	
	
	
}
