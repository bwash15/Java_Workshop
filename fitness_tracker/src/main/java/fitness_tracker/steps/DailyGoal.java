package fitness_tracker.src.main.java.fitness_tracker.steps;

public class DailyGoal {

    int dailyGoal = 10000;

    DailyGoal(int _goal) {
        dailyGoal = _goal;
    }

    public boolean hasMetGoals(Fit_trac_steps _steps) {
        if (_steps.getSteps() >= dailyGoal) {
            return true;
        }
        return false;
    }
}
