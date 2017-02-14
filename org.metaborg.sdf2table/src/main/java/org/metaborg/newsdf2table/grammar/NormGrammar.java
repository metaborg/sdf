package org.metaborg.newsdf2table.grammar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.metaborg.newsdf2table.parsetable.ContextualProduction;
import org.metaborg.newsdf2table.parsetable.ContextualSymbol;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;

public class NormGrammar implements INormGrammar {

    public IProduction initial_prod;

    public Map<UniqueProduction, IProduction> prods;
    // to handle Sort.Cons in priorities
    public Map<ProductionReference, IProduction> sort_cons_prods;
    // extra map to merge same productions with different attributes
    public SetMultimap<IProduction, IAttribute> prod_attrs;

    public BiMap<IProduction, ContextualProduction> contextual_prods;
    public Set<ContextualProduction> derived_contextual_prods;
    public Set<ContextualSymbol> contextual_symbols;

    public Set<IPriority> transitive_prio;
    public Set<IPriority> non_transitive_prio;
    SetMultimap<IPriority, Integer> prios = HashMultimap.create();
    SetMultimap<IPriority, Integer> deep_prios = HashMultimap.create();

    // extra collections to calculate the transitive closure
    public Set<IProduction> prio_prods;
    public SetMultimap<IPriority, Integer> trans_prio_arguments;
    public SetMultimap<IPriority, Integer> non_trans_prio_arguments;

    public HashMap<String, Symbol> symbols_read; // caching symbols read
    public HashMap<String, IProduction> productions_read; // caching symbols read

    public SetMultimap<Symbol, IProduction> symbol_prods;
    
    public NormGrammar() {
        this.prods = Maps.newHashMap();
        this.sort_cons_prods = Maps.newHashMap();
        this.contextual_prods = HashBiMap.create();
        this.derived_contextual_prods = Sets.newHashSet();
        this.contextual_symbols = Sets.newHashSet();
        this.prod_attrs = HashMultimap.create();
        this.transitive_prio = Sets.newHashSet();
        this.non_transitive_prio = Sets.newHashSet();
        prio_prods = Sets.newHashSet();
        trans_prio_arguments = HashMultimap.create();
        non_trans_prio_arguments = HashMultimap.create();
        symbol_prods = HashMultimap.create();
        this.symbols_read = Maps.newHashMap();
        this.productions_read = Maps.newHashMap();
    }


    @Override public Map<UniqueProduction, IProduction> syntax() {
        return prods;
    }


    @Override public SetMultimap<IPriority, Integer> priorities() {
        return prios;
    }

    public void priorityTransitiveClosure() {
        prios = HashMultimap.create();

        // Floyd Warshall Algorithm to calculate the transitive closure
        for(IProduction intermediate_prod : prio_prods) {
            for(IProduction first_prod : prio_prods) {
                for(IProduction second_prod : prio_prods) {
                    IPriority first_sec = new Priority(first_prod, second_prod, true);
                    IPriority first_k = new Priority(first_prod, intermediate_prod, true);
                    IPriority k_second = new Priority(intermediate_prod, second_prod, true);
                    // if there is no priority first_prod > second_prod
                    if(!transitive_prio.contains(first_sec)) {
                        // if there are priorities first_prod > intermediate_prod and
                        // intermediate_prod > second_prod
                        // add priority first_prod > second_prod
                        if(transitive_prio.contains(first_k) && transitive_prio.contains(k_second)) {
                            transitive_prio.add(first_sec);
                            trans_prio_arguments.putAll(first_sec, trans_prio_arguments.get(first_k));
                        }
                    } else {
                        if(transitive_prio.contains(first_k) && transitive_prio.contains(k_second)) {
                            trans_prio_arguments.putAll(first_sec, trans_prio_arguments.get(first_k));
                        }
                    }
                }
            }
        }

        prios.putAll(non_trans_prio_arguments);
        prios.putAll(trans_prio_arguments);
    }


    public SetMultimap<IPriority, Integer> deep_priorities() {
        return deep_prios;
    }

}
