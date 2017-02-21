package yaro.quickomdb.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yann on 21/02/17.
 */

public class Movie {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private int year;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Released")
    private String released;

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Writer")
    private String writer;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Language")
    private String language;

    @SerializedName("Country")
    private String country;

    @SerializedName("Awards")
    private String awards;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Metascore")
    private int metascore;

    @SerializedName("imdbRating")
    private float imdbRating;

    @SerializedName("imdbVotes")
    private float imdbVotes;

    @SerializedName("imdbID")
    private String imdbId;

    @SerializedName("Type")
    private String type;

    @SerializedName("tomatoMeter")
    private int tomatoMeter;

    @SerializedName("tomatoImage")
    private String tomatoimage;

    @SerializedName("tomatoRating")
    private float tomatoRating;

    @SerializedName("tomatoReviews")
    private int tomatoReviews;

    @SerializedName("tomatoFresh")
    private int tomatoFresh;

    @SerializedName("tomatoRotten")
    private int tomatoRotten;

    @SerializedName("tomatoConsensus")
    private String tomatoConsensus;

    @SerializedName("tomatoUserMeter")
    private int tomatoUserMeter;

    @SerializedName("tomatoUserRating")
    private float tomatoUserRating;

    @SerializedName("tomatoUserReviews")
    private int tomatoUserReviews;

    @SerializedName("tomatoURL")
    private String tomatoUrl;

    @SerializedName("DVD")
    private String dvd;

    @SerializedName("BoxOffice")
    private String boxOffice;

    @SerializedName("Production")
    private String production;

    @SerializedName("Website")
    private String website;

    @SerializedName("Response")
    private boolean response;


    public Movie(String title, int year, String imdbId, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.type = type;
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", rated='" + rated + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", metascore=" + metascore +
                ", imdbRating=" + imdbRating +
                ", imdbVotes=" + imdbVotes +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", tomatoMeter=" + tomatoMeter +
                ", tomatoimage='" + tomatoimage + '\'' +
                ", tomatoRating=" + tomatoRating +
                ", tomatoReviews=" + tomatoReviews +
                ", tomatoFresh=" + tomatoFresh +
                ", tomatoRotten=" + tomatoRotten +
                ", tomatoConsensus='" + tomatoConsensus + '\'' +
                ", tomatoUserMeter=" + tomatoUserMeter +
                ", tomatoUserRating=" + tomatoUserRating +
                ", tomatoUserReviews=" + tomatoUserReviews +
                ", tomatoUrl='" + tomatoUrl + '\'' +
                ", dvd='" + dvd + '\'' +
                ", boxOffice='" + boxOffice + '\'' +
                ", production='" + production + '\'' +
                ", website='" + website + '\'' +
                ", response=" + response +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public float getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(float imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTomatoMeter() {
        return tomatoMeter;
    }

    public void setTomatoMeter(int tomatoMeter) {
        this.tomatoMeter = tomatoMeter;
    }

    public String getTomatoimage() {
        return tomatoimage;
    }

    public void setTomatoimage(String tomatoimage) {
        this.tomatoimage = tomatoimage;
    }

    public float getTomatoRating() {
        return tomatoRating;
    }

    public void setTomatoRating(float tomatoRating) {
        this.tomatoRating = tomatoRating;
    }

    public int getTomatoReviews() {
        return tomatoReviews;
    }

    public void setTomatoReviews(int tomatoReviews) {
        this.tomatoReviews = tomatoReviews;
    }

    public int getTomatoFresh() {
        return tomatoFresh;
    }

    public void setTomatoFresh(int tomatoFresh) {
        this.tomatoFresh = tomatoFresh;
    }

    public int getTomatoRotten() {
        return tomatoRotten;
    }

    public void setTomatoRotten(int tomatoRotten) {
        this.tomatoRotten = tomatoRotten;
    }

    public String getTomatoConsensus() {
        return tomatoConsensus;
    }

    public void setTomatoConsensus(String tomatoConsensus) {
        this.tomatoConsensus = tomatoConsensus;
    }

    public int getTomatoUserMeter() {
        return tomatoUserMeter;
    }

    public void setTomatoUserMeter(int tomatoUserMeter) {
        this.tomatoUserMeter = tomatoUserMeter;
    }

    public float getTomatoUserRating() {
        return tomatoUserRating;
    }

    public void setTomatoUserRating(float tomatoUserRating) {
        this.tomatoUserRating = tomatoUserRating;
    }

    public int getTomatoUserReviews() {
        return tomatoUserReviews;
    }

    public void setTomatoUserReviews(int tomatoUserReviews) {
        this.tomatoUserReviews = tomatoUserReviews;
    }

    public String getTomatoUrl() {
        return tomatoUrl;
    }

    public void setTomatoUrl(String tomatoUrl) {
        this.tomatoUrl = tomatoUrl;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
