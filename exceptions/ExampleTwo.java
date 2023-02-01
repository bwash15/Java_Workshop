package exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class ExampleTwo {

    /**
     * 
     * Checked Exception - Compile Time
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            readFile("greetings.txt");

        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } finally {
            System.out.print("Process Complete");
        }

    }

    public static void readFile(String fileName) throws FileNotFoundException {

        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        System.out.println(scanner.nextLine());
        scanner.close();

    }
}