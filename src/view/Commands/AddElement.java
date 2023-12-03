package view.Commands;

import view.View;

public class AddElement extends Command {

    public AddElement(View view) {
        super("Add element", view);
    }

    @Override
    public void execute() {
        getView().addElement();
    }
}
