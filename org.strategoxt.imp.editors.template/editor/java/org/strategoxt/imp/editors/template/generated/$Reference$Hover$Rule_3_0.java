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

@SuppressWarnings("all") public class $Reference$Hover$Rule_3_0 extends Strategy 
{ 
  public static $Reference$Hover$Rule_3_0 instance = new $Reference$Hover$Rule_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9755, Strategy o_9755, Strategy p_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ReferenceHoverRule_3_0");
    Fail506:
    { 
      IStrategoTerm j_9936 = null;
      IStrategoTerm g_9936 = null;
      IStrategoTerm h_9936 = null;
      IStrategoTerm i_9936 = null;
      IStrategoTerm k_9936 = null;
      IStrategoTerm l_9936 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consReferenceHoverRule_3 != ((IStrategoAppl)term).getConstructor())
        break Fail506;
      g_9936 = term.getSubterm(0);
      h_9936 = term.getSubterm(1);
      i_9936 = term.getSubterm(2);
      IStrategoList annos79 = term.getAnnotations();
      j_9936 = annos79;
      term = n_9755.invoke(context, g_9936);
      if(term == null)
        break Fail506;
      k_9936 = term;
      term = o_9755.invoke(context, h_9936);
      if(term == null)
        break Fail506;
      l_9936 = term;
      term = p_9755.invoke(context, i_9936);
      if(term == null)
        break Fail506;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consReferenceHoverRule_3, new IStrategoTerm[]{k_9936, l_9936, term}), checkListAnnos(termFactory, j_9936));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}