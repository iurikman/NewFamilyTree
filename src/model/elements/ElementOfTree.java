package model.elements;

import view.Habits;
import view.Profession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElementOfTree implements Comparable, ItemOfFamilyTree {
    private int id;
    private String name;
    private Gender gender = Gender.NONE;
    private LocalDate bd = LocalDate.of(1900, 01, 01);
    private ElementOfTree mother;
    private ElementOfTree father;
    private Profession profession = Profession.NONE;
    private List<ElementOfTree> children = new ArrayList<>();
    private List<Habits> habits = new ArrayList<>();
    private List<ItemOfFamilyTree> getChildren;

    public ElementOfTree(String name) {
        this.name = name;
    }

    public ElementOfTree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        if (gender == 'm') {
            this.gender = Gender.MALE;
        } else if (gender == 'f') {
            this.gender = Gender.FEMALE;
        }
    }

    public void setBD(LocalDate bd) {
        this.bd = bd;
    }

    @Override
    public void setMother(ItemOfFamilyTree mother) {
        this.mother = (ElementOfTree) mother;
    }

    @Override
    public void setFather(ItemOfFamilyTree father) {
        this.father = (ElementOfTree) father;
    }

    @Override
    public void setChild(ItemOfFamilyTree child) {
        this.children.add((ElementOfTree) child);
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBd() {
        return bd;
    }

    public ElementOfTree getMother() {
        return mother;
    }

    public ElementOfTree getFather() {
        return father;
    }


    public int getID() {
        return id;
    }

    public boolean isExistChild(String childName) {
        for (ElementOfTree child : children) {
            if (child.name.equalsIgnoreCase(childName)) {
                return true;
            }
        }
        return false;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public void setHabit(Habits habit) {
        this.habits.add(habit);
    }


    public void getAllInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("----------------\n" +
                        "Name: ").append(getName()).append(".\n")
                .append("Birthday: ").append(bd.toString()).append(".\n")
                .append("Gender: ").append(gender.toString()).append(".\n")
                .append("Mother: ").append(mother.getName()).append(".\n")
                .append("Father: ").append(father.getName()).append(".\n")
                .append("Children: ").append(children.toString()).append(".\n")
                .append("Profession: ").append(profession.toString()).append(".\n")
                .append("Habits: ").append(habits.toString()).append(".\n----------------");
        System.out.println(stringBuilder);
    }

    @Override
    public String toString() {
        return "id: " + id + ". Name: " + name + ".";
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public int getAge() {
        return LocalDate.now().getYear() - bd.getYear();
    }

    ;
}

