package javaPedia;

import java.util.Scanner;

public class JavaPedia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        boolean running = false;
        int numOfFigures = 0;

        while (running) {
            System.out.println("******************JavaPedia*****************");
            System.out.println("How many historical figures will you register?");
            numOfFigures = scanner.nextInt();
            String[][] database = new String[numOfFigures][3];

            System.out.println("You have chosen to create " + numOfFigures + " new historical figure profile(s).");

            scanner.nextLine();
            // User enters 3 values per row
            for (int i = 0; i < numOfFigures; i++) {

                System.out.println("\n\tFigure: " + (i + 1));
                System.out.print("\t - Name: ");
                database[i][0] = scanner.nextLine();
                System.out.print("\t - Date Of Birth: ");
                database[i][1] = scanner.nextLine();
                System.out.print("\t - Occupation: ");
                database[i][2] = scanner.nextLine();
                System.out.print("\n");
            }

            // Shows the user what they entered into the database

            System.out.println("These are the values you stored: ");
            printDatabase(database);

            // Checks to see if the user has any more entries

            System.out.println("Do you have any more Entries to place in the Database?");
            String response = scanner.nextLine();
            if (response.isEmpty()) {
                System.out.println("No response given, please try again");
            } else if (response == "No" || response == "no") {
                running = false;
                break;
            } else if (response == "yes" || response == "Yes") {
                continue;
            }

            // Asks if the user would like to view any of the historical figures that they
            // entered into the database

            System.out.println("Would you like to view a Historical Figure?");
            response = scanner.nextLine();
            if (response.isEmpty()) {
                System.out.println("No response given, please try again");
            } else if (response == "No" || response == "no") {
                System.exit(0);
            } else if (response == "yes" || response == "Yes") {
                System.out.println("");

                showFigure(database, response);
            }
        }

    }

    /**
     * FuncName: printDatabase
     * It prints the database
     * 
     * @param numOfFigures (int) The number of figures in the database.
     * @param db           (String[][]) The database that you want to print.
     */

    public static void printDatabase(String[][] db) {
        for (int i = 0; i < db.length; i++) {
            for (int j = 0; j < db[i].length; j++) {
                System.out.print("\t - ");
                System.out.print(db[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * FuncName: showFigure
     * It takes a 2D array of Strings and a String as input, and prints out the row
     * of the 2D array that
     * has the same first element as the String
     * 
     * @param db   (String[][]) the database
     * @param name (String) The name of the figure you want to show.
     */
    public static void showFigure(String[][] db, String name) {

        for (int i = 0; i < db.length; i++) {
            if (db[i][0].equals(name)) {
                System.out.println("\tName: " + db[i][0]);
                System.out.println("\tDate of birth: " + db[i][1]);
                System.out.println("\tOccupation: " + db[i][2]);
            } else {
                System.out.println("Name Not Found in DataBase");
            }
        }
    }
}
