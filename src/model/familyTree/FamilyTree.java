package model.familyTree;

import model.comparators.ElementComparatorByAge;
import model.comparators.ElementComparatorByName;
import model.comparators.ElementIterator;
import model.elements.ElementOfTree;
import model.elements.Gender;
import model.elements.ItemOfFamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemOfFamilyTree> implements Iterable<E> {
    List<E> elementsList = new ArrayList<E>();

    public void addElement(E element) {
        elementsList.add(element);
    }

    public List<E> getFamilyTree() {
        return elementsList;
    }

    public boolean isExistByName(String name) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistByID(int id) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return elementsList.toString();
    }

    public ItemOfFamilyTree findByName(String name) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getName().equalsIgnoreCase(name)) {
                return element;
            }
        }
        return null;
    }

    public ItemOfFamilyTree findByID(int id) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getID() == id) {
                return element;
            }
        }
        return null;
    }

    public void setGender(String name, char gender) {
        findByName(name).setGender(gender);
    }

    public void setBD(String name, LocalDate bd) {
        findByName(name).setBD(bd);
    }

    public ItemOfFamilyTree sendByName(String memoryName) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getName().equalsIgnoreCase(memoryName)) {
                return element;
            }
        }
        return null;
    }

    public ItemOfFamilyTree sendByID(int id) {
        for (ItemOfFamilyTree element : elementsList) {
            if (element.getID() == id) {
                return element;
            }
        }
        return null;
    }

    public void sortByName() {
        elementsList.sort(new ElementComparatorByName<>());
    }

    public void sortByAge() {
        elementsList.sort(new ElementComparatorByAge<>());
    }

    public Iterator<E> iterator() {
        return new ElementIterator<>(elementsList);
    }
}
