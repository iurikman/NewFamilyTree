package view.Commands;

import view.Habits;
import view.View;

public class SetHabit extends Command {
    Habits habit;
    public SetHabit(View view, Habits habit) {
        super(habit.toString(), view);
        this.habit = habit;
    }

    @Override
    public void execute() {
        getView().setHabit();
    }
}
