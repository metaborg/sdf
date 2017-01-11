package org.metaborg.newsdf2table.grammar;

import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;

public class NonTerminal extends Symbol {

    // In a normalized grammar only character classes are terminals
    String name;
    LiteralType type;

    public NonTerminal(String name) {
        this.name = name;
        this.type = null;
    }

    public NonTerminal(String name, LiteralType type) {
        this.name = name;
        this.type = type;
    }

    @Override public String name() {
        if(type == null)
            return name;
        else if (type == LiteralType.CiLit) 
            return "'" + name + "'";
        else 
            return "\"" + name + "\"";
    }

    @Override public IStrategoTerm toAterm(ITermFactory tf) {
        if (type == LiteralType.CiLit) {
            return tf.makeAppl(tf.makeConstructor("ci-lit", 1), tf.makeString(name));
        } else if (type == LiteralType.Lit) {
            return tf.makeAppl(tf.makeConstructor("lit", 1), tf.makeString(name));
        }
        return tf.makeAppl(tf.makeConstructor("sort", 1), tf.makeString(name));
    }
}
