package view.Commands;

import view.View;

public class SortByName extends Command{

    public SortByName(View view) {
        super("Sort by name", view);
    }

    @Override
    public void execute() {
        getView().sortByName();
    }
}
