package model.elements.human;

import model.elements.ElementOfTree;
import view.Habits;
import view.Profession;

import java.util.List;

public class Human extends ElementOfTree {
    private Profession profession;
    private List<Habits> habits;

    public Human(String name) {
        super(name);
    }
}
