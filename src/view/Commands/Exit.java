package view.Commands;

import view.View;

public class Exit extends Command{

    public Exit(View view) {
        super("Exit", view);
    }

    @Override
    public void execute() {
        getView().exit();
    }
}
