package view.Commands;

import view.View;

public class Read extends Command{

    public Read(View view) {
        super("Read", view);
    }

    @Override
    public void execute() {
        getView().read();
    }
}
