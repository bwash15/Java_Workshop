package movie_store_w_exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {

        try {
            loadMovies("movie_store_w_exceptions/movies.txt");
            printStore();
            userInput();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * This function prompts the user to enter a movie number, then prompts the user
     * to enter a rating for
     * that movie, then sets the rating for that movie, then prints the store, then
     * prompts the user to
     * continue or not
     */
    public static void userInput() {
        Scanner scanner = new Scanner(System.in);
        String status = "continue";

        while (status.equals("continue")) {
            int choice = (promptForChoice(scanner));
            Movie movie = store.getMovie(choice);
            double rating = promptForRating(scanner, movie.getName());

            movie.setRating(rating);
            store.setMovie(choice, movie);
            printStore();
            System.out.print("To edit another rating, type: 'continue': ");
            status = scanner.next();
        }
        scanner.close();
    }

    /**
     * It prompts the user for an integer between 0 and 9, and returns the integer
     * if it's valid, otherwise
     * it prompts the user again
     * 
     * @param scanner The scanner object that will be used to read the user's input.
     * @return The choice the user entered.
     */
    public static int promptForChoice(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease choose an integer between 0 - 9: ");

            // 1. Anticipate the user not entering an integer.
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            // 2. Anticipate the choice being incorrect.
            int choice = scanner.nextInt();
            if (incorrectChoice(choice)) {
                continue;
            } else
                return choice;
        }
    }

    /**
     * `incorrectChoice` returns true if the choice is less than 0 or greater than
     * 10
     * 
     * @param choice The choice the user made.
     * @return The method is returning a boolean value.
     */

    public static boolean incorrectChoice(int choice) {
        // TODO - incorrectChoice
        return choice < 0 || choice > 10;
    }

    /**
     * "Prompt the user for a rating, and return it if it's valid."
     * 
     * The function is broken down into two parts:
     * 
     * 1. Anticipate the user not entering a double.
     * 2. Anticipate the rating being incorrect
     * 
     * @param scanner The scanner object that will be used to read the user's input.
     * @param name    The name of the movie.
     * @return The rating.
     */
    public static double promptForRating(Scanner scanner, String name) {
        while (true) {
            System.out.print("\nSet a new rating for " + name + ": ");

            // 1. Anticipate the user not entering a double.
            if (!scanner.hasNextDouble()) {
                scanner.next();
                continue;
            }

            // 2. Anticipate the rating being incorrect.
            double rating = scanner.nextDouble();
            if (incorrectRating(rating)) {
                continue;
            } else
                return rating;
        }
    }

    /**
     * `incorrectRating` returns true if the rating is less than 0 or greater than
     * 10
     * 
     * @param rating the rating of the movie
     * @return The method returns a boolean value.
     */
    public static boolean incorrectRating(double rating) {
        // TODO
        return rating < 0 || rating > 10;
    }

    /**
     * Reads a file line by line, splits each line into an array of strings, and
     * then creates a new movie
     * object with the first three elements of the array and adds it to the store
     * 
     * @param fileName the name of the file to load
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);

        while (scanFile.hasNextLine()) {
            // TODO
            String line = scanFile.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scanFile.close();
    }

    /**
     * This function prints the movie store
     */

    public static void printStore() {
        System.out.println("********************************MOVIE STORE*******************************");
        System.out.println(store);
    }

}
