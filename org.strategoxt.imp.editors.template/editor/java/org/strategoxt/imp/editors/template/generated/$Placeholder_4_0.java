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

@SuppressWarnings("all") public class $Placeholder_4_0 extends Strategy 
{ 
  public static $Placeholder_4_0 instance = new $Placeholder_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_9756, Strategy h_9756, Strategy i_9756, Strategy j_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Placeholder_4_0");
    Fail524:
    { 
      IStrategoTerm l_9938 = null;
      IStrategoTerm h_9938 = null;
      IStrategoTerm i_9938 = null;
      IStrategoTerm j_9938 = null;
      IStrategoTerm k_9938 = null;
      IStrategoTerm m_9938 = null;
      IStrategoTerm n_9938 = null;
      IStrategoTerm o_9938 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail524;
      h_9938 = term.getSubterm(0);
      i_9938 = term.getSubterm(1);
      j_9938 = term.getSubterm(2);
      k_9938 = term.getSubterm(3);
      IStrategoList annos94 = term.getAnnotations();
      l_9938 = annos94;
      term = g_9756.invoke(context, h_9938);
      if(term == null)
        break Fail524;
      m_9938 = term;
      term = h_9756.invoke(context, i_9938);
      if(term == null)
        break Fail524;
      n_9938 = term;
      term = i_9756.invoke(context, j_9938);
      if(term == null)
        break Fail524;
      o_9938 = term;
      term = j_9756.invoke(context, k_9938);
      if(term == null)
        break Fail524;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{m_9938, n_9938, o_9938, term}), checkListAnnos(termFactory, l_9938));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}