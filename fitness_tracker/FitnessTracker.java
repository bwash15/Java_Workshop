package fitness_tracker;

import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.nio.file.*;
import java.io.*;
import java.util.logging.*;

public class FitnessTracker {

    FitnessTracker() {
    }

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        // Getting the day of the week.
        DayOfWeek day = localDateTime.getDayOfWeek();
        System.out.println("The week day is: " + day);
    }

}
