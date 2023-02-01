package movie_store;

import java.util.Scanner;

import javax.swing.event.MouseInputAdapter;

public class Main {
    public static void main(String[] args) {

        Store movieStore = new Store();
        Scanner scanner = new Scanner(System.in);

        Movie[] movies = new Movie[] {
                new Movie("The Shawshank Redemption", "BlueRay", 9.2),
                new Movie("The Godfather: Part II", "DVD", 9.0),
                new Movie("The Godfather", "BlueRay", 9.1),
                new Movie("The Dark Knight", "BlueRay", 9.0),
                new Movie("Schindler's List", "DVD", 8.9),
                new Movie("The Lord of the Rings: The Return of the King", "BlueRay", 8.9),
                new Movie("Pulp Fiction", "DVD", 8.8),
                new Movie("The Lord of the Rings: The Fellowship of the Ring", "DVD", 8.8)
        };

        for (int i = 0; i < movies.length; i++) {
            movieStore.setMovie(i, movies[i]);
        }

        movieStore.getMovie(4);
        String userContinues = "continue";

        while (userContinues.equals("continue")) {

            System.out.println(
                    "**************************************************IMDB**************************************************");
            for (int i = 0; i < movies.length; i++) {
                System.out.println(movies[i]);
            }

            System.out.println("\nPlease choose an integer between 0 - 9");
            int userChoice = scanner.nextInt();
            Movie movie = movieStore.getMovie(userChoice);

            System.out.println("Your choice: \n" + movies[userChoice - 1].toString());
            scanner.nextLine();

            if (movieStore.getMovie(userChoice) != null) {
                System.out.print("Set a new rating for " + movies[userChoice - 1].getName() + ":  ");
                Double newRating = scanner.nextDouble();
                movies[userChoice - 1].setRating(newRating);

            }
            scanner.nextLine();
            System.out.println("Your choice with updated Rating: \n" + movies[userChoice - 1].toString());

            System.out.println("To edit another rating, type: [continue]");
            userContinues = scanner.nextLine();
        }

        scanner.close();
    }
}
