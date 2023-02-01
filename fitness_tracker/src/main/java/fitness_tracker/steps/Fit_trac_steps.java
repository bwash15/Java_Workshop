package fitness_tracker.src.main.java.fitness_tracker.steps;

import java.time.LocalDate;

public class Fit_trac_steps {

    private int steps;
    private LocalDate date;

    public Fit_trac_steps(int _steps, LocalDate _date) {
        this.steps = _steps;
        this.date = _date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int _steps) {
        this.steps = steps;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate _date) {
        this.date = date;
    }

}
