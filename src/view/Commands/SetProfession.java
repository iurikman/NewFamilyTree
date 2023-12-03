package view.Commands;

import view.Profession;
import view.View;

public class SetProfession extends Command {
    Profession profession;
    public SetProfession(View view, Profession profession) {
        super(profession.toString(), view);
        this.profession = profession;
    }

    @Override
    public void execute() {
        getView().setProfession();
    }
}
