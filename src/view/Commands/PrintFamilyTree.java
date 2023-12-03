package view.Commands;

import view.View;

public class PrintFamilyTree extends Command{

    public PrintFamilyTree(View view) {
        super("Print family tree", view);
    }

    @Override
    public void execute() {
        getView().printFamilyTree();
    }
}
