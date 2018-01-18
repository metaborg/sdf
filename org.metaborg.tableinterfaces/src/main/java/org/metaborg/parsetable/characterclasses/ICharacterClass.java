package org.metaborg.parsetable.characterclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ASCII characters: integer representation [0, 255]
 *
 * End-of-file marker (EOF): integer representation 256
 */
public interface ICharacterClass {

    boolean contains(int character);

    int min();

    int max();

    static Comparator<ICharacterClass> comparator() {
        return (one, two) -> {
            return Integer.compare(one.min(), two.min());
        };
    }

    static boolean disjointSortable(List<ICharacterClass> original) {
        List<ICharacterClass> sorted = new ArrayList<>(original);

        Collections.sort(sorted, comparator());

        return disjointSorted(sorted);
    }

    /*
     * Returns true if each character class only contains characters bigger than the characters in the previous
     * character class.
     */
    static boolean disjointSorted(List<ICharacterClass> characterClasses) {
        for(int i = 0; i < characterClasses.size() - 1; i++) {
            if(characterClasses.get(i).max() >= characterClasses.get(i + 1).min())
                return false;
        }

        return true;
    }
    
    @Override boolean equals(Object obj);
    @Override int hashCode();

}
