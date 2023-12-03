package model.elements;

import view.Habits;
import view.Profession;

import java.io.Serializable;
import java.time.LocalDate;

public interface ItemOfFamilyTree extends Serializable {
    String getName();

    int getID();

    void setGender(char gender);

    void setBD(LocalDate bd);

    void setMother(ItemOfFamilyTree mother);

    void setFather(ItemOfFamilyTree father);

    void setChild(ItemOfFamilyTree child);

    boolean isExistChild(String childName);

    void setProfession(Profession profession);

    void setHabit(Habits habit);

    void getAllInfo();

    int getAge();
}
