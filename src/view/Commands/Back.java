package view.Commands;

import view.View;

public class Back extends Command{

    public Back(View view) {
        super("Back", view);
    }

    @Override
    public void execute() {
        getView().back();
    }
}
