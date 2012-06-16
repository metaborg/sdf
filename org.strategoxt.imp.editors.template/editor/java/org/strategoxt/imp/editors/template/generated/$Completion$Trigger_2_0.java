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

@SuppressWarnings("all") public class $Completion$Trigger_2_0 extends Strategy 
{ 
  public static $Completion$Trigger_2_0 instance = new $Completion$Trigger_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_9754, Strategy w_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTrigger_2_0");
    Fail498:
    { 
      IStrategoTerm q_9934 = null;
      IStrategoTerm o_9934 = null;
      IStrategoTerm p_9934 = null;
      IStrategoTerm r_9934 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTrigger_2 != ((IStrategoAppl)term).getConstructor())
        break Fail498;
      o_9934 = term.getSubterm(0);
      p_9934 = term.getSubterm(1);
      IStrategoList annos71 = term.getAnnotations();
      q_9934 = annos71;
      term = v_9754.invoke(context, o_9934);
      if(term == null)
        break Fail498;
      r_9934 = term;
      term = w_9754.invoke(context, p_9934);
      if(term == null)
        break Fail498;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTrigger_2, new IStrategoTerm[]{r_9934, term}), checkListAnnos(termFactory, q_9934));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}