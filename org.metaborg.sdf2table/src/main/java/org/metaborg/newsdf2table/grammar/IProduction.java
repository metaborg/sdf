package org.metaborg.newsdf2table.grammar;

import java.util.List;
import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public interface IProduction {

    /**
    * Gets the left hand side of a production.
    *
    * @return The left hand symbol.
    */    
    Symbol leftHand();
        
    /**
     * Gets the constructor of a production.
     *
     * @return The the constructor.
     */    
    String constructor();
    
    /**
     * Gets the left hand side of a production.
     *
     * @return The left hand symbol.
     */    
    List<Symbol> rightHand();
    
    Set<IAttribute> attributes();

    IStrategoTerm toAterm(ITermFactory tf);
}
