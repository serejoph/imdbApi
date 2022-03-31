package model;

public class Movie {

	private Double imDbRating;
	private String image;
	private String fullTitle;
	private Integer imDbRatingCount;
	private Integer year;
	private Integer rank;
	private String id;
	private String title;
	private String crew;
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
	
	public Movie() {
	}
	@Override
	public String toString() {
		return "Movie [imDbRating=" + imDbRating + ", image=" + image + ", fullTitle=" + fullTitle
				+ ", imDbRatingCount=" + imDbRatingCount + ", year=" + year + ", rank=" + rank + ", id=" + id
				+ ", title=" + title + ", crew=" + crew + "]";
	}

	
	
	
}
