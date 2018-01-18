package org.metaborg.sdf2table.grammar;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public abstract class Symbol implements Serializable {

    private static final long serialVersionUID = -9135946758836485558L;

    protected CharacterClass followRestrictionsNoLookahead;
    protected List<CharacterClass[]> followRestrictionsLookahead;

    private boolean nullable = false;

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

    public CharacterClass followRestriction() {
        return followRestrictionsNoLookahead;
    }

    public List<CharacterClass[]> followRestrictionLookahead() {
        return followRestrictionsLookahead;
    }

    public void addFollowRestrictionsLookahead(List<CharacterClass[]> frlList) {
        for(CharacterClass[] frl : frlList) {
            // currently only merge if first character-class is the same and size = 2
            if(frl.length != 2) {
                followRestrictionsLookahead.add(frl);
                continue;
            }

            boolean merged = false;
            for(CharacterClass[] currentFRL : followRestrictionsLookahead) {
                if(currentFRL.length != 2) {
                    continue;
                }
                
                CharacterClass intersection = CharacterClass.intersection(currentFRL[0], frl[0]);
                boolean equals = intersection.equals(currentFRL[0]);
                if(equals) {
                    currentFRL[1] = CharacterClass.union(currentFRL[1], frl[1]);
                    merged = true;
                }
            }

            if(!merged) {
                followRestrictionsLookahead.add(frl);
            }
        }
    }

    public void addFollowRestriction(CharacterClass fr) {
        if(followRestrictionsNoLookahead == null) {
            followRestrictionsNoLookahead = fr;
        } else {
            followRestrictionsNoLookahead = CharacterClass.union(followRestrictionsNoLookahead, fr);
        }
    }

    public void normalizeFollowRestrictionLookahead() {
        if(followRestrictionsNoLookahead == null || followRestrictionsLookahead.isEmpty()) {
            return;
        }

        // if the character of the follow restriction already occurs without a lookahead
        // the follow restriction with lookahead is redundant
        List<CharacterClass[]> redundantFRLookahead = Lists.newArrayList();
        for(CharacterClass[] fr : followRestrictionsLookahead) {
            CharacterClass intersection = CharacterClass.intersection(fr[0], followRestrictionsNoLookahead);
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
}
