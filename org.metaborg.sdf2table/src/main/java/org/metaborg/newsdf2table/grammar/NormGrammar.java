package org.metaborg.newsdf2table.grammar;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.spoofax.interpreter.core.Pair;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

public class NormGrammar implements INormGrammar  {

    public Set<IProduction> prods;
    public Set<IRestriction> res;
    public Set<IPriority> prio;
    
    public HashMap<IStrategoTerm, Symbol> symbols; // to calculate first and follow sets
    
    public SetMultimap<IProduction, Set<IAttribute>> prod_attrs;
    
    public NormGrammar(Set<IProduction> prods, Set<IRestriction> res, Set<IPriority> prio) {
        this.prods = prods;
        this.res = res;
        this.prio = prio;
        this.symbols = Maps.newHashMap(); //new HashMap<IStrategoTerm, Symbol>();
        this.prod_attrs = HashMultimap.create();        
    }
    

    @Override public Set<IProduction> syntax() {
        return prods;
    }

    @Override public Set<IRestriction> restrictions() {
        return res;
    }

    @Override public Set<IPriority> priorities() {
        return prio;
    }
    
    public void mergeProductionAttributes(){
        for(IProduction production : prod_attrs.keys()){
            for(Set<IAttribute> attrs : prod_attrs.get(production)){
                production.attributes().addAll(attrs); 
            }            
        }
    }

}
