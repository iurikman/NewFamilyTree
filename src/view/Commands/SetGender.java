package view.Commands;

import view.View;

public class SetGender extends Command{

    public SetGender(View view) {
        super("Set gender", view);
    }

    @Override
    public void execute() {
        getView().setGender();
    }
}
