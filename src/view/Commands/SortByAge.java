package view.Commands;

import view.View;

public class SortByAge extends Command{

    public SortByAge(View view) {
        super("Sort by age", view);
    }

    @Override
    public void execute() {
        getView().sortByAge();
    }
}
