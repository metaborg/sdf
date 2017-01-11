package org.metaborg.newsdf2table.parsetable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.metaborg.newsdf2table.grammar.IProduction;
import org.metaborg.newsdf2table.grammar.NormGrammar;
import org.metaborg.newsdf2table.io.GrammarReader;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.spoofax.terms.TermFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ParseTable {


    // map of labels -> Productions
    // states
    // priorities

    final int version_number = 6;
    final int initialState_number = 0;
    
    HashMap<IProduction, Integer> prod_labels;
    
    File input;
    File output;
    List<String> paths;
    boolean generateParenthesize;
    private final static ITermFactory termFactory = new TermFactory();

    public ParseTable(File input, File output, List<String> paths, boolean parenthesize) {
        this.input = input;
        this.output = output;
        this.paths = paths;
        this.generateParenthesize = parenthesize;
    }

    public void createTable() throws Exception {
        NormGrammar grammar = GrammarReader.readGrammar(input, output, paths, termFactory);
        
        prod_labels = createLabels(grammar.prods, 257);

        // labels = createLabels();
        // create first/follow sets
        // create states

        

        // output table
        IStrategoTerm result = generateATerm();
        if(output != null) {
            FileWriter out = null;
            try {
                out = new FileWriter(output);

                out.write(result.toString());

                out.close();
            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println(result.toString());
        }
    }

    private HashMap<IProduction, Integer> createLabels(Set<IProduction> prods, int label) {
        HashMap<IProduction, Integer> labels = Maps.newHashMap();
        
        for (IProduction p : prods){
            labels.put(p, label);
            label++;
        }
        
        return labels;
    }

    private IStrategoTerm generateATerm() {
        
        IStrategoTerm version = termFactory.makeInt(version_number);
        IStrategoTerm initialState = termFactory.makeInt(initialState_number);
        
        //TODO generate terms for labels, states and priorities
        IStrategoTerm labels = generateLabelsAterm();
        IStrategoTerm states = termFactory.makeAppl(termFactory.makeConstructor("states", 1), termFactory.makeList());
        IStrategoTerm priorities = termFactory.makeAppl(termFactory.makeConstructor("priorities", 1), termFactory.makeList());
        
        return termFactory.makeAppl(termFactory.makeConstructor("parse-table", 5), version, initialState, labels, states, priorities);
    }

    private IStrategoTerm generateLabelsAterm() {
        List<IStrategoTerm> terms = Lists.newArrayList();
        
        for (IProduction p : prod_labels.keySet()){
            int label = prod_labels.get(p);
            
            IStrategoTerm p_term = termFactory.makeAppl(termFactory.makeConstructor("label", 2), p.toAterm(termFactory), termFactory.makeInt(label));
            terms.add(p_term);
        }
        
        return termFactory.makeList(terms);
    }
}
