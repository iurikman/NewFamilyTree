package model.service;

import model.builders.ElementBuilder;
import model.elements.ElementOfTree;
import model.elements.ItemOfFamilyTree;
import view.Habits;
import view.Profession;
import model.familyTree.FamilyTree;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Service {
    private FamilyTree familyTree;
    private ElementBuilder elementBuilder;

    public Service() {
        elementBuilder = new ElementBuilder();
        familyTree = new FamilyTree();
    }

    public void addElement(String name) {
        ElementOfTree element = elementBuilder.build(name);
        familyTree.addElement(element);
    }

    public void getFamilyTree() {
        for (int i = 0; i < familyTree.getFamilyTree().size(); i++) {
            System.out.println(familyTree.getFamilyTree().get(i));
        }
    }

    public boolean findByName(String name) {
        return familyTree.isExistByName(name);
    }

    public boolean findByID(int id) {
        return familyTree.isExistByID(id);
    }

    public void setGender(String name, char gender) {
        familyTree.setGender(name, gender);
    }

    public void setBD(String name, LocalDate bd) {
        familyTree.setBD(name, bd);
    }

    public void setMother(String memoryName, String motherName) {
        if (familyTree.isExistByName(motherName) && !motherName.equalsIgnoreCase(memoryName)) {
            if (familyTree.isExistByName(motherName)) {
                familyTree.findByName(memoryName).setMother(familyTree.sendByName(motherName));
            } else {
                familyTree.findByName(memoryName).setMother(new ElementOfTree(motherName));
            }
        } else {
            System.out.println("Error!");
        }
    }

    public void setFather(String memoryName, String fatherName) {
        if (familyTree.isExistByName(fatherName) && !fatherName.equalsIgnoreCase(memoryName)) {
            if (familyTree.isExistByName(fatherName)) {
                familyTree.findByName(memoryName).setFather(familyTree.findByName(fatherName));
            } else {
                familyTree.findByName(memoryName).setFather(new ElementOfTree(fatherName));
            }
        } else {
            System.out.println("Error!");
        }
    }

    public void setChild(String memoryName, String childName) {
        if (!familyTree.findByName(memoryName).isExistChild(childName)
                && familyTree.isExistByName(childName)
                && !memoryName.equalsIgnoreCase(childName)) {
            familyTree.findByName(memoryName).setChild(sendByName(childName));
            sendByName(childName).setMother(familyTree.findByName(memoryName));
        } else if (memoryName.equalsIgnoreCase(childName)) {
            System.out.println("Error!");
        } else {
            System.out.println("Error!");
        }
    }

    public void setProfession(String memoryName, Profession profession) {
        familyTree.findByName(memoryName).setProfession(profession);
    }

    public void setHabit(String memoryName, Habits habit) {
        familyTree.findByName(memoryName).setHabit(habit);
    }

    public ItemOfFamilyTree sendByName(String memoryName) {
        return familyTree.sendByName(memoryName);
    }

    public ItemOfFamilyTree sendByID(int id) {
        return familyTree.sendByID(id);
    }

    public boolean familyTreeIsExist() {
        return familyTree.getFamilyTree().size() > 0;
    }

    public boolean elementIsExistByID(int id) {
        return familyTree.getFamilyTree().size() + 1 > id;
    }

    public boolean elementIsExistByName(String name) {
        return familyTree.isExistByName(name);
    }

    public void save() {
        Saver saver = new Saver();
        saver.write(familyTree.getFamilyTree(), "SaverFile.txt");
    }

    public void read() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Elements list from file: \n");
        for (ElementOfTree element : (List<ElementOfTree>) Objects.requireNonNull(Saver.read("SaverFile.txt"))) {
            stringbuilder.append(element).append("\n");
        }
        System.out.println(stringbuilder);
    }

    public void sortByAge() {
        familyTree.sortByAge();
        getFamilyTree();
    }

    public void sortByName() {
        familyTree.sortByName();
        getFamilyTree();
    }
}