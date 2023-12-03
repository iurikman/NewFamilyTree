package view.Commands;

import view.View;

public class SetBD extends Command{

    public SetBD(View view) {
        super("Set bd", view);
    }

    @Override
    public void execute() {
        getView().setBD();
    }
}
