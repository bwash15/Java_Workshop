package movie_store;

public class Store {

    Movie[] movies;

    public Store() {
        this.movies = new Movie[10];
    }

    public Movie getMovie(int _index) {
        return new Movie(movies[_index]);
    }

    public void setMovie(int _index, Movie _movie) {
        this.movies[_index] = new Movie(_movie);
    }

    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString() + "\n";
        }
        return temp;
    }

}
