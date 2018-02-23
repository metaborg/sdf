package org.metaborg.sdf2table.grammar;

import java.util.Map;
import java.util.Set;

import org.metaborg.sdf2table.deepconflicts.Context;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

import com.google.common.collect.Lists;

public class Sort extends Symbol {

    private static final long serialVersionUID = 9143763814850136478L;
    
    private final String name;
    private final LiteralType type;

    public Sort(String name) {
        this.name = name;
        this.type = null;
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    public Sort(String name, LiteralType type) {
        this.name = name;
        this.type = type;
        followRestrictionsLookahead = Lists.newArrayList();
        followRestrictionsNoLookahead = null;
    }

    @Override public String name() {
        if(type == null)
            return name;
        else if(type == LiteralType.CiLit)
            return "'" + name + "'";
        else
            return "\"" + name + "\"";
    }

    public LiteralType getType() {
        return type;
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if(type == LiteralType.CiLit) {
            return tf.makeAppl(tf.makeConstructor("cilit", 1),
                tf.makeString(name.replace("\\\"", "\"").replace("\\\\", "\\").replace("\\'", "\'")));
        } else if(type == LiteralType.Lit) {
            return tf.makeAppl(tf.makeConstructor("lit", 1),
                tf.makeString(name.replace("\\\"", "\"").replace("\\\\", "\\").replace("\\'", "\'")));
        }
        return tf.makeAppl(tf.makeConstructor("sort", 1), tf.makeString(name));
    }

    @Override public IStrategoTerm toSDF3Aterm(ITermFactory tf, Map<Set<Context>, Integer> ctx_vals,
        Integer ctx_val) {
        if(type == LiteralType.CiLit) {
            return tf.makeAppl(tf.makeConstructor("CiLit", 1), tf.makeString("\"" + name + "\""));
        } else if(type == LiteralType.Lit) {
            return tf.makeAppl(tf.makeConstructor("Lit", 1), tf.makeString("\"" + name + "\""));
        }
        if(ctx_val != null) {
            return tf.makeAppl(tf.makeConstructor("Sort", 1), tf.makeString(name + ctx_val));
        }
        return tf.makeAppl(tf.makeConstructor("Sort", 1), tf.makeString(name));
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Sort other = (Sort) obj;
        if(name == null) {
            if(other.name != null)
                return false;
        } else if(!name.equals(other.name))
            return false;
        if(type != other.type)
            return false;
        return true;
    }
}
