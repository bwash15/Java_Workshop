package analysis;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;

/*
 *  A Point-In-Time shows the Date, Time, AM/PM, Time Zone
 *    of an event
 *  DateFormatOptions carries with it formatting options for the date and time results 
 *   returned
 * 
 */

class DateFormatOptions {
    public FormatStyle dateTimeStyle;
    public DateTimeFormatter dateFormatter;
    public DateTimeFormatter timeFormatter;
    public DateTimeFormatter _AM_PM_TZoneFormatter;

    DateFormatOptions() {
        this.dateTimeStyle = FormatStyle.MEDIUM;
        this.dateFormatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        this.timeFormatter = DateTimeFormatter.ofLocalizedTime(dateTimeStyle);
        this._AM_PM_TZoneFormatter = DateTimeFormatter.ofPattern(" a ");
    }

    public String getRegion() {
        return dateFormatter.getLocale().getDisplayCountry();
    }
}

public class PointInTime {

    private LocalDate date;
    private LocalTime theTime;
    private long nowToTheMilliSec;
    DateFormatOptions formatOptions;

    private String dateText;
    private String timeText;
    // private String am_pm_tZoneText;

    private LocalDate parsedDate;
    private LocalTime parsedTime;
    // private LocalTime parsedAmPmTzone;

    // Constructor
    public PointInTime() {
        this.date = LocalDate.now();
        this.theTime = LocalTime.now();
        this.nowToTheMilliSec = System.currentTimeMillis();
        this.formatOptions = new DateFormatOptions();
        this.dateText = date.format(formatOptions.dateFormatter);
        this.parsedDate = LocalDate.parse(dateText, formatOptions.dateFormatter);
        this.timeText = theTime.format(formatOptions.timeFormatter);
        this.parsedTime = LocalTime.parse(timeText, formatOptions.timeFormatter);

        // am_pm_tZoneText = theTime.format(formatOptions._AM_PM_TZoneFormatter);
        // parsedAmPmTzone = LocalTime.parse(am_pm_tZoneText,
        // formatOptions._AM_PM_TZoneFormatter);
    }

    // Copy Constructor
    public PointInTime(PointInTime _pointInTime) {
        if (!_pointInTime.equals(null)) {
            this.date = LocalDate.now();
            this.theTime = LocalTime.now();
            this.nowToTheMilliSec = System.currentTimeMillis();
            this.formatOptions = new DateFormatOptions();
            this.dateText = _pointInTime.date.format(formatOptions.dateFormatter);
            this.parsedDate = _pointInTime.parsedDate;

            // this._AM_PM_TZoneFormatter = _pointInTime._AM_PM_TZoneFormatter;
            // this.am_pm_tZoneText = _pointInTime.am_pm_tZoneText;
            // this.parsedAmPmTzone = _pointInTime.parsedAmPmTzone;
        }
    }

    public LocalDate getDateOfPointInTime() {
        return this.date;
    }

    public LocalTime getTimeOfPointInTime() {
        return this.theTime;
    }

    public long getNowToTheMilliSec() {
        return this.nowToTheMilliSec;
    }

    // Methods
    @Override
    public String toString() {
        return "\n\tPoint-In-Time: \n"
                + "\tDate: " + getParsedDate() + "\n"
                + "\tRegion: " + formatOptions.getRegion() + "\n"
                + "\tTime: " + getTimeOfPointInTime() + "\n"
                + "\tTo The Millisecond: " + getNowToTheMilliSec() + "\n";
    }

    public LocalDate getParsedDate() {
        return this.parsedDate;
    }

    public LocalTime getParsedTime() {
        return this.theTime;
    }

}
