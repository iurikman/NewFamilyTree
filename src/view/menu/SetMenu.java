package view.menu;

import view.Habits;
import view.Profession;
import view.Commands.*;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class SetMenu extends Menu {
    public List<Command> commandList;
    Profession Profession = view.Profession.Set_profession;
    Habits Habis = view.Habits.Set_habit;

    public SetMenu(View view) {
        commandList = new ArrayList<>();

        commandList.add(new GetAllInfo(view));
        commandList.add(new SetAllInfo(view));
        commandList.add(new SetGender(view));
        commandList.add(new SetBD(view));
        commandList.add(new SetFather(view));
        commandList.add(new SetMother(view));
        commandList.add(new SetChild(view));
        commandList.add(new SetProfession(view, Profession));
        commandList.add(new SetHabit(view, Habis));
        commandList.add(new Exit(view));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element menu:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1)
                    .append(". ")
                    .append(commandList.get(i).getName())
                    .append(".\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        if (choice < commandList.size() && choice > 0) {
            Command command = commandList.get(choice - 1);
            command.execute();
        } else if (choice == commandList.size()) {

        } else System.out.println("Error, try again!");
    }

    public int size() {
        return commandList.size();
    }
}
