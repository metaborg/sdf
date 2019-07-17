package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.parsetable.characterclasses.ICharacterClass;

import org.metaborg.sdf2table.grammar.ISymbol;
import org.metaborg.parsetable.symbols.SortCardinality;
import org.metaborg.parsetable.symbols.SyntaxContext;
import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

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
        List<ICharacterClass[]> redundantFRLookahead = Lists.newArrayList();
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

    public abstract int hashCode();

    public abstract boolean equals(Object s);

    public abstract IStrategoTerm toAterm(ITermFactory tf);

    public abstract IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals, Integer ctx_val);

    public org.metaborg.parsetable.symbols.ISymbol toParseTableSymbol() {
        return toParseTableSymbol(null, null);
    }

    public abstract org.metaborg.parsetable.symbols.ISymbol toParseTableSymbol(SyntaxContext syntaxContext, SortCardinality cardinality);
}
