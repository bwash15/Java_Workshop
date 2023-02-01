package movie_store;

public class Movie {

    private String name;
    private String format;
    private Double rating;

    // Constructor - Parameterized
    public Movie(String _name, String _format, Double _rating) {
        this.name = _name;
        this.format = _format;
        this.rating = _rating;
    }

    // Copy constructor
    public Movie(Movie _movie) {
        if (!_movie.equals(null)) {
            this.name = _movie.name;
            this.format = _movie.format;
            this.rating = _movie.rating;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String _format) {
        this.format = _format;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double _rating) {
        this.rating = _rating;
    }

    // Methods

    public String toString() {
        return "Movie Rating: " + this.rating + "\t"
                + "Movie Format: " + this.format + "\t`"
                + "Movie Name: " + this.name + " ";
    }

}
