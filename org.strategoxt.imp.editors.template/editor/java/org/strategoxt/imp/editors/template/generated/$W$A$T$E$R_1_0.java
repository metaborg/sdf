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

@SuppressWarnings("all") public class $W$A$T$E$R_1_0 extends Strategy 
{ 
  public static $W$A$T$E$R_1_0 instance = new $W$A$T$E$R_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("WATER_1_0");
    Fail542:
    { 
      IStrategoTerm q_9940 = null;
      IStrategoTerm p_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consWATER_1 != ((IStrategoAppl)term).getConstructor())
        break Fail542;
      p_9940 = term.getSubterm(0);
      IStrategoList annos108 = term.getAnnotations();
      q_9940 = annos108;
      term = d_9757.invoke(context, p_9940);
      if(term == null)
        break Fail542;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consWATER_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}