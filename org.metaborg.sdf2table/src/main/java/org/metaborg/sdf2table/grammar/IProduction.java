package org.metaborg.sdf2table.grammar;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.SetMultimap;

public interface IProduction {

    Symbol leftHand();

    List<Symbol> rightHand();

    // To calculate Deep Priority Conflicts
    int leftRecursivePosition();
    int rightRecursivePosition();
    void calculateRecursion(NormGrammar grammar);

    @Override int hashCode();
    @Override boolean equals(Object obj);

    IStrategoTerm toAterm(SetMultimap<IProduction, IAttribute> prod_attrs);
    IStrategoTerm toSDF3Aterm(SetMultimap<IProduction, IAttribute> prod_attrs,
        Map<Set<Context>, Integer> ctx_vals, Integer ctx_val);

    // TODO: FIRST AND FOLLOW SETS OF PRODUCTIONS
    // void calculateDependencies(NormGrammar g);
    //
    // TableSet firstSet();
    // TableSet followSet();
}
