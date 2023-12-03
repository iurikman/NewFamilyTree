package presenter;

import model.elements.ItemOfFamilyTree;
import model.familyTree.FamilyTree;
import view.Habits;
import view.Profession;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean elementIsExistByID(int id) {
        return service.elementIsExistByID(id);
    }

    public boolean elementIsExistByName(String name) {
        return service.elementIsExistByName(name);
    }

    public void addElement(String name) {
        service.addElement(name);
    }

    public void getFamilyTree() {
        service.getFamilyTree();
    }

    public Boolean findByName(String name) {
        return service.findByName(name);
    }

    public ItemOfFamilyTree findByID(int id) {
        if (service.findByID(id)) {
            return service.sendByID(id);
        }
        return null;
    }

    public void setGender(String name, char gender) {
        service.setGender(name, gender);
    }

    public void setBD(String name, LocalDate bd) {
        service.setBD(name, bd);
    }

    public void setMother(String memoryName, String motherName) {
        service.setMother(memoryName, motherName);
    }

    public void setFather(String memoryName, String fatherName) {
        service.setFather(memoryName, fatherName);
    }

    public void setChild(String memoryName, String childName) {
        service.setChild(memoryName, childName);
    }

    public void setProfession(String memoryName, Profession profession) {
        service.setProfession(memoryName, profession);
    }

    public void setHabit(String memoryName, Habits habit) {
        service.setHabit(memoryName, habit);
    }

    public void getAllInfo(String memoryName) {
        if (service.findByName(memoryName)) {
            service.sendByName(memoryName).getAllInfo();
        } else System.out.println("Not found!");
    }

    public ItemOfFamilyTree sendByName(String memoryName) {
        return service.sendByName(memoryName);
    }

    public boolean familyTreeIsExist() {
        return service.familyTreeIsExist();
    }

    public void save() {
        service.save();
    }

    public void read() {
        service.read();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

}
