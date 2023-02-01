package exceptions;

import java.util.Scanner;

public class CommonExceptions {
    public static void main(String[] args) {

        // **************ArrayIndexOutOfBounds**************//
        int[] grades = new int[] { 96, 65, 56, 86 };
        System.out.println(grades[4]); // << Trying to access unallocated memory

        // **************NullPointerException**************//
        String[] names = new String[7];
        names[0] = "John";
        names[1] = "Jim";
        names[2] = "Joe";

        /*
         * Here will work fine UNTIL you try to access an element that
         * has not been filled yet and is still NULL
         * > NULL does not have access to a .toUpperCase() method
         */
        for (String name : names) {
            if (name != null) {
                System.out.println(name.toUpperCase());
            } else {
                System.out.println("Name is NULL");
            }
        }

        // **************InputMismatchException**************//
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a random integer");
        if (scanner.hasNextInt()) {
            scanner.nextInt();
        } else {
            System.out.println("Please enter a number");
            scanner.next();
        }

        scanner.close();

    }
}