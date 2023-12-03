package view.Commands;

import view.View;

public class SetAllInfo extends Command{

    public SetAllInfo(View view) {
        super("Set all Info", view);
    }

    @Override
    public void execute() {
        getView().setAllInfo();
    }
}
