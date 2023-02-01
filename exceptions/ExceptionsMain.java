package exceptions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.nio.file.*;
import java.io.*;
import java.util.logging.*;

public class ExceptionsMain {
    public static void main(String[] args) throws IOException {

        // Declare a list that will contain all of the files in the txt file
        List<String> lines = Collections.emptyList();
        // try {
        // // lines = Files.readAllLines(Paths.get("readMe.txt")); << Causes a
        // NullPointer
        // // Exception
        // System.out.println("Entering the Try / Catch block");
        // } catch (NullPointerException fe) {
        // System.out.println("Exception: File Not Found");
        // }

        /*
         * It is possible to use an OR statement and check for more than one exception
         * class in
         * 
         * > You cannot use parent and child classes in the catch statement
         * 
         */

        // try {
        // // lines = Files.readAllLines(Paths.get("readMe.txt")); << Causes a
        // NullPointer
        // // Exception
        // System.out.println("Entering the Try / Catch block");
        // } catch (NullPointerException | NoSuchFileException fe) {
        // System.out.println("Exception: File Not Found");
        // }

        // provokes an exception

        Logger logger = Logger.getAnonymousLogger();

        String s = null;

        try {
            System.out.println(s.length());
            lines = Files.readAllLines(Paths.get("readMe.txt"), null);
        } catch (NoSuchFileException npe) {
            // TODO: handle exception
            logger.log(Level.SEVERE, "Null Pointer Exception Found", npe);
            // throw new ExceptionsLogger("Exception: my exception happened");

        }
        Iterator<String> iter = lines.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
