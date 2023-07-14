package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public abstract class Symbol implements Serializable, ISymbol {

    private static final long serialVersionUID = -9135946758836485558L;

    protected ICharacterClass followRestrictionsNoLookahead;
    protected List<ICharacterClass[]> followRestrictionsLookahead;

    private boolean nullable = false;

    /* (non-Javadoc)
     * @see org.metaborg.sdf2table.grammar.ISymbol#name()
     */
    @Override
    public abstract String name();

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    @Override public String toString() {
        return name();
    }

    public ICharacterClass followRestriction() {
        return followRestrictionsNoLookahead;
    }

    public List<ICharacterClass[]> followRestrictionLookahead() {
        return followRestrictionsLookahead;
    }

    public void addFollowRestrictionsLookahead(List<ICharacterClass[]> frlList) {
        for(ICharacterClass[] frl : frlList) {
            // currently only merge if first character-class is the same and size = 2
            if(frl.length != 2) {
                followRestrictionsLookahead.add(frl);
                continue;
            }

            boolean merged = false;
            for(ICharacterClass[] currentFRL : followRestrictionsLookahead) {
                if(currentFRL.length != 2) {
                    continue;
                }

                ICharacterClass intersection = currentFRL[0].intersection(frl[0]);
                boolean equals = intersection.equals(currentFRL[0]);
                if(equals) {
                    currentFRL[1] = currentFRL[1].union(frl[1]);
                    merged = true;
                }
            }

            if(!merged) {
                followRestrictionsLookahead.add(frl);
            }
        }
    }

    public void addFollowRestriction(ICharacterClass fr) {
        if(followRestrictionsNoLookahead == null) {
            followRestrictionsNoLookahead = fr;
        } else {
            followRestrictionsNoLookahead = followRestrictionsNoLookahead.union(fr);
        }
    }

    public void normalizeFollowRestrictionLookahead() {
        if(followRestrictionsNoLookahead == null || followRestrictionsLookahead.isEmpty()) {
            return;
        }

        // if the character of the follow restriction already occurs without a lookahead
        // the follow restriction with lookahead is redundant
        List<ICharacterClass[]> redundantFRLookahead = new ArrayList<>();
        for(ICharacterClass[] fr : followRestrictionsLookahead) {
            ICharacterClass intersection = fr[0].intersection(followRestrictionsNoLookahead);
            if(intersection.equals(fr[0])) {
                redundantFRLookahead.add(fr);
            } else {
                fr[0] = fr[0].difference(intersection);
            }
        }

        followRestrictionsLookahead.removeAll(redundantFRLookahead);
    }
    
    public static String getSort(ISymbol s) {
        if(s instanceof Sort && ((Sort) s).getType() == null) {
            return s.name();
        } else if(s instanceof ContextFreeSymbol) {
            return getSort(((ContextFreeSymbol) s).getSymbol());
        } else if(s instanceof LexicalSymbol) {
            return getSort(((LexicalSymbol) s).getSymbol());
        } else if(s instanceof AltSymbol) {
            return getSort(((AltSymbol) s).left()) + "_" + getSort(((AltSymbol) s).right());
        } else if(s instanceof StartSymbol || s instanceof FileStartSymbol) {
            return s.name();
        }
        return null;
    }
    
    public static boolean isListNonTerminal(ISymbol s) {
        if(s instanceof ContextFreeSymbol) {
            s = ((ContextFreeSymbol) s).getSymbol();
        } else if(s instanceof LexicalSymbol) {
            s = ((LexicalSymbol) s).getSymbol();
        }

        if(s instanceof IterSepSymbol || s instanceof IterStarSepSymbol || s instanceof IterStarSymbol
            || s instanceof IterSymbol) {
            return true;
        }

        return false;
    }

    public abstract int hashCode();

    public abstract boolean equals(Object s);

    public abstract IStrategoTerm toAterm(ITermFactory tf);

    public abstract IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val);

    public org.metaborg.parsetable.symbols.ISymbol toParseTableSymbol() {
        return toParseTableSymbol(null, null);
    }

    public abstract org.metaborg.parsetable.symbols.ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality);
}
