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

@SuppressWarnings("all") public class $Builders_2_0 extends Strategy 
{ 
  public static $Builders_2_0 instance = new $Builders_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_9753, Strategy r_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Builders_2_0");
    Fail482:
    { 
      IStrategoTerm q_9931 = null;
      IStrategoTerm o_9931 = null;
      IStrategoTerm p_9931 = null;
      IStrategoTerm r_9931 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBuilders_2 != ((IStrategoAppl)term).getConstructor())
        break Fail482;
      o_9931 = term.getSubterm(0);
      p_9931 = term.getSubterm(1);
      IStrategoList annos55 = term.getAnnotations();
      q_9931 = annos55;
      term = q_9753.invoke(context, o_9931);
      if(term == null)
        break Fail482;
      r_9931 = term;
      term = r_9753.invoke(context, p_9931);
      if(term == null)
        break Fail482;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBuilders_2, new IStrategoTerm[]{r_9931, term}), checkListAnnos(termFactory, q_9931));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}