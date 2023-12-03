package model.builders;

import model.elements.ElementOfTree;

public class ElementBuilder {
    private int id = 1;

    public ElementOfTree build(String name) {
        ElementOfTree elementOfTree = new ElementOfTree(id++, name);
        if (elementOfTree.getMother() == null) {
            elementOfTree.setMother(new ElementOfTree("none"));
        }
        if (elementOfTree.getFather() == null) {
            elementOfTree.setFather(new ElementOfTree("none"));
        }
        return elementOfTree;
    }
}
