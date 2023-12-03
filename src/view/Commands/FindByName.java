package view.Commands;

import view.View;

public class FindByName extends Command{

    public FindByName(View view) {
        super("Find by name", view);
    }

    @Override
    public void execute() {
        getView().findByName();
    }
}
