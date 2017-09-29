package org.metaborg.sdf2table.grammar;

public class MakePermissive {
    
    public static NormGrammar makePermissive(NormGrammar g) {
        addInsertionProductions(g);
        
        return g;            
    }    


    private static void addInsertionProductions(NormGrammar g) {
        // TODO Auto-generated method stub
        
    }

}
