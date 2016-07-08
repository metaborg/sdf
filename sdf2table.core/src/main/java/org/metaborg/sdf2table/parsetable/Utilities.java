package org.metaborg.sdf2table.parsetable;

import java.util.Collection;

import org.metaborg.sdf2table.grammar.Exportable;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.terms.StrategoList;

/**
 * Some useful function to generate the parse table.
 */
public class Utilities{
	/**
     * Create a new Stratego list from an array.
     * @param ary An array of Stratego terms.
     * @return A new Stratego list.
     */
    public static StrategoList strategoListFromArray(IStrategoTerm... ary){
    	StrategoList list = new StrategoList(null, null, null, 0);
    	
    	for(int i = ary.length-1; i >= 0; --i){
    		if(ary[i] != null)
    			list = new StrategoList(ary[i], list, null, 0);
    	}
    	/*for(int i = 0; i < ary.length; ++i){
    		if(ary[i] != null)
    			list = new StrategoList(ary[i], list, null, 0);
    	}*/
  
    	return list;
    }
    
    public static StrategoList strategoListFromExportables(Collection<Exportable> _list){
    	/*StrategoList list = new StrategoList(null, null, null, 0);
    	
    	for(Exportable term : _list){
    		if(term != null){
    			IStrategoTerm t = term.toATerm();
    			if(t != null)
    				list = new StrategoList(term.toATerm(), list, null, 0);
    		}
    	}
  
    	return list;*/
    	IStrategoTerm ary[] = new IStrategoTerm[_list.size()];
    	int i = 0;
    	for(Exportable e : _list){
    		ary[i] = e.toATerm();
    		++i;
    	}
    	
    	return strategoListFromArray(ary);
    }
    
    public static StrategoList strategoListFromCollection(Collection<IStrategoTerm> terms){
    	/*StrategoList list = new StrategoList(null, null, null, 0);
    	
    	for(IStrategoTerm term : terms){
    		if(term != null)
    			list = new StrategoList(term, list, null, 0);
    	}
  
    	return list;*/
    	return strategoListFromArray(terms.toArray(new IStrategoTerm[terms.size()]));
    }
    
    public static String toLabel(String str){
    	return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
    
    public static String toHtml(String str){
    	return str.replace("&", "&amp;")
    			.replace("<", "&lt;")
    			.replace(">", "&gt;")
    			.replace("'", "&apos;")
    			.replace("\"", "&quot;")
    			.replace("(", "&#40;")
    			.replace(")", "&#41;")
    			.replace("[", "&#91;")
    			.replace("]", "&#93;")
    			.replace("{", "&#123;")
    			.replace("|", "&#124;")
    			.replace("}", "&#125;")
    			.replace("/", "&#47;")
    			.replace(",", "&#44;")
    			.replace("\\", "&#92;");
    }
}
