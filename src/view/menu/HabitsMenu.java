package view.menu;

import view.Commands.Command;
import view.Commands.Exit;
import view.Commands.SetHabit;
import view.Habits;
import view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HabitsMenu extends Menu {
    public List<Command> commandList;

    public HabitsMenu(View view) {
        commandList = new ArrayList<>();

        for (int i = 0; i < Arrays.stream(Habits.values()).toList().size(); i++) {
            commandList.add(new SetHabit(view, Arrays.stream(Habits.values()).toList().get(i)));
        }
        commandList.add(new Exit(view));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size() - 3; i++) {
            stringBuilder.append(i + 1)
                    .append(". ")
                    .append(commandList.get(i).getName())
                    .append(".\n");
        }
        return stringBuilder.append(commandList.size() - 2)
                .append(". ")
                .append(commandList.get(commandList.size() - 1).getName())
                .toString();
    }

    public void execute(int choice) {
        {
            if (choice < commandList.size() - 4 && choice > 0) {
                Command command = commandList.get(choice - 1);
                command.execute();
            } else if (choice == commandList.size() - 3) {

            } else System.out.println("Error, try again!");
        }
    }

    public int size() {
        return commandList.size();
    }
}
