package model.elements.aminals;

import model.elements.ElementOfTree;
import model.elements.ItemOfFamilyTree;

public class Animal extends ElementOfTree {
    private TypeOfAnimal typeOfAnimal;
    private String toy;

    public Animal(String name) {
        super(name);
    }

    public TypeOfAnimal getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(TypeOfAnimal typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }
}
