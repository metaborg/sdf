package org.strategoxt.imp.editors.template.strategies;

import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.interpreter.terms.ITermFactory;
import org.strategoxt.lang.Context;
import org.strategoxt.lang.Strategy;

public class unquote_0_0 extends Strategy {
    public static String unquote(String s) {
        return (s != null && ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'")))) ? s =
            s.substring(1, s.length() - 1) : s;
    }

    public static unquote_0_0 instance = new unquote_0_0();

    @Override public IStrategoTerm invoke(Context context, IStrategoTerm current) {
        final String str = Tools.asJavaString(current);
        final ITermFactory factory = context.getFactory();
        IStrategoTerm after = factory.makeString(unquote(str));
        after = factory.annotateTerm(after, current.getAnnotations());
        after = factory.copyAttachments(current, after);
        return after;
    }
}
