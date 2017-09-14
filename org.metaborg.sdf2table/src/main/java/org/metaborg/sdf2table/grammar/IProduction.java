package org.metaborg.sdf2table.grammar;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.parsetable.Context;
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

    IStrategoTerm toSDF3Aterm(ITermFactory tf, SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val);

    // TODO: FIRST AND FOLLOW SETS OF PRODUCTIONS
    // void calculateDependencies(NormGrammar g);
    //
    // TableSet firstSet();
    // TableSet followSet();
}
