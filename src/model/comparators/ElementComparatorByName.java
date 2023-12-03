package model.comparators;

import model.elements.ElementOfTree;
import model.elements.ItemOfFamilyTree;

import java.util.Comparator;

public class ElementComparatorByName<E extends ItemOfFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
