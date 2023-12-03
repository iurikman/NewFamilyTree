package view.menu;

import view.Commands.*;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {
    public List<Command> commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();

        commandList.add(new AddElement(view));
        commandList.add(new PrintFamilyTree(view));
        commandList.add(new FindByID(view));
        commandList.add(new FindByName(view));
        commandList.add(new SortByName(view));
        commandList.add(new SortByAge(view));
        commandList.add(new Save(view));
        commandList.add(new Read(view));
        commandList.add(new Exit(view));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Menu:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1)
                    .append(". ")
                    .append(commandList.get(i).getName())
                    .append(".\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        if (choice < commandList.size() + 1 && choice > 0) {
            Command command = commandList.get(choice - 1);
            command.execute();
        }
    }

    public int size() {
        return commandList.size();
    }
}
