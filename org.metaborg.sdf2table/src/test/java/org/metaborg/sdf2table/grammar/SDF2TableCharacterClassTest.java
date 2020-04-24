package org.metaborg.sdf2table.grammar;

import org.metaborg.parsetable.characterclasses.AbstractCharacterClassTest;
import org.metaborg.parsetable.characterclasses.ICharacterClassFactory;

public class SDF2TableCharacterClassTest extends AbstractCharacterClassTest {

    @Override protected ICharacterClassFactory getCharacterClassFactory() {
        return new CharacterClassFactory();
    }

}
