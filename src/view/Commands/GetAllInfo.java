package view.Commands;

import view.View;

public class GetAllInfo extends Command{

    public GetAllInfo(View view) {
        super("Get all info", view);
    }

    @Override
    public void execute() {
        getView().getAllInfo();
    }
}
