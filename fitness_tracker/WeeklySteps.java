package fitness_tracker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeeklySteps {

    List<Fit_trac_steps> dailySteps = new ArrayList<>();
    DailyGoal dailyGoal;

    public List<Fit_trac_steps> getDailySteps() {
        return new ArrayList<>(dailySteps);
    }

    public void setDailySteps(List<Fit_trac_steps> _stepsList) {
        this.dailySteps = new ArrayList<>(_stepsList);
    }

    public DailyGoal getDailyGoal() {
        return dailyGoal;
    }

    public void setDailyGoal(int _goal) {
        dailyGoal = new DailyGoal(_goal);
    }

    /**
     * FuncName: bestDay() - no params
     * > Find the day of the week with the most steps
     * 
     * @return The day of the week with the most steps.
     */
    public DayOfWeek bestDay() {

        DayOfWeek bestDay = DayOfWeek.MONDAY;
        int max = 0;
        for (Fit_trac_steps fit_trac_steps : dailySteps) {
            if (fit_trac_steps.getSteps() > max) {
                max = fit_trac_steps.getSteps();
                bestDay = fit_trac_steps.getDate().getDayOfWeek();
            }
        }
        return bestDay;
    }

    /**
     * FuncName: getTotalSteps() - no params
     * > This function returns the total number of steps taken by the user in a day
     * 
     * @return The total number of steps taken in a day.
     */
    public int getTotalSteps() {
        int totalSteps = 0;
        for (Fit_trac_steps _steps : dailySteps) {
            totalSteps += _steps.getSteps();
        }
        return totalSteps;
    }

    public String format() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("Total Steps: " + getTotalSteps() + "\n");

        for (Fit_trac_steps fit_trac_steps : dailySteps) {
            if (dailyGoal.hasMetGoals(fit_trac_steps)) {
                strBuilder.append("Goal Met!!!      ");
            } else {
                strBuilder.append("Not There Yet... ");
            }
            strBuilder.append(fit_trac_steps.getDate().getDayOfWeek());
            strBuilder.append(" ");
            strBuilder.append(fit_trac_steps.getSteps());

            DayOfWeek best = bestDay();
            if (fit_trac_steps.getDate().getDayOfWeek() == best) {
                strBuilder.append(" ***** BEST DAY!");
            }
            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }

    public void addDailySteps(int _steps, LocalDate _date) {
        dailySteps.add(new Fit_trac_steps(_steps, _date));
    }

    public static void main(String[] args) {
        // Initailize Sample Data
        DailyGoal dailyGoal = new DailyGoal(10000);
        WeeklySteps weeklySteps = new WeeklySteps();

        weeklySteps.setDailyGoal(dailyGoal.dailyGoal);

        int year = 2021;
        int month = 1;
        int day = 4;

        weeklySteps.addDailySteps(11543, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(12112, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(10005, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(10011, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(9000, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(20053, LocalDate.of(year, month, day));
        day++;
        weeklySteps.addDailySteps(20048, LocalDate.of(year, month, day));

        System.out.println(weeklySteps.format());
    }

}
