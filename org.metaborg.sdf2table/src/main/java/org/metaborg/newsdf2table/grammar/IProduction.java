package org.metaborg.newsdf2table.grammar;

import java.util.List;

import org.metaborg.newsdf2table.parsetable.TableSet;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.SetMultimap;

public interface IProduction {

    /**
    * Gets the left hand side of a production.
    *
    * @return The left hand symbol.
    */    
    Symbol leftHand();
        
    /**
     * Gets the left hand side of a production.
     *
     * @return The left hand symbol.
     */    
    List<Symbol> rightHand();
    
    // To calculate Deep Priority Conflicts 
    int leftRecursivePosition();
    int rightRecursivePosition();    
    void calculateRecursion(NormGrammar grammar);
        
    @Override int hashCode();
    @Override boolean equals(Object obj);

    IStrategoTerm toAterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs);

    void calculateDependencies(NormGrammar g);

    TableSet firstSet();
    TableSet followSet();   
}
