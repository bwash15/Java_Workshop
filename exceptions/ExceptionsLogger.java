package exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.nio.file.*;
import java.io.*;
import java.util.logging.*;

public class ExceptionsLogger extends Exception {

    public ExceptionsLogger() {
        super();
    };

    public ExceptionsLogger(String message) {
        super(message);
    };

    public ExceptionsLogger(String message, Throwable cause) {
        super(message, cause);
    };

    public ExceptionsLogger(Throwable cause) {
        super(cause);
    }

    public static void main(String[] args) throws ExceptionsLogger {
        Logger logger = Logger.getAnonymousLogger();
        List<String> lines = Collections.emptyList();
        String s = null;

        try {
            System.out.println(s.length());
            lines = Files.readAllLines(Paths.get("readMe.txt"), null);
        } catch (NoSuchFileException nfe) {
            // TODO: handle exception
            logger.log(Level.SEVERE, "No Such File Exception Found", nfe);
            throw new ExceptionsLogger("Exception: my exception - No Such File Exception");

        } catch (IOException ioe) {
            logger.log(Level.SEVERE, "Null Pointer Exception Found", ioe);
            throw new ExceptionsLogger("Exception: My exception - IOException");
        } finally {
            System.out.println("Closing Exception Block");
        }
        Iterator<String> iter = lines.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
