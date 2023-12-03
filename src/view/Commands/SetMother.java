package view.Commands;

import view.View;

public class SetMother extends Command{

    public SetMother(View view) {
        super("Set mother", view);
    }

    @Override
    public void execute() {
        getView().setMother();
    }
}
