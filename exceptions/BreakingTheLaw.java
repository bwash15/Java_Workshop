package exceptions;

import java.nio.file.*;
import java.nio.file.NoSuchFileException;
import java.io.*;
import java.util.List;
import java.util.logging.*;
import java.util.Collections;
import java.util.Iterator;

public class BreakingTheLaw {

    public static class MyException extends Exception {

        public MyException() {
            super();
        };

        public MyException(String message) {
            super(message);
        };

        public MyException(String message, Throwable cause) {
            super(message, cause);
        };

        public MyException(Throwable cause) {
            super(cause);
        }

    }

    public static void main(String[] args) throws MyException {
        Logger logger = Logger.getAnonymousLogger();
        List<String> lines = Collections.emptyList();
        String s = null;

        try {
            System.out.println(s.length());
            lines = Files.readAllLines(Paths.get("readMe.txt"), null);
        } catch (NoSuchFileException nfe) {
            // TODO: handle exception
            logger.log(Level.SEVERE, "No Such File Exception Found", nfe);
            throw new MyException("Exception: my exception - No Such File Exception");

        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "Null Pointer Exception Found", ioe);
            throw new MyException("Exception: My exception - IOException");
        } finally {
            System.out.println("Closing Exception Block");
        }
        Iterator<String> iter = lines.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
