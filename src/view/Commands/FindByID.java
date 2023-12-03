package view.Commands;

import view.View;

public class FindByID extends Command{

    public FindByID(View view) {
        super("Find by id", view);
    }

    @Override
    public void execute() {
        getView().findById();
    }
}
