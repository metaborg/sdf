package org.metaborg.sdf2table.grammar;

import static org.metaborg.sdf2table.parsetable.ParseTableProduction.getAllProductionLabels;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.spoofax.interpreter.terms.IStrategoList;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.BiMap;

public class AssociativityInfo implements Serializable {

    private static final long serialVersionUID = 8078429805984018592L;

    private final Set<Production> nonAssocWith = new HashSet<>();
    private final Set<Production> nonNestedWith = new HashSet<>();

    protected AssociativityInfo() {
    }

    public Set<Production> getNonAssocWith() {
        return nonAssocWith;
    }

    public Set<Production> getNonNestedWith() {
        return nonNestedWith;
    }

    public IStrategoTerm toAterm(ITermFactory tf, BiMap<IProduction, Integer> productionLabels) {
        IStrategoList.Builder nonAssocLabels = tf.arrayListBuilder(nonAssocWith.size());
        IStrategoList.Builder nonNestedLabels = tf.arrayListBuilder(nonNestedWith.size());

        for(Production p : nonAssocWith)
            getAllProductionLabels(productionLabels, p).forEach(label -> nonAssocLabels.add(tf.makeInt(label)));
        for(Production p : nonNestedWith)
            getAllProductionLabels(productionLabels, p).forEach(label -> nonNestedLabels.add(tf.makeInt(label)));

        return tf.makeAppl(tf.makeConstructor("assoc-with", 2),
            tf.makeAppl(tf.makeConstructor("non-assoc", 1), tf.makeList(nonAssocLabels)),
            tf.makeAppl(tf.makeConstructor("non-nested", 1), tf.makeList(nonNestedLabels)));
    }
}
