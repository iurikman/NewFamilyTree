package view.Commands;

import view.View;

public class Save extends Command{

    public Save(View view) {
        super("Save", view);
    }

    @Override
    public void execute() {
        getView().save();
    }
}
