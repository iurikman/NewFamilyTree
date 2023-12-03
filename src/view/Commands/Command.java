package view.Commands;

import view.View;

public abstract class Command {
    private String commandName;
    private View view;

    public Command (String commandName, View view) {
        this.commandName = commandName;
        this.view = view;
    }

    public abstract void execute ();

    public String getName() {
        return commandName;
    }

    public View getView() {
        return view;
    }
}
