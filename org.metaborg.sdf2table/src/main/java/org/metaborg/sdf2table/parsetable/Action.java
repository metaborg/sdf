package org.metaborg.sdf2table.parsetable;

import org.metaborg.parsetable.actions.IAction;
import org.metaborg.parsetable.characterclasses.ICharacterClass;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Action implements IAction {

    ICharacterClass cc;

    public abstract IStrategoTerm toAterm(ITermFactory tf, ParseTable pt);

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

}
