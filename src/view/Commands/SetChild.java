package view.Commands;

import view.View;

public class SetChild extends Command{

    public SetChild(View view) {
        super("Set child", view);
    }

    @Override
    public void execute() {
        getView().setChild();
    }
}
