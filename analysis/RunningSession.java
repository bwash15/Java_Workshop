package analysis;

import java.util.List;
import java.util.ArrayList;

/**
 * Running Session is an object that shows you details on the
 * current runtime of the application
 * Attributes of the class:
 * > startTime - timestamp of when the current session started shown in
 * milliseconds
 * > numOfDisplayUpdates - the number of times the display has been updated
 * during the current active runtime
 * > elapsedTime - the difference in the current time and the startTime
 * attribute shown in milliseconds
 * > elapsedSeconds - number of seconds that have passed since startTime
 * attribute shown in milliseconds
 * > elapsedMinutes - number of minutes that have passed since the startTime
 * attribute shown in milliseconds
 * > secondsDisplay - number of milliseconds for ONE display window paint (time
 * taken for the display to change one frame)
 * > timeTillNextDisplayChange - number of milliseconds until the display window
 * repaints again
 * 
 */

public class RunningSession {
    List<PointInTime> timePoints = new ArrayList<>();
    PointInTime a_PointInTime;
    private long startTime;
    private long elapsedTime;
    private long elapsedSeconds;
    private long elapsedMinutes;

    private long numOfDisplayUpdates;
    private long secondsDisplay;
    private long timeTillNextDisplayChange;

    public RunningSession() {
        a_PointInTime = new PointInTime();
        startTime = System.currentTimeMillis();
        numOfDisplayUpdates = 0;
        elapsedTime = System.currentTimeMillis() - startTime;
        elapsedSeconds = elapsedTime / 1000;
        elapsedMinutes = elapsedSeconds / 60;
        secondsDisplay = elapsedSeconds % 60;
        timeTillNextDisplayChange = 1000 - (elapsedTime % 1000);
    }

    /*
     * Getters and Setters
     */

    public long getStartTime() {
        return this.startTime;
    }

}
