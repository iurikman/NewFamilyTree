package view.Commands;

import view.View;

public class SetFather extends Command{

    public SetFather(View view) {
        super("Set father", view);
    }

    @Override
    public void execute() {
        getView().setFather();
    }
}
