package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $String_1_0 extends Strategy 
{ 
  public static $String_1_0 instance = new $String_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("String_1_0");
    Fail1332:
    { 
      IStrategoTerm q_32975 = null;
      IStrategoTerm p_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1332;
      p_32975 = term.getSubterm(0);
      IStrategoList annos103 = term.getAnnotations();
      q_32975 = annos103;
      term = g_32794.invoke(context, p_32975);
      if(term == null)
        break Fail1332;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}